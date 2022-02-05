package br.com.alura.leilao.cucumber.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PropondoLanceSteps {

    private Lance lance1;
    private Leilao leilao;
    private Lance lance2;
    private Lance lance3;

    @Dado("um lance valido")
    public void dado_um_lance_valido() {
        lance1 = new Lance(new Usuario("Foo"), BigDecimal.TEN);
        leilao = new Leilao("Notebook ABC");
    }

    @Quando("propoe ao leilao")
    public void quando_propoe_o_lance() {
        leilao.propoe(lance1);
    }

    @Entao("lance eh aceito")
    public void entao_o_lance_eh_aceito() {
        assertEquals(1, leilao.getLances().size());
        assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
    }

    @Dado("varios lances validos")
    public void varios_lances_validos() {
        lance1 = new Lance(new Usuario("Foo"), BigDecimal.TEN);
        lance2 = new Lance(new Usuario("Bar"), BigDecimal.valueOf(11));
        lance3 = new Lance(new Usuario("FooBar"), BigDecimal.valueOf(11.2));
        leilao = new Leilao("Phone &");
    }

    @Quando("propoe varios ao lailao")
    public void propoe_varios_ao_lailao() {
        leilao.propoe(lance1);
        leilao.propoe(lance2);
        leilao.propoe(lance3);
    }
    @Entao("os lances sao aceitos")
    public void os_lances_sao_aceitos() {
        assertEquals(3, leilao.getLances().size());
        assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
        assertEquals(BigDecimal.valueOf(11), leilao.getLances().get(1).getValor());
        assertEquals(BigDecimal.valueOf(11.2), leilao.getLances().get(2).getValor());
    }

}
