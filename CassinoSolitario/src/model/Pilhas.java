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
public class Pilhas {
    
    private Stack<Carta> pilha = new Stack();
    
    public void empilhar(Carta carta){
        
        pilha.push(carta);
    }
    
    public Carta desempilhar(){
        
        return (Carta) pilha.pop();
    }
}
