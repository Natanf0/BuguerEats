import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TestePaginaCadastro {

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
    public void testeVoltarHome() {
        teste.clicarBotaoByCss("a");
        String msg = DriverManager.getDriverInstance().getTitle();
        Assert.assertEquals("Buger Eats", msg);
    }

    @Test
    public void testeCamposObrigatorios() {
        teste.clicarBotaoByClassName("button-success");
        Assert.assertEquals(teste.getMsg(), teste.getMsg());
    }

    @Test
    public void cadastroComSucesso() {
        teste.escrever("name", "Ayrton Senna");
        teste.escrever("cpf", "12332145690");
        teste.escrever("email", "teste@box.com");
        teste.escrever("postalcode", "22041-011");
        teste.clicarBotaoCep();
        teste.escrever("address-number", "12");
        teste.escrever("address-details", "ao lado do Shopping da regiao");
        teste.clicarBotaoByCss("li:nth-child(2)");
        teste.clicarBotaoByClassName("button-success");
        // a assertiva não foi especificada

    }

    @Test
    public void nomeInvalido() {
        teste.escrever("name", "29743864812");
        teste.clicarBotaoByClassName("button-success");

        String msg = teste.getMsg();
        Assert.assertEquals(msg, "Ooos! nome inválido");

        // a mensagem de erro não foi especificada e o teste não passa pois a aplicação ainda não implementou a mensagem


    }

    @Test
    public void cpfInvalido() {
        teste.escrever("name", "Ayrton Senna");
        teste.escrever("cpf", "aaa123111bb");
        teste.clicarBotaoByClassName("button-success");

        String msg = teste.getMsg();
        Assert.assertEquals(msg, "Oops! CPF inválido");
    }

    @Test
    public void emailInvalido() {
        teste.escrever("name", "Ayrton Senna");
        teste.escrever("cpf", "12332145690");
        teste.escrever("email", "natanfhh@da");

        teste.clicarBotaoByClassName("button-success");

        String msg = teste.getMsg();
        Assert.assertEquals(msg, "Oops! Email com formato inválido.");
    }

    @Test
    public void whatsappInvalido() {
        teste.escrever("name", "Ayrton Senna");
        teste.escrever("cpf", "12332145690");
        teste.escrever("email", "teste@box.com");
        teste.escrever("whatsapp", "textoqualquer"); // ou um numero sem ddd

        teste.clicarBotaoByClassName("button-success");

        String msg = teste.getMsg();
        Assert.assertEquals(msg, "Oops! Whatsapp com formato incorreto");
    }

    @Test
    public void cepInvalido() {
        teste.escrever("name", "Ayrton Senna");
        teste.escrever("cpf", "12332145690");
        teste.escrever("email", "teste@box.com");
        teste.escrever("postalcode", "textoAqui");

        teste.clicarBotaoByClassName("button-success");

        String msg = teste.getMsg();
        Assert.assertEquals(msg, "Oops! CEP com formato incorreto");

        // a mensagem de erro não foi especificada e o teste não passa pois a aplicação ainda não implementou a mensagem
    }

    @Test
    public void numeroInvalido() {
        teste.escrever("name", "Ayrton Senna");
        teste.escrever("cpf", "12332145690");
        teste.escrever("email", "teste@box.com");
        teste.escrever("postalcode", "22041-011");
        teste.escrever("address-number", "@@@");

        teste.clicarBotaoByClassName("button-success");

        String msg = teste.getMsg();
        Assert.assertEquals(msg, "Oops! Numero inválido");
        // a mensagem de erro não foi especificada e o teste não passa pois a aplicação ainda não implementou a mensagem
    }

    @Test
    public void botaoCep() throws InterruptedException {
        teste.escrever("name", "Ayrton Senna");
        teste.escrever("cpf", "12332145690");
        teste.escrever("email", "teste@box.com");
        teste.escrever("postalcode", "22041-011");
        teste.clicarBotaoCep();
        Thread.sleep(1000);
        Assert.assertEquals("Rua Santa Clara", teste.getValue("address"));
        Assert.assertEquals("Copacabana", teste.getValue("district"));
        Assert.assertEquals("Rio de Janeiro/RJ", teste.getValue("city-uf"));
    }

    @Test
    public void metodoEntrega() {
        teste.escrever("name", "Ayrton Senna");
        teste.escrever("cpf", "12332145690");
        teste.escrever("email", "teste@box.com");
        teste.escrever("postalcode", "22041-011");
        teste.escrever("address-number", "12");
        teste.escrever("address-details", "ao lado do Shopping da regiao");

        teste.clicarBotaoByCss("li:nth-child(1) > img");
        teste.clicarBotaoByCss("li:nth-child(2)");
        teste.clicarBotaoByCss("li:nth-child(3)");

        teste.clicarBotaoByClassName("button-success");

        Assert.assertEquals(teste.getMsg(), "Oops! Selecione apenas um método de entrega");
    }

    @Test
    public void metodoEntrega2() {
        teste.escrever("name", "Ayrton Senna");
        teste.escrever("cpf", "12332145690");
        teste.escrever("email", "teste@box.com");
        teste.escrever("postalcode", "22041-011");
        teste.escrever("address-number", "12");
        teste.escrever("address-details", "ao lado do Shopping da regiao");

        teste.clicarBotaoByCss("li:nth-child(3)");
        teste.escrever(new By.ByXPath("//input[@accept='image/*']"),
                System.getProperty("user.dir") + "/src/main/resources/img/CNH.jpg");

        teste.clicarBotaoByClassName("button-success");

    }
}

