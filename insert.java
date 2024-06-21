import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertAluno {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/novo_banco";
        String user = "user";
        String password = "password";

        String insertSQL = "INSERT INTO tabela (coluna) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            pstmt.setString(1, "Valor");
            pstmt.setString(2, "valor");
            pstmt.setInt(3, 20);

            int rowsInserted = pstmt.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
