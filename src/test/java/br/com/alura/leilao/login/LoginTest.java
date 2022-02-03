package br.com.alura.leilao.login;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    private static final String URL = "http://localhost:8080";
    private static WebDriver browser;

    @BeforeAll
    static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "driverSelenium/chromedriver");
        browser = new ChromeDriver();
    }

    @AfterAll
    static void afterAll() {
        browser.quit();
    }

    @Test
    public void testEfetuarLoginComDadosValidos(){
        browser.navigate().to(URL.concat("/login"));
        browser.findElement(By.id("username")).sendKeys("fulano");
        browser.findElement(By.id("password")).sendKeys("pass");
        browser.findElement(By.id("login-form")).submit();

        assertFalse(browser.getCurrentUrl().equals(URL));
        assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText());
    }

    @Test
    void testNaoLogarComDadosInvalidos(){
        browser.navigate().to(URL.concat("/login"));
        browser.findElement(By.id("username")).sendKeys("invalid");
        browser.findElement(By.id("password")).sendKeys("invalid");
        browser.findElement(By.id("login-form")).submit();

        assertTrue(browser.getCurrentUrl().equals(URL.concat("/login?error")));
        assertTrue(browser.getPageSource().contains("Usuário e senha inválidos."));
        assertThrows(NoSuchElementException.class, () -> browser.findElement(By.id("usuario-logado")));
    }

    @Test
    void testPaginaRestritaSemEstaAutenticado(){
        browser.navigate().to(URL.concat("/leiloes/1"));
        assertTrue(browser.getCurrentUrl().equals(URL.concat("/login")));
        assertFalse(browser.getPageSource().contains("Leilões cadastrados"));

    }
}
