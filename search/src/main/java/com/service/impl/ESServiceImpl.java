package com.service.impl;

import com.Constant;
import com.api.ESService;
import com.google.gson.Gson;
import com.model.Result;
import com.model.SearchCondition;
import com.model.SearchProductDTO;
import com.model.SearchProviderDTO;
import com.utils.ESUtil;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/6 
 * @since V1.0
 *  
 */
@Service("esService")
public class ESServiceImpl implements ESService {
    private Gson gson = new Gson();
    @Override
    public Result<List<SearchProductDTO>> search(SearchCondition searchCondition) {
        TransportClient transportClient = ESUtil.getTransportClient();
        SearchResponse searchResponse = ESUtil.search(transportClient, searchCondition);
        SearchHits searchHits = searchResponse.getHits();
        Result<List<SearchProductDTO>> result = new Result<>();
        SearchHit[] hits = searchHits.getHits();
        List<SearchProductDTO> productDTOS = new ArrayList<>();
        for (int i = 0; i < hits.length; i++) {
            String source = hits[i].getSourceAsString();
            SearchProductDTO product = gson.fromJson(source, SearchProductDTO.class);
            productDTOS.add(product);
        }
        //        return searchResponse
        result.setCode(Constant.SUCCESS.getCode());
        result.setDesc(Constant.SUCCESS.getDesc());
        result.setData(productDTOS);
        return result;
    }

    @Override
    public Result reindex() {
        return null;
    }

    @Override
    public Result<List<SearchProviderDTO>> searchProvider(SearchCondition searchCondition) {
        TransportClient transportClient = ESUtil.getTransportClient();
        SearchResponse searchResponse = ESUtil.search(transportClient, searchCondition);
        SearchHits searchHits = searchResponse.getHits();
        Result<List<SearchProviderDTO>> result = new Result<>();
        SearchHit[] hits = searchHits.getHits();
        List<SearchProviderDTO> providerDTOS = new ArrayList<>();
        for (int i = 0; i < hits.length; i++) {
            String source = hits[i].getSourceAsString();
            SearchProviderDTO product = gson.fromJson(source, SearchProviderDTO.class);
            providerDTOS.add(product);
        }
        //        return searchResponse
        result.setCode(Constant.SUCCESS.getCode());
        result.setDesc(Constant.SUCCESS.getDesc());
        result.setData(providerDTOS);
        return result;
    }

}
