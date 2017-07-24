package slacktest.message;

import java.io.IOException;

import com.ullink.slack.simpleslackapi.SlackChannel;
import com.ullink.slack.simpleslackapi.SlackSession;
import com.ullink.slack.simpleslackapi.impl.SlackSessionFactory;

public class SlackTest {

	public static void main(String[] args) {

		XMLReader reader=new XMLReader();
		String token = "xoxp-199592638803-199667632834-202539242225-fa99d0afa4e3956f4f71036b359cfa78";
		String channel ="bottest";
		String message = "Test!!!!晴れですね。雨の可能性も認識しているよ。";


		String  urlEndPoint="https://bittrex.com/api/v1.1";
		String path ="/public/getmarkethistory";
		String query ="?market=BTC-DOGE";

		//bitflyerからAPIを取得する場合は下記
		/*String urlEndPoint ="https://api.bitflyer.jp";
		String path = "/v1/ticker";
		String query = "?product_code=ETH_BTC";
*/		String url = null;




		try{
			printSlackChannelList(token);
			sendSlackMessage(token,channel,message);

		}catch (IOException e) {
			e.printStackTrace();
		}

		try{
			url =urlEndPoint + path+ query;
			BitFlyerConnectJerseyClient.executeJerseyGet(url);

		}catch(RuntimeException r){
			System.out.println("BitFlyerError0");
			r.printStackTrace();
		}
	}

	public static void sendSlackMessage(String authToken,String channelName,String message)throws IOException{
		SlackSession session = SlackSessionFactory.createWebSocketSlackSession(authToken);
		session.connect();
		SlackChannel channel = session.findChannelByName(channelName);
		session.sendMessage(channel, message);
		session.disconnect();
	}

	private static void printSlackChannelList(String authToken)throws IOException{
		SlackSession session = SlackSessionFactory.createWebSocketSlackSession(authToken);
		session.connect();
		session.getChannels().forEach(c -> System.out.println(c.getName()));
		session.disconnect();


	}

}
