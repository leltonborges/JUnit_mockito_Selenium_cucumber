package br.com.alura.leilao.leilao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}