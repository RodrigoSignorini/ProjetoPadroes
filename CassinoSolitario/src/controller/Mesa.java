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
    private Fileira[] fileiras = new Fileira[7];
    private Fundacao[] fundacoes = new Fundacao[7];
    private Estoque estoque = new Estoque();
    private Descarte descarte = new Descarte();

    public void iniciarFileiras() {
        System.out.println(">> Iniciando Fileiras...");
        for (int i = 0; i < 7; i++) {
            Fileira fileira = new Fileira("Fileira:" + (i + 7));

            for (int j = 0; j < (i + 1); j++) {
                Carta novaCarta = this.baralho.pop();
                fileira.pushCarta(novaCarta);
            }
            Carta carta = fileira.peekCarta();
            carta.setVisivel(true);
            carta.virarCarta(carta);
            this.fileiras[i] = fileira;
        }
    }

    public void iniciarFundacoes() {
        System.out.println(">> Criando Fundacoes...");
        for (int i = 0; i < 4; i++) {
            Fundacao fundacao = new Fundacao("Fundacao:" + (i + 1));
            this.fundacoes[i] = fundacao;
        }
    }

    public void iniciarEstoque() {
        System.out.println(">> Criando Estoque...");
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
        System.out.printf("\n");
    }

    public void exibirFundacoes() {
        for (int i = 0; i < 4; i++) {
            System.out.printf("\n" + (i + 3) + " - Fundacao:");
            fundacoes[i].exibir();
        }
        System.out.printf("\n");
    }

    public void exibirFileiras() {
        for (int i = 0; i < 7; i++) {
            System.out.printf("\n" + (i + 7) + " - Fileira:");
            fileiras[i].exibirFileira();
        }
        System.out.printf("\n");
    }

    public String moverCartas(int origem, int destino) {
        if (!existePosicao(origem)) return "ORIGEM INVALIDA";
        if (!existePosicao(destino)) return "DESTINO INVALIDO";
        
        if (origem == destino) return "JOGADA INVALIDA";
                
        if (origem == 1) {//Se origem for estoque
            return "ERRO ESTOQUE";
        } else if (origem == 2) {//Se origem for descarte
            if (descarte.estaVazia()) {
                return "FILEIRA VAZIA";
            }
            //movendo do descarte para as fundacoes
            if (destino == 3 || destino == 4 || destino == 5 || destino == 6) {
                Carta cartaDescarte = descarte.popCarta();
                //atualizando o estoque
                Carta carta = this.estoque.popCarta();
                carta.setVisivel(true);
                carta.virarCarta(carta);
                this.descarte.pushCarta(carta);

                fundacoes[destino - 3].pushCarta(cartaDescarte);
                return "";
            } //movendo do descarte para as fileiras
            else if (destino == 7 || destino == 8 || destino == 9 || destino == 10
                    || destino == 11 || destino == 12 || destino == 13) {

                Carta cartaDescarte = descarte.popCarta();
                //atualizando o estoque
                Carta carta = this.estoque.popCarta();
                carta.setVisivel(true);
                carta.virarCarta(carta);
                this.descarte.pushCarta(carta);

                fileiras[destino - 7].pushCarta(cartaDescarte);
                return "";
            }

        } else if (origem == 7 || origem == 8 || origem == 9
                || origem == 10 || origem == 11 || origem == 12 || origem == 13) {
            if (fileiras[origem - 7].estaVazia()) {
                return "FILEIRA VAZIA";
            }
            if (destino == 3 || destino == 4 || destino == 5 || destino == 6) {
                Carta cartaFileira = fileiras[origem - 7].popCarta();
                fundacoes[destino - 3].pushCarta(cartaFileira);
                return "";
            } else if (destino== 7 || destino== 8 || destino== 9
                    || destino== 10 || destino== 11 || destino== 12 || destino == 13) {

                Carta cartaOrigem = fileiras[origem - 7].peekCarta();
                Carta cartaDestino = fileiras[destino - 7].peekCarta();

                if (verificarSequencia(cartaOrigem, cartaDestino)) {
                    cartaOrigem = fileiras[origem - 7].popCarta();

                    fileiras[destino - 7].pushCarta(cartaOrigem);
                    fileiras[origem - 7].atualizarFileira();
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
    
    public boolean existePosicao(int pos) {
        for (int i=1; i<14; i++) {
            if (pos == i) return true;
        }
        return false;
    }
}
