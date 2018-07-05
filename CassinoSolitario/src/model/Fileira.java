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
public class Fileira {

    private String nome;
    private Stack<Carta> fileira;

    public Fileira(String nome) {
        this.nome = nome;
        this.fileira = new Stack<>();
    }

    public void pushCarta(Carta carta) {

        fileira.push(carta);
    }

    public Carta popCarta() {

        return fileira.pop();
    }

    public Carta peekCarta() {

        return fileira.peek();
    }

    public void exibirFileira() {
        for (Carta carta : fileira) {
            
            if (carta.getVisivel()) {
                System.out.printf(" %s %s", carta.getSimbolo(), carta.getNaipe().getTipo());
            } else {
                System.out.printf(" %s", carta.getSimbolo());
            }
            System.out.printf(" | ");
        }
    }

    public void atualizarFileira() {
        if (!this.fileira.empty()) {
            //Muda o simbolo da carta na fileira de origem para o valor da mesma
            Carta cartaTopo = this.fileira.peek();
            cartaTopo.setVisivel(true);
            cartaTopo.virarCarta(cartaTopo);
        }
    }

    public boolean estaVazia() {
        return fileira.empty();
    }
}
