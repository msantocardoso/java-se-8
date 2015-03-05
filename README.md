#Arquitetura

	- Java SE 8
	- Maven: gestão das dependências
	- Junit4: utilizado na implementação dos testes unitários
	- Log4J: framework registro de logs de execução

#Java SE 8

A idéia destes projeto é exemplificar a utilização de alguns recursos do java SE 8

#Foreach utilizando expressões lambda

Foram implementados alguns cenários de teste com o intuito de exemplificar as diversas formas de iterar uma lista com foreach utilizando expressões **lambda**:

-------------------------------------------------------------------------------

Execute a classe de teste no diretório "src/test/java/**/foreach/ForeachTest.java"

A seguir a descrição dos testes implementados:

> *Itera a lista de usuários usando foreach padrão
```
	@Test
	public void deveIterarListaDeUsuariosUsandoForeachVersoesAnteriores();
```
> *Itera a lista de usuários usando uma implementação de consumer
```
	@Test
	public void deveIterarListaDeUsuariosUsandoImplementacaoUsuarioConsumer();
```
> *Itera a lista de usuários usando classes anônimas
```
	@Test
	public void deveIterarListaDeUsuariosUsandoClasseAnonima();
```
> *Itera a lista de usuários usando expressão lambda com apenas uma linha
```
	@Test
	public void deveIterarListaUsandoExpressaoLambdaEmUmaLinha();
```
> * Itera a lista de usuários usando expressão lambda com diversas linhas
```
	@Test
	public void deveIterarListaDeUsuariosUsandoExpressaoLambdaComVariasLinhas();
```
> * Itera a lista de usuários passando uma expressão lambda por parâmetro
```
	@Test
	public void deveIterarListaDeUsuariosUsandoExpressaoLambdaDiretoNoParametro();
```
> * Mostra como alterar propriedade status de todos os usuários da lista através utilizando expressões lambda
```
	@Test
	public void deveAlterarOStatusDeTodosOsUsuariosDaListaParaTrue();
```