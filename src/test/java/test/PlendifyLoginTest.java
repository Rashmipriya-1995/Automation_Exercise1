package test;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import java.time.Duration;

	public class PlendifyLoginTest {
	    public static void main(String[] args) {
	        // Setup ChromeDriver
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        // Open Plendify login page
	        driver.get("https://plendify.com/");

	        // Step 1: Enter email/phone
	        driver.findElement(By.id("email")).sendKeys("testuser@example.com");

	        // Step 2: Enter password
	        driver.findElement(By.id("password")).sendKeys("TestPassword123");

	        // Step 3: Click login button
	        driver.findElement(By.id("loginBtn")).click();

	        // Step 4: Handle OTP
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement otpField = wait.until(
	                ExpectedConditions.presenceOfElementLocated(By.id("otp"))
	            );

	            // Step 5: Enter test OTP
	            String testOTP = "123456"; // fixed OTP for practice
	            otpField.sendKeys(testOTP);

	            // Step 6: Submit OTP
	            driver.findElement(By.id("submitOtp")).click();

	            System.out.println("OTP entered successfully");

	        } catch (Exception e) {
	            System.out.println("OTP page not displayed, login may be direct");
	        }

	        // Step 7: Verify login
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dashboard")));
	            System.out.println("Login successful!");
	        } catch (Exception e) {
	            System.out.println("Login failed or dashboard not found.");
	        }

	        // Close browser
	        driver.quit();
	    }
	}


