package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

public class TC_RelativeLocators_005_Test {
	@Test
	public void toLearnRelativeLocator() throws InterruptedException{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demowebshop.tricentis.com/");
		
		//near locator
		// click on login link
		
		driver.findElement(RelativeLocator.with(By.tagName("a")).near(By.xpath("//a[text()='Register']"))).click();
		
		//above and below locator
		
		driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.xpath("//input[@name='Password']"))).sendKeys("rashmi123@gmail.com");
		
		driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.xpath("//input[@name='Email']"))).sendKeys("rashmi@12345");
		
		driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.xpath("//input[@name='Password']"))).click();
		
		
		
		
		
		
	}
	

}
