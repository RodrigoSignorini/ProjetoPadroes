/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Gustavo e Jadson
 */
public class Naipe {

    private String cor;
    private String tipo;

    public Naipe(String cor, String tipo) {
        this.cor = cor;
        this.tipo = tipo;
    }

    public String getCor() {
        return cor;
    }

    public String getTipo() {
        return tipo;
    }
}
