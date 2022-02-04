package br.com.alura.leilao.leilao;

import br.com.alura.leilao.config.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeilaoPageList extends PageObject{

    @FindBy(css = "#tabela-leiloes tbody tr:last-child")
    public WebElement lastRow;

    public LeilaoPageList(WebDriver driver) {
        super(driver);
    }

    public boolean isContainsSourcePage(String nome, String valor, String nowDate) {
        WebElement columnName =  lastRow.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement columnValue = lastRow.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement columnDate = lastRow.findElement(By.cssSelector("td:nth-child(3)"));

        return columnName.getText().equals(nome)
                && columnDate.getText().equals(nowDate)
                && columnValue.getText().equals(valor);
    }

    public String page() {
        return browser.getCurrentUrl();
    }
}