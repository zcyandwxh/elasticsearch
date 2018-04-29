package com.model;

import lombok.Data;

import java.io.Serializable;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/4/12 
 * @since V1.0
 *  
 */
@Data
public class Condition implements Serializable{
    private static final long serialVersionUID = -9131275646002970201L;
    private String fileName;
    private String text;
    private Float filedBoost;
}
