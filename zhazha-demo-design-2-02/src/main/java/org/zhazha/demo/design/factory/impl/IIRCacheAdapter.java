package org.zhazha.demo.design.factory.impl;

import org.zhazha.demo.design.factory.ICacheAdapter;
import org.zhazha.demo.design.matter.IIR;

import java.util.concurrent.TimeUnit;

public class IIRCacheAdapter implements ICacheAdapter {

    private IIR iir = new IIR();

    public String get(String key) {
        return iir.get(key);
    }
    public void set(String key, String value) {
        iir.set(key, value);
    }
    public void set(String key, String value, Long timeout, TimeUnit
            timeUnit) {
        iir.setExpire(key, value, timeout, timeUnit);
    }
    public void del(String key) {
        iir.del(key);
    }
}
