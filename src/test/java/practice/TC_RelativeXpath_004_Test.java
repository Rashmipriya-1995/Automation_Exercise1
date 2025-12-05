package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_RelativeXpath_004_Test {
	@Test
	public void toLearnAncestorAndDescendantTechnique() throws InterruptedException{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demowebshop.tricentis.com/");
		
		//select excellent radio button
		driver.findElement(By.xpath("//input[@id='pollanswers-2']/../preceding-sibling::li/input")).click();
		
		Thread.sleep(3000);
		//select poor radio button
		driver.findElement(By.xpath("//input[@id='pollanswers-2']/../following-sibling::li[1]/input")).click();
		
		Thread.sleep(3000);

		
		//select good radio button
		driver.findElement(By.xpath("//input[@id='pollanswers-4']/parent::li/../li[2]/input")).click();
		Thread.sleep(3000);

	}
	

}
