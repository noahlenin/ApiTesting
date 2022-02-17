package response_Validation;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class static_Response_Validation {
	@Test
	public void staticValidation()
	{
		
		
		String expectedName="api";
		
		Response response = when().get("http://localhost:8084/projects");
		
		response.then().assertThat().statusCode(200).log().all();
		
		String actualName = response.jsonPath().get("[1].projectName");
		
		System.out.println(actualName);
		Assert.assertEquals(actualName,expectedName);
		
		
		
		
		
		
	}

}
