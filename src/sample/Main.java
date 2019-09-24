package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.model.Cliente;
import sample.model.Endereco;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/interface1.fxml"));
        primaryStage.setTitle("Gestão Comercial");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
//        Cliente c1 = new Cliente("vinicius", 1, "11297039670", "viniteixeirap@hotmail.com", "199725");
//        Endereco e1 = new Endereco("alfredo andrade", "centro", "florestal", "35690000", "Brasil");
//        c1.addEndereco("alfredo andrade", "centro", "florestal", "35690000", "Brasil");
//        System.out.println(c1.getEnderecos().get(0).getRua());
    }
}
