package practice;

import java.time.Duration;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_Iframe_001_Test{
	@Test
	public void tolearnAncestor()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.myntra.com/");
		
	WebElement	searchTf=driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
	searchTf.sendKeys("Kurta");
	driver.findElement(By.xpath("(//li[@class='desktop-suggestion null'])[2]")).click();
	driver.findElement(By.xpath("(//li[@class='product-base'])[1]")).click();
//	driver.findElement(By.xpath("//img[@title='Kurtas Women Black Printed Kurta']")).click();
	
	Set<String> allids = driver.getWindowHandles();
	for(String id:allids) {
		driver.switchTo().window(id);
		@Nullable
		String actUrl = driver.getCurrentUrl();
		if(actUrl.contains("sangria"))
			break;
	}
	String productdetails = driver.findElement(By.xpath("//div[@class='pdp-productDescriptorsContainer']")).getText();
	Reporter.log(productdetails, true);
	
	driver.close();
		
		
	}
	

}
