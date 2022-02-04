package br.com.alura.leilao.leilao;

import br.com.alura.leilao.config.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class LeilaoPage extends PageObject{

    public LeilaoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(browser, this);
    }

    @FindBy(id = "novo_leilao_link")
    private WebElement btnNewLeilao;

    public void closeBrowser() {
        browser.quit();
    }

    public LeilaoPageCadastro loadFormNewLeilao() {
        btnNewLeilao.click();
//        browser.findElement(By.id("novo_leilao_link")).click();
        return new LeilaoPageCadastro(this.browser);
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