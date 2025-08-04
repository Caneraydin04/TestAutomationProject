package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {
    public static void main(String[] args) {
        // ChromeDriver'ı otomatik kur
        WebDriverManager.chromedriver().setup();

        // Tarayıcıyı başlat
        WebDriver driver = new ChromeDriver();

        // Google'a git
        driver.get("https://www.google.com");

        // Arama kutusunu bul ve yazı yaz
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();

        // Sonuç sayfası başlığını yazdır
        try {
            Thread.sleep(2000); // sayfanın yüklenmesi için bekle
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Sayfa başlığı: " + driver.getTitle());

        // Tarayıcıyı kapat
        driver.quit();
    }
}