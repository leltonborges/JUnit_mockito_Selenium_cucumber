package br.com.alura.leilao;

import br.com.alura.leilao.dao.LeilaoDao;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class HelloWorldMockito{
    @Test
    void hello(){
        LeilaoDao leilaoDaoMock = Mockito.mock(LeilaoDao.class);

        assertTrue(leilaoDaoMock.buscarTodos().isEmpty());
    }

}
