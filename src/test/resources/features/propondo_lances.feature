# language: pt

Funcionalidade: Propondo lances ao leilao

  Cenario: Propondo um unico lance valido
    Dado um lance valido
    Quando propoe ao leilao
    Entao lance eh aceito

  Cenario: Propondo varios lances
    Dado um lance de 10.00 reais do usuario "Foo"
    E um lance de 11.00 reais do usuario "Bar"
    E um lance de 11.12 reais do usuario "FooBar"
    Quando propoe varios ao lailao
    Entao os lances sao aceitos


  Esquema do Cenario:
    Dado um lance de <value> reais e do usuario '<usuario>'
    Quando propoe ao leilao
    Entao o lance não é aceito

    Exemplos:
    | value | usuario |
    |    0  |  Foo    |
    |   -1  |  Bar    |
