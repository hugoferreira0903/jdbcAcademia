package Academia;

import java.time.LocalDate;

public class Professor extends Pessoa {

	private String modalidade;
	
	public Professor(String nome, String cpf, LocalDate dataNascimento, String modalidade) {
		super(nome, cpf, dataNascimento);
		this.modalidade = modalidade;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	
	

}
