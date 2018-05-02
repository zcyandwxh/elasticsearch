package com.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *   
 * <p>返回的商品</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/4/13 
 * @since V1.0
 *  
 */
@Data
public class SearchProductDTO implements Serializable {
    private static final long serialVersionUID = -755154633934873685L;
    private Long id;

    private String product;

    private Integer isParent;

    private Long parent;

    private LocalDateTime modityTime;

    private Long providerId;

    private BigDecimal price;

    private String pictureUrl;
}
