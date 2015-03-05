package br.com.cespec.java.foreach;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;

import br.com.cespec.java.foreach.model.Usuario;

public abstract class AbstractForeachTest {

	private final Logger LOGGER = Logger.getLogger(AbstractForeachTest.class);

	protected final String LINE_BREAK = System.getProperty("line.separator");

	protected static List<Usuario> usuarios = new ArrayList<>();

	@BeforeClass
	public static void setUpBeforeClass() {
		usuarios.add(new Usuario("Marcio Souza", 39, true));
		usuarios.add(new Usuario("Alisson", 33, false));
		usuarios.add(new Usuario("Ricardo Perez", 29, true));
		usuarios.add(new Usuario("Bianca Rios", 19, false));
		usuarios.add(new Usuario("Maria Aparecida", 26, false));
	}

	@Before
	public void setUp() {
		LOGGER.info("-----------------------------------------");
	}
}
