# Teste para QA do Woop Sicredi

Teste de Automação para seleção de QA do Woop Sicredi

## Instalação

O projeto utiliza o gradle como gerenciador de dependências. Para instalação, basta executar o seguinte comando:

```bash
gradle clean build
```

## Executando os testes

Para executar o teste de API basta executar o comando:
```bash
gradle test
```
Para executar os testes de web basta executar o comando:
```bash
gradle cucumber
```

## Tecnologias utilizadas
* JUnit 5 (JUnit Jupiter);
* REST Assured (para os testes de API);
* Selenium, para o mapeamento e automação de elementos do DOM HTML;
* Web Driver Manager para tratar as dependências de drivers do Selenium; 
* Cucumber, para implementação do BDD (Business Driven Development)

## Contato
[mail](mailto:matheus.barbachan@gmail.com)
