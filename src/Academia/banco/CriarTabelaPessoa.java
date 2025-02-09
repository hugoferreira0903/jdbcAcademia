package Academia.banco;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaPessoa {

	
	public static void main(String[] args) throws SQLException {
		
		
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "CREATE TABLE IF NOT EXISTS pessoas (" 
				+ "codigo INT AUTO_INCREMENT,"
				+ "nome VARCHAR(80) NOT NULL,"
				+ "cpf VARCHAR(11) NOT NULL UNIQUE,"
				+ "dataNascimento DATE NOT NULL,"
				+ "PRIMARY KEY (codigo)"
                + ")";
	
		
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("Tabela Criada com sucesso!!");
		
		conexao.close();
		
	}
	
	
}
