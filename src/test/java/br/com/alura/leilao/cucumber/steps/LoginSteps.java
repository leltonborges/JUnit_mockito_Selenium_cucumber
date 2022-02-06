package br.com.alura.leilao.cucumber.steps;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private Browser browser;
    private LoginPage loginPage;
    private LeiloesPage leiloesPage;

    @Before
    void setup(){
        browser.seed();
    }

    @Given("o usuario valido")
    public void o_usuario_valido() {
        browser = new Browser();
        browser.seed();
        loginPage = browser.getLoginPage();
    }

    @When("realiza login")
    public void realiza_login() {
        leiloesPage = this.loginPage.realizaLoginComo("fulano", "pass");
    }

    @Then("é redirecionado para a pagina de leiloes")
    public void é_redirecionado_para_a_pagina_de_leiloes() {
        assertTrue(leiloesPage.estaNaPaginaDeLeiloes());
        browser.clean();
    }

    @Given("o usuario invalido")
    public void o_usuario_invalido() {
        browser = new Browser();
        browser.seed();
        loginPage = browser.getLoginPage();
    }

    @When("tenta se logar")
    public void tenta_se_logar() {
        leiloesPage = this.loginPage.realizaLoginComo("invalid", "invalid");
    }

    @Then("continua na pagina no login")
    public void continua_na_pagina_no_login() {
        assertFalse(leiloesPage.estaNaPaginaDeLeiloes());
        assertTrue(loginPage.estaNaPaginaDeLoginComErro());
    }

}
