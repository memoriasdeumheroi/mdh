package br.com.sixtechsolutions.controller;

import br.com.sixtechsolutions.CenaControlada;
import br.com.sixtechsolutions.ControladorDeCenas;
import br.com.sixtechsolutions.Main;
import br.com.sixtechsolutions.model.dao.JogadorDAO;
import br.com.sixtechsolutions.model.database.Database;
import br.com.sixtechsolutions.model.database.DatabaseFactory;
import br.com.sixtechsolutions.model.dominio.Jogador;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CadastrarController implements Initializable, CenaControlada {

    ControladorDeCenas meuControlador;
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final JogadorDAO jogadorDAO = new JogadorDAO();
    private boolean confirmaClicksexo = false;
    private boolean confirmaClickpersonagem = false;
    private Jogador referencia;
    private String menssagemErro;
    private String sexo;
    private int idPersonagem;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        visualizarDadosPersonagem(false);
        jogadorDAO.setConnection(connection);
    }

    @Override
    public void defineCenaPai(ControladorDeCenas screenParent) {
        meuControlador = screenParent;
    }

    @FXML
    private AnchorPane pane;

    @FXML
    private VBox vbox;

    @FXML
    private HBox hbox;

    @FXML
    private Button btnBomberman;

    @FXML
    private Button btnCrash;

    @FXML
    private Button btnDonkeyKong;

    @FXML
    private Button btnDukeNukem;

    @FXML
    private Button btnKratos;

    @FXML
    private Button btnLaraCroft;

    @FXML
    private Button btnMegaman;

    @FXML
    private Button btnMario;

    @FXML
    private Button btnPacman;

    @FXML
    private Button btnRyu;

    @FXML
    private Button btnSonic;

    @FXML
    private Button btnZelda;

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField passwordSenha;

    @FXML
    private PasswordField passwordConfirma;

    @FXML
    private Button btnCadastro;

    @FXML
    private RadioButton radioButtonMasculino;

    @FXML
    private RadioButton radioButtonFeminino;

    @FXML
    private Label lblAvatar;

    @FXML
    private Button btnVoltar;

    @FXML
    private Label lblConfirmaNome;

    @FXML
    private Label lblConfirmaLogin;

    @FXML
    private Label lblConfirmaSenha1;

    @FXML
    private Label lblConfirmaSenha2;

    @FXML
    private TextField txtNome;

    @FXML
    private Label lblConfirmaSexo;

    @FXML
    private Label lblConfirmaPersonagem;

    @FXML
    private Label lblPersonagem;

    @FXML
    private Label lblNomePersonagem;

    @FXML
    private Label lblAtaquePersonagem;

    @FXML
    private Label lblDefesaPersonagem;

    @FXML
    private Label lblAgilidadePersonagem;

    @FXML
    private ProgressBar progressBarAtaque;

    @FXML
    private ProgressBar progressBarDefesa;

    @FXML
    private ProgressBar progressBarAgilidade;

    @FXML
    public void actionBtnVoltar(ActionEvent event) {
        lblConfirmaNome.getStyleClass().set(1, "lbl-nulo");
        lblConfirmaLogin.getStyleClass().set(1, "lbl-nulo");
        lblConfirmaSenha1.getStyleClass().set(1, "lbl-nulo");
        lblConfirmaSenha2.getStyleClass().set(1, "lbl-nulo");
        lblConfirmaSexo.getStyleClass().set(1, "lbl-nulo");
        lblConfirmaPersonagem.getStyleClass().set(1, "lbl-nulo");
        lblPersonagem.getStyleClass().set(1, "lbl-nulo");
        lblNomePersonagem.setText("");
        txtNome.setText("");
        txtLogin.setText("");
        passwordSenha.setText("");
        passwordConfirma.setText("");
        visualizarDadosPersonagem(false);
        meuControlador.loadScreen(Main.cenaLogin, Main.cenaLoginLocal);
        meuControlador.setScreen(Main.cenaLogin);
        meuControlador.unloadScreen(Main.cenaCadastro);
    }

    @FXML
    private void actionBtnCadastrar(ActionEvent event) throws SQLException, IOException {
        if (validarDados() != true) {
            Image img = new Image("/img/lbl-cadastro-erro.png");
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("");
            alert.setGraphic(new ImageView(img));
            alert.setHeaderText(null);
            alert.setContentText(menssagemErro);
            alert.showAndWait();

        } else {
            referencia = new Jogador();
            referencia.setLogin(txtLogin.getText());
            referencia.setSenha(passwordSenha.getText());
            referencia.setNome(txtNome.getText());
            referencia.setSexo(sexo);
            referencia.setNivel(1);
            referencia.setExperiencia(0);
            referencia.setIdPersonagem(idPersonagem);
            jogadorDAO.inserir(referencia);
            Image img = new Image("/img/lbl-cadastro-correto.png");
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("");
            alert.setGraphic(new ImageView(img));
            alert.setHeaderText(null);
            alert.setContentText("Cadastrado com Sucesso!");
            alert.showAndWait();
        }
    }

    @FXML
    private void radioActionMasculino(ActionEvent event) {
        radioButtonMasculino.setSelected(true);
        radioButtonFeminino.setSelected(false);
        confirmaClicksexo = true;
        sexo = "M";
    }

    @FXML
    private void radioActionFeminino(ActionEvent event) {
        radioButtonFeminino.setSelected(true);
        radioButtonMasculino.setSelected(false);
        confirmaClicksexo = true;
        sexo = "F";
    }

    @FXML
    private void actionBtnBomberman(ActionEvent event) {
        confirmaClickpersonagem = true;
        visualizarDadosPersonagem(true);
        lblPersonagem.getStyleClass().set(1, "lbl-personagem-bomberman");
        lblNomePersonagem.setText("BOMBERMAN");
        idPersonagem = 1;
        progressBarAtaque.setProgress(0.8);
        progressBarDefesa.setProgress(0.2);
        progressBarAgilidade.setProgress(0.4);
    }

    @FXML
    private void actionBtnCrash(ActionEvent event) {
        confirmaClickpersonagem = true;
        visualizarDadosPersonagem(true);
        lblPersonagem.getStyleClass().set(1, "lbl-personagem-crash");
        lblNomePersonagem.setText("CRASH");
        idPersonagem = 2;
        progressBarAtaque.setProgress(0.6);
        progressBarDefesa.setProgress(0.6);
        progressBarAgilidade.setProgress(0.3);
    }

    @FXML
    private void actionBtnDonkeyKong(ActionEvent event) {
        confirmaClickpersonagem = true;
        visualizarDadosPersonagem(true);
        lblPersonagem.getStyleClass().set(1, "lbl-personagem-donkeykong");
        lblNomePersonagem.setText("DONKEY KONG");
        idPersonagem = 3;
        progressBarAtaque.setProgress(0.9);
        progressBarDefesa.setProgress(0.4);
        progressBarAgilidade.setProgress(0.2);
    }

    @FXML
    private void actionBtnDukeNukem(ActionEvent event) {
        confirmaClickpersonagem = true;
        visualizarDadosPersonagem(true);
        lblPersonagem.getStyleClass().set(1, "lbl-personagem-dukenukem");
        lblNomePersonagem.setText("DUKE NUKEM");
        idPersonagem = 4;
        progressBarAtaque.setProgress(0.85);
        progressBarDefesa.setProgress(0.55);
        progressBarAgilidade.setProgress(0.33);
    }

    @FXML
    private void actionBtnKratos(ActionEvent event) {
        confirmaClickpersonagem = true;
        visualizarDadosPersonagem(true);
        lblPersonagem.getStyleClass().set(1, "lbl-personagem-kratos");
        lblNomePersonagem.setText("KRATOS");
        idPersonagem = 5;
        progressBarAtaque.setProgress(0.89);
        progressBarDefesa.setProgress(0.77);
        progressBarAgilidade.setProgress(0.66);
    }

    @FXML
    private void actionBtnLaraCroft(ActionEvent event) {
        confirmaClickpersonagem = true;
        visualizarDadosPersonagem(true);
        lblPersonagem.getStyleClass().set(1, "lbl-personagem-laracroft");
        lblNomePersonagem.setText("LARA CROFT");
        idPersonagem = 6;
        progressBarAtaque.setProgress(0.81);
        progressBarDefesa.setProgress(0.44);
        progressBarAgilidade.setProgress(0.75);
    }

    @FXML
    private void actionBtnMegaman(ActionEvent event) {
        confirmaClickpersonagem = true;
        visualizarDadosPersonagem(true);
        lblPersonagem.getStyleClass().set(1, "lbl-personagem-megaman");
        lblNomePersonagem.setText("MEGAMAN");
        idPersonagem = 8;
        progressBarAtaque.setProgress(0.74);
        progressBarDefesa.setProgress(0.33);
        progressBarAgilidade.setProgress(0.98);
    }

    @FXML
    private void actionBtnMario(ActionEvent event) {
        confirmaClickpersonagem = true;
        visualizarDadosPersonagem(true);
        lblPersonagem.getStyleClass().set(1, "lbl-personagem-mario");
        lblNomePersonagem.setText("MARIO");
        idPersonagem = 7;
        progressBarAtaque.setProgress(0.70);
        progressBarDefesa.setProgress(0.20);
        progressBarAgilidade.setProgress(0.86);
    }

    @FXML
    private void actionBtnPacman(ActionEvent event) {
        confirmaClickpersonagem = true;
        visualizarDadosPersonagem(true);
        lblPersonagem.getStyleClass().set(1, "lbl-personagem-pacman");
        lblNomePersonagem.setText("PAC-MAN");
        idPersonagem = 9;
        progressBarAtaque.setProgress(0.60);
        progressBarDefesa.setProgress(0.07);
        progressBarAgilidade.setProgress(0.94);
    }

    @FXML
    private void actionBtnRyu(ActionEvent event) {
        confirmaClickpersonagem = true;
        visualizarDadosPersonagem(true);
        lblPersonagem.getStyleClass().set(1, "lbl-personagem-ryu");
        lblNomePersonagem.setText("RYU");
        idPersonagem = 10;
        progressBarAtaque.setProgress(0.84);
        progressBarDefesa.setProgress(0.75);
        progressBarAgilidade.setProgress(0.70);
    }

    @FXML
    private void actionBtnSonic(ActionEvent event) {
        confirmaClickpersonagem = true;
        visualizarDadosPersonagem(true);
        lblPersonagem.getStyleClass().set(1, "lbl-personagem-sonic");
        lblNomePersonagem.setText("SONIC");
        idPersonagem = 11;
        progressBarAtaque.setProgress(0.39);
        progressBarDefesa.setProgress(0.33);
        progressBarAgilidade.setProgress(0.99);
    }

    @FXML
    private void actionBtnZelda(ActionEvent event) {
        confirmaClickpersonagem = true;
        visualizarDadosPersonagem(true);
        lblPersonagem.getStyleClass().set(1, "lbl-personagem-zelda");
        lblNomePersonagem.setText("ZELDA");
        idPersonagem = 12;
        progressBarAtaque.setProgress(0.75);
        progressBarDefesa.setProgress(0.69);
        progressBarAgilidade.setProgress(0.74);
    }

    public boolean validarDados() {
        menssagemErro = "";

        if (txtNome.getText() == null || txtNome.getText().length() == 0) {
            menssagemErro += "Nome inválido!\n";
            lblConfirmaNome.getStyleClass().set(1, "lbl-errado");
        } else {
            lblConfirmaNome.getStyleClass().set(1, "lbl-certo");
        }

        if (jogadorDAO.usuarioExiste(txtNome.getText()) == true) {
            menssagemErro += "usuário já ultilizado!\n";
            lblConfirmaNome.getStyleClass().set(1, "lbl-errado");
        }

        if (txtLogin.getText() == null || txtLogin.getText().length() == 0) {
            menssagemErro += "Login inválido!\n";
            lblConfirmaLogin.getStyleClass().set(1, "lbl-errado");
        } else {
            lblConfirmaLogin.getStyleClass().set(1, "lbl-certo");
        }

        if (passwordSenha.getText() == null || passwordSenha.getText().length() == 0) {
            menssagemErro += "Senha inválida!\n";
            lblConfirmaSenha1.getStyleClass().set(1, "lbl-errado");
        } else {
            lblConfirmaSenha1.getStyleClass().set(1, "lbl-certo");
        }

        if (passwordConfirma.getText() == null || passwordConfirma.getText().length() == 0) {
            menssagemErro += "Confirmaçãp inválida!\n";
            lblConfirmaSenha2.getStyleClass().set(1, "lbl-errado");
        } else {
            lblConfirmaSenha2.getStyleClass().set(1, "lbl-certo");
        }

        if (passwordSenha.getText().equals(passwordConfirma.getText())) {
            //
        } else {
            menssagemErro += "Senha diferente da confirmação!\n";
            lblConfirmaSenha1.getStyleClass().set(1, "lbl-errado");
            lblConfirmaSenha2.getStyleClass().set(1, "lbl-errado");
        }

        if (confirmaClicksexo == false) {
            menssagemErro += "Sexo não selecionado!\n";
            lblConfirmaSexo.getStyleClass().set(1, "lbl-errado");
        } else {
            lblConfirmaSexo.getStyleClass().set(1, "lbl-certo");
        }

        if (confirmaClickpersonagem == false) {
            menssagemErro += "Personagem não selecionado!\n";
            lblConfirmaPersonagem.getStyleClass().set(1, "lbl-errado");
        } else {
            lblConfirmaPersonagem.getStyleClass().set(1, "lbl-certo");
        }

        if (menssagemErro.length() == 0) {
            return true;
        } else {
            System.out.println("Compos, inválidos, por favor corrija.");
            System.out.println(menssagemErro);
            return false;
        }
    }

    private void visualizarDadosPersonagem(boolean estado) {
        progressBarAtaque.setVisible(estado);
        progressBarDefesa.setVisible(estado);
        progressBarAgilidade.setVisible(estado);
        lblAtaquePersonagem.setVisible(estado);
        lblDefesaPersonagem.setVisible(estado);
        lblAgilidadePersonagem.setVisible(estado);
    }

}
