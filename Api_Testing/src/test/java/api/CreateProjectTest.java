package api;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {
	
	@Test
	public void createProject()
	{
	 
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Noah Lenin");
		jobj.put("projectName", "TCS");
	    jobj.put("status", "inprogress");
	    jobj.put("teamSize", 3);
	   
	    RequestSpecification rest = RestAssured.given();
	    rest.contentType(ContentType.JSON);
	    rest.body(jobj);
	    
	    Response resp = rest.get("http://localhost:8084/employees");
	    ValidatableResponse resp1 = resp.then();
	    resp1.assertThat().statusCode(200);
	    resp1.assertThat().contentType(ContentType.JSON);
	    resp1.assertThat().log().all();
		
	}

}
