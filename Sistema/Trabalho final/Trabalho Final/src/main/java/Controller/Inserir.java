package Controller;

import App.App;
import Dao.InserirDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class Inserir implements Initializable {

    @FXML
    private TextArea DescricaoText;

    @FXML
    private Button btnInserir;

    @FXML
    private TextField Text;

    @FXML
    private DatePicker btnData;

    @FXML
    private Button btnVoltar;

    @FXML
    private ComboBox comboCategoria;

    @FXML
    private ComboBox comboTipo;

    @FXML
    private Label labelErro;

    @FXML
    private CheckBox checkBoxPago;

    @FXML
    void selectBtnData(ActionEvent event) {

    }

    @FXML
    boolean SelectCheckBoxPago() {
        if (checkBoxPago.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    int tipo;
    int categoria;

    public int testaTipo() {
        if (comboTipo.getSelectionModel().getSelectedItem().toString().equals("1. Receita")) {
            tipo = 1;
        } else if (comboTipo.getSelectionModel().getSelectedItem().toString().equals("2. Despesa")) {
            tipo = 2;
        }
        return tipo;
    }

    public int testaCategoria() {
        if (comboCategoria.getSelectionModel().getSelectedItem().toString().equals("1. Alimentação")) {
            categoria = 1;
        } else if (comboCategoria.getSelectionModel().getSelectedItem().toString().equals("2. Educação")) {
            categoria = 2;
        } else if (comboCategoria.getSelectionModel().getSelectedItem().toString().equals("3. Esportes")) {
            categoria = 3;
        } else if (comboCategoria.getSelectionModel().getSelectedItem().toString().equals("4. Lazer")) {
            categoria = 4;
        } else if (comboCategoria.getSelectionModel().getSelectedItem().toString().equals("5. Moradia")) {
            categoria = 5;
        } else if (comboCategoria.getSelectionModel().getSelectedItem().toString().equals("6. Outros")) {
            categoria = 6;
        } else if (comboCategoria.getSelectionModel().getSelectedItem().toString().equals("7. Presentes")) {
            categoria = 7;
        } else if (comboCategoria.getSelectionModel().getSelectedItem().toString().equals("8. Roupas")) {
            categoria = 8;
        } else if (comboCategoria.getSelectionModel().getSelectedItem().toString().equals("9. Salário")) {
            categoria = 9;
        } else if (comboCategoria.getSelectionModel().getSelectedItem().toString().equals("10. Saúde")) {
            categoria = 10;
        } else if (comboCategoria.getSelectionModel().getSelectedItem().toString().equals("11. Transporte")) {
            categoria = 11;
        } else if (comboCategoria.getSelectionModel().getSelectedItem().toString().equals("12. Viagem")) {
            categoria = 12;
        }
        return categoria;
    }


    @FXML
    void selectBtnInserir(ActionEvent event) {
        if (comboTipo.getItems().isEmpty() || comboTipo.getItems().isEmpty() || Text.getText().isEmpty()) {
            labelErro.setText("Erro! Favor preencher os campos corretamente.");
        } else {

            int tipo = testaTipo();
            int categoria = testaCategoria();
            int valor = Integer.parseInt(Text.getText());
            Date date = java.sql.Date.valueOf(btnData.getValue());
            String descricao = DescricaoText.getText();
            InserirDao.cadastrarMovimentacao(tipo, categoria, date, valor, descricao, SelectCheckBoxPago());
            App.changeScreen("Principal");

        }
    }

    @FXML
    void selectBtnVoltar(ActionEvent event) {
        App.changeScreen("Principal");
    }

    @FXML
    void selectComboCategoria(ActionEvent event) {

    }

    @FXML
    void selectComboTIpo(ActionEvent event) {

    }

    @FXML
    void selectValor(ActionEvent event) {

    }


    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> categoriaList = FXCollections.observableArrayList("1. Alimentação", "2. Educação",
                "3. Esportes", "4. Lazer", "5. Moradia", "6. Outros", "7. Presentes", "8. Roupas", "9. Salário", "10. Saúde",
                "11. Transporte", "12. Viagem");

        comboCategoria.setItems(categoriaList);


        ObservableList<String> tipoList = FXCollections.observableArrayList("1. Receita", "2. Despesa");

        comboTipo.setItems(tipoList);

    }

}