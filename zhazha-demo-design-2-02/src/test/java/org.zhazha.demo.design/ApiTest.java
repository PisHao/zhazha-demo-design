package org.zhazha.demo.design;

import org.junit.Test;
import org.zhazha.demo.design.factory.JDKProxy;
import org.zhazha.demo.design.factory.impl.EGMCacheAdapter;
import org.zhazha.demo.design.factory.impl.IIRCacheAdapter;
import org.zhazha.demo.design.impl.CacheServiceImpl;

public class ApiTest {

    @Test
    public void test_cacheService(){
        CacheService egmService = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
        egmService.set("user_name01", "小扎扎");
        String value01 = egmService.get("user_name01");
        System.out.println(value01);

        CacheService iirService = JDKProxy.getProxy(CacheServiceImpl.class, new IIRCacheAdapter());
        iirService.set("user_name01", "小扎扎");
        String value02 = iirService.get("user_name01");
        System.out.println(value02);
    }
}
