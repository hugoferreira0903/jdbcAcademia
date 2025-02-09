package Academia.banco.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import Academia.banco.FabricaConexao;

public class DAOExcluirPessoas {

	public static void main(String[] args) throws SQLException {
		
		
		Scanner sc = new Scanner(System.in);
		
		
		Connection conexao = FabricaConexao.getConexao();
		
		
		String sql = "DELETE  FROM pessoas WHERE codigo = ?";
		
		System.out.println("Digite o id a excluir: ");
		int procurar = sc.nextInt();
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, procurar);
		 int linhasAfetadas = stmt.executeUpdate();
		
		 	if (linhasAfetadas > 0) {
	            System.out.println("Registro excluído com sucesso!");
	        } else {
	            System.out.println("Nenhum registro encontrado com esse ID.");
	        }

	        stmt.close();
	        conexao.close();
	        sc.close();
		 
	}
	
}
