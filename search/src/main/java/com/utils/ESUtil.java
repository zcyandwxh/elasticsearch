package com.utils;

import com.model.Condition;
import com.model.SearchCondition;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.*;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 *   
 * <p>es工具类</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/6 
 * @since V1.0
 *  
 */
public class ESUtil {

    public static final String PRODUCT_INFO = "cc_index";

    /**
     * 获取es客户端
     * @return
     */
    public static TransportClient getTransportClient() {
        Settings settings = Settings.builder()
                .put("cluster.name", "my-application").build();
        TransportClient client = null;
        try {
            client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }

    /**
     * 按条件搜索操作
     * @param transportClient
     * @param searchCondition
     * @return
     */
    public static SearchResponse search(TransportClient transportClient, SearchCondition searchCondition) {
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        SearchRequestBuilder searchRequestBuilder = transportClient.prepareSearch(PRODUCT_INFO);
        //返回权重结果
        searchRequestBuilder.setExplain(true);
        //设置查询条件
        List<Condition> conditions = searchCondition.getCondition();
        for (Condition condition : conditions) {
            MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder(condition.getText(), condition.getFileName());
            boolQueryBuilder.should(matchQueryBuilder);
        }

        BoolQueryBuilder builder = new BoolQueryBuilder();
        //设置过滤条件
//        searchCondition.getFilters().stream().forEach((x) -> {
//            MatchQueryBuilder matchQuery = QueryBuilders.matchQuery(x.getName(), x.getValue());
//            builder.must(matchQuery);
//        });
        //设置分词器
//        multiMatchQueryBuilder.analyzer()
        searchRequestBuilder.setQuery(boolQueryBuilder);
//        boolQueryBuilder.filter(builder);
        SearchResponse searchResponse = searchRequestBuilder.get();
        return searchResponse;
    }
}
