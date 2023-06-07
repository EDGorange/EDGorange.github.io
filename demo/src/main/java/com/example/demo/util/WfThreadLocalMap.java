package com.example.demo.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: br
 * @author: wang.chengcheng
 * @create: 2023-02-21 14:06
 **/

public final class WfThreadLocalMap {
    /**
     * construct <br>
     */
    private WfThreadLocalMap() {
        super();
    }

    /**
     * localMap <br>
     */
    private static ThreadLocal<Map<String, Object>> localMap = new InheritableThreadLocal<Map<String, Object>>() {
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<String, Object>();
        }
    };

    /**
     * Description: <br>
     *
     * @param key
     * @param value <br>
     * @author tong.yi31<br>
     * @taskId <br>
     */
    public static void set(String key, Object value) {
        Map<String, Object> map = localMap.get();
        if (map != null) {
            map.put(key, value);
        }
    }

    /**
     * Description: <br>
     *
     * @param key
     * @return <br>
     * @author tong.yi31<br>
     * @taskId <br>
     */
    public static Object get(String key) {
        Map<String, Object> map = localMap.get();
        if (map != null) {
            return map.get(key);
        }
        return null;
    }

    public static String getRequestNo() {
        return getString("requstNo");
    }

    /**
     * Description: <br>
     *
     * @param key
     * @return <br>
     * @author tong.yi31<br>
     * @taskId <br>
     */
    private static String getString(String key) {
        Map<String, Object> map = localMap.get();
        if (map != null && map.get(key) != null) {
            return map.get(key).toString();
        }
        return null;
    }
}

