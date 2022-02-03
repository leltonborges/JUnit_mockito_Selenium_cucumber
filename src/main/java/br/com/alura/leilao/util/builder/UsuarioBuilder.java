package br.com.alura.leilao.util.builder;

import br.com.alura.leilao.model.Usuario;

public class UsuarioBuilder {
    private String name;
    private String email;
    private String pass;

    public UsuarioBuilder comNome(String name) {
        this.name = name;
        return this;
    }

    public UsuarioBuilder comEmail(String email) {
        this.email = email;
        return this;
    }

    public UsuarioBuilder comSenha(String pass) {
        this.pass = pass;
        return this;
    }

    public Usuario build() {
        return new Usuario(name, email, pass);
    }
}
