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
public class Fundacao {

    private String nome;
    private Stack<Carta> fundacao;

    public Fundacao(String nome) {
        this.nome = nome;
        this.fundacao = new Stack<>();
    }

    public void pushCarta(Carta carta) {

        fundacao.push(carta);
    }

    public Carta popCarta() {

        return fundacao.pop();
    }

    public Carta peekCarta() {

        return fundacao.peek();
    }

    public void exibir() {
        for (Carta carta : fundacao) {

            if (carta.getVisivel()) {
                System.out.printf(" %s %s", carta.getSimbolo(), carta.getNaipe().getTipo());
            } else {
                System.out.printf(" %s", carta.getSimbolo());
            }
            System.out.printf(" | ");
        }
    }

    public void atualizarFundacao() {
        if (!this.fundacao.empty()) {
            //Muda o simbolo da carta na fileira de origem para o valor da mesma
            Carta cartaTopo = this.fundacao.peek();
            cartaTopo.setVisivel(true);
            cartaTopo.virarCarta(cartaTopo);
        }
    }
}
