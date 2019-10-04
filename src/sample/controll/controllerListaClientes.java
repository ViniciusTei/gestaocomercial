package sample.controll;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.model.ClienteDAO;
import sample.model.Cliente;
import sample.model.Endereco;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class controllerListaClientes implements Initializable {
    @FXML
    private TableView<Cliente> tableViewClientes;
    @FXML
    private TableColumn<Cliente, String> tableColumnClientes;
    @FXML
    private Label labelClienteCodigo;
    @FXML
    private Label labelClienteNome;
    @FXML
    private Label labelClienteCpf;
    @FXML
    private Label labelClienteEmail;
    @FXML
    private TextField textFiltrarNome;
    @FXML
    private CheckBox checkFiltrarNome;
    @FXML
    private ComboBox<String> comboEnd = new ComboBox<>();
    @FXML
    private Label lblRua, lblNum, lblCep, lblCidade, lblBairro, lblPais;

    //private ArrayList<Cliente> listaDeClientes = new ArrayList<Cliente>();
    private ObservableList<Cliente> observableList;
    private ObservableList<Endereco> observableEnd;
    private ClienteDAO bd;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bd = ClienteDAO.getInstance();
        carregarTableViewClientes(bd.getLisdaDeClientes());

        //evento para alterar os detalhes de cada cliente ao selecionar na tabela
        tableViewClientes.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableView(newValue)
        );

        //evento para fitrar nome
        checkFiltrarNome.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if(newValue) {
                    filtrarNomes(textFiltrarNome.getText());
                } else {
                    carregarTableViewClientes(bd.getLisdaDeClientes());
                }
            }
        });

        //evento para selecionar endereço
        comboEnd.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                setEndereco(t1);
            }
        });
    }

    /* Carrega a combobox de endereços com a quantidade de endereços cadastrados */
    private void carregaComboEnd(int qtdEnd) {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < qtdEnd; i++) {
            strings.add("Endereco " + i+1);
        }
        this.comboEnd.getItems().setAll(strings);
        clearEnd();
    }

    private void setEndereco (String e) {
        //recebe o index do endereço a ser mostrado
        //subtrai 48 pois é o valor dos numericos na tabela ASCII
        int index = e.charAt(e.length()-1) - 48;
        setLabelEndereco(observableEnd.get(index - 1));
    }

    private void setLabelEndereco(Endereco e) {
        lblRua.setText(e.getRua());
        lblNum.setText(String.valueOf(e.getNumero()));
        lblBairro.setText(e.getBairro());
        lblCep.setText(e.getCep());
        lblCidade.setText(e.getCidade());
        lblPais.setText(e.getPais());
    }

    private void carregarTableViewClientes(ArrayList<Cliente> lista) {
        System.out.println("carregando table view...");
        tableColumnClientes.setCellValueFactory(new PropertyValueFactory<>("nomeDoCliente"));
        observableList = FXCollections.observableArrayList(lista);
        tableViewClientes.setItems(observableList);
        System.out.println("table view carregada!");
    }

    private void selecionarItemTableView (Cliente c) {
        System.out.println("Cliente selecionado!");
        clearEnd();
        labelClienteCodigo.setText(String.valueOf(c.getCodigoDoCliente()));
        labelClienteNome.setText(c.getNomeDoCliente());
        labelClienteCpf.setText(c.getCPF());
        labelClienteEmail.setText(c.getEmail());
        observableEnd = FXCollections.observableArrayList(c.getEnderecos());
        carregaComboEnd(c.getEnderecos().size());

    }

    private void filtrarNomes(String s) {
        try{
            carregarTableViewClientes(bd.getListaClientePorNome(s));
        } catch (NullPointerException e) {
            System.out.println("Nao possui clientes com esse nome! Ou nome errado!");
        }

    }

    private void clearEnd(){
        lblRua.setText("");
        lblNum.setText("");
        lblBairro.setText("");
        lblCep.setText("");
        lblCidade.setText("");
        lblPais.setText("");
    }
}
