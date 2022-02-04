package br.com.alura.leilao.config;

public enum Page {
    LOGIN(Page.BASE_URL.concat("/login")),
    LEILAO(Page.BASE_URL.concat("/leilao")),
    LEILOES(Page.BASE_URL.concat("/leiloes")),
    LANCE(Page.BASE_URL.concat("/lance"));

    public static final String BASE_URL = "http://localhost:8080";
    private final String urlBase;

    Page(String urlBase) {
        this.urlBase = urlBase;
    }

    public String getUrlBase() {
        return urlBase;
    }
}
