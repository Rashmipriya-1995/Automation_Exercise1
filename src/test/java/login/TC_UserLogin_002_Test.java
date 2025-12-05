package login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_UserLogin_002_Test {
	
	@Test
	public void login() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://automationexercise.com/");
		Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Home page is not displayed");
		Reporter.log("Home page is displayed", true);
		
		driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - Signup / Login", "Login to your account page is not displayed");
		Reporter.log("Login to your account page is displayed", true);
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("sahoorojalin125@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("roja@1234");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Logged in as Rojalin Sahoo page is not displayed");
		Reporter.log("Logged in as Rojalin Sahoo page is displayed", true);
		
		Thread.sleep(3000);
		driver.quit();
		
		
		
	}
	

}
