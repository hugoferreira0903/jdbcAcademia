package Academia.banco.DAO;

import java.time.LocalDate;

import Academia.Aluno;
import Academia.Pessoa;

public class DAOInserirPessoas {
    public static void main(String[] args) {
        DAOPessoas daop = new DAOPessoas();
        Pessoa p1 = new Pessoa("Hugo", "12345678910", LocalDate.of(2004, 3, 9));

        String sql = "INSERT INTO pessoas (nome, cpf, dataNascimento) VALUES (?, ?, ?)";
        int idpessoa = daop.incluir(sql, p1.getNome(), p1.getCpf(), p1.getDataNascimento());

        if (idpessoa > 0) {
            System.out.println("Pessoa inserida com ID: " + idpessoa);
            
            DAOAlunos daoa = new DAOAlunos();
            Aluno a1 = new Aluno(p1.getNome(), p1.getCpf(), p1.getDataNascimento(), "Mensal", true);
            
            String sql2 = "INSERT INTO alunos (codigo_pessoa, nome, cpf, dataNascimento, plano, statusPagamento) VALUES (?, ?, ?, ?, ?, ?)";
            daoa.incluir(sql2, idpessoa, a1.getNome(), a1.getCpf(), a1.getDataNascimento(), a1.getPlano(), a1.isStatusPagamento());
            
        } else {
            System.out.println("Erro ao inserir pessoa.");
        }
        
        
      
        
        
    }
}
