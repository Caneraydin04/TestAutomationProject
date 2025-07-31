package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;

public class FormValidationTest {

	WebDriver driver;
	
	
	@BeforeMethod
	
	public void setUp() {
		
		
		WebDriverManager.chromedriver().setup();

		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
	}
	@Test
	public void testMandatoryFieldValidation() {
	    
	    // Butonu bul ve JavaScript ile tıkla
	    WebElement submitBtn = driver.findElement(By.cssSelector("button"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);

	    // Tıklamadan SONRA bekleyip elementin gelmesini sağla
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement alertMessage = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert"))
	    );

	    // Assert ile doğrulama yap
	    Assert.assertTrue(alertMessage.isDisplayed(), "Hata mesajı gösterilmedi!");
	}

	
	@AfterMethod
	
	public void tearDown() {
		
		driver.quit();
	}
}
