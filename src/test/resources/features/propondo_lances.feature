# language: pt

Funcionalidade: Propondo lances ao leilao

  Cenario: Propondo um unico lance valido
    Dado um lance valido
    Quando propoe ao leilao
    Entao lance eh aceito

  Cenario: Propondo varios lances
    Dado varios lances validos
    Quando propoe varios ao lailao
    Entao os lances sao aceitos