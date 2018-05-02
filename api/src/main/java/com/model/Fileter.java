package com.model;

import lombok.Data;

import java.io.Serializable;

/**
 *   
 * <p>过滤条件</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/4/12 
 * @since V1.0
 *  
 */
@Data
public class Fileter implements Serializable{
    private static final long serialVersionUID = -6446362234079136817L;
    private String value;
    private String name;
}
