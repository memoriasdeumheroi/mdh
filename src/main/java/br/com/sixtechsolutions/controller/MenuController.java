package br.com.sixtechsolutions.controller;

import br.com.sixtechsolutions.CenaControlada;
import br.com.sixtechsolutions.ControladorDeCenas;
import br.com.sixtechsolutions.Main;
import br.com.sixtechsolutions.controller.logica.DadosJogador;
import br.com.sixtechsolutions.controller.logica.Personagem;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class MenuController implements Initializable, CenaControlada {

    ControladorDeCenas meuControlador;

    private Personagem personagem = new Personagem();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DadosJogador dados = new DadosJogador();
        atualizarAvatarPerfil(dados.getIdPersonagem());
        lblNomedoPlayer.setText(dados.getNome());
        lblNvDoPlayer.setText(String.valueOf(dados.getNivel()));
        lblExperiencia.setText(String.valueOf(dados.getExperiencia()));
    }

    @Override
    public void defineCenaPai(ControladorDeCenas screenParent) {
        meuControlador = screenParent;
    }

    @FXML
    private AnchorPane anchorPane;

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
    private Label lblNomedoPlayer;

    @FXML
    private Label lblNvDoPlayer;

    @FXML
    private Label lblExperiencia;

    @FXML
    private Label lblLogo;

    @FXML
    private Button btnSair;

    @FXML
    private Label lblEstado;

    @FXML
    void actionBtnConfigs(ActionEvent event) {
        /*
        meuControlador.setScreen(Main.cenaConfiguracoes);
         */
        lblEstado.setVisible(true);
    }

    @FXML
    void actionBtnConquistas(ActionEvent event) {
        /*
        meuControlador.setScreen(Main.cenaConquistas);
         */
        lblEstado.setVisible(true);
    }

    @FXML
    void actionBtnConteudo(ActionEvent event) {
        /*
        meuControlador.setScreen(Main.cenaConteudo);
         */
        lblEstado.setVisible(true);
    }

    @FXML
    void actionBtnJogar(ActionEvent event) {
        meuControlador.loadScreen(Main.cenaDificuldade, Main.cenaDificuldadeLocal);
        meuControlador.setScreen(Main.cenaDificuldade);
        meuControlador.unloadScreen(Main.cenaMenu);
        lblEstado.setVisible(false);
    }

    @FXML
    void actionBtnMelhoresScores(ActionEvent event) {
        meuControlador.loadScreen(Main.cenaRanking, Main.cenaRankingLocal);
        meuControlador.setScreen(Main.cenaRanking);
        meuControlador.unloadScreen(Main.cenaMenu);
    }

    @FXML
    void actionBtnPerfil(ActionEvent event) {

    }

    @FXML
    void actionBtnSobre(ActionEvent event) {
        /*
        meuControlador.setScreen(Main.cenaSobre);
         */
        lblEstado.setVisible(true);
    }

    @FXML
    void actionBtnSair(ActionEvent event) {
        meuControlador.loadScreen(Main.cenaLogin, Main.cenaLoginLocal);
        meuControlador.setScreen(Main.cenaLogin);
        meuControlador.unloadScreen(Main.cenaMenu);
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
            personagem.setPersonagem("bomberman");
        } else if (id == 2) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-crash");
            personagem.setPersonagem("crash");
        } else if (id == 3) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-donkeykong");
            personagem.setPersonagem("donkeykong");
        } else if (id == 4) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-dukenukem");
            personagem.setPersonagem("dukenukem");
        } else if (id == 5) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-kratos");
            personagem.setPersonagem("kratos");
        } else if (id == 6) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-laracroft");
            personagem.setPersonagem("laracroft");
        } else if (id == 7) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-mario");
            personagem.setPersonagem("mario");
        } else if (id == 8) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-megaman");
            personagem.setPersonagem("megaman");
        } else if (id == 9) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-pacman");
            personagem.setPersonagem("pacman");
        } else if (id == 10) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-ryu");
            personagem.setPersonagem("ryu");
        } else if (id == 11) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-sonic");
            personagem.setPersonagem("sonic");
        } else if (id == 12) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-zelda");
            personagem.setPersonagem("zelda");
        }
    }
}
