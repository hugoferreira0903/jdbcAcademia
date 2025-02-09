package Academia;

import java.time.LocalDate;

public class Aluno extends Pessoa {
	
	private String plano;
	private boolean statusPagamento;

	public Aluno(String nome, String cpf, LocalDate dataNascimento, String plano, boolean statusPagamento) {
		super(nome, cpf, dataNascimento);
		this.plano = plano;
		this.statusPagamento = statusPagamento;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public boolean isStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(boolean statusPagamento) {
		this.statusPagamento = statusPagamento;
	}
	
	

}
