package sample.controll;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sample.model.SistemaDAO;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class controllerCadastroCliente implements Initializable {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtCPF;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtSenha;

    private SistemaDAO bd = SistemaDAO.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void handleBtnCadastrar() {
        String nome, cpf, email, senha;
        int codigo;

        nome = txtNome.getText();
        System.out.println(nome);
    }
}
