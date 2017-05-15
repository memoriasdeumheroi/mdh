package br.com.sixtechsolutions.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AlertController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button btnOk;

    @FXML
    private Label txtMensagemErro;

    @FXML
    private void btnOk(ActionEvent event) throws Throwable {
        this.finalize();
    }

    public void setErro(String erro) throws IOException {
        txtMensagemErro.setText(erro);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(AlertController.class.getResource("/fxml/GUI_Alert.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Dados incorretos");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();
    }

}
