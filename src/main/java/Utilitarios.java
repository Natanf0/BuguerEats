import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utilitarios {

    private WebDriver driver;
    private Teste teste;
    public void inicializa(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\natan\\OneDrive\\Documentos\\Selenium - Udemy\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://buger-eats.vercel.app/deliver");
        teste = new Teste(driver);
    }
    public void finaliza(){
        driver.close();
    }
}
