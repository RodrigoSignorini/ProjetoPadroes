/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Collections;
import java.util.Stack;

/**
 *
 * @author jvboa
 */
public class Baralho {

    private Stack<Carta> baralho;

    public Naipe[] naipes = {
        new Naipe("VERMELHO", "COPAS"),
        new Naipe("VERMELHO", "OURO"),
        new Naipe("PRETO", "ESPADA"),
        new Naipe("PRETO", "PAUS"),};

    public Baralho() {
        this.baralho = new Stack<>();
    }

    public void criarCartas() {
        System.out.println("Criando cartas...\n");
        for (int numCard = 0; numCard < 13; numCard++) {
            for (Naipe naipe : naipes) {
                Carta novaCarta = new Carta("", naipe);

                switch (numCard) {
                    case 0:
                        novaCarta.setValor("A");
                        break;
                    case 10:
                        novaCarta.setValor("J");
                        break;
                    case 11:
                        novaCarta.setValor("Q");
                        break;
                    case 12:
                        novaCarta.setValor("K");
                        break;
                    default:
                        novaCarta.setValor("" + numCard);
                        break;
                }
                System.out.printf("Carta: %s, Naipe: %s, Cor:%s\n", novaCarta.getValor(), novaCarta.getNaipe().getTipo(), novaCarta.getNaipe().getCor());
                baralho.push(novaCarta);
            }
        }
        System.out.println("\n");
    }

    public void embaralhar() {
        System.out.println("Embaralhando cartas...\n");
        Collections.shuffle(baralho);
        baralho.forEach((carta) -> {
            System.out.printf("Carta: %s, Naipe: %s, Cor:%s\n", carta.getValor(), carta.getNaipe().getTipo(), carta.getNaipe().getCor());
        });
    }

    public Carta removerCartaTop() {
        Carta card = baralho.pop();
        return card;
    }

    public Stack<Carta> getBaralho() {
        return baralho;
    }
}
