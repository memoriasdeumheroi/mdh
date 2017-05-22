package br.com.sixtechsolutions.controller;

import br.com.sixtechsolutions.CenaControlada;
import br.com.sixtechsolutions.ControladorDeCenas;
import br.com.sixtechsolutions.Main;
import br.com.sixtechsolutions.controller.logica.JogadorEstatico;
import br.com.sixtechsolutions.model.dao.JogadorDAO;
import br.com.sixtechsolutions.model.database.Database;
import br.com.sixtechsolutions.model.database.DatabaseFactory;
import br.com.sixtechsolutions.model.dominio.Jogador;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class LoginController implements Initializable, CenaControlada {

    private ControladorDeCenas meuControlador;
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final JogadorDAO jogadorDAO = new JogadorDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jogadorDAO.setConnection(connection);
    }

    @Override
    public void defineCenaPai(ControladorDeCenas screenParent) {
        meuControlador = screenParent;
    }

    @FXML
    private TextField txtNomeJogador;

    @FXML
    private PasswordField txtSenhaJogador;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Pane pane;

    @FXML
    private Button btnEntrar;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Label lblEsqueciSenha;

    @FXML
    private Pane paneAlert;

    @FXML
    private Label lblImgAlert;

    @FXML
    private Label lblAlert;

    @FXML
    private Button github;

    @FXML
    private void actionGithub(ActionEvent event) {
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

    @FXML
    public void btnCadastrarHeroi(ActionEvent event) throws IOException, SQLException {
        meuControlador.setScreen(Main.cenaCadastro);
    }

    @FXML
    public void btnEntrarNoJogo(ActionEvent event) throws IOException {
        validarDados();
    }

    public void validarDados() {
        if (txtNomeJogador.getText() == null || txtNomeJogador.getText().length() == 0
                && txtSenhaJogador.getText() == null || txtSenhaJogador.getText().length() == 0) {
            paneAlert.setVisible(true);
        } else {
            Jogador jogador = new Jogador();
            jogador.setLogin(txtNomeJogador.getText());
            jogador.setSenha(txtSenhaJogador.getText());
            Jogador j = jogadorDAO.buscar(jogador);
            if (jogadorDAO.buscar(jogador).getLogin() == jogador.getLogin()) {
                meuControlador.setScreen(Main.cenaMenu);
                JogadorEstatico jogadorEstatico = new JogadorEstatico(jogadorDAO.buscar(jogador));
                paneAlert.setVisible(false);
            } else {
                paneAlert.setVisible(true);
            }
        }
    }
}
