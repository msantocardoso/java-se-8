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
		palavras.add("texto bem maior");
		palavras.add("texto medio");
		palavras.add("texto");

		LOGGER.info(palavras);
	}

	@After
	public void after() {
		palavras.clear();
	}

	@Test
	public void deveOrdenarListaPorTamanhoDaStringUsandoSintaxJava7() {

		Collections.sort(palavras, new ComparadorDoMenorParaMaior());

		assertEquals("texto", palavras.get(0));
		assertEquals("texto medio", palavras.get(1));
		assertEquals("texto bem maior", palavras.get(2));

		LOGGER.info(palavras);
	}

	@Test
	public void deveOrdenarListaPorTamanhoDaStringUsandoSintaxJava8() {

		palavras.sort(new ComparadorDoMenorParaMaior());

		assertEquals("texto", palavras.get(0));
		assertEquals("texto medio", palavras.get(1));
		assertEquals("texto bem maior", palavras.get(2));
	}
}