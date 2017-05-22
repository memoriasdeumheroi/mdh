package br.com.sixtechsolutions.controller;

import br.com.sixtechsolutions.CenaControlada;
import br.com.sixtechsolutions.ControladorDeCenas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class VersusController implements Initializable, CenaControlada {

    ControladorDeCenas meuControlador;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    public void defineCenaPai(ControladorDeCenas screenParent) {
        meuControlador = screenParent;
    }

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label lblPersonagem1;

    @FXML
    private Label lblPersonagem2;

    public void defineLabelPersonagem() {

    }

}
