/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Stack;

/**
 *
 * @author jvboa
 */
public class Descarte {

    private Stack<Carta> descarte;

    public Descarte() {
        this.descarte = new Stack<>();
    }

    public void pushCarta(Carta carta) {

        descarte.push(carta);
    }

    public Carta popCarta() {

        return descarte.pop();
    }

    public Carta peekCarta() {

        return descarte.peek();
    }

    public void exibir(int qtd) {
        if (descarte.isEmpty()) {
            System.out.printf("");
        } else {

            if (qtd == 1) {
                Carta carta = descarte.get(descarte.size() - qtd);
                System.out.printf(" %s %s", carta.getSimbolo(), carta.getNaipe().getTipo());
            } else if (qtd == 3) {
                for (int i = 0; i < 3; i++) {
                    Carta carta = descarte.get(i);
                    System.out.printf(" %s %s", carta.getSimbolo(), carta.getNaipe().getTipo());
                    System.out.printf(" | ");

                }
            }
        }
    }

}
