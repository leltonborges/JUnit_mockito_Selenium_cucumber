package br.com.alura.leilao.leilao;

import br.com.alura.leilao.config.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class LeilaoPage {
    @FindBy(id = "novo_leilao_link")
    private WebElement btnNewLeilao;

    private WebDriver browser;

    public LeilaoPage(WebDriver browser) {
        PageFactory.initElements(browser, this);
        this.browser = browser;
    }

    public void closeBrowser() {
        browser.quit();
    }

    public LeilaoPageCadastro loadFormNewLeilao() {
        btnNewLeilao.click();
        return new LeilaoPageCadastro(browser);
    }

    public boolean isPageLeiloes() {
        return browser.getCurrentUrl().equals(Page.LEILOES.getUrlBase());
    }

    public boolean isMessageValidad() {
        String pageSource = browser.getPageSource();
        return messageValided().parallelStream().allMatch(m -> pageSource.contains(m));
    }

    private Set<String> messageValided(){
        return Set.of("minimo 3 caracteres", "não deve estar em branco",
                "deve ser um valor maior de 0.1", "Coloque uma data no formato dd/MM/yyyy");
    }
}