package Academia.banco;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CriarBanco {

public static void main(String[] args) throws SQLException {
	
		try {
			Properties prop = getProperties();
			final String url = prop.getProperty("banco.url");
			final String usuario = prop.getProperty("banco.usuario");
			final String senha =  prop.getProperty("banco.senha");
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			
			Statement stmt = conexao.createStatement();
			stmt.execute("CREATE DATABASE IF NOT EXISTS academia");
			
			System.out.println("banco criado com sucesso!");
			
			conexao.close();	
			
		} catch (SQLException | IOException e ) {
			throw new RuntimeException(e);
		}	
		
		
	}

	private static Properties getProperties() throws IOException {
	Properties prop = new Properties();
	String caminho = "/conexao.properties";
	prop.load(FabricaConexao.class.getResourceAsStream(caminho));
	return prop;
	}
	
}
