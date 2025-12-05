package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC_ShadowRoot_006_Test {
	@Test
	public void tolearnShadowRootElements()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/shadow?sublist=0");
		
		driver.findElement(By.xpath("//section[contains(text(),'Shadow ')]")).click();
		driver.findElement(By.xpath("//section[text()='Shadow Root']")).click();
		
		SearchContext shadow_host = driver.findElement(By.xpath("//form/div[1]")).getShadowRoot();
		shadow_host.findElement(By.cssSelector("input[type='text']")).sendKeys("Rashmi");
		
		
		
		
	}
	

}
