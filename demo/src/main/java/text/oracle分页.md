```java
public static final String SQL_ZONE_PAGE_BEGIN = "SELECT * FROM (SELECT ROW_.*, ROWNUM AS RN FROM (";


public String getPageEndSql(ParamArray pa, int pageIndex, int pageSize) {
        String sql = ") ROW_  WHERE ROWNUM <= ? ) A WHERE A.RN >= ?";
        pa.set("", pageSize * pageIndex);
        pa.set("", (pageIndex - 1) * pageSize + 1);

        return sql;
    }
```