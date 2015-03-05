package br.com.cespec.java.foreach;

import static org.junit.Assert.assertEquals;

import java.util.function.Consumer;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.cespec.java.foreach.model.Usuario;


public class ForeachTest extends AbstractForeachTest {

	private static final Logger LOGGER = Logger.getLogger(ForeachTest.class);

	@Test
	public void deveIterarListaDeUsuariosUsandoForeachVersoesAnteriores() {
		for (Usuario usuario : usuarios) {
			LOGGER.info("Java SE 7: " + usuario);
		}
	}

	@Test
	public void deveIterarListaDeUsuariosUsandoImplementacaoUsuarioConsumer() {
		usuarios.forEach(new UsuarioConsumer());
	}

	@Test
	public void deveIterarListaDeUsuariosUsandoClasseAnonima() {
		Consumer<Usuario> lUserConsumer = new Consumer<Usuario>(){

			@Override
			public void accept(Usuario pUsuario) {
				LOGGER.info("Classe Anônima: " + pUsuario);
			}
		};

		usuarios.forEach(lUserConsumer);
	}

	@Test
	public void deveIterarListaDeUsuariosUsandoExpressaoLambdaComVariasLinhas() {

		LOGGER.info("Expressão lambda com várias linhas");
		Consumer<Usuario> lConsumer = lUsuario -> {
			StringBuilder lBuilder = new StringBuilder();

			lBuilder.append(LINE_BREAK);
			lBuilder.append("{" +LINE_BREAK);
			lBuilder.append("Nome: " + lUsuario.getNome() + LINE_BREAK);
			lBuilder.append("Idade: " + lUsuario.getIdade() +LINE_BREAK);
			lBuilder.append("Status: " + lUsuario.isStatus() +LINE_BREAK);
			lBuilder.append("}; ");

			LOGGER.info(lBuilder.toString());
		};

		usuarios.forEach(lConsumer);
	}


	@Test
	public void deveIterarListaUsandoExpressaoLambdaEmUmaLinha() {

		Consumer<Usuario> lConsumer = lUsuario -> LOGGER.info("Lambda: " + lUsuario.toString());

		usuarios.forEach(lConsumer);
	}

	@Test
	public void deveIterarListaDeUsuariosUsandoExpressaoLambdaDiretoNoParametro() {
		usuarios.forEach(lUsuario -> LOGGER.info("Lambda parâmetro: " + lUsuario.toString()));
	}

	@Test
	public void deveAlterarOStatusDeTodosOsUsuariosDaListaParaTrue() {

		usuarios.forEach(lUsuario -> lUsuario.setStatus(true));

		usuarios.forEach(lUsuario -> assertEquals(true, lUsuario.isStatus()));
	}
}
