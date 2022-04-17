package org.zhazha.demo.design;

import org.junit.Test;
import org.zhazha.demo.design.cuisine.impl.CacheServiceImpl;

public class ApiTest {

    @Test
    public void test_CacheService(){
        CacheService cacheService = new CacheServiceImpl();
        cacheService.set("user_name_01", "小扎扎", 1);
        String value01 = cacheService.get("user_name_01", 1);
        System.out.println(value01);
    }
}
