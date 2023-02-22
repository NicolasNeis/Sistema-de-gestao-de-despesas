package Controller;

import ConnectionFactory.ConnectionFactory;
import App.App;
import Dao.CadastroDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cadastro {

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnVoltar;

    @FXML
    private Label labelConfirmacao;

    @FXML
    private PasswordField passwordTextCadastro;

    @FXML
    private TextField userTextCadastro;

    @FXML
    void SelectBtnCadastrar(ActionEvent event) {
        CadastroDao.cadastrarUser(userTextCadastro.getText(), passwordTextCadastro.getText());
        labelConfirmacao.setText("Usuário cadastrado com sucesso!");
    }

    @FXML
    void selectBtnVoltar(ActionEvent event) {
        App.changeScreen("Login");
    }

    @FXML
    void selectPasswordTextCadastro(ActionEvent event) {

    }

    @FXML
    void selectUserTextCadastro(ActionEvent event) {

    }

}
