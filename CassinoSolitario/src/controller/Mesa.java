/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Stack;
import model.Carta;
import model.Estoque;
import model.Fileira;
import model.Fundacao;
import model.Descarte;

/**
 *
 * @author Gustavo e Jadson
 */
public class Mesa {

    private Stack<Carta> baralho;

    public Mesa(Stack<Carta> baralho) {
        this.baralho = baralho;
    }
    //Funcoes que estao na classe baralho deverao ser feitas aqui
    private Fileira[] fileiras = new Fileira[7];
    private Fundacao[] fundacoes = new Fundacao[7];
    private Estoque estoque = new Estoque();
    private Descarte descarte = new Descarte();

    public void iniciarFileiras() {
        System.out.println("\nIniciando Fileiras...");
        for (int i = 0; i < 7; i++) {
            Fileira fileira = new Fileira("Fileira:" + (i + 1));
//            System.out.println("\nFileira " + (i + 1));

            for (int j = 0; j < (i + 1); j++) {
                Carta novaCarta = this.baralho.pop();
                fileira.pushCarta(novaCarta);
//                System.out.printf("Carta: %s, Naipe: %s, Cor:%s, Simbolo:%s\n", novaCarta.getValor(), novaCarta.getNaipe().getTipo(), novaCarta.getNaipe().getCor(), novaCarta.getSimbolo());
            }
            Carta carta = fileira.peekCarta();
            carta.setVisivel(true);
            carta.virarCarta(carta);
            this.fileiras[i] = fileira;
        }

    }

    public void iniciarFundacoes() {
        System.out.println("\nFundacoes");
        for (int i = 0; i < 4; i++) {
            Fundacao fundacao = new Fundacao("Fundacao:" + (i + 1));
            this.fundacoes[i] = fundacao;
        }
    }

    public void iniciarEstoque() {
        System.out.println("\nEstoque");
        for (int i = 0; i < 23; i++) {

            Carta cartaEstoque = this.baralho.pop();
            this.estoque.pushCarta(cartaEstoque);
        }

        Carta carta = this.estoque.popCarta();
        carta.setVisivel(true);
        carta.virarCarta(carta);
        this.descarte.pushCarta(carta);
        Carta carta2 = this.estoque.popCarta();
        carta2.setVisivel(true);
        carta.virarCarta(carta2);
        this.descarte.pushCarta(carta2);
        Carta carta3 = this.estoque.popCarta();
        carta3.setVisivel(true);
        carta.virarCarta(carta3);
        this.descarte.pushCarta(carta3);

        System.out.printf("\n");
    }

    public void exibirEstoque() {
        System.out.printf("\nEstoque: ");
        this.estoque.exibirEstoque();
    }

    public void exibirDescarte(int escolha) {
        System.out.printf("\nDescarte: ");
        this.descarte.exibir(escolha);
    }

    public void exibirFileiras() {
        //System.out.println("\nExibirFileiras");
        for (int i = 0; i < 7; i++) {
            System.out.printf("\nFileira " + (i + 1) + ":");
            fileiras[i].exibirFileira();
        }
        System.out.printf("\n");
    }

    public boolean moverCartas(int fileiraOrigem, int fileiraDestino) {

        if (fileiras[fileiraOrigem - 1].estaVazia()) {
            return false;
        } else {
            Carta cartaOrigem = fileiras[fileiraOrigem - 1].popCarta();
            fileiras[fileiraDestino - 1].pushCarta(cartaOrigem);
            fileiras[fileiraOrigem - 1].atualizarFileira();
            return true;
        }

    }
}
