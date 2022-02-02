package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioDaoTest {
    private UsuarioDao dao;
    private EntityManager em;

    @BeforeEach
    void setUp() {
        dao = new UsuarioDao(em);
    }

    @Test
    void testeBuscaDeUsuarioPeloUsername(){
        Usuario usuario = this.dao.buscarPorUsername("fulano");

        assertNotNull(usuario);
    }

}