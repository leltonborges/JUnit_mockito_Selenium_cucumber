package br.com.alura.leilao.leilao;

import br.com.alura.leilao.PageService;
import br.com.alura.leilao.config.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class PageObject {
    protected final String URL_BASE = "http://localhost:8080";
    protected WebDriver browser;

    public PageObject(WebDriver driver) {
        if(driver == null)
            this.browser = new ChromeDriver();
        this.browser = driver;
    }

    public boolean isPageLeiloes() {
        return browser.getCurrentUrl().equals(Page.LEILOES.getUrlBase());
    }
}
