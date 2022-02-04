package br.com.alura.leilao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class PageService {
    protected final String URL_BASE = "http://localhost:8080";
    protected WebDriver browser;

    public PageService() {
        System.setProperty("webdriver.chrome.driver", "driverSelenium/chromedriver");
        browser = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver", "driverSelenium/geckodriver");
//        browser = new FirefoxDriver();
    }

    public void closeBrowser() {
        browser.quit();
    }
}
