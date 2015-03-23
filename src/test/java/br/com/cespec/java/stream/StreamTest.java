package br.com.cespec.java.stream;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

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
	public void deveRetornarListaComDoisCursosQuemContemMaisDeCemAlunos() {

		List<String> lNomeCursos = cursos.stream()
			.filter(c->c.getAlunos() > 100)
			.map(Curso::getNome)
			.collect(Collectors.toList());

		assertEquals("JavaScript", lNomeCursos.get(0));
		assertEquals("Java 8", lNomeCursos.get(1));
	}

	@Test
	public void deveRetornarMapaComDoisCursosQuemContemMenosDeCemAlunos() {
		Map<String, Integer> lCursos = cursos.stream()
			.filter(c -> c.getAlunos() < 100)
			.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));

		assertEquals(2, lCursos.size());
		assertEquals(Integer.valueOf(45), lCursos.get("Python"));
		assertEquals(Integer.valueOf(55), lCursos.get("C"));
	}

	@Test
	public void deveCalcularMediaDeAlunosDeTodosOsCursos() {

		OptionalDouble lMedia = cursos.stream()
			.mapToInt(Curso::getAlunos)
			.average();

		assertEquals(Double.valueOf(90.75), Double.valueOf(lMedia.getAsDouble()));
	}
}
