package Dao;

import ConnectionFactory.ConnectionFactory;
import Models.Movimentacao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MovimentacaoDao {

    public static ObservableList<Movimentacao> listaMovimentacoes() {

        String sql = "SELECT * FROM movimentacao";

        ObservableList<Movimentacao> listaDeMovimentacao = FXCollections.observableArrayList();

        try(Connection con = ConnectionFactory.criaConexao();
            PreparedStatement statement = con.prepareStatement(sql)) {

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int tipo = rs.getInt("tipo");
                int categoria = rs.getInt("categoria");
                LocalDate data = rs.getDate("data").toLocalDate();
                int valor = rs.getInt("valor");
                int id = rs.getInt("id");

                var movimentacao = new Movimentacao(tipo, categoria, data, valor, id);

                listaDeMovimentacao.add(movimentacao);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return listaDeMovimentacao;
    }

    public static ObservableList<Movimentacao> lastListaMovimentacoes() {

        String sql = "SELECT * FROM movimentacao ORDER BY id DESC LIMIT 1";

        ObservableList<Movimentacao> listaDeMovimentacao = FXCollections.observableArrayList();

        try(Connection con = ConnectionFactory.criaConexao();
            PreparedStatement statement = con.prepareStatement(sql)) {

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int tipo = rs.getInt("tipo");
                int categoria = rs.getInt("categoria");
                LocalDate data = rs.getDate("data").toLocalDate();
                int valor = rs.getInt("valor");
                int id = rs.getInt("id");

                var movimentacao = new Movimentacao(tipo, categoria, data, valor, id);

                listaDeMovimentacao.add(movimentacao);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return listaDeMovimentacao;
    }

    public static void delete( TableView tabela) {

        String sql = "DELETE FROM movimentacao WHERE id = ?";

        try(Connection con = ConnectionFactory.criaConexao();
            PreparedStatement statement = con.prepareStatement(sql)) {

            Movimentacao movimentacao = (Movimentacao) tabela.getSelectionModel().getSelectedItem();

            statement.setInt(1, movimentacao.getId());

            statement.execute();
            statement.close();

            tabela.getItems().remove(movimentacao);

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
