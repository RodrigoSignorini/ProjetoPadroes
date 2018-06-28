/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Stack;

/**
 *
 * @author aluno
 */
public class PilhaFileira extends Pilhas{

    private String nome;

    public PilhaFileira(String nome) {
        this.nome = nome;
    }

    @Override
    public void empilhar(Carta carta) {
        super.empilhar(carta);
    }

    @Override
    public void desempilhar(Carta carta) {
        super.desempilhar(carta);
    }

}
