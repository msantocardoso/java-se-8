package br.com.cespec.java.ordenacao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrdenacaoStringTest {

	private final Logger LOGGER = Logger.getLogger(OrdenacaoStringTest.class);

	private static List<String> palavras = new ArrayList<>();

	@Before
	public void before() {
		palavras.add("texto medio");
		palavras.add("texto bem maior");
		palavras.add("texto");
	}

	@After
	public void after() {
		palavras.clear();
	}

	@Test
	public void deveOrdenarListaPorTamanhoDaStringDoMenorParaMaiorUsandoSintaxJava7() {

		Collections.sort(palavras, new ComparadorDoMenorParaMaior());

		assertEquals("texto", palavras.get(0));
		assertEquals("texto medio", palavras.get(1));
		assertEquals("texto bem maior", palavras.get(2));
	}

	@Test
	public void deveOrdenarListaPorTamanhoDaStringDoMenorParaMaiorUsandoSintaxJava8() {

		palavras.sort(new ComparadorDoMenorParaMaior());

		assertEquals("texto", palavras.get(0));
		assertEquals("texto medio", palavras.get(1));
		assertEquals("texto bem maior", palavras.get(2));

		LOGGER.info(palavras);
	}

	@Test
	public void deveOrdenarListaPorTamanhoDaStringDoMaiorParaMenorUsandoSintaxJava8() {

		palavras.sort(new ComparadorDoMaiorParaMenor());

		assertEquals("texto bem maior", palavras.get(0));
		assertEquals("texto medio", palavras.get(1));
		assertEquals("texto", palavras.get(2));

		LOGGER.info(palavras);
	}

	@Test
	public void deveOrdenarListaPeloTamanhoDaStringDoMenorParaMaiorUsandoLambdaJava8() {

		palavras.sort((textoI, textoII) -> Integer.compare(textoI.length(), textoII.length()));

		assertEquals("texto", palavras.get(0));
		assertEquals("texto medio", palavras.get(1));
		assertEquals("texto bem maior", palavras.get(2));

		LOGGER.info(palavras);
	}
}