/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula01.introducao.gui.swing;

import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author prof. Célio R. Castelano
 */
public class TempoDecorrido {

    private long inicio;
    private long termino;

    public TempoDecorrido() {
        this.iniciar();
        this.calcular();
        this.finalizar();
        this.exibir();
    }

    public void iniciar() {
        this.inicio = System.nanoTime();
    }

    public void calcular() {
        int quantidade = 100000;
        long valor = 0;

        for (int x = 0; x < quantidade; x++) {
            for (int y = 0; y < quantidade; y++) {
                valor += (x + y);
            }
        }
    }

    public void exibir() {
        long decorrido = termino - inicio;

        long milesegundos = TimeUnit.NANOSECONDS.toMillis(decorrido);

        String tempototal = decorrido + " nano segundos";

        if (milesegundos > 0) {
            tempototal = String.format("%02dh:%02dm:%02ds",
                    TimeUnit.MILLISECONDS.toHours(milesegundos),
                    TimeUnit.MILLISECONDS.toMinutes(milesegundos)
                    - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milesegundos)), // The change is in this line
                    TimeUnit.MILLISECONDS.toSeconds(milesegundos)
                    - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milesegundos)));
        }

        JOptionPane.showMessageDialog(null,
                "Tempo Inicial: " + this.inicio + "\n"
                + "Tempo Final: " + this.termino + "\n"
                + "Tempo Decorrido: " + tempototal + "\n"
        );
    }

    public void finalizar() {

        this.termino = System.nanoTime();
    }

    public static void main(String[] args) {
        TempoDecorrido tempo = new TempoDecorrido();
    }
}
