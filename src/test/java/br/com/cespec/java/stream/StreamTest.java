package br.com.cespec.java.stream;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.cespec.java.foreach.model.Curso;

public class StreamTest {

	private List<Curso> cursos = new ArrayList<>();

	@Before
	public void before() {
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
	}

	@Test
	public void deveEncontrarDoisCursosComMenosDeCemAlunos() {

		assertEquals(2, cursos.stream().filter(c -> c.getAlunos() < 100).count());
	}

	@Test
	public void deveSomarTotalDeAlunosDosCursosComMaisDeCemAlunos() {

		int lTotal = cursos.stream()
						.filter(c->c.getAlunos() > 100)
						.mapToInt(Curso::getAlunos)
						.sum();

		assertEquals(263, lTotal);
	}

	@Test
	public void deveOrdenarListaPelaQuantidadeDeAlunos() {

		cursos.sort(Comparator.comparing(Curso::getAlunos));

		assertEquals("Python", cursos.get(0).getNome());
		assertEquals("C", cursos.get(1).getNome());
		assertEquals("Java 8", cursos.get(2).getNome());
		assertEquals("JavaScript", cursos.get(3).getNome());
	}
}
