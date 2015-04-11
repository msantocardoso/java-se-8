package br.com.cespec.java.stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import br.com.cespec.java.foreach.model.Aluno;
import br.com.cespec.java.foreach.model.Sexo;
import br.com.cespec.java.foreach.model.Turma;

public class TurmaTest {

	private Turma turma = new Turma();

	@Before
	public void setUpBeforeClass() {
		turma.adicionar(new Aluno("Murilo", Sexo.MASCULINO, 8.9) );
		turma.adicionar(new Aluno("Teste I", Sexo.FEMININO, 9.0));
		turma.adicionar(new Aluno("Fanfarrão", Sexo.MASCULINO, 10.0));
	}

	@Test
	public void deveRetornarOsAlunosAprovados() {
		List<Aluno> aprovados = turma.getAprovados();

		assertEquals(3, aprovados.size());
	}

	@Test
	public void deveRetornarSumarizacaoDasNotas() {
		DoubleSummaryStatistics sumario = turma.getSumarizacaoDasNotas();

		assertEquals(Double.valueOf(9.299999999999999), Double.valueOf(sumario.getAverage()));
		assertEquals(Double.valueOf(3), Double.valueOf(sumario.getCount()));
		assertEquals(Double.valueOf(8.9), Double.valueOf(sumario.getMin()));
		assertEquals(Double.valueOf(10.0), Double.valueOf(sumario.getMax()));
		assertEquals(Double.valueOf(27.9), Double.valueOf(sumario.getSum()));
	}

	@Test
	public void deveAgruparAlunosPorSexo() {
		Map<Sexo, List<Aluno>> mapAlunos = turma.getAlunosAgrupadoPorSexo();

		assertEquals(2, mapAlunos.get(Sexo.MASCULINO).size());
		assertEquals(1, mapAlunos.get(Sexo.FEMININO).size());
	}

	@Test
	public void deveParticionarAlunosAprovadosEReprovados() {
		Map<Boolean, List<Aluno>> particionamento = turma.particionarAlunosAprovadosEReprovados();

		assertEquals(3, particionamento.get(Boolean.TRUE).size());
	}

	@Test
	public void deveMatchAlunos() {
		boolean temAprovados = turma.existeAlunoAprovado();

		assertEquals(true, temAprovados);
	}

	@Test
	public void deveVerificarSeTodosOsAlunosForamAprovados() {
		boolean lPossuiAprovados = turma.todosEstaoAprovados();

		assertEquals(true, lPossuiAprovados);
	}

	@Test
	public void deveSomarAsNotasDeTodosOsAlunos() {
		Optional<Double> total = turma.somarTodasAsNotas();

		assertEquals(Double.valueOf(27.9), total.get());
	}

	@Test
	public void deveJuntarTodasAsTurmas() {
		Turma matutino = new Turma();

		matutino.adicionar(new Aluno("A", Sexo.FEMININO, 5.5));
		matutino.adicionar(new Aluno("B", Sexo.MASCULINO, 6.0));
		matutino.adicionar(new Aluno("C", Sexo.FEMININO, 4.4));
		matutino.adicionar(new Aluno("D", Sexo.MASCULINO, 8.3));
		matutino.adicionar(new Aluno("E", Sexo.FEMININO, 6.2));

		Turma vespertino = new Turma();
		vespertino.adicionar(new Aluno("F", Sexo.MASCULINO, 8.5));
		vespertino.adicionar(new Aluno("G", Sexo.MASCULINO, 9.0));
		vespertino.adicionar(new Aluno("H", Sexo.FEMININO, 8.5));
		vespertino.adicionar(new Aluno("I", Sexo.FEMININO, 8.3));
		vespertino.adicionar(new Aluno("J", Sexo.FEMININO, 8.7));

		TurmaSumarizadora sumarizadora = TurmaSumarizadora.of(matutino, vespertino);

		assertNotNull(sumarizadora);
	}
}