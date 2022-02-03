package br.com.alura.leilao.util.builder;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.stream.DoubleStream;

public class LeilaoBuider {
    private String nome;
    private BigDecimal valueInit;
    private LocalDate date;
    private Usuario usuario;

    public LeilaoBuider comNome(String nome) {
        this.nome = nome;
        return this;
    }
    public LeilaoBuider comValueInicial(BigDecimal valueInit) {
        this.valueInit = valueInit;
        return this;
    }

    public LeilaoBuider comUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public LeilaoBuider comData(LocalDate date) {
        this.date = date;
        return this;
    }

    public Leilao builder() {
        return new Leilao(nome, valueInit, date, usuario);
    }
}
