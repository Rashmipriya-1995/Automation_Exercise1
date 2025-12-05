package baisalimamsession;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class GoogleTask {
	@Test
	public void countingName() throws InterruptedException {
		  ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-blink-features=AutomationControlled");
	        
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("rashmi priya",Keys.ENTER);
		List<WebElement> allNames = driver.findElements(By.xpath("//*[contains(text(),'Rashmi Priya')]"));
		Thread.sleep(3000);
		System.out.println(allNames.size());
		
	}

}
