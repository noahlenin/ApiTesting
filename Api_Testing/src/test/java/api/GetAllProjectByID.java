package api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllProjectByID {

	
	@Test
	public void getAllProjects()
	{
		Response response = RestAssured.get("http://localhost:8084/projects/");
		System.out.println(response.asString());
	//	System.out.println(response.prettyPrint());
		System.out.println("content "+response.getContentType());
		System.out.println("getStatusCode "+response.getStatusCode());
		System.out.println("getSessionId "+response.getSessionId());
		System.out.println("getTime "+response.getTime());
		System.out.println("getStatusCode "+response.getStatusCode());
		System.out.println("getBody "+response.getBody());
	//	int actualStatus = response.getStatusCode();
	//	Assert.assertEquals(actualStatus, 200);
		
		ValidatableResponse validateResp = response.then();
		validateResp.assertThat().statusCode(200);
		validateResp.assertThat().contentType("application/json");
		validateResp.log().all();
		
	}
}
