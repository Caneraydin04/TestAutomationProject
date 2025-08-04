package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class AmazonLogoutTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver", "C:\\broswer\\chromedriver.exe");

	        // WebDriver başlat
	        WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();

	        // 1. Google'a git
	        driver.get("https://www.google.com");

	        // 2. Çerezleri kabul et (gerekirse)
	        try {
	            WebElement kabulEt = driver.findElement(By.xpath("//div[contains(text(),'Kabul et')]"));
	            kabulEt.click();
	        } catch (Exception e) {
	            // buton görünmüyorsa geç
	        }

	        // 3. Arama kutusuna "amazon" yaz ve Enter'a bas
	        WebElement aramaKutusu = driver.findElement(By.name("q"));
	        aramaKutusu.sendKeys("amazon");
	        aramaKutusu.submit();

	        // 4. İlk çıkan sonuca tıkla
	        WebElement ilkSonuc = driver.findElement(By.cssSelector("h3"));
	        ilkSonuc.click();

	        // 5. "Hesaplar ve Listeler" menüsüne git
	        Actions actions = new Actions(driver);
	        WebElement hesaplarMenusu = driver.findElement(By.id("nav-link-accountList"));
	        actions.moveToElement(hesaplarMenusu).perform();

	        // 6. Çıkış butonuna tıkla (eğer giriş yaptıysan görünür)
	        try {
	            WebElement cikisButonu = driver.findElement(By.xpath("//span[text()='Çıkış Yap']"));
	            cikisButonu.click();
	            System.out.println("Çıkış yapıldı.");
	        } catch (Exception e) {
	            System.out.println("Çıkış butonu görünmüyor. Belki giriş yapılmamıştır.");
	        }

	        // Tarayıcıyı kapat
	        driver.quit();
	}

}
