package br.com.cespec.java.foreach.model;

public class Aluno {

	private String nome;
	private Sexo sexo;
	private Double nota;

	public Aluno(String nome, Sexo sexo, Double nota) {
		this.nome = nome;
		this.sexo = sexo;
		this.nota = nota;
	}

	public String getNome() {
		return nome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public Double getNota() {
		return nota;
	}

}
