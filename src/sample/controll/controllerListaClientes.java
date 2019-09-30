package sample.controll;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.model.SistemaDAO;
import sample.model.Cliente;

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

    //private ArrayList<Cliente> listaDeClientes = new ArrayList<Cliente>();
    private ObservableList<Cliente> observableList;
    private SistemaDAO bd;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bd = SistemaDAO.getInstance();
        carregarTableViewClientes(bd.getLisdaDeClientes());

        //evento para alterar os detalhes de cada cliente ao selecionar na tabela
        tableViewClientes.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableView(newValue)
        );

        //evento para fitrar nome
        if(checkFiltrarNome.isSelected()) {
            carregarTableViewClientes(bd.buscaCliente(textFiltrarNome.getText()));
        }
    }

//    /* inicia o arraylist de clientes para testar se as outras funções funcionam corretamente */
//    private void cadastraClientes() {
//        this.listaDeClientes.add(new Cliente("vinicius", 1, "112.970.396-70", "viniteixeirap@hotmail.com", "199725"));
//        this.listaDeClientes.add(new Cliente("vitoria", 2, "111.999.396-70", "vitoria@hotmail.com", "199725"));
//        this.listaDeClientes.add(new Cliente("camila", 3, "112.000.333-77", "camila@hotmail.com", "199725"));
//        this.listaDeClientes.add(new Cliente("selina", 4, "110.123.123-12", "selina@hotmail.com", "199725"));
//        System.out.println("clientes cadastrados com sucesso!");
//    }


    public void carregarTableViewClientes(ArrayList<Cliente> lista) {
        System.out.println("carregando table view...");
        tableColumnClientes.setCellValueFactory(new PropertyValueFactory<>("nomeDoCliente"));
        observableList = FXCollections.observableArrayList(lista);
        tableViewClientes.setItems(observableList);
        System.out.println("table view carregada!");
    }

    public void selecionarItemTableView (Cliente c) {
        System.out.println("Cliente selecionado!");
        labelClienteCodigo.setText(String.valueOf(c.getCodigoDoCliente()));
        labelClienteNome.setText(c.getNomeDoCliente());
        labelClienteCpf.setText(c.getCPF());
        labelClienteEmail.setText(c.getEmail());

    }

    public void filtrarNomes() {

    }

//    public void setBd(SistemaDAO bd) {
//        this.bd = bd;
//    }
}
