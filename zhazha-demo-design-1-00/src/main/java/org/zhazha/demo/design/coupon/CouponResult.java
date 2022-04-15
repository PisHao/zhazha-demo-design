package org.zhazha.demo.design.coupon;

import lombok.Data;

@Data
public class CouponResult {

    private String code;//编码

    private String info;//描述

    public CouponResult(String code, String info){
        this.code = code;
        this.info = info;
    }
}
