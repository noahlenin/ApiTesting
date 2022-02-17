package crudUsingBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DeleteAllProject {
@Test
	public void deleteproject() {
		
	when().delete("http://localhost:8084/projects/TY_PROJ_011")
	.then().assertThat()
	.statusCode(204)
	.and()
	.assertThat()
	.contentType("application/json").and().log().all();
		
		
		
	}
}
