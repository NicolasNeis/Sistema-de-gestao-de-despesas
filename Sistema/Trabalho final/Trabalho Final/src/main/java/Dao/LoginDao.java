package Dao;

import App.App;
import ConnectionFactory.ConnectionFactory;
import Controller.Login;
import Models.Usuario;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginDao {
    public static ArrayList<Usuario> listaUsuarios() {
        String sql = "SELECT * FROM usuario";
        var listaUsers = new ArrayList<Usuario>();

        try(Connection con = ConnectionFactory.criaConexao();
            PreparedStatement statement = con.prepareStatement(sql)) {

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String senha = rs.getString("senha");

                var usuarios = new Usuario(nome, senha);
                listaUsers.add(usuarios);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return listaUsers;
    }
}
