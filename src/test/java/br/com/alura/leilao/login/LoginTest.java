package br.com.alura.leilao.login;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    private static WebDriver browser;

    @BeforeAll
    static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "driverSelenium/chromedriver");
        browser = new ChromeDriver();
    }

    @Test
    public void testEfetuarLoginComDadosValidos(){
        browser.navigate().to("http://localhost:8080/login");
        browser.findElement(By.id("username")).sendKeys("fulano");
        browser.findElement(By.id("password")).sendKeys("pass");
        browser.findElement(By.id("login-form")).submit();

        assertFalse(browser.getCurrentUrl().equals("http://localhost:8080/login"));
        assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText());
        browser.quit();
    }
}
