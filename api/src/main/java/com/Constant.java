package com;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/4/13 
 * @since V1.0
 *  
 */
public enum  Constant {
    SUCCESS(1, "成功"),FAILED(99, "查询失败"),NO_DATA(100, "无数据");

    private Integer code;
    private String desc;

    public void setCode(Integer code){
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getCode() {
        return code;
    }

    Constant(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
