package br.com.alura.leilao.cucumber.steps;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import br.com.alura.leilao.e2e.pages.NovoLeilaoPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.*;

public class LeilaoSteps {

    private Browser browser;
    private LoginPage loginPage;
    private LeiloesPage leiloesPage;
    private NovoLeilaoPage novoLeilaoPage;

    @Given("um usuario logado")
    public void um_usuario_logado() {
        browser = new Browser();
        browser.seed();
        loginPage = browser.getLoginPage();
        leiloesPage = loginPage.realizaLoginComoFulano();
    }

    @When("acessa a pagina de novo leilao")
    public void acessa_a_pagina_de_novo_leilao() {
        novoLeilaoPage = leiloesPage.visitaPaginaParaCriarUmNovoLeilao();
    }
    @When("prenche o formulario cim dados validos")
    public void prenche_o_formulario_cim_dados_validos() {
        this.leiloesPage = novoLeilaoPage.preencheForm("PC novo", "1500", "02/12/2022");
    }
    @Then("volta para a pagina de leiloess")
    public void volta_para_a_pagina_de_leiloess() {
        assertTrue(this.leiloesPage.estaNaPaginaDeLeiloes());
    }
    @Then("o novo leilao aparece na tabela")
    public void o_novo_leilao_aparece_na_tabela() {
        assertTrue(leiloesPage.existe("PC novo", "1500", "02/12/2022", "fulano"));
        browser.clean();
    }

}
