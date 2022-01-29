package br.com.alura.leilao.service;

import br.com.alura.leilao.dao.PagamentoDao;
import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

class GeradorDePagamentoTest {

    @Mock
    private PagamentoDao pagamentoDao;
    private GeradorDePagamento geradorDePagamento;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.geradorDePagamento = new GeradorDePagamento(pagamentoDao);
    }

    @Test
    void deveriacriarPagamentoParaVecendorDoleilao(){
        Leilao leilao = leilao();
        Lance vencedor = leilao.getLanceVencedor();
        geradorDePagamento.gerarPagamento(vencedor);
        Mockito.verify(pagamentoDao).salvar();
    }

    private Leilao leilao(){
        Leilao leilao = new Leilao("Celular", new BigDecimal(500), new Usuario("Foo"));

        Lance lance = new Lance(new Usuario("FOO_BAR"), new BigDecimal(700));

        leilao.propoe(lance);
        leilao.setLanceVencedor(lance);

        return leilao;
    }
}