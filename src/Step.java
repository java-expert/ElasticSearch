import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;


public class Step {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n=NodeBuilder.nodeBuilder()
		        .settings(Settings.builder()
		            .put("path.home", "D:\\elasticsearch-2.2.1\\path_home")).node();
final Client client = n.client();

//**************************************************Insert Doc 
client.prepareIndex("index11", "type", "101")
.setSource(putJsonDocument("title: Java",
                           "content_updated",
                           new Date(),
                           new String[]{"tags"},
                           "author")).execute().actionGet();


//********************************get by id*****************************************

getDocument(client, "index11", "type","101");
//*********************************delete by id**************************************
//deleteDocument(client, "index11", "type", "101");
//*****************************************
}
	
    public static void getDocument(Client client, String index, String type, String id){
        
        GetResponse getResponse = client.prepareGet(index, type, id)
                                        .execute()
                                        .actionGet();
        System.out.println("------------------------------");
        System.out.println("Index: " + getResponse.getIndex());
        System.out.println("Type: " + getResponse.getType());
        System.out.println("Id: " + getResponse.getId());
        System.out.println("Version: " + getResponse.getVersion());
        System.out.println(getResponse.getSource());
        System.out.println("------------------------------");
        
    }
    
    public static void deleteDocument(Client client, String index, String type, String id){
        
        DeleteResponse response = client.prepareDelete(index, type, id).execute().actionGet();
        System.out.println("Information on the deleted document:");
        System.out.println("Index: " + response.getIndex());
        System.out.println("Type: " + response.getType());
        System.out.println("Id: " + response.getId());
        System.out.println("Version: " + response.getVersion());
    }

public static Map<String, Object> putJsonDocument(String title, String content, Date postDate, 
            String[] tags, String author){
Map<String, Object> jsonDocument = new HashMap<String, Object>();
jsonDocument.put("title", title);
jsonDocument.put("content", content);
jsonDocument.put("postDate", postDate);
jsonDocument.put("tags", tags);
jsonDocument.put("author", author);

return jsonDocument;
}
}
