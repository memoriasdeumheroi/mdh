package br.com.sixtechsolutions.controller;

import br.com.sixtechsolutions.CenaControlada;
import br.com.sixtechsolutions.ControladorDeCenas;
import br.com.sixtechsolutions.Main;
import br.com.sixtechsolutions.model.dao.JogadorDAO;
import br.com.sixtechsolutions.model.database.Database;
import br.com.sixtechsolutions.model.database.DatabaseFactory;
import br.com.sixtechsolutions.model.dominio.Jogador;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EsqueciSenhaController implements Initializable, CenaControlada {

    ControladorDeCenas meuControlador;
    private String login;
    private String sexo;
    private int idPersonagem;
    private boolean confirmaClicksexo;
    private boolean confirmaClickPersonagem;
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final JogadorDAO jogadorDAO = new JogadorDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblEstado.setText("");
    }

    @Override
    public void defineCenaPai(ControladorDeCenas screenParent) {
        meuControlador = screenParent;
    }

    @FXML
    private AnchorPane anchoPane;

    @FXML
    private TextField txtLogin;

    @FXML
    private RadioButton radioButtonMasculino;

    @FXML
    private RadioButton radioButtonFeminino;

    @FXML
    private Label lblAvatar;

    @FXML
    private VBox vbox;

    @FXML
    private HBox hbox;

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
    private Label lblSexo;

    @FXML
    private Button btnVerificar;

    @FXML
    private Button btnVoltar;

    @FXML
    private Label lblEstado;

    @FXML
    void actionBtnBomberman(ActionEvent event
    ) {
        idPersonagem = 1;
        confirmaClickPersonagem = true;
    }

    @FXML
    void actionBtnCrash(ActionEvent event
    ) {
        idPersonagem = 2;
        confirmaClickPersonagem = true;
        System.out.println("id ps" + idPersonagem);
    }

    @FXML
    void actionBtnDonkeyKong(ActionEvent event
    ) {
        idPersonagem = 3;
        confirmaClickPersonagem = true;
    }

    @FXML
    void actionBtnDukeNukem(ActionEvent event
    ) {
        idPersonagem = 4;
        confirmaClickPersonagem = true;
    }

    @FXML
    void actionBtnKratos(ActionEvent event
    ) {
        idPersonagem = 5;
        confirmaClickPersonagem = true;
    }

    @FXML
    void actionBtnLaraCroft(ActionEvent event
    ) {
        idPersonagem = 6;
        confirmaClickPersonagem = true;
    }

    @FXML
    void actionBtnMario(ActionEvent event
    ) {
        idPersonagem = 7;
        confirmaClickPersonagem = true;
    }

    @FXML
    void actionBtnMegaman(ActionEvent event
    ) {
        idPersonagem = 8;
        confirmaClickPersonagem = true;
    }

    @FXML
    void actionBtnPacman(ActionEvent event
    ) {
        idPersonagem = 9;
        confirmaClickPersonagem = true;
    }

    @FXML
    void actionBtnRyu(ActionEvent event
    ) {
        idPersonagem = 10;
        confirmaClickPersonagem = true;
    }

    @FXML
    void actionBtnSonic(ActionEvent event
    ) {
        this.idPersonagem = 11;
        confirmaClickPersonagem = true;
        System.out.println(idPersonagem);
    }

    @FXML
    void actionBtnZelda(ActionEvent event
    ) {
        idPersonagem = 12;
        confirmaClickPersonagem = true;
    }

    @FXML
    void actionBtnVoltar(ActionEvent event) {
        lblEstado.setText("");
        meuControlador.setScreen(Main.cenaLogin);
    }

    @FXML
    void actionBtnVerificar(ActionEvent event
    ) {
        if (txtLogin.getText() == null || txtLogin.getText().length() == 0
                && confirmaClicksexo == false && confirmaClickPersonagem == false) {
            lblEstado.setText("Dados Incorretos!");
        } else {
            jogadorDAO.setConnection(connection);
            Jogador jogador = new Jogador();
            Jogador jogadorEsqueci = new Jogador();
            jogadorEsqueci.setSexo(sexo);
            jogadorEsqueci.setIdPersonagem(idPersonagem);
            jogador = jogadorDAO.buscarDadosDoJogador(txtLogin.getText());
            System.out.println(jogador.getIdPersonagem());
            System.out.println(jogador.getSexo());
            System.out.println(jogador.getSenha());
            if (jogadorEsqueci.getSexo().equals(jogador.getSexo()) && jogadorEsqueci.getIdPersonagem() == jogador.getIdPersonagem()) {
                lblEstado.setText("Sua senha é: " + jogador.getSenha());
            } else {
                lblEstado.setText("Dados Incorretos!");
            }
        }

    }

    @FXML
    void radioActionFeminino(ActionEvent event
    ) {
        radioButtonFeminino.setSelected(true);
        radioButtonMasculino.setSelected(false);
        confirmaClicksexo = true;
        sexo = "F";
    }

    @FXML
    void radioActionMasculino(ActionEvent event
    ) {
        radioButtonMasculino.setSelected(true);
        radioButtonFeminino.setSelected(false);
        confirmaClicksexo = true;
        sexo = "M";
        System.out.println("sexo ps" + sexo);

    }

}
