import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestePaginaInicial {
    private WebDriver driver;
    private Teste teste;
    @Before
    public void inicializa(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\natan\\OneDrive\\Documentos\\Selenium - Udemy\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://buger-eats.vercel.app");
        teste = new Teste(driver);
    }
    @After
    public void finaliza(){
        driver.close();
    }
    @Test
    public void testeHome(){
        teste.clicarBotaoByCss("strong");
        String msg = driver.getTitle();
        Assert.assertEquals("Buger Eats", msg);
    }
}
