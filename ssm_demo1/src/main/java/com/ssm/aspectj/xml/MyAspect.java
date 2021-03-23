package com.ssm.aspectj.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面类，在此编写通知
 */
public class MyAspect {

    //前置通知
    public void myBefore(JoinPoint joinPoint) {
        System.out.println("前置通知，模拟检查权限...");
        System.out.print("目标类为：" + joinPoint);
        System.out.println("，被植入的增强处理方法为：" + joinPoint.getSignature().getName());
    }

    //后置通知
    public void myAfterReturning(JoinPoint joinPoint) {
        System.out.print("后置通知，模拟记录日志...");
        System.out.println("，被植入的增强处理方法为：" + joinPoint.getSignature().getName());
    }

    /**
     * 环绕通知
     * @param proceedingJoinPoint JoinPoint的子接口，表示可执行目标方法
     * @return 返回值必须为Object
     * @throws Throwable
     */
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕开始：执行目标方法前，模拟开启事务...");
        //执行当前目标方法
        Object obj = proceedingJoinPoint.proceed();

        System.out.println("环绕结束：执行目标方法后，模拟关闭事务...");

        return obj;
    }

    /**
     * 异常通知
     *
     * @param joinPoint
     * @param e
     */
    public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("异常通知：" + e.getMessage());
    }

    //最终通知
    public void myEnd() {
        System.out.println("最终通知，模拟方法结束后释放资源...");
    }
}
