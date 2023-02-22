package Dao;

import ConnectionFactory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class InserirDao {

    public static void cadastrarMovimentacao(int tipo, int categoria, Date data, int valor, String descricao, boolean pago) {
        String sql = "INSERT INTO movimentacao (tipo, categoria, data, valor, descricao, pago) VALUES (?,?,?,?,?,?)";

        try(Connection con = ConnectionFactory.criaConexao();
            PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setInt(1, tipo);
            statement.setInt(2, categoria);
            statement.setDate(3, (java.sql.Date) data);
            statement.setInt(4, valor);
            statement.setString(5, descricao);
            statement.setBoolean(6, pago);

            statement.execute();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
