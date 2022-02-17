package com.RMGYantra_Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PreemtiveAuthenticationTest {
	@Test
	public void preemtiveAuth()
	{
		given()
			.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.when()
			.get("http://localhost:8084/login")
		.then()		
		.statusCode(202)
		.log().all();
	}		
}
