package Academia.banco;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaAluno {

	public static void main(String[] args) throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "CREATE TABLE IF NOT EXISTS alunos("
				+ "codigo_pessoa INT NOT NULL,"
				+ "nome VARCHAR(80) NOT NULL,"
				+ "cpf VARCHAR(11) NOT NULL UNIQUE,"
				+ "dataNascimento DATE NOT NULL,"
				+ "plano VARCHAR(20) NOT NULL,"
				+ "statusPagamento TINYINT(1) NOT NULL,"
				+ "PRIMARY KEY (codigo_pessoa),"
				+ "FOREIGN KEY (codigo_pessoa) REFERENCES pessoas(codigo) ON DELETE CASCADE"
				+ ")";
		
		
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("Tabela Criada com Sucesso!!!");
		
		
		
		
		conexao.close();
		
		
	}
	
}
