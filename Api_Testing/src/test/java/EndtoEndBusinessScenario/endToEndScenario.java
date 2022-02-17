package EndtoEndBusinessScenario;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.mysql.cj.jdbc.Driver;
import gereniricLib.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class endToEndScenario {

	@Test
	public void endToEndScenario() throws SQLException
	{
		//Create a body using POJO class
		Random random = new Random();
		int randomNumber = random.nextInt(1000);
		
		String expectedProjectName="Avengers"+randomNumber;
		String expectedStatus="Completed";
		PojoClass pojoObj = new PojoClass("Doctor_Strange",expectedProjectName,"Completed",2);
		
		//Giving preconditions for the post request		
				 Response response = given()
		.body(pojoObj)
		.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject");
				 
				//captuing the project name and id  from the reponse received from 
		
				 
				String responseProjectName = response.jsonPath().get("projectName");
				String responseProjectId = response.jsonPath().get("projectId");
				
				System.out.println(responseProjectName);
				System.out.println(responseProjectId);
				
				
				//restassured assertions for validating
				response.then()
				.assertThat().statusCode(201)
				.contentType(ContentType.JSON)
				.time(Matchers.lessThan(3000l),TimeUnit.MILLISECONDS)
				.log().all();
				 
				//JDBC:Register the JDBC driver
				Driver driver = new Driver();
				DriverManager.registerDriver(driver);
				
				//Connect to mySql database
				
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
				
				//Create a statement
				
				Statement statement = connection.createStatement();
				
				//Execute Select Query and get all the project
				ResultSet result = statement.executeQuery("select * from project");
				
				String dataBaseProjectName=null;
				String dataBaseStatus=null;
				String databaseProjectId=null;
				
				while(result.next())
				{
				   if(result.getString(4).equals(expectedProjectName))	
				   {
					dataBaseProjectName=result.getString("project_name");
					databaseProjectId=result.getString("project_id");
					dataBaseStatus=result.getString("status");
					
					
					break;
					
				   }
				}
				
				//Close the Database connection
				connection.close();
				
				System.out.println(dataBaseProjectName);
				System.out.println(dataBaseStatus);
					
				
				Assert.assertEquals(responseProjectName, expectedProjectName);
				Assert.assertEquals(dataBaseProjectName, expectedProjectName);
				Assert.assertEquals(responseProjectId, databaseProjectId);
				Assert.assertEquals(dataBaseStatus, expectedStatus);
				
				
				System.out.println("***************Selenium******************");
				String exp="Avengers851";
				String act=null;
				WebDriver driver1 = new ChromeDriver();
				
				driver1.get("http://localhost:8084/");
				driver1.manage().window().maximize();
				driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				driver1.findElement(By.id("usernmae")).sendKeys("rmgyantra");
				driver1.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
				driver1.findElement(By.xpath("//button[text()='Sign in']")).click();
				
				
				
				driver1.findElement(By.xpath("//a[text()='Projects']")).click();
				
				List<WebElement> ele = driver1.findElements(By.xpath("//table[@class='table table-striped table-hover']//td[2]"));
				
				for(WebElement a:ele)
				{
					if(a.getText().equals(exp)) {
						act=a.getText();
						break;
					}
					
				}
				System.out.println(act);
				driver1.close();
					

				
	}
}
