package sample.controll;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sample.model.ClienteDAO;
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
    @FXML
    private TextField txtRua;
    @FXML
    private TextField txtNum;
    @FXML
    private TextField txtBairro;
    @FXML
    private TextField txtCidade;
    @FXML
    private TextField txtPais;
    @FXML
    private TextField txtCep;

    private ClienteDAO bd = ClienteDAO.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void handleBtnCadastrar() {
        String nome, cpf, email, senha;
        String rua, bairro, cidade, pais, cep;
        int codigo, num;

        nome = txtNome.getText();
        cpf = txtCPF.getText();
        email = txtEmail.getText();
        senha = txtSenha.getText();
        codigo = Integer.parseInt(txtCodigo.getText());

        rua = txtRua.getText();
        bairro = txtBairro.getText();
        cidade = txtCidade.getText();
        pais = txtPais.getText();
        cep = txtCep.getText();
        num = Integer.parseInt(txtNum.getText());

        System.out.println(rua);
        bd.addCliente(nome, codigo, cpf, email, senha);
        bd.addEndereco(codigo, rua,bairro,cidade,pais,cep,num);
        System.out.println("Cliente cadastrado!");
    }

}
