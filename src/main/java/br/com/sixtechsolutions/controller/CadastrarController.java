package br.com.sixtechsolutions.controller;

import br.com.sixtechsolutions.CenaControlada;
import br.com.sixtechsolutions.ControladorDeCenas;
import br.com.sixtechsolutions.Main;
import br.com.sixtechsolutions.model.dao.JogadorDAO;
import br.com.sixtechsolutions.model.database.DatabaseMySQL;
import br.com.sixtechsolutions.model.dominio.Jogador;
import java.net.URL;
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

    ControladorDeCenas meuControlador;
    Jogador jogador;

    JogadorDAO jogadorDAO = new JogadorDAO();
    DatabaseMySQL banco = new DatabaseMySQL();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

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

    private boolean sexo = false;
    private boolean personagem = false;

    public boolean validarDados() {
        String menssagemErro = "";
        if (textNickname.getText() == null || textNickname.getText().length() == 0) {
            menssagemErro += "Nome inválido!\n";
            lblConfirmaNickname.setText("Coloque um nickname!");
        } else {
        }

        if (passwordSenha.getText() == null || passwordSenha.getText().length() == 0) {
            menssagemErro += "Senha inválida!\n";
            lblConfirmaSenha.setText("Coloque uma senha!");
        }

        if (passwordConfirma.getText() == null || passwordConfirma.getText().length() == 0) {
            menssagemErro += "Senha inválida!\n";
            lblConfirmaSenha.setText("Coloque a confirmação da senhas!");
        }

        if (sexo == false) {
            menssagemErro += "Sexo não selecionado!\n";
            lblConfirmaSexo.setText("Sexo não selecionado!\n");
        }

        if (personagem == false) {
            menssagemErro += "Personagem não selecionado!\n";
            lblConfirmaPersonagem.setText("Personagem não selecionado!\n");
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
            jogador = new Jogador("felipe", "f", "alessandra", "1236");
            banco.conectar();
            jogadorDAO.inserir(jogador);
            banco.desconectar(jogadorDAO.getConnection());
        } else {
            System.out.println("não foi possivel");
        }
    }

    @FXML
    public void radioActionMasculino(ActionEvent event) {
        radioButtonMasculino.setSelected(true);
        radioButtonFeminino.setSelected(false);
        sexo = true;
    }

    @FXML
    public void radioActionFeminino(ActionEvent event) {
        radioButtonFeminino.setSelected(true);
        radioButtonMasculino.setSelected(false);
        sexo = true;
    }

    @FXML
    void actionBtnPersonagem1(ActionEvent event) {
        personagem = true;
    }

    @FXML
    void actionBtnPersonagem2(ActionEvent event) {
        personagem = true;
    }

    @FXML
    void actionBtnPersonagem3(ActionEvent event) {
        personagem = true;
    }

    @FXML
    void actionBtnPersonagem4(ActionEvent event) {
        personagem = true;
    }

    @FXML
    void actionBtnPersonagem5(ActionEvent event) {
        personagem = true;
    }

    @FXML
    void actionBtnPersonagem6(ActionEvent event) {
        personagem = true;
    }

    @FXML
    void actionBtnPersonagem7(ActionEvent event) {
        personagem = true;
    }

    @FXML
    void actionBtnPersonagem8(ActionEvent event) {
        personagem = true;
    }


    
    
    
    
    @FXML
    void actionBtnPersonagem9(ActionEvent event) {
        personagem = true;
    }

    @FXML
    void actionBtnPersonagem10(ActionEvent event) {
        personagem = true;
    }

    @FXML
    void actionBtnPersonagem11(ActionEvent event) {
        personagem = true;
    }

    @FXML
    void actionBtnPersonagem12(ActionEvent event) {
        personagem = true;
    }

    @FXML
    public void btnActionVoltar(ActionEvent event) {
        meuControlador.setScreen(Main.cenaPrincipal);
    }

}
