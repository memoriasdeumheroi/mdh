package br.com.sixtechsolutions.controller;

import br.com.sixtechsolutions.CenaControlada;
import br.com.sixtechsolutions.ControladorDeCenas;
import br.com.sixtechsolutions.Main;
import br.com.sixtechsolutions.controller.logica.Dificuldade;
import br.com.sixtechsolutions.controller.logica.Personagem;
import br.com.sixtechsolutions.controller.logica.Resultado;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class DificuldadeController implements Initializable, CenaControlada {

    ControladorDeCenas meuControlador;
    Personagem personagem = new Personagem();
    Dificuldade dificuldade = new Dificuldade();
    Resultado resultado = new Resultado();
    private boolean personagemSelecionado;
    private boolean dificuldadeSelecionado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pegaPersonagemPrincipal();
        bloqueiaBtnPersonagem();
    }

    @Override
    public void defineCenaPai(ControladorDeCenas screenParent) {
        meuControlador = screenParent;
    }

    @FXML
    private ProgressBar progressBarAtaque1;

    @FXML
    private ProgressBar progressBarDefesa1;

    @FXML
    private ProgressBar progressBarAgilidade1;

    @FXML
    private ProgressBar progressBarAtaque2;

    @FXML
    private ProgressBar progressBarDefesa2;

    @FXML
    private ProgressBar progressBarAgilidade2;

    @FXML
    private Label lblAtaquePersonagem1;

    @FXML
    private Label lblDefesaPersonagem1;

    @FXML
    private Label lblDificuldade;

    @FXML
    private Label lblPersonagem1;

    @FXML
    private Label lblAgilidadePersonagem1;

    @FXML
    private Label lblPersonagem2;

    @FXML
    private Label lblAtaquePersonagem2;

    @FXML
    private Label lblDefesaPersonagem2;

    @FXML
    private Label lblAgilidadePersonagem2;

    @FXML
    private Button btnFacil;

    @FXML
    private Button btnNormal;

    @FXML
    private Button btnDificil;

    @FXML
    private Button btnHeroi;

    @FXML
    private Button btnCrash;

    @FXML
    private Button btnDonkeyKong;

    @FXML
    private Button btnDukeNukem;

    @FXML
    private Button btnMegaman;

    @FXML
    private Button btnKratos;

    @FXML
    private Button btnMario;

    @FXML
    private Button btnLaraCroft;

    @FXML
    private Button btnPacman;

    @FXML
    private Button btnRyu;

    @FXML
    private Button btnSonic;

    @FXML
    private Button btnZelda;

    @FXML
    private Button btnBomberman;

    @FXML
    private Button btnAleatorio;

    @FXML
    private Button btnJogar;

    @FXML
    void actionBtnFacil(ActionEvent event) {
        dificuldadeSelecionado = true;
        dificuldade.setTempoExibicao(6);
    }

    @FXML
    void actionBtnNormal(ActionEvent event) {
        dificuldadeSelecionado = true;
        dificuldade.setTempoExibicao(5);
    }

    @FXML
    void actionBtnDificil(ActionEvent event) {
        dificuldadeSelecionado = true;
        dificuldade.setTempoExibicao(3.5f);
    }

    @FXML
    void actionBtnHeroi(ActionEvent event) {
        dificuldadeSelecionado = true;
        dificuldade.setTempoExibicao(3);
    }

    @FXML
    void actionBtnJogar(ActionEvent event) {
        if (dificuldadeSelecionado == true && personagemSelecionado == true) {
            meuControlador.loadScreen(Main.cenaVersus, Main.cenaVersusLocal);
            meuControlador.setScreen(Main.cenaVersus);
            meuControlador.unloadScreen(Main.cenaDificuldade);
        }
    }

    @FXML
    void actionBtnAleatorio(ActionEvent event) {

    }

    @FXML
    void actionBtnBomberman(ActionEvent event) {
        personagem.setPersonagemRival("bomberman");
        lblPersonagem2.getStyleClass().set(1, "lbl-personagem-bomberman");
        personagemSelecionado = true;
        progressBarAtaque2.setProgress(0.8);
        progressBarDefesa2.setProgress(0.2);
        progressBarAgilidade2.setProgress(0.4);
    }

    @FXML
    void actionBtnCrash(ActionEvent event) {
        personagem.setPersonagemRival("crash");
        lblPersonagem2.getStyleClass().set(1, "lbl-personagem-crash");
        personagemSelecionado = true;
        progressBarAtaque2.setProgress(0.6);
        progressBarDefesa2.setProgress(0.6);
        progressBarAgilidade2.setProgress(0.3);
    }

    @FXML
    void actionBtnDonkeyKong(ActionEvent event) {
        personagem.setPersonagemRival("donkeykong");
        lblPersonagem2.getStyleClass().set(1, "lbl-personagem-donkeykong");
        personagemSelecionado = true;
        progressBarAtaque2.setProgress(0.9);
        progressBarDefesa2.setProgress(0.4);
        progressBarAgilidade2.setProgress(0.2);
    }

    @FXML
    void actionBtnDukeNukem(ActionEvent event) {
        personagem.setPersonagemRival("dukenukem");
        lblPersonagem2.getStyleClass().set(1, "lbl-personagem-dukenukem");
        personagemSelecionado = true;
        progressBarAtaque2.setProgress(0.85);
        progressBarDefesa2.setProgress(0.55);
        progressBarAgilidade2.setProgress(0.33);
    }

    @FXML
    void actionBtnKratos(ActionEvent event) {
        personagem.setPersonagemRival("kratos");
        lblPersonagem2.getStyleClass().set(1, "lbl-personagem-kratos");
        personagemSelecionado = true;
        progressBarAtaque2.setProgress(0.89);
        progressBarDefesa2.setProgress(0.77);
        progressBarAgilidade2.setProgress(0.66);
    }

    @FXML
    void actionBtnLaraCroft(ActionEvent event) {
        personagem.setPersonagemRival("laracroft");
        lblPersonagem2.getStyleClass().set(1, "lbl-personagem-laracroft");
        personagemSelecionado = true;
        progressBarAtaque2.setProgress(0.81);
        progressBarDefesa2.setProgress(0.44);
        progressBarAgilidade2.setProgress(0.75);
    }

    @FXML
    void actionBtnMario(ActionEvent event) {
        personagem.setPersonagemRival("mario");
        lblPersonagem2.getStyleClass().set(1, "lbl-personagem-mario");
        personagemSelecionado = true;
        progressBarAtaque2.setProgress(0.70);
        progressBarDefesa2.setProgress(0.20);
        progressBarAgilidade2.setProgress(0.86);
    }

    @FXML
    void actionBtnMegaman(ActionEvent event) {
        personagem.setPersonagemRival("megaman");
        lblPersonagem2.getStyleClass().set(1, "lbl-personagem-megaman");
        personagemSelecionado = true;
        progressBarAtaque2.setProgress(0.74);
        progressBarDefesa2.setProgress(0.33);
        progressBarAgilidade2.setProgress(0.98);
    }

    @FXML
    void actionBtnPacman(ActionEvent event) {
        personagem.setPersonagemRival("pacman");
        lblPersonagem2.getStyleClass().set(1, "lbl-personagem-pacman");
        personagemSelecionado = true;
        progressBarAtaque2.setProgress(0.60);
        progressBarDefesa2.setProgress(0.07);
        progressBarAgilidade2.setProgress(0.94);
    }

    @FXML
    void actionBtnRyu(ActionEvent event) {
        personagem.setPersonagemRival("ryu");
        lblPersonagem2.getStyleClass().set(1, "lbl-personagem-ryu");
        personagemSelecionado = true;
        progressBarAtaque2.setProgress(0.84);
        progressBarDefesa2.setProgress(0.75);
        progressBarAgilidade2.setProgress(0.70);
    }

    @FXML
    void actionBtnSonic(ActionEvent event) {
        personagem.setPersonagemRival("sonic");
        lblPersonagem2.getStyleClass().set(1, "lbl-personagem-sonic");
        personagemSelecionado = true;
        progressBarAtaque2.setProgress(0.39);
        progressBarDefesa2.setProgress(0.33);
        progressBarAgilidade2.setProgress(0.99);
    }

    @FXML
    void actionBtnZelda(ActionEvent event) {
        personagem.setPersonagemRival("zelda");
        lblPersonagem2.getStyleClass().set(1, "lbl-personagem-zelda");
        personagemSelecionado = true;
        progressBarAtaque2.setProgress(0.75);
        progressBarDefesa2.setProgress(0.69);
        progressBarAgilidade2.setProgress(0.74);
    }

    public void pegaPersonagemPrincipal() {
        lblPersonagem1.getStyleClass().set(1, "lbl-personagem-" + personagem.getPersonagem());
        System.out.println();
        System.out.println("funcionou");
    }

    public void selecionaBtn(Button clicado, String nome) {
        btnBomberman.getStyleClass().set(1, "btn-avatar-bomberman");
        btnCrash.getStyleClass().set(1, "btn-avatar-crash");
        btnDonkeyKong.getStyleClass().set(1, "btn-avatar-donkeykong");
        btnDukeNukem.getStyleClass().set(1, "btn-avatar-dukenukem");
        btnKratos.getStyleClass().set(1, "btn-avatar-kratos");
        btnLaraCroft.getStyleClass().set(1, "btn-avatar-laracroft");
        btnMario.getStyleClass().set(1, "btn-avatar-mario");
        btnMegaman.getStyleClass().set(1, "btn-avatar-megaman");
        btnPacman.getStyleClass().set(1, "btn-avatar-pacman");
        btnRyu.getStyleClass().set(1, "btn-avatar-ryu");
        btnSonic.getStyleClass().set(1, "btn-avatar-sonic");
        btnZelda.getStyleClass().set(1, "btn-avatar-zelda");
        clicado.getStyleClass().set(1, "btn-avatar-selecionado-" + nome);
    }

    public void bloqueiaBtnPersonagem() {
        if (null != personagem.getPersonagem()) {
            switch (personagem.getPersonagem()) {
                case "bomberman":
                    btnBomberman.getStyleClass().set(1, "btn-avatar-selecionado-bomberman");
                    progressBarAtaque1.setProgress(0.8);
                    progressBarDefesa1.setProgress(0.2);
                    progressBarAgilidade1.setProgress(0.4);
                    btnBomberman.setDisable(true);
                    break;
                case "crash":
                    btnCrash.getStyleClass().set(1, "btn-avatar-selecionado-crash");
                    progressBarAtaque1.setProgress(0.6);
                    progressBarDefesa1.setProgress(0.6);
                    progressBarAgilidade1.setProgress(0.3);
                    btnCrash.setDisable(true);
                    break;
                case "donkeykong":
                    btnDonkeyKong.getStyleClass().set(1, "btn-avatar-selecionado-donkeykong");
                    progressBarAtaque1.setProgress(0.9);
                    progressBarDefesa1.setProgress(0.4);
                    progressBarAgilidade1.setProgress(0.2);
                    btnDonkeyKong.setDisable(true);
                    break;
                case "dukenukem":
                    btnDukeNukem.getStyleClass().set(1, "btn-avatar-selecionado-dukenukem");
                    progressBarAtaque1.setProgress(0.85);
                    progressBarDefesa1.setProgress(0.55);
                    progressBarAgilidade1.setProgress(0.33);
                    btnDukeNukem.setDisable(true);
                    break;
                case "kratos":
                    btnKratos.getStyleClass().set(1, "btn-avatar-selecionado-kratos");
                    progressBarAtaque1.setProgress(0.89);
                    progressBarDefesa1.setProgress(0.77);
                    progressBarAgilidade1.setProgress(0.66);
                    btnKratos.setDisable(true);
                    break;
                case "laracroft":
                    btnLaraCroft.getStyleClass().set(1, "btn-avatar-selecionado-laracroft");
                    progressBarAtaque1.setProgress(0.81);
                    progressBarDefesa1.setProgress(0.44);
                    progressBarAgilidade1.setProgress(0.75);
                    btnLaraCroft.setDisable(true);
                    break;
                case "mario":
                    btnMario.getStyleClass().set(1, "btn-avatar-selecionado-mario");
                    progressBarAtaque1.setProgress(0.70);
                    progressBarDefesa1.setProgress(0.20);
                    progressBarAgilidade1.setProgress(0.86);
                    btnMario.setDisable(true);
                    break;
                case "megaman":
                    btnMegaman.getStyleClass().set(1, "btn-avatar-selecionado-megaman");
                    progressBarAtaque1.setProgress(0.74);
                    progressBarDefesa1.setProgress(0.33);
                    progressBarAgilidade1.setProgress(0.98);
                    btnMegaman.setDisable(true);
                    break;
                case "pacman":
                    btnPacman.getStyleClass().set(1, "btn-avatar-selecionado-pacman");
                    progressBarAtaque1.setProgress(0.60);
                    progressBarDefesa1.setProgress(0.07);
                    progressBarAgilidade1.setProgress(0.94);
                    btnPacman.setDisable(true);
                    break;
                case "ryu":
                    btnRyu.getStyleClass().set(1, "btn-avatar-selecionado-ryu");
                    progressBarAtaque1.setProgress(0.84);
                    progressBarDefesa1.setProgress(0.75);
                    progressBarAgilidade1.setProgress(0.70);
                    btnRyu.setDisable(true);
                    break;
                case "sonic":
                    btnSonic.getStyleClass().set(1, "btn-avatar-selecionado-sonic");
                    progressBarAtaque1.setProgress(0.39);
                    progressBarDefesa1.setProgress(0.33);
                    progressBarAgilidade1.setProgress(0.99);
                    btnSonic.setDisable(true);
                    break;
                case "zelda":
                    btnZelda.getStyleClass().set(1, "btn-avatar-selecionado-zelda");
                    progressBarAtaque1.setProgress(0.75);
                    progressBarDefesa1.setProgress(0.69);
                    progressBarAgilidade1.setProgress(0.74);
                    btnZelda.setDisable(true);
                    break;
                default:
                    break;
            }
        }
    }
}
