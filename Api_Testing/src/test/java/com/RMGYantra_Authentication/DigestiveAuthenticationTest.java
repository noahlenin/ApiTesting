package com.RMGYantra_Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DigestiveAuthenticationTest {
	@Test
	public void digestiveAuth()
	{
		given()
			.auth().digest("rmgyantra", "rmgy@9999")
		.when()
			.get("http://localhost:8084/login")
		.then()
		 	.statusCode(202)
		 	.log();

	}

}
