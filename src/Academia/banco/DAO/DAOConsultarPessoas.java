package Academia.banco.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Academia.Pessoa;
import Academia.banco.FabricaConexao;



public class DAOConsultarPessoas {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		
		Connection conexao = FabricaConexao.getConexao();
		
		
		String sql = "SELECT * FROM pessoas WHERE nome like ?";
	
		
		System.out.println("Digite o nome a procurar: ");
		String procurar = sc.nextLine();
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, "%" + procurar + "%");
		ResultSet resultado = stmt.executeQuery();
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while(resultado.next()) {
			int codigo = resultado.getInt("codigo");
			String nome =  resultado.getString("nome");
			pessoas.add(new Pessoa(codigo, nome));
		}
		
		
		for (Pessoa p : pessoas) {
			System.out.println(p.getCodigo() +  " ===> " + p.getNome());
		}
		
		stmt.close();
		conexao.close();
		sc.close();
		
	}
		
}
