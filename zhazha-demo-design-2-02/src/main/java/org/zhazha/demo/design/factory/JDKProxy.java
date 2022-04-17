package org.zhazha.demo.design.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JDKProxy {

    public static <T> T getProxy(Class<T> interfaceClass, ICacheAdapter iCacheAdapter){
        InvocationHandler jdkInvocationHandler = new JDKInvocationHandler(iCacheAdapter);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?>[] classes = interfaceClass.getInterfaces();
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{classes[0]}, jdkInvocationHandler);
    }
}
