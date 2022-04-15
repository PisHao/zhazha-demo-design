package org.zhazha.demo.design;

import lombok.Data;

@Data
public class AwardRes {

    private String code;//编码
    private String info;//信息

    public AwardRes(String code, String info ){
        this.code = code;
        this.info = info;
    }
}
