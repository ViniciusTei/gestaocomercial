package sample.controll;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sample.model.SistemaDAO;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

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
    private PasswordField txtSenha;

    private SistemaDAO bd = SistemaDAO.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void handleBtnCadastrar() {
        String nome, cpf, email, senha;
        int codigo;

        nome = txtNome.getText();
        cpf = txtCPF.getText();
        email = txtEmail.getText();
        senha = txtSenha.getText();
        codigo = Integer.parseInt(txtCodigo.getText());

        bd.addCliente(nome, codigo, cpf, email, senha);
        System.out.println("Cliente cadastrado!");
    }
}
