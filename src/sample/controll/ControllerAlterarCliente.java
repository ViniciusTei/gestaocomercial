package sample.controll;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.model.Cliente;
import sample.model.ClienteDAO;
import sample.model.Endereco;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerAlterarCliente implements Initializable {
    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtCpf;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtRua;
    @FXML
    private TextField txtNum;
    @FXML
    private TextField txtCep;
    @FXML
    private TextField txtCidade;
    @FXML
    private TextField txtBairro;
    @FXML
    private TextField txtPais;
    @FXML
    private ComboBox<String> comboEnd;
    @FXML
    private TableView<Cliente> tableViewClientes;
    @FXML
    private TableColumn<Cliente, String> tableColumnClientes;

    private ObservableList<Cliente> observableCliente;
    private ObservableList<Endereco> observableEnd;
    private ClienteDAO clientes;
    private int enderecoMostrado=-1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clientes = ClienteDAO.getInstance();

        carregarTableViewClientes(clientes.getLisdaDeClientes());

        //Evento seleciona cliente para ser alterado
        tableViewClientes.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableView(newValue)
        );

        //evento para selecionar endereço
        comboEnd.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                setEndereco(t1);
            }
        });
    }

    /* Primeiro os módulos que auxiliarao o usuario a selecionar o cliente que ele deseja alterar
    * carrega a table view com a lista de clientes, e o cliente selecionado sera mostrado ao lado
    * numa tabela de edicao, onde elo pode alterar os dados cadastrados assim como adicionar ou
    * alterar os endereços do cliente.*/

    /* Carrega a table view com a lista de clientes passada */
    private void carregarTableViewClientes(ArrayList<Cliente> lista) {
        System.out.println("carregando table view...");
        tableColumnClientes.setCellValueFactory(new PropertyValueFactory<>("nomeDoCliente"));
        observableCliente = FXCollections.observableArrayList(lista);
        tableViewClientes.setItems(observableCliente);
        System.out.println("table view carregada!");
    }

    /* Metodo que efetua uma acao ao selecionar um cliente na table */
    private void selecionarItemTableView (Cliente c) {
        System.out.println("Cliente selecionado!");
        clearend();
        txtNome.setText(c.getNomeDoCliente());
        txtCodigo.setText(String.valueOf(c.getCodigoDoCliente()));
        txtEmail.setText(c.getEmail());
        txtCpf.setText(c.getCPF());

        observableEnd = FXCollections.observableArrayList(c.getEnderecos());
        carregaComboEnd(c.getEnderecos().size());

    }

    /* Carrega a combobox de endereços com a quantidade de endereços cadastrados */
    private void carregaComboEnd(int qtdEnd) {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < qtdEnd; i++) {
            strings.add("Endereco " + i+1);
        }
        this.comboEnd.getItems().setAll(strings);
        enderecoMostrado = -1;
        clearend();
    }

    private void setEndereco (String e) {
        //recebe o index do endereço a ser mostrado
        //subtrai 48 pois é o valor dos numericos na tabela ASCII
        if(e != null) {
            int index = e.charAt(e.length() - 1) - 48;
            enderecoMostrado = index - 1;
            setTxtEndereco(observableEnd.get(index - 1));
        }
    }

    private void setTxtEndereco(Endereco e) {
        txtRua.setText(e.getRua());
        txtBairro.setText(e.getBairro());
        txtCidade.setText(e.getCidade());
        txtCep.setText(e.getCep());
        txtPais.setText(e.getPais());
        txtNum.setText(String.valueOf(e.getNumero()));
    }

    //modulos para alterar os dados
    public void handleBtnCadastrarCliente() {
            alterarCliente();
    }

    public void handleBtnCadastrarEndereco() {
           cadastrarEndereco();
    }

     private void cadastrarEndereco() {
         clientes.addEndereco(
                 Integer.parseInt(txtCodigo.getText()),
                 txtRua.getText(),
                 txtBairro.getText(),
                 txtCidade.getText(),
                 txtPais.getText(),
                 txtCep.getText(),
                 Integer.parseInt(txtNum.getText())
         );
         System.out.println("nono endereço cadastrado!");
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Endereco Cadastrado");
         alert.setHeaderText(null);
         alert.setContentText("Endereço cadastrado com sucesso!");

         alert.showAndWait();

     }

     private void alterarCliente() {
       Cliente c = clientes.getCliente(Integer.parseInt(txtCodigo.getText()));

       if((enderecoMostrado == -1) ||verificaEnderecoMostrado(c.getEnderecos().get(enderecoMostrado))) {
           c.setNomeDoCliente(txtNome.getText());
           c.setCPF(txtCpf.getText());
           c.setEmail(txtEmail.getText());
           System.out.println("Cliente alterado]1");
       } else {
           c.setNomeDoCliente(txtNome.getText());
           c.setCPF(txtCpf.getText());
           c.setEmail(txtEmail.getText());
           c.getEnderecos().get(enderecoMostrado).setBairro(txtBairro.getText());
           c.getEnderecos().get(enderecoMostrado).setCep(txtCep.getText());
           c.getEnderecos().get(enderecoMostrado).setCidade(txtCidade.getText());
           c.getEnderecos().get(enderecoMostrado).setRua(txtRua.getText());
           System.out.println("Endereco e cliente alterados!");
       }

         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Alteração concluída");
         alert.setHeaderText(null);
         alert.setContentText("Os dados do cliente foram atualizados com sucesso!");

         alert.showAndWait();

     }

     /* metodo que verifica se o endereco mostrado foi alterado */
     private boolean verificaEnderecoMostrado(Endereco enderecoMostrado) {
        if(txtRua.getText().equals(enderecoMostrado.getRua())){
            return false;
        } else if (Integer.parseInt(txtNum.getText()) != enderecoMostrado.getNumero()) {
            return false;
        } else if(txtCep.getText().equals(enderecoMostrado.getCep())) {
            return false;
        } else if(txtBairro.getText().equals(enderecoMostrado.getBairro())) {
            return false;
        } else if(txtCidade.getText().equals(enderecoMostrado.getCidade())) {
            return false;
        } else if(txtPais.getText().equals(enderecoMostrado.getPais())) {
            return false;
        }

        //retorna verdadeiro se o endereco é igual
        return true;
     }

     private void clearend() {
         txtRua.setText("");
         txtBairro.setText("");
         txtCidade.setText("");
         txtCep.setText("");
         txtPais.setText("");
         txtNum.setText("");
     }
}
