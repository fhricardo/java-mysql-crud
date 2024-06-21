import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAluno {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/novo_banco";
        String user = "user";
        String password = "password";

        String deleteSQL = "DELETE FROM tabela WHERE coluna = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {

            pstmt.setInt(1, 1); // ID do aluno a ser deletado

            int rowsDeleted = pstmt.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
