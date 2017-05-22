package br.com.sixtechsolutions.controller;

import br.com.sixtechsolutions.CenaControlada;
import br.com.sixtechsolutions.ControladorDeCenas;
import br.com.sixtechsolutions.Main;
import br.com.sixtechsolutions.controller.logica.Personagem;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class PersonagemController implements Initializable, CenaControlada {

    ControladorDeCenas meuControlador;

    @FXML
    AnchorPane anchorPane;

    @FXML
    Button btnVoltar;

    Personagem personagem = new Personagem();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @Override
    public void defineCenaPai(ControladorDeCenas screenParent) {
        meuControlador = screenParent;
    }

    @FXML
    public void btnVoltarAoInicio(ActionEvent event) throws IOException {
        meuControlador.setScreen(Main.cenaLogin);
    }

}
