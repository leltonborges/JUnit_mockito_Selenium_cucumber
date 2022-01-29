package br.com.alura.leilao.service;

import br.com.alura.leilao.dao.PagamentoDao;
import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Pagamento;
import br.com.alura.leilao.model.Usuario;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.math.BigDecimal;
import java.time.LocalDate;

class GeradorDePagamentoTest {

    @Mock
    private PagamentoDao pagamentoDao;

    // Captura uma objeto criado internamente no metodo
    @Captor
    private ArgumentCaptor<Pagamento> captorPagamento;

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
        Mockito.verify(pagamentoDao).salvar(captorPagamento.capture());
        Pagamento pagamento = captorPagamento.getValue();
        assertEquals(LocalDate.now().plusDays(1), pagamento.getVencimento());
        assertEquals(vencedor.getValor(), pagamento.getValor());
        assertFalse(pagamento.getPago());
        assertEquals(vencedor.getUsuario(), pagamento.getUsuario());
        assertEquals(vencedor.getLeilao(), pagamento.getLeilao());
    }

    private Leilao leilao(){
        Leilao leilao = new Leilao("Celular", new BigDecimal(500), new Usuario("Foo"));

        Lance lance = new Lance(new Usuario("FOO_BAR"), new BigDecimal(700));

        leilao.propoe(lance);
        leilao.setLanceVencedor(lance);

        return leilao;
    }
}