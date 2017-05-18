package br.com.sixtechsolutions;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static String cenaMenu = "menu";
    public static String cenaMenuLocal = "/fxml/GUI_Menu.fxml";

    public static String cenaIntro = "intro";
    public static String cenaIntroLocal = "/fxml/GUI_Intro.fxml";

    public static String cenaSobre = "sobre";
    public static String cenaSobreLocal = "/fxml/GUI_Sobre.fxml";

    public static String cenaJogada = "jogada";
    public static String cenaJogadaLocal = "/fxml/GUI_Jogada.fxml";

    public static String cenaRanking = "ranking";
    public static String cenaRankingLocal = "/fxml/GUI_Ranking.fxml";

    public static String cenaPrincipal = "login";
    public static String cenaPrincipalLocal = "/fxml/GUI_Login.fxml";

    public static String cenaConteudo = "conteudo";
    public static String cenaConteudoLocal = "/fxml/GUI_Conteudo.fxml";

    public static String cenaCadastro = "cadastro";
    public static String cenaCadastroLocal = "/fxml/GUI_Cadastro.fxml";

    public static String cenaEscolha = "escolha";
    public static String cenaEscolhaLocal = "/fxml/GUI_Personagens.fxml";

    public static String cenaConquistas = "conquistas";
    public static String cenaConquistasLocal = "/fxml/GUI_Conquistas.fxml";

    public static String cenaConfiguracoes = "configuracoes";
    public static String cenaConfiguracoesLocal = "/fxml/GUI_Configuracoes.fxml";

    @Override
    public void start(Stage primaryStage) {

        ControladorDeCenas mainContainer = new ControladorDeCenas();
        mainContainer.loadScreen(Main.cenaMenu, Main.cenaMenuLocal);
        mainContainer.loadScreen(Main.cenaSobre, Main.cenaSobreLocal);
        mainContainer.loadScreen(Main.cenaIntro, Main.cenaIntroLocal);
        mainContainer.loadScreen(Main.cenaJogada, Main.cenaJogadaLocal);
        mainContainer.loadScreen(Main.cenaRanking, Main.cenaRankingLocal);
        mainContainer.loadScreen(Main.cenaEscolha, Main.cenaEscolhaLocal);
        mainContainer.loadScreen(Main.cenaConteudo, Main.cenaConteudoLocal);
        mainContainer.loadScreen(Main.cenaCadastro, Main.cenaCadastroLocal);
        mainContainer.loadScreen(Main.cenaPrincipal, Main.cenaPrincipalLocal);
        mainContainer.loadScreen(Main.cenaConquistas, Main.cenaConquistasLocal);
        mainContainer.loadScreen(Main.cenaConfiguracoes, Main.cenaConfiguracoesLocal);

        mainContainer.setScreen(cenaIntro);

        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
