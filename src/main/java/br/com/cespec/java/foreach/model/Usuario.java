package br.com.cespec.java.foreach.model;

public class Usuario {

	private String nome;
	private int idade;
	private boolean status;

	public Usuario(String nome, int idade, boolean status) {
		this.nome = nome;
		this.idade = idade;
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public boolean isStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", idade=" + idade + ", status=" + status + "]";
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
