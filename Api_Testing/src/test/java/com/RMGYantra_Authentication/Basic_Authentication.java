package com.RMGYantra_Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Basic_Authentication {
	@Test
public void basicAuth()
{

	given()
		.auth().basic("rmgyantra", "rmgy@9999")
		
	.when()
		.get("http://localhost:8084/login")
		
	.then()
		.assertThat().statusCode(202)
		.assertThat().log().all();
		
		
		
}
}
