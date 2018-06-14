/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;
import model.Baralho;
import model.Carta;

/**
 *
 * @author jvboa
 */
public class main {

    public static void main(String[] args) {
        Baralho baralho = new Baralho();
        baralho.criarCartas();

        int randomNum = ThreadLocalRandom.current().nextInt(1, 52);
        System.out.printf("numero: %d \n", randomNum);
        baralho.embaralhar();

        Carta carta = baralho.removerCartaTop();
        System.out.printf("\nCarta do topo: %s\nTipo: %s\nCor: %s\n", carta.getValor(), carta.getNaipe().getTipo(), carta.getNaipe().getCor());

    }
}
