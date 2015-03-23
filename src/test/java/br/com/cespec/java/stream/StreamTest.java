package br.com.cespec.java.stream;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
		Stream<Curso> lCursos = cursos.stream().filter(c -> c.getAlunos() < 100);

		assertEquals(2, lCursos.count());
	}
}
