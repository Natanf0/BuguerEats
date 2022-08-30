import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestePaginaInicial {
    private Teste teste;
    @Before
    public void inicializa() {
        teste = DriverManager.inicializa();
    }

    @After
    public void finaliza() {
        DriverManager.finaliza();
    }
    @Test
    public void testeHome(){
        DriverManager.getDriverInstance().get("https://buger-eats.vercel.app/");
        teste.clicarBotaoByCss("strong");
        String msg = DriverManager.getDriverInstance().getTitle();
        Assert.assertEquals("Buger Eats", msg);
    }
}
