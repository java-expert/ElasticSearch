/*import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;


public class FirstExample {
	public static void main(String[] args) {
		try{
		System.out.println("End");
		//Client client = NodeBuilder.nodeBuilder().node().client();
		Settings settings = ImmutableSettings.settingsBuilder().put("cluster.name", "localtestsearch").build();
			TransportClient transportClient = new TransportClient(settings);
			transportClient = transportClient.addTransportAddress(new InetSocketTransportAddress("localhost", 9200));
			Client client1 =transportClient;
			
			GetRequestBuilder getRequestBuilder = client1.prepareGet("movies", "movie", "1");
				getRequestBuilder.setFields(new String[]{"title"});
				GetResponse response = getRequestBuilder.execute().actionGet();
				String name = response.getSourceAsString();
				System.out.println(name);
		}catch(Exception e){
			System.out.println("error");
		}
	}
}
*/