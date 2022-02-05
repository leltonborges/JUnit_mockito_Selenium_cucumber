package br.com.alura.leilao.cucumber.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PropondoLanceSteps {

    private Lance lance;
    private Leilao leilao;

    @Dado("Dado um lance valido")
    public void dado_um_lance_valido() {
        lance = new Lance(new Usuario("Foo"), BigDecimal.TEN);
    }
    
    @Quando("Quando propoe o lance")
    public void quando_propoe_o_lance() {
        leilao = new Leilao("Notebook ABC");
        leilao.propoe(lance);
    }

    @Entao("Entao o lance eh aceito")
    public void entao_o_lance_eh_aceito() {
        assertEquals(1, leilao.getLances().size());
        assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
    }
}
