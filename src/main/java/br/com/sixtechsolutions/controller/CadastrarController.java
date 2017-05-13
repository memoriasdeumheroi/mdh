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
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CadastrarController implements Initializable, CenaControlada {

    private ControladorDeCenas meuControlador;
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final JogadorDAO jogadorDAO = new JogadorDAO();
    private Jogador referencia;
    private boolean confirmaClicksexo = false;
    private boolean confirmaClickpersonagem = false;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
    private Button btnPersonagem1;

    @FXML
    private Button btnPersonagem2;

    @FXML
    private Button btnPersonagem3;

    @FXML
    private Button btnPersonagem4;

    @FXML
    private Button btnPersonagem7;

    @FXML
    private Button btnPersonagem5;

    @FXML
    private Button btnPersonagem8;

    @FXML
    private Button btnPersonagem6;

    @FXML
    private Button btnPersonagem9;

    @FXML
    private Button btnPersonagem10;

    @FXML
    private Button btnPersonagem11;

    @FXML
    private Button btnPersonagem12;

    @FXML
    private TextField textNickname;

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
    private Label lblConfirmaNickname;

    @FXML
    private Label lblConfirmaSenha;

    @FXML
    private Label lblConfirmaSexo;

    @FXML
    private Label lblConfirmaPersonagem;

    @FXML
    private PieChart grafico;

    @FXML
    private Button voltar;

    public boolean validarDados() {
        String menssagemErro = "";
        if (textNickname.getText() == null || textNickname.getText().length() == 0) {
            menssagemErro += "Nome inválido!\n";
            lblConfirmaNickname.setText("Coloque um nickname!");
        } else {
            lblConfirmaNickname.setText("");
        }

        if (passwordSenha.getText() == null || passwordSenha.getText().length() == 0) {
            menssagemErro += "Senha inválida!\n";
            lblConfirmaSenha.setText("Coloque uma senha!");
        } else {
            lblConfirmaSenha.setText("");
        }

        if (passwordConfirma.getText() == null || passwordConfirma.getText().length() == 0) {
            menssagemErro += "Senha inválida!\n";
            lblConfirmaSenha.setText("Coloque a confirmação da senhas!");
        } else {
            lblConfirmaSenha.setText("");
        }

        if (confirmaClicksexo == false) {
            menssagemErro += "Sexo não selecionado!\n";
            lblConfirmaSexo.setText("Sexo não selecionado!\n");
        } else {
            lblConfirmaSexo.setText("");
        }

        if (confirmaClickpersonagem == false) {
            menssagemErro += "Personagem não selecionado!\n";
            lblConfirmaPersonagem.setText("Personagem não selecionado!\n");
        } else {
            lblConfirmaPersonagem.setText("");
        }

        if (menssagemErro.length() == 0) {
            return true;
        } else {
            System.out.println("Compos, inválidos, por favor corrija.");
            System.out.println(menssagemErro);
            return false;
        }
    }

    @FXML
    public void actionBtnCadastrar(ActionEvent event) throws SQLException {
        if (validarDados() == true) {
            Jogador jogador = new Jogador("felipe", "f", "alessandra", "1236");
            jogadorDAO.inserir(jogador);
        } else {
            System.out.println("não foi possivel");
        }
    }

    @FXML
    public void radioActionMasculino(ActionEvent event) {
        radioButtonMasculino.setSelected(true);
        radioButtonFeminino.setSelected(false);
        confirmaClicksexo = true;
    }

    @FXML
    public void radioActionFeminino(ActionEvent event) {
        radioButtonFeminino.setSelected(true);
        radioButtonMasculino.setSelected(false);
        confirmaClicksexo = true;
    }

    @FXML
    void actionBtnPersonagem1(ActionEvent event) {
        confirmaClickpersonagem = true;
    }

    @FXML
    void actionBtnPersonagem2(ActionEvent event) {
        confirmaClickpersonagem = true;
    }

    @FXML
    void actionBtnPersonagem3(ActionEvent event) {
        confirmaClickpersonagem = true;
    }

    @FXML
    void actionBtnPersonagem4(ActionEvent event) {
        confirmaClickpersonagem = true;
    }

    @FXML
    void actionBtnPersonagem5(ActionEvent event) {
        confirmaClickpersonagem = true;
    }

    @FXML
    void actionBtnPersonagem6(ActionEvent event) {
        confirmaClickpersonagem = true;
    }

    @FXML
    void actionBtnPersonagem7(ActionEvent event) {
        confirmaClickpersonagem = true;
    }

    @FXML
    void actionBtnPersonagem8(ActionEvent event) {
        confirmaClickpersonagem = true;
    }

    @FXML
    void actionBtnPersonagem9(ActionEvent event) {
        confirmaClickpersonagem = true;
    }

    @FXML
    void actionBtnPersonagem10(ActionEvent event) {
        confirmaClickpersonagem = true;
    }

    @FXML
    void actionBtnPersonagem11(ActionEvent event) {
        confirmaClickpersonagem = true;
    }

    @FXML
    void actionBtnPersonagem12(ActionEvent event) {
        confirmaClickpersonagem = true;
    }

    @FXML
    public void btnActionVoltar(ActionEvent event) {
        meuControlador.setScreen(Main.cenaPrincipal);
    }

}
