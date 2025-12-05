package test;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class GoogleTaskTest {
	@Test

	public void googleTaskClickOnChromeWebStoreTest() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//a[@aria-label='Google apps']")).click();
		Thread.sleep(2000);
		WebElement appsframe = driver.findElement(By.xpath("//iframe[contains(@src,'https://ogs.google.com/')]"));
		driver.switchTo().frame(appsframe);
		
		WebElement chromestore = driver.findElement(By.xpath("//span[text()='Chrome Web Store']"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", chromestore);
		Thread.sleep(2000);

		chromestore.click();
		
		driver.switchTo().defaultContent();
	
		
		String windowid = driver.getWindowHandle();
		Set<String> ids = driver.getWindowHandles();
		for(String id:ids) {
			driver.switchTo().window(id);
			if(driver.getCurrentUrl().contains("chromewebstore")) {
				break;
			}
			
		}
		driver.findElement(By.id("extensionsTabSecondary")).click();
		Thread.sleep(5000);
		driver.quit();

		
	}

}
