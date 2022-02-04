package br.com.alura.leilao.leilao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class LeilaoPageCadastro extends PageObject{

    @FindBy(id = "nome")
    public WebElement name;

    @FindBy(id = "valorInicial")
    public WebElement value;

    @FindBy(css = "#dataAbertura")
    public WebElement date;

    @FindBy(id = "button-submit")
    public WebElement buttonsubmit;

    public LeilaoPageCadastro(WebDriver driver) {
        super(driver);
        PageFactory.initElements(browser, this);
    }

    public LeilaoPageList saveLeilaoAndSubmint(String name, String value, String nowDate) {
        this.name.sendKeys(name);
        this.value.sendKeys(value);
//       date.sendKeys(nowDate); 
        /// FIXME: 2/3/22  Não esta funcionado o insert da data

        buttonsubmit.click();
        return new LeilaoPageList(this.browser);
    }
}