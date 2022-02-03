package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    private static final String URL_BASE = "http://localhost:8080";
    private static WebDriver browser;

    public LoginPage() {
        System.setProperty("webdriver.chrome.driver", "driverSelenium/chromedriver");
        browser = new ChromeDriver();
    }

    public void closeBrowser() {
        browser.quit();
    }

    public void setUrlNagivate(String suffix) {
        browser.navigate().to(URL_BASE.trim().concat(suffix.trim()));
    }

    public void inputValuesFormularioLogin(String username, String password) {
        browser.findElement(By.id("username")).sendKeys(username);
        browser.findElement(By.id("password")).sendKeys(password);
    }

    public void submitForm() {
        browser.findElement(By.id("login-form")).submit();
//        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public boolean isPageLogin(String param) {
        return param == null
                ? browser.getCurrentUrl().equals(URL_BASE) :
                browser.getCurrentUrl().equals(URL_BASE.concat(param));
    }

    public String getUserNameLogin() throws NoSuchElementException {
        return browser.findElement(By.id("usuario-logado")).getText();
    }

    public boolean getContaisIsPageSource(String text) {
        return browser.getPageSource().contains(text);
    }
}
