package register_user;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class TC_RegisterUserWithExistingEmail_005_Test {
	
	public void userRegistration() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://automationexercise.com/");
		Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Home page is not displayed");
		Reporter.log("Home page is displayed", true);
		
		driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - Signup / Login", "New User Signup page is not displayed");
		Reporter.log("New User Signup page is displayed", true);
		
		driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Rojalin Sahoo");
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("sahoorojalin125@gmail.com");
		driver.findElement(By.xpath("//button[text()='Signup']")).click();
		
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - Signup / Login", "Email Address already exist! message is not displayed");
		Reporter.log("Email Address already exist! message is displayed", true);
		
		Thread.sleep(4000);
		driver.quit();
		
	}
	
}
