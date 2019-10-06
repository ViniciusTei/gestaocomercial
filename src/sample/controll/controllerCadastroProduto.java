package sample.controll;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import sample.model.ProdutoDAO;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import sample.model.Produto;
import javax.xml.soap.Text;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class controllerCadastroProduto implements Initializable{
    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtDescricao;

    @FXML
    private TextField txtQntEstoque;

    @FXML
    private TextField txtCategoria;

    private ProdutoDAO bd = ProdutoDAO.getInstance();

    private ArrayList<Produto> listaDeProdutos = new ArrayList<Produto>();


    @Override
    public void initialize(URL url, ResourceBundle rb){
        listaDeProdutos = bd.getListaDeProdutos();

    }

    @FXML
    public void handleBtnCadastrar(){
        String nome, descricao, categoria;
        int codigo, qntEstoque;
        codigo = Integer.parseInt(txtCodigo.getText());
        nome = txtNome.getText();
        descricao = txtDescricao.getText();
        qntEstoque = Integer.parseInt(txtQntEstoque.getText());
        categoria = txtCategoria.getText();

        bd.addProduto(codigo,nome,descricao,qntEstoque,categoria);


        System.out.println("Produto cadastrado!");
    }

    private void showSucessAlert() {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Sucesso");
        alerta.setHeaderText(null);
        alerta.setContentText("Produto cadastrado!");
        alerta.showAndWait();
    }
}
