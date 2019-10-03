package sample.controll;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

    /* Carrega a table view com a lista de clientes passada */
    public void carregarTableViewClientes(ArrayList<Cliente> lista) {
        System.out.println("carregando table view...");
        tableColumnClientes.setCellValueFactory(new PropertyValueFactory<>("nomeDoCliente"));
        observableCliente = FXCollections.observableArrayList(lista);
        tableViewClientes.setItems(observableCliente);
        System.out.println("table view carregada!");
    }

    /* Metodo que efetua uma acao ao selecionar um cliente na table */
    public void selecionarItemTableView (Cliente c) {
        System.out.println("Cliente selecionado!");
        //clearEnd();
        txtNome.setText(c.getNomeDoCliente());
        txtCodigo.setText(String.valueOf(c.getCodigoDoCliente()));
        txtEmail.setText(c.getEmail());
        txtCpf.setText(c.getCPF());

        observableEnd = FXCollections.observableArrayList(c.getEnderecos());
        carregaComboEnd(c.getEnderecos().size());

    }

    /* Carrega a combobox de endereços com a quantidade de endereços cadastrados */
    public void carregaComboEnd(int qtdEnd) {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < qtdEnd; i++) {
            strings.add("Endereco " + i+1);
        }
        this.comboEnd.getItems().setAll(strings);
    }

    private void setEndereco (String e) {
        //recebe o index do endereço a ser mostrado
        //subtrai 48 pois é o valor dos numericos na tabela ASCII
        int index = e.charAt(e.length()-1) - 48;
        setTxtEndereco(observableEnd.get(index - 1));
    }

    private void setTxtEndereco(Endereco e) {
        txtRua.setText(e.getRua());
        txtBairro.setText(e.getBairro());
        txtCidade.setText(e.getCidade());
        txtCep.setText(e.getCep());
        txtPais.setText(e.getPais());
        txtNum.setText(String.valueOf(e.getNumero()));
    }
}
