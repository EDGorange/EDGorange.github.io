package com.example.demo.summary;

import com.google.common.base.Joiner;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description: br
 * @author: wang.chengcheng
 * @create: 2023-06-07 09:43
 **/

public class DBSummaryCodeDemo {

    public static void main(String[] args) {

    }

    public static void dbMethod() {

        ArrayList<Map<String, String>> lcFmsOrderDetails = new ArrayList<Map<String, String>>();
        //for循环中调用数据库优化：
        List<String> orderNbs = lcFmsOrderDetails.stream().map(map -> map.get("ORDER_NO")).collect(Collectors.toList());

        int size = orderNbs.size();

        int selectCount = (int) Math.ceil(size / 1000.0);
        ArrayList<String> existNbrs = new ArrayList<>();
        for (int i = 0; i < selectCount; i++) {
            int fromIndex = i * 1000;
            int toIndex = Math.min(fromIndex + 1000, size);
            String orderNbrStrings = Joiner.on(",").join(orderNbs.subList(fromIndex, toIndex));
            //DB操作：
            //List<HashMap<String, String>> hashMaps = woDao.qryWFMLcFmsOrderDetailByOrderNbrs(orderNbrStrings);
            List<HashMap<String, String>> hashMaps = new ArrayList<>();
            if (!CollectionUtils.isEmpty(hashMaps)) {
                List<String> hasExistNbrStrings = hashMaps.stream().map(map -> map.get("ORDER_NO")).collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(hasExistNbrStrings)) {
                    existNbrs.addAll(hasExistNbrStrings);
                }
            }
        }

        ArrayList<String> orignNbrs = new ArrayList <>(orderNbs);
        orignNbrs.removeAll(existNbrs);
    }
}
