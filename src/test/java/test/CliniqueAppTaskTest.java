package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CliniqueAppTaskTest {
	@Test
	public void cliniqueappTaskTest()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.clinique.com/");
		WebElement skincareLink = driver.findElement(By.xpath("(//span[text()='Skincare'])[1]"));
		Actions act=new Actions(driver);
		act.moveToElement(skincareLink).perform();
		
		List<WebElement> pList = driver.findElements(By.xpath("//a[text()='Shop All Skincare']/../div/ul/li/following-sibling::li"));
		System.out.println("List of all "+pList.size()+" skincare items :-");
		
		System.out.println("-------------------------------");
//		System.out.println();
		for(int i=0;i<=pList.size()-1;i++)
		{
			System.out.println((i+1)+". "+pList.get(i).getText());
		}
		
		driver.close();
		
		System.out.println();
	}
}
