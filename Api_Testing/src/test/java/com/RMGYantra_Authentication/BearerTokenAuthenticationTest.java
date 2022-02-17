package com.RMGYantra_Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerTokenAuthenticationTest {
	@Test
	public void bearerTokenAuth()
	{
		given()
			.auth().oauth2("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")
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.assertThat().statusCode(200)
			.log().all();
	
	}

}
