package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CandyMapperTaskTest {
	@Test
	public void selectOption() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://candymapper.com/");

		driver.findElement(By.xpath("//*[local-name()='svg' and contains(@id,'popup-widget')]")).click();
		WebElement socialText = driver.findElement(By.xpath("//span[contains(text(),'Connect with us')]"));
		Actions act = new Actions(driver);
		act.scrollToElement(socialText).perform();
		WebElement frame = driver.findElement(By.xpath("(//iframe[contains(@id,'iframe')])[2]"));
		driver.switchTo().frame(frame);
		
		WebElement countryDropdown = driver.findElement(By.xpath("//select[@id='tCounty']"));
		Select sel = new Select(countryDropdown);
		sel.selectByIndex(15);
		String value = sel.getFirstSelectedOption().getText();
		System.out.println(value);
		
		driver.quit();
	}

}
