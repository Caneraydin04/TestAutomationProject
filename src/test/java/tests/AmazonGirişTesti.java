package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AmazonGirişTesti {

	public static void main(String[] args) {
		
		
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.com.tr/");

		try {
			
			
			driver.get("https://amazon.com.tr/");
			
			
			driver.manage().window().maximize();
			
			try {
				WebElement acceptCookies= driver.findElement(By.id("sp-cc-accept"));
			    acceptCookies.click();
			}catch (Exception e) {
				System.out.println("çerez bildirimi bulunmadı");
			}
			
			
			WebElement hesapVeListeler= driver.findElement(By.id("nav-link-accountList"));
			hesapVeListeler.click();
			
			
			  // E-posta gir
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
            WebElement emailInput = driver.findElement(By.id("ap_email_login"));
            emailInput.sendKeys("ahmetcaneraydin@hotmail.com");

            driver.findElement(By.id("continue")).click();

            // Şifre gir
            WebElement passwordInput = driver.findElement(By.id("ap_password"));
            passwordInput.sendKeys("qwer1112");

            driver.findElement(By.id("signInSubmit")).click();

            // Başarılı giriş kontrolü (örnek: hesap ismi görünüyor mu?)
            WebElement hesapMenu = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
            if (hesapMenu.getText().contains("caner")) {
                System.out.println("✅ Başarılı giriş yapıldı.");
            } else {
                System.out.println("❌ Giriş başarısız.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Tarayıcıyı kapat
            driver.quit();
        }
		}
		
	}


