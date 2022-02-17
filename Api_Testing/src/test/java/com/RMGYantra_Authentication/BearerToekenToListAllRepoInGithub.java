package com.RMGYantra_Authentication;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class BearerToekenToListAllRepoInGithub {

	
	@Test
	public void bearerToekenToList()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("name","Bearer token authentication repo");
		jobj.put("description", "Test repo");
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
			.auth().oauth2("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")
		.when()	
			.post("https://api.github.com/user/repos")
		.then()	
			.assertThat().statusCode(201)
			.time(Matchers.lessThan(3000l),TimeUnit.MILLISECONDS)
			.log().all();
	}		

}
