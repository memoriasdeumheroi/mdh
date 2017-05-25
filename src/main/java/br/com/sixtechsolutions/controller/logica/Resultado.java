package br.com.sixtechsolutions.controller.logica;

public class Resultado {

    static private int totalBtnCertos;
    static private int totalAcertos = 0;
    static private int totalErros = 0;
    static private int pontos;
    static private boolean trava = false;

    Personagem personagem = new Personagem();

    public void verificarSeAcertou(int btn) {
        if (trava == false) {
            if (personagem.getReferencia(btn) == 1) {
                Resultado.totalAcertos++;
                pontos += 1250;
            } else {
                Resultado.totalErros++;

            }
        }
    }

    public void verificarTotalBtnCerto() {
        for (int i = 0; i < personagem.getReferencia().length; i++) {
            if (personagem.getReferencia(i) == 1) {
                Resultado.totalBtnCertos++;
            }
        }
    }

    public void zeraResultados() {
        totalBtnCertos = 0;
        totalAcertos = 0;
        totalErros = 0;
        pontos = 0;
        trava = false;
    }

    public int getTotalBtnCertos() {
        return totalBtnCertos;
    }

    public int getTotalAcertos() {
        return totalAcertos;
    }

    public int getTotalErros() {
        return totalErros;
    }

    public int getPontos() {
        return pontos;
    }

    public static void setTrava(boolean trava) {
        Resultado.trava = trava;
    }

    public boolean getTrava() {
        return this.trava;
    }
}
