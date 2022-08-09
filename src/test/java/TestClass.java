import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {

    @Test
    public void webdriverGoogleChrome(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mercadolibre.cl/");
        driver.quit();

    }

}
