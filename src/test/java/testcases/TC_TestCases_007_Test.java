package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_TestCases_007_Test {
	
	@Test
	public void testCases() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://automationexercise.com/");
		Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Home page is not displayed");
		Reporter.log("Home page is displayed", true);
		
		driver.findElement(By.xpath("//a[text()=' Test Cases']")).click();
		
		Assert.assertEquals(driver.getTitle(), "Automation Practice Website for UI Testing - Test Cases", "Test cases page is not displayed");
		Reporter.log("Test Cases page is displayed", true);
		
		Thread.sleep(3000);
		driver.close();
		
	

}
}
