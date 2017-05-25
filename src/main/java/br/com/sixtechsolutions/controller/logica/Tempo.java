package br.com.sixtechsolutions.controller.logica;

import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.control.Button;

public class Tempo extends Jogada {

    Dificuldade dificuldade = new Dificuldade();

    private int contadorSegundos = 0;

    Timer timer;
    TimerTask task;

    public void iniciarTempo(final Button[] lista) {
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                if (contadorSegundos < 5) {
                    contadorSegundos++;
                    System.out.println("segundo = " + contadorSegundos);
                } else {
                    esconderBotoes(lista);
                    System.out.println("Terminaou tempo!");
                    timer.cancel();
                }
            }
        };
    }

    public void iniciarTime() {
        timer.scheduleAtFixedRate(task, 1, 1000);
    }

    public void diminuirTempo() {
        dificuldade.setTempoExibicao(0.2f);
    }

    public void zerarTempo() {
        this.contadorSegundos = 0;
    }

    public void pararTempo() {

    }
}
