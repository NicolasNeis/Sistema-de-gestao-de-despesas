package App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {

    private static Stage stage;
    private static Scene sceneLogin;
    private static Scene sceneCadastro;
    private static Scene scenePrincipal;
    private static Scene sceneInserir;
    private static Scene sceneExcluir;

    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;

        Pane Login = FXMLLoader.load(getClass().getResource("Login.fxml"));
        sceneLogin = new Scene(Login,450,400);

        Pane Cadastro = FXMLLoader.load(getClass().getResource("Cadastro.fxml"));
        sceneCadastro = new Scene(Cadastro,450,400);

        Pane Principal = FXMLLoader.load(getClass().getResource("Principal.fxml"));
        scenePrincipal = new Scene(Principal, 900, 600);

        Pane Inserir = FXMLLoader.load(getClass().getResource("Inserir.fxml"));
        sceneInserir = new Scene(Inserir, 900, 600);

        primaryStage.setScene(sceneLogin);
        primaryStage.show();
    }

    public static void changeScreen(String scr) {
        switch (scr){
            case "Login":
                stage.setScene(sceneLogin);
                break;
            case "Cadastro":
                stage.setScene(sceneCadastro);
                break;
            case "Principal":
                stage.setScene(scenePrincipal);
                break;
            case "Inserir":
                stage.setScene(sceneInserir);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}