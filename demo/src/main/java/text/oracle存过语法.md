```sql
--1：存过里面不能直接使用ddl，需要使用动态语法来执行
--2：存过里面创建临时表权限问题使用Authid Current_User 来解决
--3：存过里面创建临时表后需要先删临时表数据再drop；
--创建保障的存储过程用于同步订单表数据到局方表中  ！！注意更新存过中的dblink和局方表名：

CREATE OR REPLACE PROCEDURE syncFaultOrderDetailFields Authid Current_User AS
  str_sql varchar2(300);
BEGIN
-- 创建临时表
str_sql :='CREATE  GLOBAL TEMPORARY TABLE temp_table_B
ON COMMIT PRESERVE ROWS
AS
SELECT COMP_ID
FROM WF_FRAN_PEND_CLR_LC_FAULT_DSCM
WHERE XFER_TO_FMS_FLAG = ''Y'' AND SYNC_FLAG IS NULL AND TASK_COMPLETE_DATE IS NOT NULL  AND ROWNUM <= 1000 ';

execute immediate str_sql;
--END syncProvOrderDetailFields;
EXECUTE IMMEDIATE 'update  FRAN_PEND_CLR_FAULT_NORTH@LINK_CLARITY  A

　　set (A.TT_FAULT_CLR_CODE_DESC, A.TT_FAULT_CLR_CODES, A.XFER_TO_FMS_FLAG)
　　=
　　(select B.TT_FAULT_CLR_CODE_DESC, B.TT_FAULT_CLR_CODES, B.XFER_TO_FMS_FLAG
　　from  FRAN_PEND_CLR_LC_FAULT_DSCM B
　　where B.COMP_ID= A.COMP_ID 
　　)
where exists
(select ''X'' from FRAN_PEND_CLR_LC_FAULT_DSCM B where A.COMP_ID=B.COMP_ID  AND  B.XFER_TO_FMS_FLAG=''Y''  AND B.COMP_ID IN (SELECT COMP_ID FROM temp_table_B))';

EXECUTE IMMEDIATE 'UPDATE WF_LC_FMS_ORDER_DETAILS SET SYNC_FLAG = ''Y'' WHERE ORDER_NO IN (SELECT ORDER_NO FROM temp_table_B)';
-- 删除临时表
execute IMMEDIATE 'TRUNCATE TABLE temp_table_B';

execute IMMEDIATE 'DROP TABLE temp_table_B';

END syncFaultOrderDetailFields;

```