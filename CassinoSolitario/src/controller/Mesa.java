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
            Fileira fileira = new Fileira("Fileira:" + (i + 7));
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
        System.out.println("Fundacoes");
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

    public void iniciarJogo() {
        iniciarFileiras();
        iniciarEstoque();
        iniciarFundacoes();

    }

    public void exibirJogo(int escolhaQtdCartas) {
        exibirEstoque();
        exibirDescarte(escolhaQtdCartas);
        exibirFundacoes();
        exibirFileiras();
    }

    public void exibirEstoque() {
        System.out.printf("\n1 - Estoque: ");
        this.estoque.exibirEstoque();
    }

    public void exibirDescarte(int escolha) {
        System.out.printf("\n2 - Descarte: ");
        this.descarte.exibir(escolha);
    }

    public void exibirFundacoes() {

        for (int i = 0; i < 4; i++) {
            System.out.printf("\n" + (i + 3) + " - Fundacao:");
            fundacoes[i].exibir();
        }
        System.out.printf("\n");
    }

    public void exibirFileiras() {
        //System.out.println("\nExibirFileiras");
        for (int i = 0; i < 7; i++) {
            System.out.printf("\n" + (i + 7) + " - Fileira:");
            fileiras[i].exibirFileira();
        }
        System.out.printf("\n");
    }

    public String moverCartas(int fileiraOrigem, int fileiraDestino) {
        if (fileiraOrigem == 1) {
            return "ERRO ESTOQUE";
        } else if (fileiraOrigem == 2) {
            if (descarte.estaVazia()) {
                return "FILEIRA VAZIA";
            }
            //movendo do descarte para as fundacoes
            if (fileiraDestino == 3 || fileiraDestino == 4 || fileiraDestino == 5 || fileiraDestino == 6) {
                Carta cartaDescarte = descarte.popCarta();
                //atualizando o estoque
                Carta carta = this.estoque.popCarta();
                carta.setVisivel(true);
                carta.virarCarta(carta);
                this.descarte.pushCarta(carta);

                fundacoes[fileiraDestino - 3].pushCarta(cartaDescarte);
                return "";
            } //movendo do descarte para as fileiras
            else if (fileiraDestino == 7 || fileiraDestino == 8 || fileiraDestino == 9 || fileiraDestino == 10 || fileiraDestino == 11 || fileiraDestino == 12 || fileiraDestino == 13) {

                Carta cartaDescarte = descarte.popCarta();
                //atualizando o estoque
                Carta carta = this.estoque.popCarta();
                carta.setVisivel(true);
                carta.virarCarta(carta);
                this.descarte.pushCarta(carta);

                fileiras[fileiraDestino - 7].pushCarta(cartaDescarte);
                return "";
            }

        } else if (fileiraOrigem == 7 || fileiraOrigem == 8 || fileiraOrigem == 9
                || fileiraOrigem == 10 || fileiraOrigem == 11 || fileiraOrigem == 12 || fileiraOrigem == 13) {
            if (fileiras[fileiraOrigem - 7].estaVazia()) {
                return "FILEIRA VAZIA";
            }
            if (fileiraDestino == 3 || fileiraDestino == 4 || fileiraDestino == 5 || fileiraDestino == 6) {
                Carta cartaFileira = fileiras[fileiraOrigem - 7].popCarta();
                fundacoes[fileiraDestino - 3].pushCarta(cartaFileira);
                return "";
            } else if (fileiraDestino== 7 || fileiraDestino== 8 || fileiraDestino== 9
                    || fileiraDestino== 10 || fileiraDestino== 11 || fileiraDestino== 12 || fileiraDestino == 13) {

                Carta cartaOrigem = fileiras[fileiraOrigem - 7].peekCarta();
                Carta cartaDestino = fileiras[fileiraDestino - 7].peekCarta();

                if (verificarSequencia(cartaOrigem, cartaDestino)) {
                    cartaOrigem = fileiras[fileiraOrigem - 7].popCarta();

                    fileiras[fileiraDestino - 7].pushCarta(cartaOrigem);
                    fileiras[fileiraOrigem - 7].atualizarFileira();
                    return "";
                } else {

                    return "SEQ INV";
                }
            }
        }
        return "ERRO";
    }

    public boolean verificarSequencia(Carta cartaOrigem, Carta cartaDestino) {
        //Verifica a sequencia de cartas entre FILEIRAS
        if ((cartaOrigem.getValorNumerico() + 1) == cartaDestino.getValorNumerico()
                && !cartaOrigem.getNaipe().getCor().equals(cartaDestino.getNaipe().getCor())) {
            System.out.println("\nSequencia Valida.");
            return true;
        } else {
            return false;
        }
    }
}
