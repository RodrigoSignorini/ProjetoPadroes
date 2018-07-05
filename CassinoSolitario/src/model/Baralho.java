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
 * @author Gustavo e Jadson
 */
public class Baralho {

    private Stack<Carta> baralho;

    public Naipe[] naipes = {
        new Naipe("VERMELHO", "COPAS"),
        new Naipe("VERMELHO", "OUROS"),
        new Naipe("PRETO", "ESPADA"),
        new Naipe("PRETO", "PAUS"),};

    public Baralho() {
        this.baralho = new Stack<>();
    }

    public void criarCartas() {
        System.out.println("Criando cartas...\n");
        for (int numCard = 1; numCard < 14; numCard++) {
            for (Naipe naipe : naipes) {
                Carta novaCarta = new Carta("", naipe);

                switch (numCard) {
                    case 1:
                        novaCarta.setValor("A");
                        novaCarta.setValorNumerico(numCard);
                        break;
                    case 11:
                        novaCarta.setValor("J");
                        novaCarta.setValorNumerico(numCard);
                        break;
                    case 12:
                        novaCarta.setValor("Q");
                        novaCarta.setValorNumerico(numCard);
                        break;
                    case 13:
                        novaCarta.setValor("K");
                        novaCarta.setValorNumerico(numCard);
                        break;
                    default:
                        novaCarta.setValor("" + numCard);
                        novaCarta.setValorNumerico(numCard);
                        break;
                }
//                System.out.printf("Carta: %s, Naipe: %s, Cor:%s\n", novaCarta.getValor(), novaCarta.getNaipe().getTipo(), novaCarta.getNaipe().getCor()); 
                baralho.push(novaCarta);
            }
        }
//        System.out.println("\n");
    }

    public void embaralhar() {
        System.out.println("Embaralhando cartas...");
        Collections.shuffle(baralho);
        baralho.forEach((carta) -> {
//            System.out.printf("Carta: %s, Naipe: %s, Cor:%s\n", carta.getValor(), carta.getNaipe().getTipo(), carta.getNaipe().getCor());
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
