package br.com.alura.leilao;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldSelenium {
    @Test
    public void hello(){
        System.setProperty("webdriver.chrome.driver", "driverSelenium/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.navigate().to("http://localhost:8080/leiloes");
        webDriver.quit();
    }
}
