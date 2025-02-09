package Academia.banco;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaPlanos {

	public static void main(String[] args) throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		
		
		
		
		 String sql = "DROP TABLE IF EXISTS planos (" 
	                + "codigo INT AUTO_INCREMENT,"
	                + "descricao VARCHAR(50) NOT NULL,"
	                + "PRIMARY KEY (codigo)"
	                + ")";
		
		

		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("Tabela criada!!!");
		
		conexao.close();
		
		
	}
	
	
	
}
