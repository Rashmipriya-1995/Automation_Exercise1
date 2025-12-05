package taskpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_Clinique_005_Test {
	
	@Test
	public void TolearnSVGTag() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.clinique.in/");
		
		WebElement cartSymbol = driver.findElement(By.xpath("//*[local-name()='svg' and contains(@class,'cart-icon')]"));
	}

}
