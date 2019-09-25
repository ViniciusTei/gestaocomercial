package sample.controll;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private AnchorPane anchorPanePrincipal;

    private AnchorPane oldAnchorPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //todo
    }

    @FXML
    public void handleBtnListarCliente () throws IOException {
        AnchorPane newAnchorPane = (AnchorPane) FXMLLoader.load(getClass().getResource("/sample/view/viewListaClientes.fxml"));
        this.oldAnchorPane = this.anchorPanePrincipal;
        this.anchorPanePrincipal.getChildren().setAll(newAnchorPane);
    }

    @FXML
    public void handleMenuListarCliente () throws IOException {
        AnchorPane newAnchorPane = (AnchorPane) FXMLLoader.load(getClass().getResource("/sample/view/viewListaClientes.fxml"));
        this.oldAnchorPane = this.anchorPanePrincipal;
        this.anchorPanePrincipal.getChildren().setAll(newAnchorPane);
    }

    @FXML
    public void handleMenuVoltar () throws IOException {
        this.anchorPanePrincipal.getChildren().setAll(this.oldAnchorPane);
    }
}
