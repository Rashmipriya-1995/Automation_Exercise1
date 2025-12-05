package taskpractice;

import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class TC_DWS_001_Test {
	@Test
	public void ToAdd3Products() throws InterruptedException, IOException {
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//a[text()='14.1-inch Laptop']/../..//input[@value='Add to cart']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//a[contains(text(),'Books')])[3]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[contains(text(),'Computing')]/../..//input[@type='button']")).click();
		Thread.sleep(1000);

		driver.navigate().back();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//a[contains(text(),'Electronics')])[3]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Cell phones')])[3]")).click();
		driver.findElement(By.xpath("//a[text()='Smartphone']/../..//input[@type='button']")).click();
		Thread.sleep(1000);

		driver.navigate().back();
		driver.navigate().back();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();

		String time = LocalDateTime.now().toString().replace(":", "_");
		TakesScreenshot ts=(TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshots/"+time+".png");
		FileHandler.copy(temp, dest);
		
		
		Thread.sleep(4000);
		driver.quit();
		
		
	}

}
