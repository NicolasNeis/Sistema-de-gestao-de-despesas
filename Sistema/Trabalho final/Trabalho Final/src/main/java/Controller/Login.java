package Controller;

import App.App;
import Dao.LoginDao;
import Models.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Login {

    @FXML
    private Button btnCadastro;

    @FXML
    private Button btnLogin;

    @FXML
    private CheckBox btnStill;

    @FXML
    private PasswordField passwordText;

    @FXML
    private TextField userText;

    @FXML
    void SelectBtnLogin(ActionEvent event) {
        var login = LoginDao.listaUsuarios();
        for (Usuario u : login) {
            if(userText.getText().equals(u.getNome()) && passwordText.getText().equals(u.getSenha())) {
                App.changeScreen("Principal");
            }
            else {
                labelErroUser.setText("Erro! Usuário ou senha INCORRETOS!");
            }
        }
    }

    @FXML
    void SelectBtnStill(ActionEvent event) {

    }

    @FXML
    private Label labelErroUser;

    @FXML
    void selectBtnCadastro(ActionEvent event) throws IOException {
        App.changeScreen("Cadastro");
    }

    @FXML
    void selectPasswordText(ActionEvent event) {

    }

    @FXML
    void selectUserText(ActionEvent event) {

    }

    public void labelWarning(MouseEvent mouseEvent) {
    }
}
