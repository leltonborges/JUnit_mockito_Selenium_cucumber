package br.com.alura.leilao.leilao;

import br.com.alura.leilao.leilao.cadastro.LeilaoPageCadastro;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeilaoPage {
    @FindBy(css = "a#novo_leilao_link.btn.btn-primary")
    private WebElement btnNewLeilao;

    private final WebDriver browser;

    public LeilaoPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public void closeBrowser() {
        browser.quit();
    }

    public LeilaoPageCadastro loadFormNewLeilao() {
        btnNewLeilao.click();
        return new LeilaoPageCadastro(browser);
    }
}