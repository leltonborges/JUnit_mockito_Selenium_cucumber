package br.com.alura.leilao.cucumber.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PropondoLanceSteps {

    private Lance lance1;
    private Leilao leilao;
    private Lance lance2;
    private Lance lance3;
    private List<Lance> lista;

    @Before
    public void setup(){
        this.lista = new ArrayList<>();
        leilao = new Leilao("Phone &");
    }

    @Dado("um lance valido")
    public void dado_um_lance_valido() {
        lance1 = new Lance(new Usuario("Foo"), BigDecimal.TEN);
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

//    @Dado("varios lances validos")
//    public void varios_lances_validos() {
//        lance1 = new Lance(new Usuario("Foo"), BigDecimal.TEN);
//        lance2 = new Lance(new Usuario("Bar"), BigDecimal.valueOf(11));
//        lance3 = new Lance(new Usuario("FooBar"), BigDecimal.valueOf(11.2));
//        leilao = new Leilao("Phone &");
//    }

    @Dado("um lance de {double} reais do usuario {string}")
    public void um_lance_de_reais_do_usuario_foo(Double amount, String name) {
        lance1 = new Lance(new Usuario(name), new BigDecimal(amount));
        lista.add(lance1);

    }

    @Quando("propoe varios ao lailao")
    public void propoe_varios_ao_lailao() {
        lista.forEach(leilao::propoe);
    }

    @Entao("os lances sao aceitos")
    public void os_lances_sao_aceitos() {
        assertEquals(lista.size(), leilao.getLances().size());
        assertEquals(lista.get(0).getValor(), leilao.getLances().get(0).getValor());
        assertEquals(lista.get(1).getValor(), leilao.getLances().get(1).getValor());
        assertEquals(lista.get(2).getValor(), leilao.getLances().get(2).getValor());
    }

    @Dado("um lance de {double} reais e do usuario {string}")
    public void um_lance_de_reais(Double value, String name) {
        lance1 = new Lance(new BigDecimal(value));
    }

    @Entao("o lance não é aceito")
    public void o_lance_nao_e_aceito() {
        assertEquals(0, leilao.getLances().size());
    }

    @Dado("dois lances")
    public void dois_lances(DataTable dataTable) {
        List<Map<String, String>> maps = dataTable.asMaps();
        maps.forEach((v) -> {
            String valor = v.get("value");
            String name = v.get("user");
            Lance lance = new Lance(new Usuario(name), new BigDecimal(valor));

            lista.add(lance);
        });
    }

    @Entao("o segundo lance nao eh aceito")
    public void o_segundo_lance_nao_eh_aceito() {
        assertEquals(1, leilao.getLances().size());
        assertEquals(lista.get(0).getValor(), leilao.getLances().get(0).getValor());
    }


}
