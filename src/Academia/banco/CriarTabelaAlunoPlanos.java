package Academia.banco;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaAlunoPlanos {

	public static void main(String[] args) throws SQLException {
		
		
		Connection conexao = FabricaConexao.getConexao();
		
		 String sql = "DROP TABLE IF EXISTS aluno_planos (" 
	                + "codigoAluno INT NOT NULL,"
	                + "codigoPlano INT NOT NULL,"
	                + "dataInicio DATE NOT NULL,"
	                + "PRIMARY KEY (codigoAluno, codigoPlano),"
	                + "FOREIGN KEY (codigoAluno) REFERENCES alunos(codigo) ON DELETE CASCADE,"
	                + "FOREIGN KEY (codigoPlano) REFERENCES planos(codigo) ON DELETE CASCADE"
	                + ")";
		
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("tabela criada!!");
		
		conexao.close();
		
	}
	
	
}
