package com.example.demo.deepCopy;

import org.apache.commons.lang.SerializationUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @description: br
 * @author: wang.chengcheng
 * @create: 2023-05-26 14:24
 **/

class Address implements Serializable {
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String city;
    public String streetName;
    public int streetNumber;

    public Address(String city, String streetName, int streetNumber) {
        this.city = city;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }
}

class Employee implements Serializable {
    public String name;
    public Address address;

    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}

public class DeepCloneDemo {
    public static void main(String[] args) {
        Address address = new Address("Beijing", "Xinjiekou", 100);
        Employee originalEmployee = new Employee("Alice", address);

        Employee clonedEmployee = (Employee) SerializationUtils.clone(originalEmployee);
        clonedEmployee.address.streetNumber = 200;

        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("1", 1);
        stringIntegerHashMap.put("2", 2);
        stringIntegerHashMap.put("3", 3);
        stringIntegerHashMap.put("4", 4);

        Map<String, Integer> hash  = (Map<String, Integer>) SerializationUtils.clone(stringIntegerHashMap);
        hash.put("4", 5);
        for (Map.Entry<String, Integer> stringIntegerEntry : hash.entrySet()) {
            System.out.println("new Map--"+ stringIntegerEntry.getKey());
            System.out.println("new Map--"+ stringIntegerEntry.getValue());
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : stringIntegerHashMap.entrySet()) {
            System.out.println("old Map--"+ stringIntegerEntry.getKey());
            System.out.println("old Map--"+ stringIntegerEntry.getValue());
        }
        System.out.println("Original employee: " + originalEmployee.address.streetNumber);
        System.out.println("Cloned employee: " + clonedEmployee.address.streetNumber);
        System.out.println(Optional.ofNullable(address).map(Address::getCity).get());
        System.out.println(Optional.ofNullable(address).map(Address::getCity).orElse("nihao"));
    }
}
