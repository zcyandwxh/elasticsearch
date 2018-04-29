import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetItemResponse;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.elasticsearch.index.reindex.ScrollableHitSource;
import org.elasticsearch.script.Script;
import org.elasticsearch.script.ScriptService;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.histogram.DateHistogramInterval;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;
import static org.elasticsearch.threadpool.ThreadPool.Names.INDEX;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/1/25 
 * @since V1.0
 *  
 */
public class Elasticsearch {

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {

        Settings settings = Settings.builder()
                .put("cluster.name", "my-application").build();
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));

        SearchResponse searchResponse = client.prepareSearch("huixing", "qw").setTypes("user", "user").setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(QueryBuilders.matchQuery("name", "zcy")).setPostFilter(QueryBuilders.rangeQuery("age").from(1).to(100)).get();

        System.out.println(searchResponse);
//        SearchResponse searchResponse = client.prepareSearch("huixing").setTerminateAfter(10).get();
//
//        if (searchResponse.isTerminatedEarly()) {
//            System.out.println("-------------");
//        }

     //   UpdateResponse updateResponse = client.prepareUpdate("qw", "user", "1").setScript(new Script("ctx._source.name=\"zcy\"")).get();
//        UpdateRequest updateRequest = new UpdateRequest();
//        updateRequest.index("qw").type("user").id("1").doc(jsonBuilder().startObject().field("name", "wxh").endObject());
//        UpdateResponse updateResponse = client.update(updateRequest).get();
   //     System.out.println(updateResponse);
        //创建index
//        IndexResponse indexResponse = client.prepareIndex("qw", "user", "1").setSource(
//                jsonBuilder().startObject().field("name", "zcy").field("age", 10).endObject()
//        ).get();
//
//        System.out.println(indexResponse.toString());
        //GET
//        GetResponse getResponse = client.prepareGet("qw", "user", "1").get();
//        System.out.println(getResponse);

//        client.prepareMultiGet().add()


        //DETELE
//        DeleteResponse deleteResponse = client.prepareDelete("qw", "user", "1").get();
//        System.out.println(deleteResponse);
//        BulkByScrollResponse bulkByScrollResponse = DeleteByQueryAction.INSTANCE.newRequestBuilder(client).filter(QueryBuilders.matchQuery("name", "zcy")).source("qw").get();
//        System.out.println(bulkByScrollResponse);
        //
//        BulkByScrollResponse bulkByScrollResponse = DeleteByQueryAction.INSTANCE.newRequestBuilder(client).filter(QueryBuilders.matchQuery("name", "zcy"))
//                .source("huixing").get();
//        System.out.println(bulkByScrollResponse.getDeleted());

//        DeleteByQueryAction.INSTANCE.newRequestBuilder(client).filter(QueryBuilders.matchQuery("name", "zcy")).source("huixing").execute(
//                new ActionListener<BulkByScrollResponse>() {
//                    public void onResponse(BulkByScrollResponse bulkByScrollResponse) {
//                        System.out.println(bulkByScrollResponse.getDeleted());
//                    }
//
//                    public void onFailure(Exception e) {
//
//                    }
//                }
//        );
        //update
//        UpdateRequest updateRequest = new UpdateRequest();
//        updateRequest.index("huixing");
//        updateRequest.type("user");
//        updateRequest.id("1");
//        updateRequest.doc(jsonBuilder().startObject().field("name", "zcy").endObject());
//        client.update(updateRequest).get();

//        MultiGetResponse multiGetItemResponses = client.prepareMultiGet().add("huixing", "user", "1")
//                .add("huixing", "user", "5").add("huixing", "user", "10").get();
//        for (MultiGetItemResponse mul : multiGetItemResponses) {
//            GetResponse getResponse = mul.getResponse();
//            System.out.println(getResponse.getSourceAsString());
//        }
//
//        BulkRequestBuilder bulkRequestBuilder = client.prepareBulk();
//        bulkRequestBuilder.add(client.prepareIndex("", "", "").setSource(jsonBuilder().startObject().field("","").endObject()));
//        BulkResponse bulk = bulkRequestBuilder.get();


//        SearchResponse searchResponse = client.prepareSearch("huixing").setTypes("user")
//                .setQuery(QueryBuilders.termQuery("name", "zcy"))
//                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
//                .setPostFilter(QueryBuilders.rangeQuery("age")
//                .from(10).to(20)).setFrom(10).setSize(20).setExplain(true).get();
//
//        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("huixing").setQuery(QueryBuilders.queryStringQuery("")).setSize(1);
//        MultiSearchResponse multiSearchResponse = client.prepareMultiSearch().add(searchRequestBuilder).get();
//
//        for (MultiSearchResponse.Item item : multiSearchResponse.getResponses()) {
//            SearchResponse searchResponse1 = item.getResponse();
//            searchResponse1.getHits().getHits();
//        }
//        SearchResponse response = client.prepareSearch("huixing")
//                .setTypes("user")
//                .setFrom(0).setSize(60).setExplain(true)
//                .get();
//        Map<String, Object> json = new HashMap<String, Object>();
//        json.put("user","kimchy");
//        json.put("postDate",new Date());
//        json.put("message","trying out Elasticsearch");

//        XContentBuilder builder = jsonBuilder()
//                .startObject()
//                .field("name", "kimchy")
//                .field("id", 10)
//                .endObject();
//
//        IndexResponse response = client.prepareIndex("huixing", "user", "16")
//                .setSource(builder)
//                .get();

//        BulkByScrollResponse response =
//                DeleteByQueryAction.INSTANCE.newRequestBuilder(client)
//                        .filter(QueryBuilders.matchQuery("name", "kimchy"))
//                        .source("huixing")
//                        .get();
//
//        System.out.println(response.getDeleted());

//        client.prepareUpdate("huixing", "user", "1")
//                .setScript(new Script("ctx._source.name = \"hahaha\""))
//                .get();

//        client.prepareMultiGet()
//                .add("huixing", "user", "17","12")
//                .get();
//
//
//        BulkRequestBuilder bulkRequest = client.prepareBulk();

// either use client#prepare, or use Requests# to directly build index/delete requests
//        bulkRequest.add(client.prepareIndex("huixing", "user", "11")
//                .setSource(jsonBuilder()
//                        .startObject()
//                        .field("name", "kimchy")
//                        .field("age", 10)
//                        .endObject()
//                ).setSource(jsonBuilder()
//                        .startObject()
//                        .field("name", "aiuschzx")
//                        .field("age", 7)
//                        .endObject())
//        );
//
//        BulkResponse bulkResponse = bulkRequest.get();
//        if (bulkResponse.hasFailures()) {
//            // process failures by iterating through each bulk response item
//        }

//        QueryBuilder qb = termQuery("name", "zcy");
//
//        SearchResponse scrollResp = client.prepareSearch("huixing")
//                .addSort(FieldSortBuilder.DOC_FIELD_NAME, SortOrder.ASC)
//                .setScroll(new TimeValue(6000))
//                .setQuery(qb)
//                .setSize(4).get();
//        do {
//            for (SearchHit hit : scrollResp.getHits().getHits()) {
//                System.out.println(hit.docId());
//            }
//
//            scrollResp = client.prepareSearchScroll(scrollResp.getScrollId()).setScroll(new TimeValue(60000)).execute().actionGet();
//            Thread.sleep(1000);
//        } while(scrollResp.getHits().getHits().length != 0);

//        SearchRequestBuilder srb1 = client
//                .prepareSearch().setQuery(QueryBuilders.queryStringQuery("elasticsearch")).setSize(1);
//        SearchRequestBuilder srb2 = client
//                .prepareSearch().setQuery(QueryBuilders.matchQuery("name", "kimchy")).setSize(1);
//
//        MultiSearchResponse sr = client.prepareMultiSearch()
//                .add(srb1)
//                .add(srb2)
//                .get();
//
//// You will get all individual responses from MultiSearchResponse#getResponses()
//        long nbHits = 0;
//        for (MultiSearchResponse.Item item : sr.getResponses()) {
//            SearchResponse response = item.getResponse();
//            System.out.println(nbHits += response.getHits().getTotalHits());
//        }

//        SearchResponse sr = client.prepareSearch("user")
//                .setTerminateAfter(1000)
//                .get();
//
//        if (sr.isTerminatedEarly()) {
//            // We finished early
//            System.out.println("hhhh");
//        }
//

//        SearchResponse sr = client.prepareSearch()
//                .addAggregation(
//                        AggregationBuilders.terms("user").field("name")
//                                .subAggregation(AggregationBuilders.dateHistogram("by_year")
//                                        .field("dateOfBirth")
//                                        .dateHistogramInterval(DateHistogramInterval.YEAR)
//                                        .subAggregation(AggregationBuilders.avg("avg_children").field("children"))
//                                )
//                )
//                .execute().actionGet();
//
//        client.close();

    }

}
