package crudUsingBDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;

public class UpdateProject {
	
	public void updateproject()
	{
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "noalen");
		jobj.put("projectName", "helo12");
		jobj.put("status", "created");
		jobj.put("teamSize", 5);
		
		
	}

}
