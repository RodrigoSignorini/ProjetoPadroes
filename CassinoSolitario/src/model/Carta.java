/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jvboa
 */
public class Carta {

    private final Naipe naipe;
    private String valor;
    private String simbolo;
    private boolean isVisible;

    public Carta(String valor, Naipe naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    public Naipe getNaipe() {
        return naipe;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public boolean isIsVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public void virarCarta(Carta carta) {
        
        if (carta.isVisible) {
            carta.setSimbolo("[<>]");
        } else {
            carta.setSimbolo(carta.getValor());
        }
        
    }
}
