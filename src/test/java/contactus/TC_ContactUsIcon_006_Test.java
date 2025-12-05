package contactus;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_ContactUsIcon_006_Test {
	@Test
	public void contactUs() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://automationexercise.com/");
		Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Home page is not displayed");
		Reporter.log("Home page is displayed", true);
		
		driver.findElement(By.xpath("//a[text()=' Contact us']")).click();
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - Contact Us", "Get In Touch page is not displayed");
		Reporter.log("Get In Touch page is displayed", true);
		
		driver.findElement(By.xpath("//input[@data-qa='name']")).sendKeys("Srinivash Sahoo");
		driver.findElement(By.xpath("//input[@data-qa='email']")).sendKeys("sahoosrinivash1234@gmail.com");
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("Testing Application");
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("We need some Test Engineers to do Acceptance Testing");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\sahoo\\OneDrive\\Desktop\\System Testing Scenarios.pptx");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		
		
		Alert popup = driver.switchTo().alert();
		popup.accept();
		
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - Contact Us", "Success! Your details have been submitted successfully message is not displayed");
		Reporter.log("Success! Your details have been submitted successfully message is displayed", true);
		
		driver.findElement(By.xpath("//span[text()=' Home']")).click();
		
		Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Home page is not displayed");
		Reporter.log("Home page is displayed", true);
		
		Thread.sleep(3000);
		driver.close();
		
		
		
		
		}
	}
		
		
		
	


