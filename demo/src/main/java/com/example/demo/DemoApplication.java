package com.example.demo;

import com.example.demo.dto.Home;
import com.example.demo.dto.Man;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args)  {
        /*java.lang.reflect.InvocationHandler invocationHandler = new ProxyClass();
        Demo4DynamicProxy o = (Demo4DynamicProxy) Proxy.newProxyInstance(Demo4DynamicProxy.class.getClassLoader(), new Class[]{Demo4DynamicProxy.class},  invocationHandler);
        System.out.println(o.hello("什么东西"));*/

        SpringApplication.run(DemoApplication.class, args);
        System.out.println("i am demoApplication...");
     /*   DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(new FileSystemResource("Beans.xml"));

// bring in some property values from a Properties file
        PropertySourcesPlaceholderConfigurer cfg = new PropertySourcesPlaceholderConfigurer();
        cfg.setLocation(new FileSystemResource("jdbc.properties"));

// now actually do the replacement
        cfg.postProcessBeanFactory(factory);
*/

        /*ProxyClass proxyClass = new ProxyClass();
        Demo4DynamicProxy demo = (Demo4DynamicProxy) Proxy.newProxyInstance(Demo4DynamicProxy.class.getClassLoader(), new Class[]{Demo4DynamicProxy.class}, proxyClass);
        demo.hello("11111");

        List<String> strings = Splitter.on(",").trimResults().splitToList("146086100,123");
        System.out.println(strings);
        String resultString = URLDecoder.decode("%7B%22deviceName%22%3A%22%22%2C%22pageIndex%22%3A%221%22%2C%22pageSize%22%3A%2210%22%2C%22edOrSdFlag%22%3A%22FR_ED%22%2C%22areaCode%22%3A%22PUNAAI%22%2C%22resSpecId%22%3A%22OLT%22%2C%22userCode%22%3A%22BBC01%22%2C%22assignAirFiberFlag%22%3A%22Y%22%2C%22taskOrderNo%22%3A%22221128195402391921%22%7D&_=1669712846652", "ISO-8859-1");
        System.out.println(resultString);*/
        /*String bsnlRetentionCloseJobInterval = "T1113,T1112,T1111,T1120:24H|T1044:10D";

        ArrayList<Map<String, String>> maps = new ArrayList<>();
        String[] split = bsnlRetentionCloseJobInterval.split("\\|");
        int i = 1;
        for (String s : split) {
            String[] split1 = s.split(":");
            String taskCodes = split1[0];
            String jobInterval = split1[1];
            ArrayList<Map<String, String>> maps1 = new ArrayList<Map<String, String>>();
            HashMap<String, String> stringStringHashMap = new HashMap<>();
            stringStringHashMap.put(String.valueOf(i), String.valueOf(i));
            i++;
            maps1.add(stringStringHashMap);
            //List<Map<String, String>> retentionTasks = bsnlOperTaskDAO.queryTaskRetentionForClose(taskStatus, taskCodes, jobInterval, pageSize, pageIndex);
            System.out.println("taskCodes = " + taskCodes);
            System.out.println("jobInterval = " + jobInterval);
            maps.addAll(maps1);
        }
        for (Map<String, String> map : maps) {
            for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
                System.out.println(stringStringEntry.getKey());
                System.out.println(stringStringEntry.getValue());
            }

        }
        maps.clear();


        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3,4,5,2");
        String join = StringUtils.join(strings, ',');
        System.out.println(join);
        String[] split1 = join.split(",");
        List<String> strings1 = Arrays.asList(split1);
        List<String> collect = strings1.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);*/

       /* System.out.println("i am main function");
        CacheClazz claz = new CacheClazz();
        CacheClazz.getTesting();*/
        /*SecureRandom secRandom = new SecureRandom();
        StringBuffer otp = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            otp.append(String.valueOf(secRandom.nextInt(10)));
            System.out.println(otp.toString());
        }
        System.out.println(otp.toString());*/
        /*ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(1);
        integers.add(2);
        for (int i = 0; i < integers.size() - 1; i++) {
            System.out.println("i = " + i + "----" +integers.get(i));
            for (int i1 = integers.size() - 1; i1 > i; i1--) {
                System.out.println("i1 = " + i1 + "----" +integers.get(i1));
                if (Objects.equals(integers.get(i), integers.get(i1))) {
                    integers.remove(i1);
                }
            }
        }
        System.out.println(integers);*/
        //String sql = "CIRCLE,SSA,STATUS,ORDER_NO,POSTING_DATE,ESTAT,CUST_NAME,PHONE_NO,CUSTOMER_ACCT,EXCHANGE,SERO_ID,PENDING_TASK,ADDR,MOBILE_NO,PENDING_TASK_STATUS,PENDING_FROM_DT,CLARITY_STATUS,SERO_ID_1,PENDING_DURATION,SERVICE_TYPE,SERVICE_SUB_TYPE,BOOKED_OPER_CODE,SALE_FRANCHISEE,WORK_FRAN_CODE,FRAN_CATEGORY,ORDER_TYPE,ORDER_SUB_TYPE,EMAIL,ASSIGN_TO_FRAN_TASK_DATE,LAST_MILE,TYPE_OF_MEDIA_AEND,TYPE_OF_MEDIA_BEND,BB_ACCESS_NETWORK,TESTING_DT,XFER_TO_FMS_FLAG,INST_MAIN_LOC,INST_SUB_LOC,ORDER_INFO,RTOD_FLAG,CLARITY_REMARK,ORDER_COMP_DATE,SLA,\"ZONE\",TRANS_DATE,ORDER_FLAG,ORD_STATUS_FMS,ASSIGNED_TO_ID,ASSIGNED_TO_NAME,BB_AEND_MODEM1_COLLECTED,CABLE_ID,CABLE_TYPE,CABLE_IN_METERS,CABLE_ID_BEND,CABLE_TYPE_BEND,CABLE_IN_METERS_BEND,BB_CUST_REQ_MODEM_AEND,AEND_MODEM_ACQUISITION_TYPE,NO_OF_MODEMS_AEND,BB_CUST_REQ_MODEM_BEND,BEND_MODEM_ACQUISITION_TYPE,NO_OF_MODEMS_BEND,EXCH_CODE_ENDA,EXCH_CODE_ENDB,FRANCHISEE_FIBRE_LENGTH,FRANCHISEE_FIBRE_LENGTH_ENDB,RF_BTS_IP_ENDA,RF_BTS_TYPE_ENDA,RF_BTS_IP_ENDB,RF_BTS_TYPE_ENDB,SYSDATE,TASK_ORDER_NO,SEQ,TASK_COMPLETE_DATE";
        //
        //List<String> allStringList = Arrays.asList(sql.split(","));
        //for (int i = 0; i < allStringList.size(); i++) {
        //    System.out.println("paList["+i+"].setBatchElement(\""+allStringList.get(i)+"\", lcFmsOrderDetaiMap.get(\""+allStringList.get(i)+"\"), i);");
        //}
  /*      JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", "1");
        jsonObject.put("a", "2");
        jsonObject.put("a", "3");
        System.out.println(jsonObject);

        Man build = Man.builder().age("10").sex("21").phone("1122").build();*/

       /* ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < objects.size(); i++) {
            System.out.println("jjjj");
        }*/


      /*  Map<String, Set<String>> stringStringHashMap = new HashMap<>();
        Set<String> strings  =  stringStringHashMap.get("T1081");
        if (null == strings) {
            strings =  new HashSet<>();
            stringStringHashMap.put("T1081", strings);
        }
        strings.add("123");

        for (Map.Entry<String, Set<String>> stringSetEntry : stringStringHashMap.entrySet()) {
            System.out.println(stringSetEntry.getKey() + " " + stringSetEntry.getValue());
        }

        System.out.println(strings);*/

/*        ParentFactory loginFactory = new LoginCheck();
        ParentFactory auFactory = new AuthCheck();
        PayCheck payCheck = new PayCheck();
        loginFactory.setNextNode(auFactory).setNextNode(payCheck);
        loginFactory.checkResult("success");*/


        /*HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("1", "2");
        stringStringHashMap.put("2", null);

        HashMap<String, String> stringStringHashMap2 = new HashMap<>();
        stringStringHashMap2.put("1", "2");
        stringStringHashMap2.put("2", "3");

        ArrayList<Map<String, String>> maps = new ArrayList<>();
        maps.add(stringStringHashMap);
        maps.add(stringStringHashMap2);

        Set<String> collect = maps.stream().map(map -> map.get("2")).filter(item -> !StringUtils.isEmpty(item)).collect(Collectors.toSet());
        System.out.println(collect);


        for (String s : collect) {
            for (Map<String, String> map : maps) {
                if (!StringUtils.isEmpty(map.get("2")) && map.get("2").equals(s)) {
                    System.out.println(s);
                }
            }
        }*/
        ArrayList<String> strings = new ArrayList<>();
        String s = "";
        if (Strings.isNotEmpty(s)) {
            strings.add(s);
        }
        strings.add("1");
        System.out.println("------------------");
        System.out.println(getMultiValue(strings));
        Home home = new Home();
        home.setPeople("me");
        home.setAddress("xian");
        Man man = new Man();
        man.setSex("1");
        man.setAge("28");
        man.setHome(home);
        man.setPhone("18394388545");

        Man man1 = new Man();
        BeanUtils.copyProperties(man, man1);
        man1.setPhone("110");
        man1.getHome().setAddress("BJ");
        System.out.println(man.getPhone());
        System.out.println(man1.getPhone());
        System.out.println(man1.getHome().getAddress());
        System.out.println(man.getHome().getAddress());

    }


    private static String getMultiValue(List<String> list) {
        String s = "";
        if (!CollectionUtils.isEmpty(list)) {
            String stringList = join(list, ",");
            List<String> allStringList = Arrays.asList(stringList.split(","));
            allStringList = allStringList.stream().distinct().collect(Collectors.toList());
            s = join(allStringList, ",");
        }
        return s;
    }


    public static String join(List<String> list, String delim) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        } else {
            StringBuilder buf = new StringBuilder();
            Iterator<String> i = list.iterator();

            while(i.hasNext()) {
                buf.append((String)i.next());
                if (i.hasNext()) {
                    buf.append(delim);
                }
            }

            return buf.toString();
        }
    }




}
