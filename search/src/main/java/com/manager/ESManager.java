package manager;

//import model.SearchCondition;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import com.utils.ESUtil;

import java.util.List;

/**
 *   
 * <p>搜索查询</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/6 
 * @since V1.0
 *  
 */
public class ESManager {

    public List<IndexResponse> createIndex(String index, String type, String data) {
        TransportClient transportClient = ESUtil.getTransportClient();
        transportClient.prepareIndex(index, type).setSource().get();
        return null;
    }

    /**
     * 调用搜索引擎进行查询
     * @return
     */
//    public List<SearchResponse> search(SearchCondition searchCondition) {
////        TransportClient transportClient = ESUtil.getTransportClient();
////        transportClient.prepareSearch("")
////                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery().setFrom()
//        return null;
//    }

}
