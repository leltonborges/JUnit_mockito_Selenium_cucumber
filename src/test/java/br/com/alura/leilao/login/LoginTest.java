package br.com.alura.leilao.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private static LoginPage loginPage;

    @BeforeEach
    void beforeAll() {
        loginPage = new LoginPage();
    }

    @AfterEach
    void afterAll() {
        loginPage.closeBrowser();
    }

    @Test
    public void testEfetuarLoginComDadosValidos(){
        loginPage.setUrlNagivate("/login");
        loginPage.inputValuesFormularioLogin("fulano", "pass");
        loginPage.submitForm();

        assertFalse(loginPage.isPageLogin(null));
        assertEquals("fulano", loginPage.getUserNameLogin());
    }

    @Test
    void testNaoLogarComDadosInvalidos(){
        loginPage.setUrlNagivate("/login");
        loginPage.inputValuesFormularioLogin("invalid", "invalid");
        loginPage.submitForm();

        assertTrue(loginPage.isPageLogin("/login?error"));
        assertTrue(loginPage.getContaisIsPageSource("Usuário e senha inválidos."));
        assertThrows(NoSuchElementException.class, () -> loginPage.getUserNameLogin());
    }

    @Test
    void testPaginaRestritaSemEstaAutenticado(){
        loginPage.setUrlNagivate("/leiloes/1");
        assertTrue(loginPage.isPageLogin("/login"));
        assertFalse(loginPage.getContaisIsPageSource("Leilões cadastrados"));

    }
}
