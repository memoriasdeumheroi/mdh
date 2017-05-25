package br.com.sixtechsolutions.controller;

import br.com.sixtechsolutions.CenaControlada;
import br.com.sixtechsolutions.ControladorDeCenas;
import br.com.sixtechsolutions.Main;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class ConquistasController implements Initializable, CenaControlada {

    ControladorDeCenas meuControlador;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @Override
    public void defineCenaPai(ControladorDeCenas screenParent) {
        meuControlador = screenParent;
    }

    @FXML
    private Pane pane;

    @FXML
    private Button btnPerfil;

    @FXML
    private Button btnMenu;

    @FXML
    private Button btnJogar;

    @FXML
    private Button btnConquistas;

    @FXML
    private Button btnConteudo;

    @FXML
    private Button btnMelhoresScores;

    @FXML
    private Button btnConfigs;

    @FXML
    private Button btnSobre;

    @FXML
    private Button btnGitHub;

    @FXML
    private Label lblNomedoPlayer;

    @FXML
    private Label lblNvDoPlayer;

    @FXML
    private Label lblExperiencia;

    @FXML
    void actionBtnConfigs(ActionEvent event) {
        meuControlador.setScreen(Main.cenaConfiguracoes);
    }

    @FXML
    void actionBtnConteudo(ActionEvent event) {
        meuControlador.setScreen(Main.cenaConteudo);
    }

    @FXML
    void actionBtnJogar(ActionEvent event) {
        meuControlador.setScreen(Main.cenaDificuldade);
    }

    @FXML
    void actionBtnMelhoresScores(ActionEvent event) {
        meuControlador.setScreen(Main.cenaRanking);
    }

    @FXML
    void actionBtnPerfil(ActionEvent event) {

    }

    @FXML
    void actionBtnMenu(ActionEvent event) {
        meuControlador.setScreen(Main.cenaMenu);
    }

    @FXML
    void actionBtnSobre(ActionEvent event) {
        meuControlador.setScreen(Main.cenaSobre);
    }

    @FXML
    void actionBtnGitHub(ActionEvent event) {
        if (Desktop.isDesktopSupported()) {
            new Thread(() -> {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/memoriasdeumheroi/mdh"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }).start();
        }
    }

    public void atualizarAvatarPerfil(int id) {
        if (id == 1) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-bomberman");
        } else if (id == 2) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-crash");
        } else if (id == 3) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-donkeykong");
        } else if (id == 4) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-dukenukem");
        } else if (id == 5) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-kratos");
        } else if (id == 6) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-laracroft");
        } else if (id == 7) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-mario");
        } else if (id == 8) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-megaman");
        } else if (id == 9) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-pacman");
        } else if (id == 10) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-ryu");
        } else if (id == 11) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-sonic");
        } else if (id == 12) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-zelda");
        }
    }

}
