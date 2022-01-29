package br.com.alura.leilao.service;

import br.com.alura.leilao.dao.LeilaoDao;
import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

class FinalizarLeilaoServiceTest {

    private FinalizarLeilaoService finalizarLeilaoService;
    @Mock
    private LeilaoDao leilaoDao;

    @BeforeEach
    void init() {
//        leilaoDao = Mockito.mock(LeilaoDao.class); // Outra forma é usando o @Mock mais MockitoAnnotations.initMocks
        MockitoAnnotations.initMocks(this); // ler as anotações do Mockito
        this.finalizarLeilaoService = new FinalizarLeilaoService(leilaoDao);
    }

    @Test
    void deveriaFinalizarUmLeilao() {
        List<Leilao> leilaos = leilaos();
        Mockito.when(leilaoDao.buscarLeiloesExpirados()).thenReturn(leilaos);
        finalizarLeilaoService.finalizarLeiloesExpirados();
        Leilao leilao = leilaos.get(0);
        assertTrue(leilao.isFechado());
        assertEquals(BigDecimal.valueOf(700), leilao.getLanceVencedor().getValor());

        // Verifica se metodo salvar foi acionado com o param
        Mockito.verify(leilaoDao).salvar(leilao);
    }

    private List<Leilao> leilaos(){
        Leilao leilao1 = new Leilao("Celular", new BigDecimal(500), new Usuario("Foo"));

        Lance firstLance = new Lance(new Usuario("BAR"), new BigDecimal(600));
        Lance secundLance = new Lance(new Usuario("FOO_BAR"), new BigDecimal(700));

        leilao1.propoe(firstLance);
        leilao1.propoe(secundLance);

        return Arrays.asList(leilao1);
    }
}