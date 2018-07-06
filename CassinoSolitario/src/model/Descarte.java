/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Stack;

/**
 *
 * @author Gustavo e Jadson
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

    public boolean estaVazia() {
        return descarte.empty();
    }
    
    public int countCartas() {
        return descarte.size();
    }

    public void exibir(int qtd) {
        if (descarte.isEmpty()) {
            System.out.printf("");
        } else {
            if (qtd == 1) {
                Carta carta = descarte.peek();
                System.out.printf(" %s %s", carta.getSimbolo(), carta.getNaipe().getTipo());
            } else if (qtd == 3) {
                Descarte aux = new Descarte();
                int tam = descarte.size();
                for (int i = 0; i < tam; i++) {
                    Carta carta = descarte.pop();
                    aux.pushCarta(carta);
                    if (i < 3) {
                        System.out.printf(" %s %s", carta.getSimbolo(), carta.getNaipe().getTipo());
                        System.out.printf(" | ");               
                    }
                }
                for (int j=0; j< tam; j++){
                    descarte.push(aux.popCarta());
                }
            }
        }
    }

}
