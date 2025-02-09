package Academia;

import java.time.LocalDate;

public class Pessoa {

	private Long codigo;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	
	
	
	public Pessoa(String nome, String cpf, LocalDate dataNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	
	public Pessoa(Long codigo, String nome, String cpf, LocalDate dataNascimento) {
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}


	public Pessoa(int codigo, String nome) {
		super();
		this.codigo = (long) codigo;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public LocalDate getDataNascimento() {
		return dataNascimento;
	}



	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}



	public Long getCodigo() {
		return codigo;
	}
	
	
	
	
	
	
	
	
}
