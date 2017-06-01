package br.com.sixtechsolutions.controller;

import br.com.sixtechsolutions.CenaControlada;
import br.com.sixtechsolutions.ControladorDeCenas;
import br.com.sixtechsolutions.Main;
import br.com.sixtechsolutions.controller.logica.DadosJogador;
import br.com.sixtechsolutions.controller.logica.Personagem;
import br.com.sixtechsolutions.controller.logica.Regras;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class JogadaController extends Regras implements Initializable, CenaControlada {

    ControladorDeCenas meuControlador;
    DadosJogador dados = new DadosJogador();
    Timer timer;
    TimerTask task;
    Button[] listabtn = new Button[12];

    @Override
    public void defineCenaPai(ControladorDeCenas screenParent) {
        meuControlador = screenParent;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listabtn[0] = btnA1;
        listabtn[1] = btnA2;
        listabtn[2] = btnA3;
        listabtn[3] = btnA4;
        listabtn[4] = btnA5;
        listabtn[5] = btnA6;
        listabtn[6] = btnA7;
        listabtn[7] = btnA8;
        listabtn[8] = btnA9;
        listabtn[9] = btnA10;
        listabtn[10] = btnA11;
        listabtn[11] = btnA12;
        btnIniciar.setVisible(true);
        atualizarAvatarPerfil(dados.getIdPersonagem());
        atualizarAvatarRival();
        lblNomeJogador1.setText(dados.getNome());
    }

    @FXML
    public Button btnA1;
    @FXML
    public Button btnA2;
    @FXML
    public Button btnA3;
    @FXML
    public Button btnA4;
    @FXML
    public Button btnA5;
    @FXML
    public Button btnA6;
    @FXML
    public Button btnA7;
    @FXML
    public Button btnA8;
    @FXML
    public Button btnA9;
    @FXML
    public Button btnA10;
    @FXML
    public Button btnA11;
    @FXML
    public Button btnA12;
    @FXML
    public Button btnIniciar;
    @FXML
    public ProgressBar barraVida;
    @FXML
    public ProgressBar barraEstamina;
    @FXML
    public Label lblPontuacao;
    @FXML
    public Label exibePontuacao;
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
    private Label lblAvatarJogador1;

    @FXML
    private Label lblAvatarJogador2;

    @FXML
    private Label lblNomeJogador1;

    @FXML
    private Label lblNomeRival;

    @FXML
    void actionBtnPerfil(ActionEvent event) {

    }

    @FXML
    void actionBtnConfigs(ActionEvent event) {
        meuControlador.setScreen(Main.cenaConfiguracoes);
    }

    @FXML
    void actionBtnConquistas(ActionEvent event) {
        meuControlador.setScreen(Main.cenaConquistas);
    }

    @FXML
    void actionBtnConteudo(ActionEvent event) {
        meuControlador.setScreen(Main.cenaConteudo);
    }

    @FXML
    void actionBtnMenu(ActionEvent event) {
        meuControlador.setScreen(Main.cenaMenu);
    }

    @FXML
    void actionBtnMelhoresScores(ActionEvent event) {
        meuControlador.setScreen(Main.cenaRanking);
    }

    @FXML
    void actionBtnSobre(ActionEvent event) {
        meuControlador.setScreen(Main.cenaSobre);
    }

    public void btnA1Action(ActionEvent event) {
        cliclouBotao(listabtn, btnA1, exibePontuacao, 0);
        verificaJogada(listabtn, meuControlador);
    }

    @FXML
    public void btnA2Action(ActionEvent event) {
        cliclouBotao(listabtn, btnA2, exibePontuacao, 1);
        verificaJogada(listabtn, meuControlador);
    }

    @FXML
    public void btnA3Action(ActionEvent event) {
        cliclouBotao(listabtn, btnA3, exibePontuacao, 2);
        verificaJogada(listabtn, meuControlador);
    }

    @FXML
    public void btnA4Action(ActionEvent event) {
        cliclouBotao(listabtn, btnA4, exibePontuacao, 3);
        verificaJogada(listabtn, meuControlador);
    }

    @FXML
    public void btnA5Action(ActionEvent event) {
        cliclouBotao(listabtn, btnA5, exibePontuacao, 4);
        verificaJogada(listabtn, meuControlador);
    }

    @FXML
    public void btnA6Action(ActionEvent event) {
        cliclouBotao(listabtn, btnA6, exibePontuacao, 5);
        verificaJogada(listabtn, meuControlador);
    }

    @FXML
    public void btnA7Action(ActionEvent event) {
        cliclouBotao(listabtn, btnA7, exibePontuacao, 6);
        verificaJogada(listabtn, meuControlador);
    }

    @FXML
    public void btnA8Action(ActionEvent event) {
        cliclouBotao(listabtn, btnA8, exibePontuacao, 7);
        verificaJogada(listabtn, meuControlador);
    }

    @FXML
    public void btnA9Action(ActionEvent event) {
        cliclouBotao(listabtn, btnA9, exibePontuacao, 8);
        verificaJogada(listabtn, meuControlador);
    }

    @FXML
    public void btnA10Action(ActionEvent event) {
        cliclouBotao(listabtn, btnA10, exibePontuacao, 9);
        verificaJogada(listabtn, meuControlador);
    }

    @FXML
    public void btnA11Action(ActionEvent event) {
        cliclouBotao(listabtn, btnA11, exibePontuacao, 10);
        verificaJogada(listabtn, meuControlador);
    }

    @FXML
    public void btnA12Action(ActionEvent event) {
        cliclouBotao(listabtn, btnA12, exibePontuacao, 11);
        verificaJogada(listabtn, meuControlador);
    }

    @FXML
    public void btnAction(ActionEvent event) {
        iniciaJogo(listabtn);
        btnIniciar.setVisible(false);
    }

    public void atualizarAvatarPerfil(int id) {
        if (id == 1) {
            lblAvatarJogador1.getStyleClass().set(1, "btn-avatar-bomberman");
            personagem.setPersonagem("bomberman");
        } else if (id == 2) {
            lblAvatarJogador1.getStyleClass().set(1, "btn-avatar-crash");
            personagem.setPersonagem("crash");
        } else if (id == 3) {
            lblAvatarJogador1.getStyleClass().set(1, "btn-avatar-donkeykong");
            personagem.setPersonagem("donkeykong");
        } else if (id == 4) {
            lblAvatarJogador1.getStyleClass().set(1, "btn-avatar-dukenukem");
            personagem.setPersonagem("dukenukem");
        } else if (id == 5) {
            lblAvatarJogador1.getStyleClass().set(1, "btn-avatar-kratos");
            personagem.setPersonagem("kratos");
        } else if (id == 6) {
            lblAvatarJogador1.getStyleClass().set(1, "btn-avatar-laracroft");
            personagem.setPersonagem("laracroft");
        } else if (id == 7) {
            lblAvatarJogador1.getStyleClass().set(1, "btn-avatar-mario");
            personagem.setPersonagem("mario");
        } else if (id == 8) {
            lblAvatarJogador1.getStyleClass().set(1, "btn-avatar-megaman");
            personagem.setPersonagem("megaman");
        } else if (id == 9) {
            lblAvatarJogador1.getStyleClass().set(1, "btn-avatar-pacman");
            personagem.setPersonagem("pacman");
        } else if (id == 10) {
            lblAvatarJogador1.getStyleClass().set(1, "btn-avatar-ryu");
            personagem.setPersonagem("ryu");
        } else if (id == 11) {
            lblAvatarJogador1.getStyleClass().set(1, "btn-avatar-sonic");
            personagem.setPersonagem("sonic");
        } else if (id == 12) {
            lblAvatarJogador1.getStyleClass().set(1, "btn-avatar-zelda");
            personagem.setPersonagem("zelda");
        }
    }

    public void atualizarAvatarRival() {
        if (Personagem.personagemRival == "bomberman") {
            lblAvatarJogador2.getStyleClass().set(1, "btn-avatar-bomberman");
            lblNomeRival.setText("Thorin");
        } else if (Personagem.personagemRival == "crash") {
            lblAvatarJogador2.getStyleClass().set(1, "btn-avatar-crash");
            lblNomeRival.setText("Bifur");
        } else if (Personagem.personagemRival == "donkeykong") {
            lblAvatarJogador2.getStyleClass().set(1, "btn-avatar-donkeykong");
            lblNomeRival.setText("Bombur");
        } else if (Personagem.personagemRival == "dukenukem") {
            lblAvatarJogador2.getStyleClass().set(1, "btn-avatar-dukenukem");
            lblNomeRival.setText("Borin");
        } else if (Personagem.personagemRival == "kratos") {
            lblAvatarJogador2.getStyleClass().set(1, "btn-avatar-kratos");
            lblNomeRival.setText("Durin");
        } else if (Personagem.personagemRival == "laracroft") {
            lblAvatarJogador2.getStyleClass().set(1, "btn-avatar-laracroft");
            lblNomeRival.setText("Gróin");
        } else if (Personagem.personagemRival == "mario") {
            lblAvatarJogador2.getStyleClass().set(1, "btn-avatar-mario");
            lblNomeRival.setText("Glóin");
        } else if (Personagem.personagemRival == "megaman") {
            lblAvatarJogador2.getStyleClass().set(1, "btn-avatar-megaman");
            lblNomeRival.setText("Óin");
        } else if (Personagem.personagemRival == "pacman") {
            lblAvatarJogador2.getStyleClass().set(1, "btn-avatar-pacman");
            lblNomeRival.setText("Ori");
        } else if (Personagem.personagemRival == "ryu") {
            lblAvatarJogador2.getStyleClass().set(1, "btn-avatar-ryu");
            lblNomeRival.setText("Balin");
        } else if (Personagem.personagemRival == "sonic") {
            lblAvatarJogador2.getStyleClass().set(1, "btn-avatar-sonic");
            lblNomeRival.setText("Balin");
        } else if (Personagem.personagemRival == "zelda") {
            lblAvatarJogador2.getStyleClass().set(1, "btn-avatar-zelda");
            lblNomeRival.setText("Borin");
        }

    }
}
