package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    byte a;
    short b;
    int c;
    long d;
    float e;
    double f;
    char g;
    Byte h;
    Short i;
    Integer j;
    Long k;
    Float l;
    Double m;
    Character n;


    @Test
    void contextLoads() {

        System.out.println(a+"---" + b +"---"+ c+"---"+d+"---"+e+"---"+f+"---"+g+"--"+ "\r\n"+h+"---"+i+"---"+j+"---"+k+"---"+l+"---"+m+"---"+n+"----");
    }

}
