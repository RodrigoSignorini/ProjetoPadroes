/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Stack;
import model.Carta;
import model.Fileira;

/**
 *
 * @author jvboa
 */
public class Mesa {

    private Stack<Carta> baralho;

    public Mesa(Stack<Carta> baralho) {
        this.baralho = baralho;
    }
    //Funcoes que estao na classe baralho deverao ser feitas aqui
    private Fileira[] fileiras = new Fileira[7];
    private Stack estoque = new Stack();

    public void iniciarFileiras() {
        System.out.println("\nIniciarFileiras");
        for (int i = 0; i < 7; i++) {
            Fileira fileira = new Fileira("Fileira:" + (i + 1));
//            System.out.println("\nFileira " + (i + 1));

            for (int j = 0; j < (i + 1); j++) {
                Carta novaCarta = this.baralho.pop();
                fileira.pushCarta(novaCarta);
//                System.out.printf("Carta: %s, Naipe: %s, Cor:%s, Simbolo:%s\n", novaCarta.getValor(), novaCarta.getNaipe().getTipo(), novaCarta.getNaipe().getCor(), novaCarta.getSimbolo());
            }
            Carta carta = fileira.popCarta();
            carta.setVisivel(true);
            carta.virarCarta(carta);
            fileira.pushCarta(carta);

            this.fileiras[i] = fileira;
        }

    }

    public void iniciarEstoque() {
        System.out.println("\nEstoque");

        for (int i = 0; i < 23; i++) {
            Carta cartaEstoque = this.baralho.pop();
            estoque.push(cartaEstoque);
//            System.out.printf("Carta: %s, Naipe: %s, Cor:%s\n", cartaEstoque.getValor(), cartaEstoque.getNaipe().getTipo(), cartaEstoque.getNaipe().getCor());

        }
    }

    public void exibirFileiras() {
        System.out.println("\nExibirFileiras");
        for (int i = 0; i < 7; i++) {
            System.out.printf("\nFileira " + (i + 1) + ":");
            fileiras[i].exibirFileira();
        }
    }

    public boolean moverCartas(int fileiraOrigem, int fileiraDestino) {

        if (fileiras[fileiraOrigem - 1].estaVazia()) {
            return false;
        } else {
            Carta cartaOrigem = fileiras[fileiraOrigem - 1].popCarta();
            fileiras[fileiraDestino - 1].pushCarta(cartaOrigem);
            
            //Muda o simbolo da carta na fileira de origem para o valor da mesma
            Carta cartaTopo = fileiras[fileiraOrigem - 1].peekCarta();
            cartaTopo.setVisivel(true);
            cartaTopo.virarCarta(cartaTopo);
//            fileiras[fileiraOrigem - 1].pushCarta(cartaTopo);
            return true;
        }

    }
}
