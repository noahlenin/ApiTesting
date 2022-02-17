package EndtoEndBusinessScenario;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Gui_End_To_End {

	@Test
	public void gui_EndToEnd()
	{
		String exp="Avengers851";
		String act=null;
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8084/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		
		
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		
		List<WebElement> ele = driver.findElements(By.xpath("//table[@class='table table-striped table-hover']//td[2]"));
		
		for(WebElement a:ele)
		{
			if(a.getText().equals(exp)) {
				act=a.getText();
				break;
			}
			
		}
		System.out.println(act);
		driver.close();
		
	
		
	}
}
