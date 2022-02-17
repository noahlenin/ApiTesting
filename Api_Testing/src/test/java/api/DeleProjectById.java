package api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleProjectById {

	@Test
	public void deleteProjByid()
	{
		Response response = RestAssured.delete("http://localhost:8084/employees/TYP_00001");
		ValidatableResponse res = response.then();
		res.assertThat().statusCode(204);
		res.assertThat().log().all();
		
		
	}
}
