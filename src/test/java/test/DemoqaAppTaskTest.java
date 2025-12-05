package test;

import java.time.Duration;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoqaAppTaskTest {
	@Test
	public void handlingWindowsTest() throws InterruptedException
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		try {
		driver.get("https://demoqa.com/");
		WebElement alertLink = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",alertLink );
		Thread.sleep(4000);
		WebElement browserWindowLink = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
		js.executeScript("arguments[0].click();",browserWindowLink );
		WebElement messageWindowButton = driver.findElement(By.id("messageWindowButton"));
		js.executeScript("arguments[0].scrollIntoView(true);",messageWindowButton );
		
		messageWindowButton.click();
		Set<String> allIds = driver.getWindowHandles();
		String parentId = driver.getWindowHandle();
		
		for(String id:allIds)
		{
			if(!id.equals(parentId))
			{	
				driver.switchTo().window(id);
				
			 System.out.println(driver.findElement(By.tagName("body")).getText());
	            driver.close();
	        }
	    }
				
			
		
		 driver.switchTo().window(parentId);
	        System.out.println("Back to parent window: " + driver.getTitle());
		}
		finally {
	        driver.quit(); // close everything
		}
	}

}
