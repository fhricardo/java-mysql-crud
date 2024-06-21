import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadAluno {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/novo_banco";
        String user = "user";
        String password = "password";

        String selectSQL = "SELECT coluna1, coluna2, FROM tabela WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {

            pstmt.setInt(1, 1); //ID A SER LIDO

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("colunaID");
                String nome = rs.getString("colunaNOME");

                System.out.println("ID: " + id);
                System.out.println("Nome: " + nome);
            } else {
                System.out.println("Nenhum registro encontrado com o ID especificado.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
