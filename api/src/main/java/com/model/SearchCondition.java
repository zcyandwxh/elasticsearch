package com.model;

import lombok.Data;

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
public class SearchCondition {
    private Integer start;
    private Integer size;
    private String analyser = "ik";
    List<Condition> condition;
    List<Fileter> filters;
}
