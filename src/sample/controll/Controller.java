package sample.controll;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import sample.model.ClienteDAO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private AnchorPane anchorPanePrincipal;

    private ClienteDAO bd = ClienteDAO.getInstance();

    FXMLLoader loader = new FXMLLoader();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(bd.getLisdaDeClientes().get(0).getNomeDoCliente());
    }

    @FXML
    public void handleBtnListarCliente () throws IOException {
        loader = new FXMLLoader(getClass().getResource("/sample/view/viewListaClientes.fxml"));
        AnchorPane newAnchorPane = (AnchorPane) loader.load();
        this.anchorPanePrincipal.getChildren().setAll(newAnchorPane);
    }

    @FXML
    public void handleMenuListarCliente () throws IOException {
        AnchorPane newAnchorPane = (AnchorPane) loader.load(getClass().getResource("/sample/view/viewListaClientes.fxml"));
        this.anchorPanePrincipal.getChildren().setAll(newAnchorPane);

    }

    @FXML
    public void handleBtnCadastrarCliente () throws IOException {
        AnchorPane newAnchorPane = (AnchorPane) loader.load(getClass().getResource("/sample/view/viewCadastroCliente.fxml"));
        this.anchorPanePrincipal.getChildren().setAll(newAnchorPane);
    }

    @FXML
    public void handleMenuCadastrarCliente() throws IOException {
        AnchorPane newAnchorPane = (AnchorPane) loader.load(getClass().getResource("/sample/view/viewCadastroCliente.fxml"));
        this.anchorPanePrincipal.getChildren().setAll(newAnchorPane);
    }
    @FXML
    public void handleBtnAlterarCliente () throws IOException {
        AnchorPane newAnchorPane = (AnchorPane) loader.load(getClass().getResource("/sample/view/ViewAlterarCliente.fxml"));
        this.anchorPanePrincipal.getChildren().setAll(newAnchorPane);
    }

    @FXML
    public void handleMenuAlterarCliente() throws IOException {
        AnchorPane newAnchorPane = (AnchorPane) loader.load(getClass().getResource("/sample/view/ViewAlterarCliente.fxml"));
        this.anchorPanePrincipal.getChildren().setAll(newAnchorPane);
    }
    //    @FXML
//    public void handleMenuVoltar () throws IOException {
//        this.anchorPanePrincipal.getChildren().setAll(this.oldAnchorPane);
//    }

}
