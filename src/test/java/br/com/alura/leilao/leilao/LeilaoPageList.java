package br.com.alura.leilao.leilao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// about:blank
public class LeilaoPageList {

    @FindBy(css = "#tabela-leiloes tbody tr:last-child")
    public WebElement lastRow;
    private WebDriver driver;

    public LeilaoPageList(WebDriver browser) {
        PageFactory.initElements(browser, this);
        this.driver = browser;
    }

    public boolean isContainsSourcePage(String nome, String valor, String nowDate) {
        WebElement columnName =  lastRow.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement columnValue = lastRow.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement columnDate = lastRow.findElement(By.cssSelector("td:nth-child(3)"));

        return columnName.getText().equals(nome)
                && columnDate.getText().equals(nowDate)
                && columnValue.getText().equals(valor);
    }
}