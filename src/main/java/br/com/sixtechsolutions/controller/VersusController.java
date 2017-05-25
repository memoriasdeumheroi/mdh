package br.com.sixtechsolutions.controller;

import br.com.sixtechsolutions.CenaControlada;
import br.com.sixtechsolutions.ControladorDeCenas;
import br.com.sixtechsolutions.Main;
import br.com.sixtechsolutions.controller.logica.Personagem;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class VersusController implements Initializable, CenaControlada {

    ControladorDeCenas meuControlador;
    private int contadorSegundos = 0;
    Timer timer;
    TimerTask task;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Personagem personagem = new Personagem();
        lblPersonagemVersus1.getStyleClass().set(1, "lbl-versus-" + personagem.getPersonagem());
        lblPersonagemVersus2.getStyleClass().set(1, "lbl-versus-" + personagem.getPersonagemRival());
        irParaJogada();
        iniciarTempoParaIrParaJogada();
    }

    @Override
    public void defineCenaPai(ControladorDeCenas screenParent) {
        meuControlador = screenParent;
    }

    @FXML
    private AnchorPane anchorPane;

    @FXML
    public Label lblPersonagemVersus1;

    @FXML
    public Label lblPersonagemVersus2;

    public void irParaJogada() {
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                if (contadorSegundos < 6) {
                    contadorSegundos++;
                    System.out.println("segundo = " + contadorSegundos);
                } else {
                    meuControlador.loadScreen(Main.cenaJogada, Main.cenaJogadaLocal);
                    meuControlador.setScreen(Main.cenaJogada);
                    System.out.println("Terminaou tempo!");
                    timer.cancel();
                }
            }
        };
    }

    public void iniciarTempoParaIrParaJogada() {
        timer.scheduleAtFixedRate(task, 1, 1000);
    }

}
