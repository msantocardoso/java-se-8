package br.com.cespec.java.foreach.model;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

public class Turma {
	private static final Predicate<Aluno> ALUNO_APROVADO = aluno -> aluno.getNota() >= 7.0;

	private List<Aluno> alunos = new ArrayList<>();

	public List<Aluno> getAlunos() {
		return Collections.unmodifiableList(alunos);
	}

	public void adicionar(Aluno aluno) {
		alunos.add(aluno);
	}

	public List<Aluno> getAprovados() {
		return alunos.stream().filter((aluno) -> aluno.getNota() >= 7.0)
				.sorted(Comparator.comparing(Aluno::getNome))
				.collect(toList());
	}

	public DoubleSummaryStatistics getSumarizacaoDasNotas() {
		return alunos.stream().mapToDouble(Aluno::getNota).summaryStatistics();
	}

	public Map<Sexo, List<Aluno>> getAlunosAgrupadoPorSexo() {
		return alunos.stream().collect(groupingBy(Aluno::getSexo));
	}

	public Map<Boolean, List<Aluno>> particionarAlunosAprovadosEReprovados() {
		return alunos.stream().collect(partitioningBy(ALUNO_APROVADO));
	}

	public boolean existeAlunoAprovado() {
		return alunos.stream().anyMatch(ALUNO_APROVADO);
	}

	public boolean todosEstaoAprovados() {
		return alunos.stream().allMatch(ALUNO_APROVADO);
	}

	public Optional<Double> somarTodasAsNotas() {
		return alunos.stream().map(Aluno::getNota).reduce((a, b) -> a + b);
	}
}
