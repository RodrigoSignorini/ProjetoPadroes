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
public class Estoque {

    private Stack<Carta> estoque;

    public Estoque() {
        this.estoque = new Stack<>();
    }

    public void pushCarta(Carta carta) {

        estoque.push(carta);
    }

    public Carta popCarta() {

        return estoque.pop();
    }

    public Carta peekCarta() {

        return estoque.peek();
    }
    
    public boolean estaVazio() {
        return estoque.empty();
    }
    
    public int countCartas() {
        return estoque.size();
    }

    public void exibirEstoque() {
        for (Carta carta : estoque) {
            if (carta.getVisivel()) {
                System.out.printf(" %s %s", carta.getSimbolo(), carta.getNaipe().getTipo());
            } else {
                System.out.printf(" %s", carta.getSimbolo());
            }
            System.out.printf(" | ");
        }
    }
}
