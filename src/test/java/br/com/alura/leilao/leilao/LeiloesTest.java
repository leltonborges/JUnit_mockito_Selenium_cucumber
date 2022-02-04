package br.com.alura.leilao.leilao;

import br.com.alura.leilao.config.Page;
import br.com.alura.leilao.login.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class LeiloesTest {

    private static LeilaoPage leilaoPage;
    private static LeilaoPageCadastro leilaoPageCadastro;

    @BeforeEach
    void setUp() {
        LoginPage loginPage = new LoginPage();
        loginPage.setUrlNagivate(Page.LOGIN);
        loginPage.inputValuesFormularioLogin("fulano", "pass");
        leilaoPage = loginPage.efetuarLogin();
    }

    @AfterEach
    void tearDown() {
//        leilaoPage.closeBrowser();
    }

//    @Test
// FIXME: 2/3/22 não esta funcioando
    public void testCadastrarLeilao(){
         leilaoPageCadastro = leilaoPage.loadFormNewLeilao();

        String nowDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String valor = "500";
        String nome = "Leilão do dia ";

        LeilaoPageList leilaoPageList = leilaoPageCadastro.saveLeilaoAndSubmint(nome, valor, nowDate);
        assertTrue(leilaoPageList.isContainsSourcePage(nome, valor, nowDate));
    }

    @Test
    void testValidaCadastroDeLeilao(){
        leilaoPageCadastro = leilaoPage.loadFormNewLeilao();
        LeilaoPageList leilaoPageList = leilaoPageCadastro.saveLeilaoAndSubmint("", "", "");
        assertTrue(leilaoPageList.isPageLeiloes());
        assertTrue(leilaoPage.isMessageValidad());
    }
}
