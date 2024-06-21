import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateAluno {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/novo_banco";
        String user = "user";
        String password = "password";

        String updateSQL = "UPDATE tabela SET coluna = ? WHERE condicao = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            pstmt.setString(1, "valor1");
            pstmt.setString(2, "valor2");
            pstmt.setInt(3, 1); // ID do aluno a ser atualizado

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
