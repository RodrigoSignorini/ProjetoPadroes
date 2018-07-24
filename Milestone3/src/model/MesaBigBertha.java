/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Stack;

/**
 *
 * @author gboan
 */
public class MesaBigBertha {

    private final Stack<Carta>[] fundacoes;
    private final Stack<Carta>[] fileiras;
    private final Stack<Carta> estoque;
    private final Stack<Carta> descarte;
    private int qtdEstoque;

    /**
     * Construtor.
     */
    public MesaBigBertha() {
        this.fundacoes = new Stack[9];
        this.fileiras = new Stack[15];

        this.criarPilhas();

        this.estoque = new Baralho().getBaralho(2);

        this.descarte = new Stack<>();

        this.qtdEstoque = 1;

        this.distribuirJogo(estoque);
    }

    /**
     * Método que cria as pilhas de cartas necessárias para uma partida.
     */
    private void criarPilhas() {
        for (int i = 0; i < 9; i++) {
            fundacoes[i] = new Stack<>();
        }
        for (int i = 0; i < 15; i++) {
            fileiras[i] = new Stack<>();
        }
    }

    /**
     * Método responsável por distribuir as cartas do baralho para o estado
     * inicial do jogo.
     *
     * @param baralho
     */
    private void distribuirJogo(Stack<Carta> baralho) {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 6; j++) {
                Carta c = baralho.pop();
                c.mostrarCarta();
                fileiras[i].push(c);
            }
        }

    }

    /**
     * Método que retorna o estado atual da pilha de estoque.
     *
     * @return
     */
    public String getEstoque() {
        String nome = "";
        int aux = 0;
        for (Carta c : estoque) {
            c.mostrarCarta();
            nome += c.toString() + "Pos:" + aux + " | ";
            aux++;
        }

        return nome;
    }

    /**
     * Método que retorna o estado atual da pilha de descarte.
     *
     * @return
     */
    public String getDescarte() {
        String topo = "";

        if (descarte.empty()) {
            return "";
        } else {
            if (qtdEstoque == 1) {
                return descarte.peek().toString();
            } else {
                Stack<Carta> aux = new Stack<>();
                aux.addAll(descarte);

                for (int i = 0; i < 3; i++) {
                    if (!aux.empty()) {
                        topo += aux.pop();
                    }
                }
                return topo;
            }
        }
    }

    /**
     * Método que retorna o estado atual da primeira fundação de cartas.
     *
     * @return
     */
    public String getFundacao1() {
        if (fundacoes[0].empty()) {
            return "";
        } else {
            return fundacoes[0].peek().toString();
        }
    }

    /**
     * Método que retorna o estado atual da segunda fundação de cartas.
     *
     * @return
     */
    public String getFundacao2() {
        if (fundacoes[1].empty()) {
            return "";
        } else {
            return fundacoes[1].peek().toString();
        }
    }

    /**
     * Método que retorna o estado atual da terceira fundação de cartas.
     *
     * @return
     */
    public String getFundacao3() {
        if (fundacoes[2].empty()) {
            return "";
        } else {
            return fundacoes[2].peek().toString();
        }
    }

    /**
     * Método que retorna o estado atual da quarta fundação de cartas.
     *
     * @return
     */
    public String getFundacao4() {
        if (fundacoes[3].empty()) {
            return "";
        } else {
            return fundacoes[3].peek().toString();
        }
    }

    public String getFundacao5() {
        if (fundacoes[4].empty()) {
            return "";
        } else {
            return fundacoes[4].peek().toString();
        }
    }

    public String getFundacao6() {
        if (fundacoes[5].empty()) {
            return "";
        } else {
            return fundacoes[5].peek().toString();
        }
    }

    public String getFundacao7() {
        if (fundacoes[6].empty()) {
            return "";
        } else {
            return fundacoes[6].peek().toString();
        }
    }

    public String getFundacao8() {
        if (fundacoes[7].empty()) {
            return "";
        } else {
            return fundacoes[7].peek().toString();
        }
    }

    public String getFundacaoK() {
        if (fundacoes[8].empty()) {
            return "";
        } else {
            return fundacoes[8].peek().toString();
        }
    }

    /**
     * Método que retorna o estado atual da primeira pilha de cartas.
     *
     * @return
     */
    public String getPilhaA() {
        String pilha = "";

        for (Carta c : fileiras[0]) {
            pilha += c.toString();
        }

        return pilha;
    }

    /**
     * Método que retorna o estado atual da segunda pilha de cartas.
     *
     * @return
     */
    public String getPilhaB() {
        String pilha = "";

        for (Carta c : fileiras[1]) {
            pilha += c.toString();
        }

        return pilha;
    }

    /**
     * Método que retorna o estado atual da terceira pilha de cartas.
     *
     * @return
     */
    public String getPilhaC() {
        String pilha = "";

        for (Carta c : fileiras[2]) {
            pilha += c.toString();
        }

        return pilha;
    }

    /**
     * Método que retorna o estado atual da quarta pilha de cartas.
     *
     * @return
     */
    public String getPilhaD() {
        String pilha = "";

        for (Carta c : fileiras[3]) {
            pilha += c.toString();
        }

        return pilha;
    }

    /**
     * Método que retorna o estado atual da quinta pilha de cartas.
     *
     * @return
     */
    public String getPilhaE() {
        String pilha = "";

        for (Carta c : fileiras[4]) {
            pilha += c.toString();
        }

        return pilha;
    }

    /**
     * Método que retorna o estado atual da sexta pilha de cartas.
     *
     * @return
     */
    public String getPilhaF() {
        String pilha = "";

        for (Carta c : fileiras[5]) {
            pilha += c.toString();
        }

        return pilha;
    }

    /**
     * Método que retorna o estado atual da sétima pilha de cartas.
     *
     * @return
     */
    public String getPilhaG() {
        String pilha = "";

        for (Carta c : fileiras[6]) {
            pilha += c.toString();
        }

        return pilha;
    }

    public String getPilhaH() {
        String pilha = "";

        for (Carta c : fileiras[7]) {
            pilha += c.toString();
        }

        return pilha;
    }

    public String getPilhaI() {
        String pilha = "";

        for (Carta c : fileiras[8]) {
            pilha += c.toString();
        }

        return pilha;
    }

    public String getPilhaJ() {
        String pilha = "";

        for (Carta c : fileiras[9]) {
            pilha += c.toString();
        }

        return pilha;
    }

    public String getPilhaK() {
        String pilha = "";

        for (Carta c : fileiras[10]) {
            pilha += c.toString();
        }

        return pilha;
    }

    public String getPilhaL() {
        String pilha = "";

        for (Carta c : fileiras[11]) {
            pilha += c.toString();
        }

        return pilha;
    }

    public String getPilhaM() {
        String pilha = "";

        for (Carta c : fileiras[12]) {
            pilha += c.toString();
        }

        return pilha;
    }

    public String getPilhaN() {
        String pilha = "";

        for (Carta c : fileiras[13]) {
            pilha += c.toString();
        }

        return pilha;
    }

    public String getPilhaO() {
        String pilha = "";

        for (Carta c : fileiras[14]) {
            pilha += c.toString();
        }

        return pilha;
    }

    /**
     * Método que analisa o pedido de movimento de cartas e direciona para o
     * método adequado.
     *
     * @param origem (pilha de origem)
     * @param destino (pilha de destino)
     * @param qtdCartas (quantidade de cartas à serem movidas)
     */
    public void mover(int origem, int destino, int qtdCartas, int posicaoCarta) {
        if (origem == 1) {
            estoqueParaFundacao(destino, qtdCartas, posicaoCarta);
        } else if (origem == 2 || origem == 3 || origem == 4 || origem == 5 || origem == 6 || origem == 7
                || origem == 8 || origem == 9 || origem == 10) {
            fundacoesParaFileiras(origem, destino, qtdCartas);
        } else if (origem == 11 || origem == 12 || origem == 13 || origem == 14 || origem == 15 || origem == 16
                || origem == 17 || origem == 18 || origem == 19 || origem == 20 || origem == 21 || origem == 22 || origem == 23
                || origem == 24 || origem == 25) {
            if (destino == 2 || destino == 3 || destino == 4 || destino == 5 || destino == 6 || destino == 7
                    || destino == 8 || destino == 9 || origem == 10) {
                fileirasParaFundacoes(origem, destino, qtdCartas);
            } else {
                fileirasParaFileiras(origem, destino, qtdCartas);
            }
        }
    }

    /**
     * Método que move cartas da pilha de descarte para as pilhas de fundação.
     *
     * @param destino (pilha de destino)
     * @param qtd (quantidade de cartas)
     */
    private void estoqueParaFundacao(int destino, int qtd, int posicaoCarta) {
        if (qtd > 1) {
            System.out.println("\n SÓ É POSSÍVEL MOVER UMA CARTA DA PILHA DE ESTOQUE!");
        } else {
            if (destino == 2 || destino == 3 || destino == 4 || destino == 5 || destino == 6 || destino == 7 || destino == 8 || destino == 9) {
                if (fundacoes[destino - 2].empty()) {
                    if (!estoque.empty()) {
                        if (estoque.get(posicaoCarta).getNum() == 1) {
                            fundacoes[destino - 2].push(estoque.remove(posicaoCarta));
                        } else {
                            System.out.println("\n MOVIMENTO PROIBIDO! A BASE DAS FUNDAÇÕES SÃO FORMADAS POR ÁSES!");
                        }
                    } else {
                        System.out.println("\n NÃO HÁ CARTAS NA PILHA DE ESTOQUE!");
                    }
                } else {
                    if (!estoque.empty()) {
                        if (estoque.get(posicaoCarta).getNaipe().equals(fundacoes[destino - 2].peek().getNaipe())) {
                            if ((estoque.get(posicaoCarta).getNum() - fundacoes[destino - 2].peek().getNum()) == 1) {
                                fundacoes[destino - 2].push(estoque.remove(posicaoCarta));
                            } else {
                                System.out.println("\n MOVIMENTO PROIBIDO! CARTA INVÁLIDA!");
                            }
                        } else {
                            System.out.println("\n MOVIMENTO PROIBIDO! NAIPES DIFERENTES!");
                        }
                    } else {
                        System.out.println("\n NÃO HÁ CARTAS NA PILHA DE DESCARTE!");
                    }
                }
//            } else {
//                    System.out.println("\n MOVIMENTO PROIBIDO! A BASE DA FUNDAÇAO 10 É FORMADA POR REIS!");
//                }
            } else {
                estoqueParaFileira(destino, qtd, posicaoCarta);
            }
        }
    }

    /**
     * Método que move cartas da pilha de descarte para as fileiras.
     *
     * @param destino (pilha de destino)
     * @param qtd (quantidade de cartas)
     */
    private void estoqueParaFileira(int destino, int qtd, int posicaoCarta) {
        if (qtd > 1) {
            System.out.println("\n SÓ É POSSÍVEL MOVER UMA CARTA DA PILHA DE DESCARTE!");
        } else {
            if (destino == 11 || destino == 12 || destino == 13 || destino == 14 || destino == 15 || destino == 16 || destino == 17
                    || destino == 18 || destino == 19 || destino == 20 || destino == 21 || destino == 22 || destino == 23 || destino == 24 || destino == 25) {
                if (fileiras[destino - 11].empty()) {
                    if (!estoque.empty()) {
                        if (estoque.get(posicaoCarta).getNum() == 13) {
                            fileiras[destino - 11].push(estoque.remove(posicaoCarta));
                        } else {
                            System.out.println("\n MOVIMENTO PROIBIDO! A BASE DAS FILEIRAS SÃO FORMADAS POR REIS!");
                        }
                    } else {
                        System.out.println("\n NÃO HÁ CARTAS NA PILHA DE ESTOQUE!");
                    }
                } else {
                    if (!estoque.empty()) {
                        if (!estoque.get(posicaoCarta).getCor().equals(fileiras[destino - 11].peek().getCor())) {
                            if ((fileiras[destino - 11].peek().getNum() - estoque.get(posicaoCarta).getNum()) == 1) {
                                fileiras[destino - 11].push(estoque.remove(posicaoCarta));
                            } else {
                                System.out.println("\n MOVIMENTO PROIBIDO! CARTA INVÁLIDA!");
                            }
                        } else {
                            System.out.println("\n MOVIMENTO PROIBIDO! CARTA INVÁLIDA!");
                        }
                    } else {
                        System.out.println("\n NÃO HÁ CARTAS NA PILHA DE ESTOQUE!");
                    }
                }
            } else {
                System.out.println("\n DESTINO INCORRETO!");
            }
        }
    }

    /**
     * Método que move cartas das fundações de volta para as fileiras.
     *
     * @param origem (pilha de origem)
     * @param destino (pilha de destino)
     * @param qtd (quantidade de cartas)
     */
    private void fundacoesParaFileiras(int origem, int destino, int qtd) {
        if (qtd > 1) {
            System.out.println("\n SÓ É POSSÍVEL MOVER UMA CARTA DA FUNDAÇÃO!");
        } else {
            if (destino == 7 || destino == 8 || destino == 9 || destino == 10 || destino == 11 || destino == 12 || destino == 13) {
                if (fileiras[destino - 7].empty()) {
                    if (!fundacoes[origem - 3].empty()) {
                        if (fundacoes[origem - 3].peek().getNum() == 13) {
                            fileiras[destino - 7].push(fundacoes[origem - 3].pop());
                        } else {
                            System.out.println("\n MOVIMENTO PROIBIDO! A BASE DAS FILEIRAS SÃO FORMADAS POR REIS!");
                        }
                    } else {
                        System.out.println("\n NÃO HÁ CARTAS NA FUNDAÇÃO!");
                    }
                } else {
                    if (!fundacoes[origem - 3].empty()) {
                        if (!fundacoes[origem - 3].peek().getCor().equals(fileiras[destino - 7].peek().getCor())) {
                            if ((fileiras[destino - 7].peek().getNum() - fundacoes[origem - 3].peek().getNum()) == 1) {
                                fileiras[destino - 7].push(fundacoes[origem - 3].pop());
                            } else {
                                System.out.println("\n MOVIMENTO PROIBIDO! CARTA INVÁLIDA!");
                            }
                        } else {
                            System.out.println("\n MOVIMENTO PROIBIDO! CARTA INVÁLIDA!");
                        }
                    } else {
                        System.out.println("\n NÃO HÁ CARTAS NA FUNDAÇÃO!");
                    }
                }
            } else {
                System.out.println("\n DESTINO INCORRETO!");
            }
        }
    }

    /**
     * Método que move cartas das fileiras para as pilhas de fundação.
     *
     * @param origem (pilha de origem)
     * @param destino (pilha de destino)
     * @param qtd (quantidade de cartas)
     */
    private void fileirasParaFundacoes(int origem, int destino, int qtd) {
        if (qtd > 1) {
            System.out.println("\n SÓ É POSSÍVEL MOVER UMA CARTA PARA A FUNDAÇÃO!");
        } else {
            if (destino == 2 || destino == 3 || destino == 4 || destino == 5 || destino == 6 || destino == 7 || destino == 8 || destino == 9) {
                if (fundacoes[destino - 2].empty()) {
                    if (!fileiras[origem - 11].empty()) {
                        if (fileiras[origem - 11].peek().getNum() == 1) {
                            fundacoes[destino - 2].push(fileiras[origem - 11].pop());
                            if (!fileiras[origem - 11].empty()) {
                                fileiras[origem - 11].peek().mostrarCarta();
                            }
                        } else {
                            System.out.println("\n MOVIMENTO PROIBIDO! A BASE DAS FUNDAÇÕES SÃO FORMADAS POR ÁSES!");
                        }
                    } else {
                        System.out.println("\n NÃO HÁ CARTAS NA FILEIRA!");
                    }
                } else {
                    if (!fileiras[origem - 11].empty()) {
                        if (fileiras[origem - 11].peek().getNaipe().equals(fundacoes[destino - 2].peek().getNaipe())) {
                            if ((fileiras[origem - 11].peek().getNum() - fundacoes[destino - 2].peek().getNum()) == 1) {
                                fundacoes[destino - 2].push(fileiras[origem - 11].pop());
                                if (!fileiras[origem - 11].empty()) {
                                    fileiras[origem - 11].peek().mostrarCarta();
                                }
                            } else {
                                System.out.println("\n MOVIMENTO PROIBIDO! CARTA INVÁLIDA!");
                            }
                        } else {
                            System.out.println("\n MOVIMENTO PROIBIDO! NAIPES DIFERENTES!");
                        }
                    } else {
                        System.out.println("\n NÃO HÁ CARTAS NA FILEIRA!");
                    }
                }
            } else {
                fileirasParaFileiras(origem, destino, qtd);
            }
        }
    }

    /**
     * Método que move cartas entre fileiras.
     *
     * @param origem (pilha de origem)
     * @param destino (pilha de destino)
     * @param qtd (quantidade de cartas)
     */
    private void fileirasParaFileiras(int origem, int destino, int qtd) {
        if (qtd > fileiras[origem - 11].size()) {
            System.out.println("\n NÃO EXISTEM TANTAS CARTAS ASSIM PARA MOVER!");
        } else {
            if (destino == 11 || destino == 12 || destino == 13 || destino == 14 || destino == 15 || destino == 16
                    || destino == 17 || destino == 18 || destino == 19 || destino == 20 || destino == 21 || destino == 22 || destino == 23
                    || destino == 24 || destino == 25) {
                Stack<Carta> aux = new Stack<>();
                Stack<Carta> aux2 = new Stack<>();
                Stack<Carta> aux3 = new Stack<>();

                aux.addAll(fileiras[origem - 11]);
                aux3.addAll(fileiras[destino - 11]);

                for (int i = 0; i < qtd; i++) {
                    Carta c = aux.pop();
                    if (c.toString().equals("[<>]")) {
                        System.out.println("\n NÃO É POSSÍVEL MOVER CARTAS VIRADAS!");
                        return;
                    }
                    aux2.push(c);
                }

                aux.removeAllElements();
                aux.addAll(aux2);

                while (!aux2.empty()) {
                    if (!aux3.empty()) {
                        if (!aux3.peek().getCor().equals(aux2.peek().getCor())) {
                            if (aux3.peek().getNum() - aux2.peek().getNum() == 1) {
                                aux3.push(aux2.pop());
                            } else {
                                System.out.println("\n MOVIMENTO INVÁLIDO!");
                                return;
                            }
                        } else {
                            System.out.println("\n MOVIMENTO INVÁLIDO!");
                            return;
                        }
                    } else {
                        if (aux2.peek().getNum() == 13) {
                            aux3.push(aux2.pop());
                        }
                    }
                }

                for (int i = 0; i < qtd; i++) {
                    fileiras[destino - 11].push(aux.pop());
                    fileiras[origem - 11].pop();
                }
                if (!fileiras[origem - 11].empty()) {
                    fileiras[origem - 11].peek().mostrarCarta();
                }
            } else {
                System.out.println("\n DESTINO INCORRETO!");
            }
        }
    }

    /**
     * Método que analisa se a partida já foi vencida.
     *
     * @return
     */
    public boolean condicaoDeVitoria() {
        return (fundacoes[0].size() == 12 && fundacoes[1].size() == 12 && fundacoes[2].size() == 12 && fundacoes[3].size() == 12
                && fundacoes[4].size() == 12 && fundacoes[5].size() == 12 && fundacoes[6].size() == 12 && fundacoes[7].size() == 12
                && fundacoes[8].size() == 8);
    }

    public String getMsgVitoria() {
        return "PARABENS";
    }
}
