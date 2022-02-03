package br.com.alura.leilao.leilao;

import br.com.alura.leilao.config.Page;
import br.com.alura.leilao.leilao.cadastro.LeilaoPageCadastro;
import br.com.alura.leilao.login.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeiloesTest {

    private static LeilaoPage leilaoPage;


    @AfterEach
    void tearDown() {
        leilaoPage.closeBrowser();
    }

    @Test
    public void testCadastrarLeilao(){
        LoginPage loginPage = new LoginPage();
        loginPage.setUrlNagivate(Page.LOGIN);
        loginPage.inputValuesFormularioLogin("fulano", "pass");
        leilaoPage = loginPage.efetuarLogin();
        LeilaoPageCadastro leilaoPageCadastro = leilaoPage.loadFormNewLeilao();

    }
}
