package com.example.aspect;

import org.aspectj.lang.annotation.Aspect;

/**
 * Created by hadoop on 9/7/16.
 */

@Aspect
public class AspectDemo {

    public void before() {
        System.out.println("before");
    }

    public void after() {
        System.out.println("after");
    }


}
