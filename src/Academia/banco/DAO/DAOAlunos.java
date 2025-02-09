package Academia.banco.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import Academia.banco.FabricaConexao;

public class DAOAlunos {

	private Connection conexao;
	
	
	
	public int incluir (String sql, Object... atributos) {
		
		PreparedStatement stmt;
		try {
			stmt = getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			adicionarAtributos(stmt, atributos);
			
			if(stmt.executeUpdate() > 0) {
				ResultSet resultado = stmt.getGeneratedKeys();
				
				if(resultado.next()) {
					return resultado.getInt(1);
				}
			}
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
		
		return -1;
	}

	
	
	public void close() {
		try {
        getConexao().close();
		} 
		catch (SQLException e) {
        } 
		finally {
        conexao = null;
		}
	}


	private void adicionarAtributos(PreparedStatement stmt, Object[] atributos) throws SQLException {
	    int indice = 1;

	    for (Object atributo : atributos) {
	        if (atributo == null) {
	            stmt.setNull(indice, java.sql.Types.NULL); 
	        } else if (atributo instanceof String) {
	            stmt.setString(indice, (String) atributo);
	        } else if (atributo instanceof Integer) {
	            stmt.setInt(indice, (Integer) atributo);
	        } else if (atributo instanceof LocalDate) {
	            stmt.setDate(indice, java.sql.Date.valueOf((LocalDate) atributo));
	        } else if (atributo instanceof Boolean) {
	            stmt.setInt(indice, (Boolean) atributo ? 1 : 0); 
	        } else {
	            throw new SQLException("Tipo de dado não suportado: " + atributo.getClass().getName());
	        }
	        indice++;
	    }
	}


private Connection getConexao() {
	try {
		if(conexao != null && !conexao.isClosed()) {
			return conexao;
		}
	} catch (SQLException e) {

	}
	
	conexao = FabricaConexao.getConexao();
	return conexao;
}

}

