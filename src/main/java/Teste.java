import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Teste {
    private WebDriver driver;
    public Teste(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Método que preenche um campo com a string conteúdo, usando a o name do campo.
     * @param nome
     * @param conteudo
     */
    public void escrever(String nome, String conteudo){
        escrever(new By.ByName(nome), conteudo);
    }


    /**
     * Método que preenche um campo com a string conteúdo, usando qualquer locator by
     * @param by
     * @param conteudo
     */
    public void escrever(By by, String conteudo){
        driver.findElement(by).sendKeys(conteudo);
    }


    public void clicarBotaoByClassName(String className){
        driver.findElement(By.className(className)).click();
    }
    public void clicarBotaoByCss(String css){
        driver.findElement(By.cssSelector(css)).click();
    }

    /**
     * Método que clica num LinkText, ou seja, um texto que contém um link
     * @param linkText
     */
    public void clicarLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    /**
     * Método que retorna a mensagem de erro que aparece abaixo dos campos
     * @return
     */
    public String getMsg(){
        String msg = driver.findElement(By.className("alert-error")).getText();
        return msg;
    }

    /**
     * Método que, dado o name do campo, retorna o conteúdo do campo.
     * @param name
     * @return
     */
    public String getValue(String name){
        return driver.findElement(By.name(name)).getAttribute("value");}


    public void clicarBotaoCep(){
        driver.findElement(By.cssSelector("fieldset:nth-child(3) > .field-group:nth-child(2) > .field:nth-child(2) > input")).click();
    }
}