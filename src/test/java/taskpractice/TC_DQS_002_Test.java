package taskpractice;

import java.io.IOException;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_DQS_002_Test {
	
	@Test
	public void ToLearnMulipleWindow() throws InterruptedException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demoapps.qspiders.com/ui/browser/multipleWindow?sublist=2");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[text()='Shop Now']")).click();
		Thread.sleep(3000);
		switchToWindow(driver, "product");
		driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
		Thread.sleep(3000);

		switchToWindow(driver, "product/2");
		driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
		
		Thread.sleep(3000);

		switchToWindow(driver, "product/3");
		driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
		
		Thread.sleep(3000);

		switchToWindow(driver, "product/4");
		driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
		
		Thread.sleep(6000);
		driver.quit();
		
	}
	
	public void switchToWindow(WebDriver driver, String expURL) {
		Set<String> allWindowids = driver.getWindowHandles();
		for(String id:allWindowids) {
		driver.switchTo().window(id);
		
		 if(driver.getCurrentUrl().contains(expURL))
			 break;
	}
		
	}
	
		

}
