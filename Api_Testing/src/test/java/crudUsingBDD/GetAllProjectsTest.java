package crudUsingBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;//.* means all /making this static import

public class GetAllProjectsTest {

	@Test
	public void getallprojects()
	{
		when().get("http://localhost:8084/projects")
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.assertThat()
		.contentType("application/json")
		.and().log().all();
		
	}
}
