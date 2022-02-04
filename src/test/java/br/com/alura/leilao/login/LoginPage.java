package br.com.alura.leilao.login;

import br.com.alura.leilao.PageService;
import br.com.alura.leilao.config.Page;
import br.com.alura.leilao.leilao.LeilaoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LoginPage extends PageService {

    public void setUrlNagivate(String suffix) {
        browser.navigate().to(URL_BASE.trim().concat(suffix.trim()));
    }

    public void inputValuesFormularioLogin(String username, String password) {
        browser.findElement(By.id("username")).sendKeys(username);
        browser.findElement(By.id("password")).sendKeys(password);
    }

    public void submitForm() {
        browser.findElement(By.id("login-form")).submit();
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

    public void setUrlNagivate(Page login) {
        browser.navigate().to(login.getUrlBase());
    }

    public LeilaoPage efetuarLogin() {
        browser.findElement(By.id("login-form")).submit();
        return new LeilaoPage(this.browser);
    }
}
