package rmgYantra_PojoClass;

import static io.restassured.RestAssured.*;

import gereniricLib.PojoClass;
import io.restassured.http.ContentType;

public class createProject_Using_PojoClass {
	
	public void createProject()
	{
		
		PojoClass pojoObj = new PojoClass("noa1","helo","completed",10);
		
		given()
		.contentType(ContentType.JSON)
		.body(pojoObj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.and()
		.assertThat().statusCode(201)
		.assertThat().log().all();
	}

}
