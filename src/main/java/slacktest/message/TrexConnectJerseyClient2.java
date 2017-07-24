//不要の可能性あり
package slacktest.message;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

public class TrexConnectJerseyClient2 {
	public static void executeTrexGet(String url){

		Client client = ClientBuilder.newClient();
		System.out.println("===== HTTP GET Start =====");



		try {
			/*Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
			Response response = builder.get(Entity.entity(param,MediaType.APPLICATION_JSON), Response.class);*/

			WebTarget target = client.target(url);
		    //.path(path);
			System.out.println("WebTarget target = client.target(url);");

			Invocation.Builder builder = target.request();
			System.out.println("Invocation.Builder builder = target.request();");

			final String responseString = builder.get(String.class);
			System.out.println("String responseString  = builder.get(String.class);");

			System.out.println(responseString);
			System.out.println("System.out.println(responseString );");

		} catch (BadRequestException e) {
		    //logger.error("response=" + e.getResponse().readEntity(String.class), e);
		    throw e;
		}

		System.out.println("===== HTTP GET End =====");

		/*User user = target.resolveTemplate("id", 1)
		    .request(MediaType.APPLICATION_XML)
		    .get(User.class);*/


		/*System.out.println(user);*/
		// => User(id=1, name=John, age=25)
	}





	/*
	public static void executeJerseyGet(String url,String path) {
        System.out.println("===== HTTP GET Start(JerseyGet) =====");

        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target(url)
        	    .path(path)
        	    .queryParam("token", "shortAccessToken");

        	try {
        	    String result = target.request().get(String.class);
       	       System.out.println(result);
        	} catch (BadRequestException e) {
        		System.out.println("BItFlyerError1");
        	    throw e;
        	}


        System.out.println("===== HTTP GET End =====");
        }*/
}