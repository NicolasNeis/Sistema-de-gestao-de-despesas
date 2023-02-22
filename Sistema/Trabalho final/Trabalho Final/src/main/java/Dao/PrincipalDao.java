package Dao;

import ConnectionFactory.ConnectionFactory;
import Models.Movimentacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class PrincipalDao {

    public static ArrayList<Integer> atualizaValorAtual(){

        String sql = "SELECT * FROM movimentacao";

        var listaAtual = new ArrayList<Integer>();

        try(Connection con = ConnectionFactory.criaConexao();
            PreparedStatement statement = con.prepareStatement(sql)) {

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                LocalDate data = rs.getDate("data").toLocalDate();
                int valor = rs.getInt("valor");

                if (data.isBefore(LocalDate.now()) || data.isEqual(LocalDate.now())) {
                    listaAtual.add(valor);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return listaAtual;
    }

    public static ArrayList<Integer> atualizaValorPrevisto(){

        String sql = "SELECT * FROM movimentacao";

        var listaPrevista = new ArrayList<Integer>();

        try(Connection con = ConnectionFactory.criaConexao();
            PreparedStatement statement = con.prepareStatement(sql)) {

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                LocalDate data = rs.getDate("data").toLocalDate();
                int valor = rs.getInt("valor");

                if (data.isAfter(LocalDate.now())) {
                    listaPrevista.add(valor);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return listaPrevista;
    }

    public static ArrayList<Movimentacao> verificaTipo() {

        String sql = "SELECT * FROM movimentacao";

        var listaTipo = new ArrayList<Movimentacao>();

        try(Connection con = ConnectionFactory.criaConexao();
        PreparedStatement statement = con.prepareStatement(sql)) {

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int tipo = rs.getInt("tipo");

                Movimentacao movimentacao = new Movimentacao(tipo);
                listaTipo.add(movimentacao);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return listaTipo;
    }

}
