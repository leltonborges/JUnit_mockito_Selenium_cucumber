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
import java.time.*;

class GeradorDePagamentoTest {

    @Mock
    private PagamentoDao pagamentoDao;
    @Mock
    private Clock clock;

    // Captura uma objeto criado internamente no metodo
    @Captor
    private ArgumentCaptor<Pagamento> captorPagamento;
    @Captor
    private ArgumentCaptor<LocalDate> captorVencimento;

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
//        LocalDate date = LocalDate.of(2020, 12, 7);
//        Instant instant = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
//        Mockito.when(clock.instant()).thenReturn(instant);

//        Mockito.when(clock.getZone()).thenReturn(ZoneId.systemDefault());
        geradorDePagamento.gerarPagamento(vencedor);

        //Capitura a instance do Captor
        Mockito.verify(pagamentoDao).salvar(captorPagamento.capture());
        Pagamento pagamento = captorPagamento.getValue();
        LocalDate nextDayUtil = DayUtil.getDayUtil(LocalDate.now().plusDays(1));

        assertEquals(nextDayUtil, pagamento.getVencimento());
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