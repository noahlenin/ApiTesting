package chickenCoop;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class OauthAuthenGet {
	@Test
	public void oauthGet()
	{
		
		
		Response response = given()
				.formParam("client_id", "Noah")
				.formParam("response_type", "d31cf61f926ea976caac0fe588fb6ba333e6fc58")
				.formParam("redirect_uri", "authorization_code")
			  //.formParam("grant_type", "Noah")
				.formParam("scope", "barn-unlock")
			.when()
				.get("http://coop.apps.symfonycasts.com/token");
				response.prettyPrint();
				String accesstoken=response.jsonPath().get("access_token");
						
			given()
				.auth().oauth2(accesstoken)
				.pathParam("USER_ID","2822")
			.when()
			 	.get("http://coop.apps.symfonycasts.com/api/me")
			.then()
			 	.assertThat().time(Matchers.lessThan(3000l),TimeUnit.MILLISECONDS)
			 	.log().all();

	}

}
