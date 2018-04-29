package com.api;


import com.model.Result;
import com.model.SearchCondition;
import com.model.SearchProductDTO;
import com.model.SearchProviderDTO;

import java.util.List;

/**
 *   
 * <p>RPC调用</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/6 
 * @since V1.0
 *  
 */
public interface ESService {
    /**
     * 通过搜索引擎查询商品
     * @param searchCondition
     * @return
     */
    Result<List<SearchProductDTO>> search(SearchCondition searchCondition);

    /**
     * 重建索引 TODO
     * @return
     */
    Result reindex();

    /**
     * 查询经销商
     * @param searchCondition
     * @return
     */
    Result<List<SearchProviderDTO>> searchProvider(SearchCondition searchCondition);
}
