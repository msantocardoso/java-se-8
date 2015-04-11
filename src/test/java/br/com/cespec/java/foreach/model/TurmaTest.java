package br.com.cespec.java.foreach.model;

import static org.junit.Assert.assertEquals;

import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TurmaTest {

	private Turma turma = new Turma();

	@Before
	public void setUpBeforeClass() {
		turma.adicionar(new Aluno("Murilo", Sexo.MASCULINO, 8.9) );
		turma.adicionar(new Aluno("Teste I", Sexo.FEMININO, 9.0));
		turma.adicionar(new Aluno("Fanfarrão", Sexo.MASCULINO, 10.0));
	}

	@After
	public void tearDownAfterClass() throws Exception {
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
}
