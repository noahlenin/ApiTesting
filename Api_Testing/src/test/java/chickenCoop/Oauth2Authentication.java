package chickenCoop;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class Oauth2Authentication {
	
	@Test
	
	public void oauth2Auth()
	{
		Response response = given()
			.formParam("client_id", "Noah")
			.formParam("client_secret", "18287a31998bb1766cc188a4f1025874")
			.formParam("grant_type", "client_credentials")
			.formParam("redirect_uri", "http://example.com")
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
			response.prettyPrint();
			String accesstoken=response.jsonPath().get("access_token");
					
		given()
			.auth().oauth2(accesstoken)
			.pathParam("USER_ID","2822")
		.when()
		 	.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
		.then()
		 	.assertThat().time(Matchers.lessThan(3000l),TimeUnit.MILLISECONDS)
		 	.log().all();

	}

}
