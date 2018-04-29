package com.model;

import lombok.Data;

import java.io.Serializable;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/6 
 * @since V1.0
 *  
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1554257824560361213L;
    private T data;
    private Integer code;
    private String desc;
}
