#language: pt
@basePage

Funcionalidade: Teste pagina login

  Cenário: Realizar primeiros itens mais escolhidos
  Dado logar no site com sucesso
    E acesssar selecao de herois
    Então selecionar o heroi para obter os dados
    |herois|
    |pudge |
    Dado dos primeiros itens mais usados