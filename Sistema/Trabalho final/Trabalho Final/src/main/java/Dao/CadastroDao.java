package Dao;

import ConnectionFactory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroDao {

    public static void cadastrarUser(String user, String senha) {
        String sql = "INSERT INTO usuario (nome, senha) VALUES (?,?)";

        try(Connection con = ConnectionFactory.criaConexao();
            PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setString(1, user);
            statement.setString(2, senha);

            statement.execute();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
