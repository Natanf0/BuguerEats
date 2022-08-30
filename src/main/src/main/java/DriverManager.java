import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static WebDriver driver;


    public static WebDriver getDriverInstance() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://buger-eats.vercel.app/deliver");
        }
        return driver;
    }

    public static Teste inicializa() {
        return new Teste(getDriverInstance());
    }

    public static void finaliza() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}
