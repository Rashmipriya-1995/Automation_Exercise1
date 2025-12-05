package register_user;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_RegisterUser_001_Test {
	@Test
	public void userRegistration() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://automationexercise.com/");
		Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Home page is not displayed");
		Reporter.log("Home page is displayed", true);
		
		driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
		 String signUptext = driver.findElement(By.xpath("//h2[text()='New User Signup!']")).getText();
		
		Assert.assertEquals(signUptext, "New User Signup!");
		Reporter.log("New User Signup! is visible", true);
		
		driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Rojalin Sahoo");
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("sahoorojalin00909@gmail.com");
		driver.findElement(By.xpath("//button[text()='Signup']")).click();
		
		String accountInformationText = driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]")).getText();
		
		Assert.assertEquals(accountInformationText,"ENTER ACCOUNT INFORMATION");
		Reporter.log("Enter Account Information is visible", true);

		driver.findElement(By.xpath("//label[@for='id_gender2']/..//input[@type='radio']")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("roja@1234");
		WebElement dayDropdown = driver.findElement(By.xpath("//select[@name='days']"));
		WebElement monthDropdown = driver.findElement(By.xpath("//select[@id='months']"));
		WebElement yearDropdown = driver.findElement(By.xpath("//select[@id='years']"));
		Select sel=new Select(dayDropdown);
		sel.selectByValue("15");
		Select sele=new Select(monthDropdown);
		sele.selectByVisibleText("May");
		Select selec=new Select(yearDropdown);
		selec.selectByValue("1995");
		driver.findElement(By.xpath("//label[contains(text(),'Sign up')]/..//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Receive special')]/..//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Rojalin");
		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Sahoo");
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("TCS, Tata Consultancy Services");
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Gandhi Nagar, Whitefield");
		driver.findElement(By.xpath("//input[@name='address2']")).sendKeys("EPIP Industrial Area");
		WebElement countryDropdown = driver.findElement(By.xpath("//select[@id='country']"));
		Select select=new Select(countryDropdown);
		select.selectByValue("India");
		driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("Karnataka");
		driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("560066");
		driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("6789034567");
		driver.findElement(By.xpath("//button[text()='Create Account']")).click();
		
		String accountcreatedText = driver.findElement(By.xpath("//b[text()='Account Created!']")).getText();
		Assert.assertEquals(accountcreatedText, "ACCOUNT CREATED!");
		Reporter.log("Account created is visible", true);
	
		
	

		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		String userloggedtext = driver.findElement(By.xpath("//b[text()='Rojalin Sahoo']")).getText();
		Assert.assertEquals(userloggedtext,  "Rojalin Sahoo");
		Reporter.log("Logged in as Rojalin Sahoo is visible", true);
		
		Thread.sleep(4000);

		driver.findElement(By.xpath("//a[text()='Delete Account']")).click();
		String useraccountDeletedtext = driver.findElement(By.xpath("//b[text()='ACCOUNT DELETED']")).getText();

		Assert.assertEquals(useraccountDeletedtext, "ACCOUNT DELETED!");
		Reporter.log("Account deleted is visible", true);
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		
		
		
		


		
		
	
		Thread.sleep(4000);
		driver.quit();		
		
		
	}

}
