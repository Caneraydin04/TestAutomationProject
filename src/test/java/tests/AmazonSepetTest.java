package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
public class AmazonSepetTest {
	
	public static void main(String[] args){
WebDriverManager.chromedriver().setup();


WebDriverManager.chromedriver().setup();

WebDriver driver=new ChromeDriver();

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
try {
   driver.manage().window().maximize(); 

   driver.get("https://www.amazon.com.tr");
try {
	
	
	WebElement accept=driver.findElement(By.id("sp-cc-accept"));
	accept.click();

}catch (Exception e) {
	
}

WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

searchBox.sendKeys("bilgisayar");

searchBox.submit();
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
WebElement ilkUrun = driver.findElement(By.xpath("//a[contains(@href, '/Lenovo-IdeaCentre-Bilgisayar')]"));
ilkUrun.click();

// Ürün sayfası sekmesinde devam et
for (String winHandle : driver.getWindowHandles()) {
    driver.switchTo().window(winHandle);
}

// Sepete ekle
WebElement sepeteEkle = driver.findElement(By.id("add-to-cart-button"));
sepeteEkle.click();

Thread.sleep(3000); // biraz bekle

// Sepete git
driver.findElement(By.id("nav-cart")).click();

// Ürün sepette mi

 WebElement urunSepette= driver.findElement(By.xpath("//span[@id='sc-subtotal-label-activecart' and contains(@class, 'sc-number-of-items')]"));

 String text = urunSepette.getText(); 
//Örnek: "Ara toplam (1 ürün):"
System.out.println("Sepetteki metin: " + text);

//Parantez içindeki sayıyı çıkaralım:
int urunSayisi = 0;
try {
  // Parantez içini çek
  String sayiStr = text.replaceAll(".*\\((\\d+) ürün\\).*", "$1");
  urunSayisi = Integer.parseInt(sayiStr);
} catch (Exception e) {
  System.out.println("Sayısal değer bulunamadı: " + e.getMessage());
}

//Kontrol
if (urunSayisi >= 1) {
  System.out.println("✅ Test başarılı: Ürün sepette.");
} else {
  System.out.println("❌ Test başarısız: Ürün sepete eklenemedi.");
}


} catch (Exception e) {
System.out.println("⚠️ Hata oluştu: " + e.getMessage());
} finally {
driver.quit();
}
}
	}