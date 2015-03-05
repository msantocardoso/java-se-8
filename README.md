#Arquitetura

	- Java SE 8
	- Maven: gestão das dependências
	- Junit4: framework utilizado na implementação dos testes unitários
	- Log4J: framework registro de logs de execução

#Java SE 8

A idéia destes projeto é exemplificar a utilização de alguns recursos do java SE 8

#Foreach utilizando expressões lambda

Inicialmente foram desenvolvidos as diversas formas de criar um foreach utilizando expressões **lambda**:

Execute a classe de teste no diretório "src/test/java/**/foreach/ForeachTest.java"

A seguir a descrição dos testes implementados:

> *Mostra a iteração de uma lista de usuários usando foreach padrão
```
	@Test
	public void deveIterarListaDeUsuariosUsandoForeachVersoesAnteriores();
```
> *Exemplifica a iteração de uma lista de usuários usando uma implementação de consumer
```
	@Test
	public void deveIterarListaDeUsuariosUsandoImplementacaoUsuarioConsumer();
```
> *Exemplifica a iteração de uma lista de usuários usando uma implementação utilizando classes anônimas
```
	@Test
	public void deveIterarListaDeUsuariosUsandoClasseAnonima();
```
> * Exemplifica a iteração de uma lista de usuários usando expressão lambda com diversas linhas
```
	@Test
	public void deveIterarListaDeUsuariosUsandoExpressaoLambdaComVariasLinhas();
```
> *Exemplifica a iteração de uma lista de usuários usando expressão lambda com apenas uma linha
```
	@Test
	public void deveIterarListaUsandoExpressaoLambdaEmUmaLinha();
```
> * Exemplifica a iteração de uma lista de usuários passando uma expressão lambda por parâmetro
```
	@Test
	public void deveIterarListaDeUsuariosUsandoExpressaoLambdaDiretoNoParametro();
```
> * Mostra a alteração da propriedade status de todos os usuários da lista através de uma expressão lambda
```
	@Test
	public void deveAlterarOStatusDeTodosOsUsuariosDaListaParaTrue();
```
