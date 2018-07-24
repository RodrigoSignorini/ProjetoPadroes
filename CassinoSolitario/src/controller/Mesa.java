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

    public void iniciarEstoque(int qtdCartas) {
        System.out.println(">> Criando Estoque...");
        for (int i = 0; i < 23; i++) {
            Carta cartaEstoque = this.baralho.pop();
            this.estoque.pushCarta(cartaEstoque);
        }
        Carta carta = this.estoque.popCarta();
        carta.setVisivel(true);
        carta.virarCarta(carta);
        this.descarte.pushCarta(carta);

        if (qtdCartas == 3) {
            Carta carta2 = this.estoque.popCarta();
            carta2.setVisivel(true);
            carta.virarCarta(carta2);
            this.descarte.pushCarta(carta2);

            Carta carta3 = this.estoque.popCarta();
            carta3.setVisivel(true);
            carta.virarCarta(carta3);
            this.descarte.pushCarta(carta3);
        }
    }

    public void iniciarJogo(int qtdCartas) {
        iniciarFileiras();
        iniciarEstoque(qtdCartas);
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
        if (this.estoque.countCartas() > 0) {
            System.out.printf("[" + this.estoque.countCartas() + " carta(s)]\n");
        } else {
            System.out.printf("[VAZIO]\n");
        }
        this.estoque.exibirEstoque();
    }

    public void exibirDescarte(int escolha) {
        System.out.printf("\n2 - Descarte: ");
        if (this.descarte.countCartas() > 0) {
            System.out.printf("[" + this.descarte.countCartas() + " carta(s)]\n");
        } else {
            System.out.printf("[VAZIO]\n");
        }
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

    public String moverCartas(int origem, int destino, int escolhaQtdCartas) {
        if (!existePosicao(origem)) {
            return "ORIGEM INVALIDA";
        }
        if (!existePosicao(destino)) {
            return "DESTINO INVALIDO";
        }

        if (origem == destino) {
            return "JOGADA INVALIDA";
        }

        if (origem == 1) {//Se origem for estoque
            if (destino != 2) {
                return "DESTINO INVALIDO"; //Destino só pode ser descarte
            }
            if (estoque.estaVazio()) {
                //Se descarte for maior que a quantidade de cartas pra estoque,
                //o estoque é restaurado
                if (descarte.countCartas() > escolhaQtdCartas) {
                    Descarte aux = new Descarte();
                    int tam1 = descarte.countCartas();
                    for (int j = 0; j < tam1; j++) {
                        Carta card = descarte.popCarta();
                        aux.pushCarta(card);
                    }
                    int tam2 = aux.countCartas();
                    for (int j = 0; j < tam2; j++) {
                        Carta card = aux.popCarta();
                        estoque.pushCarta(card);
                    }
                    descarte.pushCarta(estoque.popCarta());
                    return "";
                } else {
                    return "ESTOQUE VAZIO";
                }
            } else {
                //Pega carta do estoque e deixa visivel
                Carta cartaOn = this.estoque.popCarta();
                cartaOn.setVisivel(true);
                cartaOn.virarCarta(cartaOn);
                //Verifica descarte
                //Se descarte estiver vazio recebe a carta do estoque
                if (descarte.estaVazia()) {
                    descarte.pushCarta(cartaOn);
                } else {
                    //Se descarte não estiver vazio
                    if(escolhaQtdCartas == 1) {
                        Carta cartaOff = this.descarte.popCarta();
                        cartaOff.setVisivel(false);
                        cartaOff.virarCarta(cartaOff);
                        descarte.pushCarta(cartaOff);
                        descarte.pushCarta(cartaOn);
                    } else {
                        int tam = descarte.countCartas();
                        Descarte auxDescarte = new Descarte();
                        for (int i=0; i<tam; i++){
                            auxDescarte.pushCarta(descarte.popCarta());
                        }
                        Carta cartaOff = auxDescarte.popCarta();
                        cartaOff.setVisivel(false);
                        cartaOff.virarCarta(cartaOff);
                        descarte.pushCarta(cartaOff);
                        int tam2 = auxDescarte.countCartas();
                        for (int i=0; i<tam2; i++){
                            descarte.pushCarta(auxDescarte.popCarta());
                        }
                        descarte.pushCarta(cartaOn);
                    }
                }
                return "";
            }
        } else if (origem == 2) {//Se origem for descarte
            if (destino == 1) {
                return "DESTINO INVALIDO";
            }
            if (descarte.estaVazia()) {
                return "FILEIRA VAZIA";
            }
            //movendo do descarte para as fundacoes
            if (destino == 3 || destino == 4 || destino == 5 || destino == 6) {
                if (fundacoes[destino - 3].estaVazia()) {
                    if (descarte.peekCarta().getValorNumerico() != 1) {
                        return "FUNDACAO VAZIA SO ACEITA ASES";
                    }
                } else {//Se fundacao nao estiver vazia
                    Carta cartaOrigem = descarte.peekCarta();
                    Carta cartaDestino = fundacoes[destino - 3].peekCarta();
                    if (!verificarSequenciaFundacao(cartaOrigem, cartaDestino)) {
                        return "SEQUENCIA INVALIDA";
                    }
                }
                Carta cartaDescarte = descarte.popCarta();
                //atualizando o estoque
                if (!estoque.estaVazio()) {
                    Carta carta = this.estoque.popCarta();
                    carta.setVisivel(true);
                    carta.virarCarta(carta);
                    this.descarte.pushCarta(carta);
                }
                fundacoes[destino - 3].pushCarta(cartaDescarte);
                return "";
            } //movendo do descarte para as fileiras
            else if (destino == 7 || destino == 8 || destino == 9 || destino == 10
                    || destino == 11 || destino == 12 || destino == 13) {
                //Verificar fileira
                if (fileiras[destino - 7].estaVazia()) {
                    if (descarte.peekCarta().getValorNumerico() != 13) {
                        return "FILEIRA VAZIA SO ACEITA K (REIS)";
                    }
                } else {
                    Carta cartaOrigem = descarte.peekCarta();
                    Carta cartaDestino = fileiras[destino - 7].peekCarta();
                    if (!verificarSequencia(cartaOrigem, cartaDestino)) {
                        return "SEQUENCIA INVALIDA";
                    }
                }
                Carta cartaDescarte = descarte.popCarta();
                //atualizando o estoque
                if (!estoque.estaVazio()) {
                    Carta carta = this.estoque.popCarta();
                    carta.setVisivel(true);
                    carta.virarCarta(carta);
                    this.descarte.pushCarta(carta);
                }
                fileiras[destino - 7].pushCarta(cartaDescarte);
                return "";
            }
        //Se origem for fileiras
        } else if (origem == 7 || origem == 8 || origem == 9
                || origem == 10 || origem == 11 || origem == 12 || origem == 13) {
            if (destino == 1 || destino == 2) {
                return "DESTINO INVALIDO";
            }
            if (fileiras[origem - 7].estaVazia()) {
                return "FILEIRA VAZIA";
            }//destino for fundacao
            if (destino == 3 || destino == 4 || destino == 5 || destino == 6) {
                if (fundacoes[destino - 3].estaVazia()) {
                    if (fileiras[origem - 7].peekCarta().getValorNumerico() != 1) {
                        return "FUNDACAO VAZIA SO ACEITA ASES";
                    }
                } else {//Se fundacao nao estiver vazia
                    Carta cartaOrigem = fileiras[origem - 7].peekCarta();
                    Carta cartaDestino = fundacoes[destino - 3].peekCarta();
                    if (!verificarSequenciaFundacao(cartaOrigem, cartaDestino)) {
                        return "SEQUENCIA INVALIDA";
                    }
                }
                Carta cartaFileira = fileiras[origem - 7].popCarta();
                fundacoes[destino - 3].pushCarta(cartaFileira);
                fileiras[origem - 7].atualizarFileira();
                return "";
                //destino for fileira
            } else if (destino == 7 || destino == 8 || destino == 9
                    || destino == 10 || destino == 11 || destino == 12 || destino == 13) {
                Carta cartaOrigem = fileiras[origem - 7].peekCarta();
                Carta cartaDestino = fileiras[destino - 7].peekCarta();
                if (verificarSequencia(cartaOrigem, cartaDestino)) {
                    cartaOrigem = fileiras[origem - 7].popCarta();
                    fileiras[destino - 7].pushCarta(cartaOrigem);
                    fileiras[origem - 7].atualizarFileira();
                    return "";
                } else {
                    return "SEQUENCIA INVALIDA";
                }
            }
        //Se origem for fundação
        } else if(origem == 3 || origem == 4 || origem == 5 || origem == 6) {
            if (destino == 1 || destino == 2) {
                return "DESTINO INVALIDO"; //Destino só pode ser fileira
            }
            //Verificar fileira
            if (fileiras[destino - 7].estaVazia()) {
                if (fundacoes[origem - 3].peekCarta().getValorNumerico() != 13) {
                    return "FILEIRA VAZIA SO ACEITA K (REIS)";
                }
            } else {
                Carta cartaOrigem = fundacoes[origem - 3].peekCarta();
                Carta cartaDestino = fileiras[destino - 7].peekCarta();
                if (!verificarSequencia(cartaOrigem, cartaDestino)) {
                    return "SEQUENCIA INVALIDA";
                }
            }
            Carta cartaFundacao = fundacoes[origem - 3].popCarta();
            fileiras[destino - 7].pushCarta(cartaFundacao);
            return "";
        }
        return "404 - NAO PASSOU NAS CONDICOES";
    }

    public String moverConjuntoDeCartas(int origem, int destino) {
        if (!existePosicao(origem)) {
            return "ORIGEM INVALIDA";
        }
        else if (!existePosicao(destino)) {
            return "DESTINO INVALIDO";
        }
        else if (origem == destino) {
            return "JOGADA INVALIDA";
        }
        else if (origem == 1 || origem == 2 || origem == 3 || origem == 4 || origem == 5 || origem == 6) {
            return "ORIGEM INVALIDA";
        }
        else if (destino == 1 || destino == 2 || destino == 3 || destino == 4 || destino == 5 || destino == 6) {
            return "DESTINO INVALIDO";
        }
        else if (fileiras[origem - 7].estaVazia()) {
            return "FILEIRA VAZIA";
        }
        else {
            Fileira fileiraAux = new Fileira("aux");
            int tam = fileiras[origem-7].countCartas();
            for (int i=0; i<tam; i++){
                if(fileiras[origem-7].peekCarta().getVisivel()){
                    fileiraAux.pushCarta(fileiras[origem-7].popCarta());
                } else {
                    break;
                }
            }
            if (!fileiraAux.estaVazia()) {
                int tam2 = fileiraAux.countCartas();
                for (int j=0; j<tam2; j++){
                    if (fileiras[destino-7].estaVazia()){
                        if (fileiraAux.peekCarta().getValorNumerico() == 13){
                            fileiras[destino-7].pushCarta(fileiraAux.popCarta());
                        } else {
                            return "FILEIRA VAZIA SO ACEITA K (REIS)";
                        }
                    } else if (fileiras[destino-7].peekCarta().getValorNumerico() == (fileiraAux.peekCarta().getValorNumerico()+1) &&
                                !fileiraAux.peekCarta().getNaipe().getCor().equals(fileiras[destino-7].peekCarta().getNaipe().getCor())) {
                        fileiras[destino-7].pushCarta(fileiraAux.popCarta());
                    } else {
                        return "SEQUENCIA INVALIDA";
                    }
                }
                fileiras[origem-7].atualizarFileira();
                return "";
            }
        }
        
        return "404 - NAO PASSOU NAS CONDICOES";
    }

    public boolean verificarSequencia(Carta cartaOrigem, Carta cartaDestino) {
        //Verifica a sequencia de cartas entre FILEIRAS
        if ((cartaOrigem.getValorNumerico() + 1) == cartaDestino.getValorNumerico()
                && !cartaOrigem.getNaipe().getCor().equals(cartaDestino.getNaipe().getCor())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verificarSequenciaFundacao(Carta cartaOrigem, Carta cartaDestino) {
        //Verifica a sequencia de cartas entre FUNDACOES
        System.out.println(cartaOrigem.getValorNumerico());
        System.out.println(cartaDestino.getValorNumerico());
        if ((cartaOrigem.getValorNumerico() - 1) == cartaDestino.getValorNumerico()
                && cartaOrigem.getNaipe().getTipo().equals(cartaDestino.getNaipe().getTipo())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean existePosicao(int pos) {
        for (int i = 1; i < 14; i++) {
            if (pos == i) {
                return true;
            }
        }
        return false;
    }
    
    public boolean verificaVitoria() {
        if((fundacoes[0].countCartas() + fundacoes[1].countCartas() +
                fundacoes[2].countCartas() + fundacoes[3].countCartas()) == 52){
            return true;
        }
      return false;
    };
}
