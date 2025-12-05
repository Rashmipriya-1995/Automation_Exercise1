package taskpractice;

import java.io.IOException;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC_Clinic_004_Test {
	@Test
	public void ToLearnMousehover() throws InterruptedException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.clinique.in/");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));// manage Cookies
		
		//handle accept all

		WebElement acceptallElement = driver.findElement(By.xpath("//button[contains(text(),'ACCEPT ')]"));
		wait.until(ExpectedConditions.elementToBeClickable(acceptallElement));
		acceptallElement.click();
		WebElement skincarelink = driver.findElement(By.xpath("(//a[contains(text(),'Skincare')])[2]"));
		Actions act=new Actions(driver);
		act.moveToElement(skincarelink).perform();
		
		
		List<WebElement> alloptions = driver.findElements(By.xpath("//a[contains(@class,'item')]"));
		for(WebElement option:alloptions) {
			String text = option.getText();
			if(!text.isEmpty())
			{
				
				System.out.println(text);

			}
		
			
		}
		
		Thread.sleep(4000);
		driver.quit();

		
	

}
}
