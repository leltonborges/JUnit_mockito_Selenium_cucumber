
@Leilao
Feature: Cadastrando um leilao
  Scenario: Um usuario logado pode cadastrar um leilao
    Given um usuario logado
    When acessa a pagina de novo leilao
    And  prenche o formulario cim dados validos
    Then volta para a pagina de leiloess
    And o novo leilao aparece na tabela