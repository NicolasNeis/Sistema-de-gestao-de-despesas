package Controller;

import App.App;
import Dao.MovimentacaoDao;
import Dao.PrincipalDao;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import Models.Movimentacao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Principal implements Initializable {

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnAtualizar;

    @FXML
    private Button btnInserir;

    @FXML
    private TableColumn<Movimentacao, Integer> columnCategoria;

    @FXML
    private TableColumn<Movimentacao, LocalDate> columnData;

    @FXML
    private TableColumn<Movimentacao,Integer> columnTipo;

    @FXML
    private TableColumn<Movimentacao, Integer> columnValor;

    @FXML
    private PieChart grafico;

    @FXML
    private Label labelSaldoAtual;

    @FXML
    private Label labelSaldoPrevisto;

    @FXML
    private TableColumn<Movimentacao, Integer> lastCategoria;

    @FXML
    private TableColumn<Movimentacao, LocalDate> lastData;

    @FXML
    private TableColumn<Movimentacao, Integer> lastTipo;

    @FXML
    private TableColumn<Movimentacao, Integer> lastValor;

    @FXML
    private TableView<Movimentacao> lastTabela;

    @FXML
    private TableView<Movimentacao> tabela;

    @FXML
    void selectBtnAtualizar(ActionEvent event) {
        atualiza();
    }

    @FXML
    void selectBtnExcluir(ActionEvent event) {
        MovimentacaoDao.delete(tabela);
    }

    @FXML
    void selectBtnInserir(ActionEvent event) {
        App.changeScreen("Inserir");
    }

    public void inserirDadosTabela() {
        columnTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        columnCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        columnData.setCellValueFactory(new PropertyValueFactory<>("data"));
        columnValor.setCellValueFactory(new PropertyValueFactory<>("valor"));

        tabela.setItems(MovimentacaoDao.listaMovimentacoes());
    }

    public void inserirDadosLastTabela(){
        lastTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        lastCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        lastData.setCellValueFactory(new PropertyValueFactory<>("data"));
        lastValor.setCellValueFactory(new PropertyValueFactory<>("valor"));

        lastTabela.setItems(MovimentacaoDao.lastListaMovimentacoes());
    }
    public void atualiza() {
        inserirDadosTabela();
        inserirDadosLastTabela();

        var saldoAtual = PrincipalDao.atualizaValorAtual().stream().mapToInt(i -> i).sum();
        var saldoPrevisto = PrincipalDao.atualizaValorPrevisto().stream().mapToInt(i -> i).sum();

        labelSaldoAtual.setText(String.valueOf(saldoAtual));
        if (saldoAtual > 0) {
            labelSaldoAtual.setStyle("-fx-text-fill: green");
        } else if (saldoAtual < 0) {
            labelSaldoAtual.setStyle("-fx-text-fill: red");
        } else {
            labelSaldoAtual.setStyle("-fx-text-fill: black");
        }

        labelSaldoPrevisto.setText(String.valueOf(saldoPrevisto));
        if (saldoPrevisto > 0) {
            labelSaldoPrevisto.setStyle("-fx-text-fill: green");
        } else if (saldoPrevisto < 0) {
            labelSaldoPrevisto.setStyle("-fx-text-fill: red");
        } else {
            labelSaldoPrevisto.setStyle("-fx-text-fill: black");
        }

        int contadorReceita = 0;
        int contadorDespesa = 0;

        for (Movimentacao m : PrincipalDao.verificaTipo()) {
            if(m.getTipo() == 1) {
                contadorReceita += 1;
            } else if (m.getTipo() == 2) {
                contadorDespesa += 1;
            }
        }

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Receita", contadorReceita),
                new PieChart.Data("Despesa", contadorDespesa)
        );

        grafico.setData(pieChartData);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        atualiza();

    }

}
