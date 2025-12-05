package test;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLinksTest {
	
	@Test
	public void toHandleBrokenLinks() throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.epfindia.gov.in/");
		
		//to get all the links present in the application
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
//		driver.findElements(By.tagName("a"));
		//count all the links
		System.out.println(allLinks.size());
		
		for(WebElement link:allLinks)
		{
			@Nullable
			String eachlink = link.getDomAttribute("href");
//			String eachlink=link.getAttribute("href");// next version it will not work(depricated)
			
			//create URL object
			try {
			URL url=new URL(eachlink); // it will throw MalformedURLException instead of that give Throwable exception, it can handle any type of exception
//			URI uri=new URI(eachlink);// URL is depricated we can use URI object
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection(); // openConnection return type is URLConnection, type cast to HttpURLConnection, in order to find getResponseCode()
			int statusCode = httpConn.getResponseCode();
			if(statusCode>=400) {
				System.out.println(eachlink+"--->"+statusCode);
			}
		}
		catch (Exception e) {
		}
		
		}
	}
}


