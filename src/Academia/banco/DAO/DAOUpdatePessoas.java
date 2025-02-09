package Academia.banco.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import Academia.banco.FabricaConexao;

public class DAOUpdatePessoas {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Connection conexao = FabricaConexao.getConexao();

        
        String sql = "UPDATE pessoas SET nome = ?, cpf = ?, dataNascimento = ? WHERE codigo = ?";

        System.out.print("Digite o ID da pessoa a atualizar: ");
        int codigo = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Digite o novo nome: ");
        String novoNome = sc.nextLine();

        System.out.print("Digite o novo CPF: ");
        String novoCpf = sc.nextLine();

        System.out.print("Digite a nova data de nascimento (AAAA-MM-DD): ");
        String novaDataNascimento = sc.nextLine(); 

        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, novoNome);
        stmt.setString(2, novoCpf);
        stmt.setString(3, novaDataNascimento);
        stmt.setInt(4, codigo); 

        int linhasAfetadas = stmt.executeUpdate(); 

        
        if (linhasAfetadas > 0) {
            System.out.println("Registro atualizado com sucesso!");
        } else {
            System.out.println("Nenhum registro encontrado com esse ID.");
        }
        
        
        String sql2 = "UPDATE alunos SET nome = ?, cpf = ?, dataNascimento = ?, plano = ?, statusPagamento = ? WHERE codigo_pessoa = ?";
        
        System.out.print("Digite o novo plano: ");
        String novoPlano = sc.nextLine();
        
        System.out.print("Digite o novo statusPagamento: ");
        int novostatusPagamento = sc.nextInt();
        
        PreparedStatement stmt2 = conexao.prepareStatement(sql2);
        stmt2.setString(1, novoNome);
        stmt2.setString(2, novoCpf);
        stmt2.setString(3, novaDataNascimento);
        stmt2.setString(4, novoPlano);
        stmt2.setInt(5, novostatusPagamento);
        stmt2.setInt(6, codigo);
        
        int linhasAfetadas2 = stmt2.executeUpdate(); 

        
        if (linhasAfetadas2 > 0) {
            System.out.println("Registro atualizado com sucesso!");
        } else {
            System.out.println("Nenhum registro encontrado com esse ID.");
        }
        
        stmt.close();
        stmt2.close();
        conexao.close();
        sc.close();
    }
}
