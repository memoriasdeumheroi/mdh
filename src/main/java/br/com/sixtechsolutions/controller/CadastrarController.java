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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CadastrarController implements Initializable, CenaControlada {

    ControladorDeCenas meuControlador;
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final JogadorDAO jogadorDAO = new JogadorDAO();
    private Jogador referencia;
    private boolean confirmaClicksexo = false;
    private boolean confirmaClickpersonagem = false;
    private String menssagemErro;
    private String sexo;

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

    public boolean validarDados() {
        menssagemErro = "";

        if (txtNome.getText() == null || txtNome.getText().length() == 0) {
            menssagemErro += "Nome inválido!\n";
            lblConfirmaNome.getStyleClass().set(1, "lbl-errado");
        } else {
            lblConfirmaNome.getStyleClass().set(1, "lbl-certo");
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
        meuControlador.setScreen(Main.cenaPrincipal);
    }

    @FXML
    private void actionBtnCadastrar(ActionEvent event) throws SQLException, IOException {
        if (validarDados() != true) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText(null);
            alert.setContentText(menssagemErro);
            alert.showAndWait();
        } else {
            referencia = new Jogador();
            referencia.setLogin(txtLogin.getText());
            referencia.setSenha(passwordSenha.getText());
            referencia.setNome(txtNome.getText());
            referencia.setSexo(sexo);
            jogadorDAO.inserir(referencia);
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
        lblPersonagem.getStyleClass().set(1, "lbl-cadastro-personagem-bomberman");
        lblNomePersonagem.setText("BOMBERMAN");
    }

    @FXML
    private void actionBtnCrash(ActionEvent event) {
        confirmaClickpersonagem = true;
        visualizarDadosPersonagem(true);
        lblPersonagem.getStyleClass().set(1, "lbl-cadastro-personagem-crash");
        lblNomePersonagem.setText("CRASH");
    }

    @FXML
    private void actionBtnDonkeyKong(ActionEvent event) {
        confirmaClickpersonagem = true;
        visualizarDadosPersonagem(true);
        lblPersonagem.getStyleClass().set(1, "lbl-cadastro-personagem-donkeykong");
        lblNomePersonagem.setText("DONKEY KONG");
    }

    @FXML
    private void actionBtnDukeNukem(ActionEvent event) {
        confirmaClickpersonagem = true;
        visualizarDadosPersonagem(true);
        lblPersonagem.getStyleClass().set(1, "lbl-cadastro-personagem-dukenukem");
        lblNomePersonagem.setText("DUKE NUKEM");
    }

    @FXML
    private void actionBtnKratos(ActionEvent event) {
        confirmaClickpersonagem = true;
        visualizarDadosPersonagem(true);
        lblPersonagem.getStyleClass().set(1, "lbl-cadastro-personagem-kratos");
        lblNomePersonagem.setText("KRATOS");
    }

    @FXML
    private void actionBtnLaraCroft(ActionEvent event) {
        confirmaClickpersonagem = true;
        visualizarDadosPersonagem(true);
        lblPersonagem.getStyleClass().set(1, "lbl-cadastro-personagem-laracroft");
        lblNomePersonagem.setText("LARA CROFT");
    }

    @FXML
    private void actionBtnMegaman(ActionEvent event) {
        confirmaClickpersonagem = true;
        visualizarDadosPersonagem(true);
        lblPersonagem.getStyleClass().set(1, "lbl-cadastro-personagem-megaman");
        lblNomePersonagem.setText("MEGAMAN");
    }

    @FXML
    private void actionBtnMario(ActionEvent event) {
        confirmaClickpersonagem = true;
        visualizarDadosPersonagem(true);
        lblPersonagem.getStyleClass().set(1, "lbl-cadastro-personagem-mario");
        lblNomePersonagem.setText("MARIO");
    }

    @FXML
    private void actionBtnPacman(ActionEvent event) {
        confirmaClickpersonagem = true;
        visualizarDadosPersonagem(true);
        lblPersonagem.getStyleClass().set(1, "lbl-cadastro-personagem-pacman");
        lblNomePersonagem.setText("PAC-MAN");
    }

    @FXML
    private void actionBtnRyu(ActionEvent event) {
        confirmaClickpersonagem = true;
        visualizarDadosPersonagem(true);
        lblPersonagem.getStyleClass().set(1, "lbl-cadastro-personagem-ryu");
        lblNomePersonagem.setText("RYU");
    }

    @FXML
    private void actionBtnSonic(ActionEvent event) {
        confirmaClickpersonagem = true;
        visualizarDadosPersonagem(true);
        lblPersonagem.getStyleClass().set(1, "lbl-cadastro-personagem-sonic");
        lblNomePersonagem.setText("SONIC");
    }

    @FXML
    private void actionBtnZelda(ActionEvent event) {
        confirmaClickpersonagem = true;
        visualizarDadosPersonagem(true);
        lblPersonagem.getStyleClass().set(1, "lbl-cadastro-personagem-zelda");
        lblNomePersonagem.setText("ZELDA");
    }

}
