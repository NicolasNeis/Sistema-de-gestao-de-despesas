package ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection criaConexao() {

        //jdbc:mysql://ip_servidor_bd/nome_banco
        String str = "jdbc:mysql://localhost/financas";
        String user = "root";
        String password = "root";

        try {
            return DriverManager.getConnection(str, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
