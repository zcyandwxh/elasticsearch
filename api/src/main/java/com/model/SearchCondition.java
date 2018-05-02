package com.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *   
 * <p>查询条件</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/10 
 * @since V1.0
 *  
 */
@Data
public class SearchCondition implements Serializable{
    private static final long serialVersionUID = -1360917639181449837L;
    private Integer start;
    private Integer size;
    private String analyser = "ik";
    List<Condition> condition;
    List<Fileter> filters;
}
