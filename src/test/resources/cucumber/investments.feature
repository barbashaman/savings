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
      | Para você | 20.00  | 20.00         | 12            | meses     | R$ 266        |
      | Para você | 40.00  | 40.00         | 24            | meses     | R$ 1.046      |
      | Para você | 80.00  | 80.00         | 36            | meses     | R$ 3.167      |
      | Para você | 160.00 | 160.00        | 48            | meses     | R$ 8.581      |
      | Para você | 320.00 | 320.00        | 60            | meses     | R$ 21.863     |