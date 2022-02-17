package crudUsingBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Random;

public class CreateHashProject {
	@Test
	public void createHash()
	{
		Random random = new Random();
		int ranNum = random.nextInt(1000);
		HashMap map = new HashMap();
		map.put("createdBy", "noa");
		map.put("projectName", "bye"+ranNum);
		map.put("status", "done");
		map.put("teamSize", 5);
		
		given().body(map)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.and()
		.assertThat()
		.contentType("application/json")
		.and()
		.log().all();
		
		
	}

}
