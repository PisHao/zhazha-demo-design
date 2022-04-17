package org.zhazha.demo.design.factory;

import org.zhazha.demo.design.utils.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKInvocationHandler implements InvocationHandler {

    private ICacheAdapter iCacheAdapter;

    public JDKInvocationHandler(ICacheAdapter iCacheAdapter) {
        this.iCacheAdapter = iCacheAdapter;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        return ICacheAdapter.class.getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args))
                .invoke(iCacheAdapter, args);
    }
}
