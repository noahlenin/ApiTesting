package response_Validation;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class Dynamic_Validation {
	
	@Test
	public void dynamic_valid()
	{
		String expectedName="bye803";
		
		Response response = when().get("http://localhost:8084/projects");
		
		response.then().log().all();
		
		String actualProject=null;
		List<String> responseProject = response.jsonPath().get("projectName");
		
		for(String singleProject:responseProject)
		{
		if(singleProject.equals(expectedName)) {
			
			actualProject = singleProject;
		break;
		}
		//Assert.assertEquals(actualProject, expectedName);
		}
		Assert.assertEquals(actualProject, expectedName);
		System.out.println(actualProject);
				
}

}
