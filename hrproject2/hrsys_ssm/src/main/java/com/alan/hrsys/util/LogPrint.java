package com.alan.hrsys.util;

// 1. 必须导入 AspectJ 的注解，而不是 JUnit 的
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect // 现在这个注解不会标红了
public class LogPrint {

    // 2. 这里的 @Before 是 AspectJ 的，不是 JUnit 的
    @Before("execution(* com.alan.hrsys.service.impl.*.*(..))")
    public void methodBegin(JoinPoint joinPoint) {
        System.out.println("方法开始执行: " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.alan.hrsys.service.impl.*.*(..))")
    public void methodEnd(JoinPoint joinPoint) {
        System.out.println("方法结束执行: " + joinPoint.getSignature().getName());
    }
}