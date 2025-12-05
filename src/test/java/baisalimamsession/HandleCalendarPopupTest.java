package baisalimamsession;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandleCalendarPopupTest {
	@Test
	public void handleCaledarPopupInRedBus() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.redbus.in/");
		String place1 = "Chennai";
		String place2 = "Bangalore";
		String date = "30";
		String month="September";

		WebElement formTextField = driver.findElement(By.xpath("//div[.='From']"));

		formTextField.click();
		// setTimeout(()=>{debugger},5000)// to freeze the option
		// to send data to the text field

		driver.findElement(By.xpath("//input[@id='srcDest']")).sendKeys(place1);
		driver.findElement(By.xpath("//div[contains(@aria-label,'" + place1 + "')]")).click();

		WebElement toTextField = driver.findElement(By.xpath("//div[.='To']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", toTextField);

		// to send data to the text field
		driver.findElement(By.xpath("//input[@id='srcDest']")).sendKeys(place2);
		driver.findElement(By.xpath("//div[contains(@aria-label,'" + place2 + "')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='dojWrapper___1f3d15']")).click();
		
		for(; ;) {
			try {
		driver.findElement(By.xpath("//p[text()='"+month+"']/../../following-sibling::ul//span[text()='"+date+"']")).click();
				break;
			}
			catch (Exception e) {
				driver.findElement(By.xpath("//i[contains(@aria-label,'Next month')]")).click();
			}
		}
		driver.quit();
	}

}
