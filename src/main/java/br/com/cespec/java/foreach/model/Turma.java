package br.com.cespec.java.foreach.model;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class Turma {

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
}
