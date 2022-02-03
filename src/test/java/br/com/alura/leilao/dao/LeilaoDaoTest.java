package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;

import static org.junit.jupiter.api.Assertions.*;

import br.com.alura.leilao.util.builder.LeilaoBuider;
import br.com.alura.leilao.util.builder.UsuarioBuilder;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;

class LeilaoDaoTest {
    private UsuarioDao usuarioDao;
    private LeilaoDao leilaoDao;
    private static EntityManager em;
    private static Usuario user;
    private static Leilao leilao;

    @BeforeAll
    static void beforeAll() {
        em = JPAUtil.getEntityManager();
    }

    @BeforeEach
    void setUp() {
        usuarioDao = new UsuarioDao(em);
        leilaoDao = new LeilaoDao(em);
        user = new UsuarioBuilder()
                .comNome("Foo")
                .comEmail("foo@foo")
                .comSenha("1234")
                .build();

        em.getTransaction().begin();
        em.persist(user);

        leilao = new LeilaoBuider()
                .comNome("Mochila")
                .comValueInicial(new BigDecimal(500))
                .comData(LocalDate.now())
                .comUsuario(user)
                .builder();

    }

    @AfterEach
    void tearDown() {
        em.getTransaction().rollback();
    }

    @Test
    void deveriaCadastraUmLeilao() {
        leilao = leilaoDao.salvar(leilao);
        assertEquals(leilao, leilaoDao.buscarPorId(leilao.getId()));
    }

    @Test
    void deveriaAtualizarUmLeilao() {
        leilao = leilaoDao.salvar(leilao);
        leilao.setNome("Outro Nome");
        leilao.setValorInicial(new BigDecimal(100));
        Leilao leilaoUpdate = leilaoDao.salvar(leilao);
        assertEquals(leilao.getId(), leilaoUpdate.getId());
        assertEquals(leilao.getNome(), leilaoUpdate.getNome());
        assertEquals(leilao.getValorInicial(), leilaoUpdate.getValorInicial());
    }

    @Test
    void buscarPorId() {
    }

    @Test
    void buscarTodos() {
    }

    @Test
    void buscarLeiloesDoPeriodo() {
    }

    @Test
    void buscarLeiloesDoUsuario() {
    }

    @AfterAll
    static void afterAll() {
        em.close();
    }
}