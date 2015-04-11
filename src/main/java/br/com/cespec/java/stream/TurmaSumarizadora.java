package br.com.cespec.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

import br.com.cespec.java.foreach.model.Turma;

public class TurmaSumarizadora {

	private List<Turma> turmas;

	public TurmaSumarizadora() {
		turmas = new ArrayList<>();
	}

	public TurmaSumarizadora(List<Turma> nova) {
		this.turmas = nova;
	}

	public static final TurmaSumarizadora of(Turma... turmas) {
		return Stream.of(turmas).collect(sumarizador());
	}

	public void adicionar(Turma turma) {
		turmas.add(turma);
	}

	public TurmaSumarizadora adicionarTodos(TurmaSumarizadora sumarizador) {
		List<Turma> nova = new ArrayList<>();

		turmas.forEach(nova::add);
		sumarizador.turmas.forEach(nova::add);

		return new TurmaSumarizadora(nova);
	}

	private static Collector<Turma,	TurmaSumarizadora, TurmaSumarizadora> sumarizador() {
		Supplier<TurmaSumarizadora> fornecedor = TurmaSumarizadora::new;
		BiConsumer<TurmaSumarizadora, Turma> acumulador = TurmaSumarizadora::adicionar;
		BinaryOperator<TurmaSumarizadora> combinador = TurmaSumarizadora::adicionarTodos;

		return Collector.of(fornecedor, acumulador, combinador);
	}
}

