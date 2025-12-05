package taskpractice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC_TestAuto_006_Test {
	@Test
	public void ToPerformDragAndDrop() throws InterruptedException{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(3000);
		
		//scroll down
		WebElement scrollslider = driver.findElement(By.xpath("//h2[text()='Slider']"));
		Actions act=new Actions(driver);
		Thread.sleep(3000);

		act.scrollToElement(scrollslider).perform();
		
		//drag and drop
		
		WebElement dragBox = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dropBox = driver.findElement(By.xpath("//div[@id='droppable']"));
		Thread.sleep(3000);

		act.dragAndDrop(dragBox, dropBox).perform();
		
		//upload files
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[text()='Upload Single File']")).click();
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\sahoo\\OneDrive\\Desktop\\System Testing Scenarios.pptx");
		Thread.sleep(3000);
		
		//upload multiple files
		
		driver.findElement(By.xpath("//button[text()='Upload Multiple Files']")).click();
		
		WebElement multipleFile = driver.findElement(By.xpath("//input[@id='multipleFilesInput']"));
		String filepath1 = "C:\\Users\\sahoo\\OneDrive\\Desktop\\Project PPT.pptx";
		String filepath2 = "C:\\Users\\sahoo\\OneDrive\\Desktop\\System Testing Scenarios.pptx";
		multipleFile.sendKeys(filepath1 + "\n"+ filepath2);
		Thread.sleep(3000);

	

		//Scrolling in dropdown
		WebElement scrolltoLabels = driver.findElement(By.xpath("//h2[text()='Labels And Links']"));
		Thread.sleep(3000);

		act.scrollToElement(scrolltoLabels).perform();
		
		driver.findElement(By.xpath("//input[@id='comboBox']")).click();
		Thread.sleep(3000);

		WebElement item = driver.findElement(By.xpath("//div[text()='Item 42']"));
		Thread.sleep(3000);

		act.scrollToElement(item).perform();
		
		Thread.sleep(9000);
		driver.quit();


		
		
	}
	

}
