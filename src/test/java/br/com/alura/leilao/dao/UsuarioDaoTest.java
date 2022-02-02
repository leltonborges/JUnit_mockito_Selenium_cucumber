package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioDaoTest {
    private UsuarioDao dao;
    private static EntityManager em;

    @BeforeAll
    static void beforeAll() {
        em = JPAUtil.getEntityManager();
    }

    @BeforeEach
    void setUp() {
        em.getTransaction().begin();
        dao = new UsuarioDao(em);
        listUser().forEach(em::persist);
    }

    @AfterEach
    void tearDown() {
        em.getTransaction().rollback();
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

    private List<Usuario> listUser(){
        Usuario u1 = new Usuario("foo", "foo@gmail.com", "123");
        Usuario u2 = new Usuario("foo_bar", "foo_bar@gmail.com", "123");
        Usuario u3 = new Usuario("bar_foo", "bar_foo@gmail.com", "123");
        return List.of(u1, u2, u3);
    }
}