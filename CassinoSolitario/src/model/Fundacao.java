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
public class Fundacao {
    private String nome;
    private Stack<Carta> fundacao;
    
    public Fundacao (String nome) {
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
}
