package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioDaoTest {
    private UsuarioDao dao;
    private static EntityManager em;

    @BeforeAll
    static void beforeAll() {
        em = JPAUtil.getEntityManager();
        Usuario usuario = new Usuario("foo", "foo@gmail.com", "123");
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
    }

    @BeforeEach
    void setUp() {
        dao = new UsuarioDao(em);
    }

    @Test
    void testeParaEncontrarUsuarioCadastrado(){
        Usuario usuario = this.dao.buscarPorUsername("foo");
        assertNotNull(usuario);
    }

    @Test
    void testeNãoDeveriaEncontrarNaoCadastrado(){
        assertThrows(NoResultException.class, () -> this.dao.buscarPorUsername("bar"));
    }

    @AfterAll
    static void afterAll() {
        em.close();
    }
}