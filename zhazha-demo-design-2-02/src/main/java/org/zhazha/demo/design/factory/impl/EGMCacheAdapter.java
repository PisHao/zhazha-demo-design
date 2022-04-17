package org.zhazha.demo.design.factory.impl;

import org.zhazha.demo.design.factory.ICacheAdapter;
import org.zhazha.demo.design.matter.EGM;

import java.util.concurrent.TimeUnit;

public class EGMCacheAdapter implements ICacheAdapter {

    private EGM egm = new EGM();

    public String get(String key) {
        return egm.gain(key);
    }
    public void set(String key, String value) {
        egm.set(key, value);
    }
    public void set(String key, String value, Long timeout, TimeUnit
            timeUnit) {
        egm.setEx(key, value, timeout, timeUnit);
    }
    public void del(String key) {
        egm.delete(key);
    }
}
