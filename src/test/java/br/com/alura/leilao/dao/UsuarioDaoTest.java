package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UsuarioDaoTest {
    private UsuarioDao dao;
    private static EntityManager em;
    private static Usuario user;

    @BeforeAll
    static void beforeAll() {
        em = JPAUtil.getEntityManager();
    }

    @BeforeEach
    void setUp() {
        em.getTransaction().begin();
        dao = new UsuarioDao(em);
        user = new Usuario("foo", "foo@gmail.com", "123");
        em.persist(user);
    }

    @AfterEach
    void tearDown() {
        em.getTransaction().rollback();
    }

    @Test
    void testeParaEncontrarUsuarioCadastrado(){
        Usuario usuario = this.dao.buscarPorUsername(user.getNome());
        assertNotNull(usuario);
    }

    @Test
    void testeNãoDeveriaEncontrarNaoCadastrado(){
        assertThrows(NoResultException.class, () -> this.dao.buscarPorUsername("bar"));
    }

    @Test
    void deveriaDeletarUmUsuario(){
        dao.deletar(user);
        assertThrows(NoResultException.class, () -> dao.buscarPorUsername(user.getNome()));
    }

    @AfterAll
    static void afterAll() {
        em.close();
    }

}