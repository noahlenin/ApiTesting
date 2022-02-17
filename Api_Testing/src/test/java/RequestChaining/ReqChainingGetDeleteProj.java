package RequestChaining;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class ReqChainingGetDeleteProj {
	
	
	@Test
	public void reqChainingDel()
	{
  
		Response response = when().get("http://localhost:8084/projects");
		String responseProId = response.jsonPath().get("[0].projectId");
		System.out.println(responseProId);
				response.then()
		.assertThat().statusCode(200)
		.contentType(ContentType.JSON)
		.assertThat().time(Matchers.lessThan(3000l),TimeUnit.MILLISECONDS)
		.log().all();
		
	}

}
