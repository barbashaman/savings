#language: pt
Funcionalidade: Investimentos em Poupança Sicredi

  Esquema do Cenário: Investimento simples com sucesso
    Dado que eu tenha um usuario do Sicredi com o perfil "<Perfil>"
    E queira definir o valor de aplicação "<valor>"
    E queira poupar por mês "<valorPoupanca>" Reais por "<tempoPoupanca>" "<tipoTempo>"
    Quando eu pressionar o botão Simular
    Então a simulação ira mostrar o valor esperado de "<valorEsperado>" Reais poupados

    Exemplos:
      | Perfil    | valor  | valorPoupanca | tempoPoupanca | tipoTempo | valorEsperado |
      | Para você | 20.00  | 20.00         | 12            | meses     | 266           |
      | Para você | 40.00  | 40.00         | 24            | meses     | 1.046         |
      | Para você | 80.00  | 80.00         | 36            | meses     | 3.167         |
      | Para você | 160.00 | 160.00        | 48            | meses     | 8.581         |
      | Para você | 320.00 | 320.00        | 60            | meses     | 21.863        |


  Esquema do Cenario: Investimento preenchendo incorretamente o formulario
    Dado que eu tenha um usuario do Sicredi com o perfil "<Perfil>"
    E queira definir o valor de aplicação "<valor>"
    E queira poupar por mês "<valorPoupanca>" Reais por "<tempo>" "<tipoTempo>"
    Quando eu pressionar o botão Simular
    Entao eu vou visualizar a mensagem de erro "<mensagemErro>" e a mensagem de erro "<mensagemErro2>"

    Exemplos:
      | Perfil    | valor        | valorPoupanca | tempo | tipoTempo | mensagemErro          | mensagemErro2              |
      | Para você | 19.00        | 19.00         | 0     | meses     | Valor mínimo de 20.00 | Valor esperado não confere |
      | Para você | 9.999.999,01 | 9.999.999,01  | 0     | meses     | Máximo de 9999999.00  | Valor esperado não confere |