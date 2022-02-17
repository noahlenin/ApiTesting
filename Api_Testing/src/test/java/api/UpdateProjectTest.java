package api;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {
	
	@Test
	public void updateProject()
	{
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "snl");
		jobj.put("projectName", "s");
		jobj.put("status", "completed");
		jobj.put("teamSize", 5);
		
		
		RequestSpecification res = RestAssured.given();
		res.contentType(ContentType.JSON);
		res.body(jobj);
		Response resp = res.put("http://localhost:8084/projects/TY_PROJ_004");
		ValidatableResponse valid = resp.then();
		valid.assertThat().statusCode(200);
		valid.assertThat().contentType("application/json");
		valid.assertThat().log().all();
		
		
	}



}
