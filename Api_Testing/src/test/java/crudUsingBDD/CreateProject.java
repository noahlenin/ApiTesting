package crudUsingBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProject {
	@Test
	public void createproject()
	{
		//4 ways to send file json object,json file,pojo class,hash map
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "noah12");
		jobj.put("projectName", "helo");
		jobj.put("status", "onProgress");
		jobj.put("teamSize", 3);
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then().assertThat().statusCode(201)
		.and()
		.assertThat().contentType("application/json")
		.and().assertThat().log().all();
		
		
	}

}
