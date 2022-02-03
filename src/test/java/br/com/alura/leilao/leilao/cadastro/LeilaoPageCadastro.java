package br.com.alura.leilao.leilao.cadastro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeilaoPageCadastro {
    private WebDriver driver;

    public LeilaoPageCadastro(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}