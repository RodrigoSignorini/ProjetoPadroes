/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Collections;
import java.util.Stack;

/**
 *
 * @author jvboa
 */
public class Baralho {

    private Stack<Carta> baralho;

    private PilhaFileira[] fileiras = new PilhaFileira[7];
    private Stack estoque = new Stack();

    public Naipe[] naipes = {
        new Naipe("VERMELHO", "COPAS"),
        new Naipe("VERMELHO", "OURO"),
        new Naipe("PRETO", "ESPADA"),
        new Naipe("PRETO", "PAUS"),};

    public Baralho() {
        this.baralho = new Stack<>();
    }

    public void criarCartas() {
        System.out.println("Criando cartas...\n");
        for (int numCard = 1; numCard < 14; numCard++) {
            for (Naipe naipe : naipes) {
                Carta novaCarta = new Carta("", naipe);

                switch (numCard) {
                    case 1:
                        novaCarta.setValor("A");
                        break;
                    case 11:
                        novaCarta.setValor("J");
                        break;
                    case 12:
                        novaCarta.setValor("Q");
                        break;
                    case 13:
                        novaCarta.setValor("K");
                        break;
                    default:
                        novaCarta.setValor("" + numCard);
                        break;
                }
//                System.out.printf("Carta: %s, Naipe: %s, Cor:%s\n", novaCarta.getValor(), novaCarta.getNaipe().getTipo(), novaCarta.getNaipe().getCor()); 
                baralho.push(novaCarta);
            }
        }
//        System.out.println("\n");
    }

    public void embaralhar() {
        System.out.println("Embaralhando cartas...\n");
        Collections.shuffle(baralho);
        baralho.forEach((carta) -> {
//            System.out.printf("Carta: %s, Naipe: %s, Cor:%s\n", carta.getValor(), carta.getNaipe().getTipo(), carta.getNaipe().getCor());
        });
    }

    public Carta removerCartaTop() {
        Carta card = baralho.pop();
        return card;
    }

    public Stack<Carta> getBaralho() {
        return baralho;

    }

    public void iniciarFileiras() {
        System.out.println("\nIniciarFileiras\n");
        for (int i = 0; i < 7; i++) {
            PilhaFileira pilha = new PilhaFileira("Fileira:" + (i + 1));
            System.out.println("\nFileira " + (i + 1));
            // Retira do baralho e receberNo nas listas de cartas
            for (int j = 0; j < (i + 1); j++) {
                Carta novaCarta = this.baralho.pop();
                pilha.empilhar(novaCarta);
                System.out.printf("Carta: %s, Naipe: %s, Cor:%s\n", novaCarta.getValor(), novaCarta.getNaipe().getTipo(), novaCarta.getNaipe().getCor());
            }
            this.fileiras[i] = pilha;
        }
    }

    public void iniciarEstoque() {
        System.out.println("\nEstoque\n ");

        for (int i = 0; i < 23; i++) {
            Carta cartaEstoque = this.baralho.pop();
            estoque.push(cartaEstoque);
            System.out.printf("Carta: %s, Naipe: %s, Cor:%s\n", cartaEstoque.getValor(), cartaEstoque.getNaipe().getTipo(), cartaEstoque.getNaipe().getCor());

        }
        
        
    }
}
