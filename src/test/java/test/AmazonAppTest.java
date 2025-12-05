package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonAppTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//a[@data-csa-c-content-id='nav_cs_bestsellers']")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Book')])[2]")).click();
		List<WebElement> productTitle = driver.findElements(By.xpath("//div[@class='_cDEzb_p13n-sc-css-line-clamp-1_1Fn1y']"));
		 

		 List<WebElement> productPrice = driver.findElements(By.xpath("//div[@class='_cDEzb_p13n-sc-css-line-clamp-1_1Fn1y']/../../..//span[@class='_cDEzb_p13n-sc-price_3mJ9Z']"));
		
		  for (int i = 0; i < productTitle.size() && i < productPrice.size(); i++) {
	            String title = productTitle.get(i).getText();
	            String price = productPrice.get(i).getText();
	            System.out.println(title + "   " + price);
		
		
		
	}
		  
		  driver.quit();

	}
}
