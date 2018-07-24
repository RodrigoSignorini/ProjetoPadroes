/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;
import model.MesaBigBertha;

/**
 *
 * @author gboan
 */
public class InterfaceBigBertha {

    private MesaBigBertha mesa;
    private final Scanner ler;
    int posicaoCarta;

    /**
     * Construtor.
     */
    public InterfaceBigBertha() {
        this.ler = new Scanner(System.in);
        this.mesa = new MesaBigBertha();
        jogarBigBertha();
    }

    private void jogarBigBertha() {
        System.out.println("\n *********** INICIANDO BIG BERTHA ... ***********");
        System.out.println("  1: ESTOQUE == " + mesa.getEstoque());

        System.out.println("");
        System.out.println("  2: FUNDAÇÃO 1 == " + mesa.getFundacao1());
        System.out.println("  3: FUNDAÇÃO 2 == " + mesa.getFundacao2());
        System.out.println("  4: FUNDAÇÃO 3 == " + mesa.getFundacao3());
        System.out.println("  5: FUNDAÇÃO 4 == " + mesa.getFundacao4());
        System.out.println("  6: FUNDAÇÃO 5 == " + mesa.getFundacao5());
        System.out.println("  7: FUNDAÇÃO 6 == " + mesa.getFundacao6());
        System.out.println("  8: FUNDAÇÃO 7 == " + mesa.getFundacao7());
        System.out.println("  9: FUNDAÇÃO 8 == " + mesa.getFundacao8());
        System.out.println("  10: FUNDAÇÃO K == " + mesa.getFundacaoK());

        System.out.println("");
        System.out.println("  11: TABLEAU1 == " + mesa.getPilhaA());
        System.out.println("  12: TABLEAU2 == " + mesa.getPilhaB());
        System.out.println("  13: TABLEAU3 == " + mesa.getPilhaC());
        System.out.println("  14: TABLEAU4 == " + mesa.getPilhaD());
        System.out.println("  15: TABLEAU5 == " + mesa.getPilhaE());
        System.out.println("  16: TABLEAU6 == " + mesa.getPilhaF());
        System.out.println("  17: TABLEAU7 == " + mesa.getPilhaG());
        System.out.println("  18: TABLEAU8 == " + mesa.getPilhaH());
        System.out.println("  19: TABLEAU9 == " + mesa.getPilhaI());
        System.out.println("  20: TABLEAU10 == " + mesa.getPilhaJ());
        System.out.println("  21: TABLEAU11 == " + mesa.getPilhaK());
        System.out.println("  22: TABLEAU12 == " + mesa.getPilhaL());
        System.out.println("  23: TABLEAU13 == " + mesa.getPilhaM());
        System.out.println("  24: TABLEAU14 == " + mesa.getPilhaN());
        System.out.println("  25: TABLEAU15 == " + mesa.getPilhaO());

        if (!mesa.condicaoDeVitoria()) {
            imprimirMenu();
        } else {
            System.err.println(mesa.getMsgVitoria());
            System.exit(0);
        }
    }

    /**
     * Método que imprime as ações disponíveis para jogar.
     */
    private void imprimirMenu() {
        System.out.println("");
        System.out.println(" ATENÇÃO, VÁ COM CALMA!");

        System.out.println("");
        System.out.println(" ESCOLHA UMA DAS OPÇÕES ABAIXO [1 - 3]:");
        //System.out.println("  1 - ALTERAR QUANTIDADE DE CARTAS À VIRAR DO ESTOQUE");
        //System.out.println("  2 - PEDIR CARTA");
        System.out.println("  1 - MOVER CARTA");
        System.out.println("  2 - NOVO JOGO");
        System.out.println("  3 - FINALIZAR");
        System.out.print(" DIGITE O Nº DA OPÇÃO DESEJADA: ");

        this.casosDeUso();
    }

    private void casosDeUso() {
        try {
            int x = Integer.parseInt(ler.nextLine());
            if (x < 1 || x > 3) {
                System.out.println(" OPÇÃO INVÁLIDA!\n\n");
                jogarBigBertha();
            } else {
                switch (x) {
                    case 1:
                        caso1();
                        jogarBigBertha();
                        break;
                    case 2:
                        //Paciência -> 4 fundações e 7 fileiras
                        new InterfaceBigBertha();
                        System.out.println("\n BOA SORTE!");
                        jogarBigBertha();
                        break;
                    case 3:
                        System.err.println("\n OBRIGADO POR JOGAR! ;)");
                        System.exit(0);
                        break;
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println(" OPÇÃO INVÁLIDA!\n\n");
            jogarBigBertha();
        }
    }

    private void caso1() {
        System.out.println("_______________________________________________________________________________________________________________________________________\n");
        System.out.println("  1: ESTOQUE == " + mesa.getEstoque());

        System.out.println("");
        System.out.println("  2: FUNDAÇÃO 1 == " + mesa.getFundacao1());
        System.out.println("  3: FUNDAÇÃO 2 == " + mesa.getFundacao2());
        System.out.println("  4: FUNDAÇÃO 3 == " + mesa.getFundacao3());
        System.out.println("  5: FUNDAÇÃO 4 == " + mesa.getFundacao4());
        System.out.println("  6: FUNDAÇÃO 5 == " + mesa.getFundacao5());
        System.out.println("  7: FUNDAÇÃO 6 == " + mesa.getFundacao6());
        System.out.println("  8: FUNDAÇÃO 7 == " + mesa.getFundacao7());
        System.out.println("  9: FUNDAÇÃO 8 == " + mesa.getFundacao8());
        System.out.println("  10: FUNDAÇÃO K == " + mesa.getFundacaoK());

        System.out.println("");
        System.out.println("  11: TABLEAU1 == " + mesa.getPilhaA());
        System.out.println("  12: TABLEAU2 == " + mesa.getPilhaB());
        System.out.println("  13: TABLEAU3 == " + mesa.getPilhaC());
        System.out.println("  14: TABLEAU4 == " + mesa.getPilhaD());
        System.out.println("  15: TABLEAU5 == " + mesa.getPilhaE());
        System.out.println("  16: TABLEAU6 == " + mesa.getPilhaF());
        System.out.println("  17: TABLEAU7 == " + mesa.getPilhaG());
        System.out.println("  18: TABLEAU8 == " + mesa.getPilhaH());
        System.out.println("  19: TABLEAU9 == " + mesa.getPilhaI());
        System.out.println("  20: TABLEAU10 == " + mesa.getPilhaJ());
        System.out.println("  21: TABLEAU11 == " + mesa.getPilhaK());
        System.out.println("  22: TABLEAU12 == " + mesa.getPilhaL());
        System.out.println("  23: TABLEAU13 == " + mesa.getPilhaM());
        System.out.println("  24: TABLEAU14 == " + mesa.getPilhaN());
        System.out.println("  25: TABLEAU15 == " + mesa.getPilhaO());

        try {
            System.out.print("\n DIGITE O NÚMERO CORRESPONDENTE À PILHA DE ORIGEM: ");
            int origem = Integer.parseInt(ler.nextLine());

            if (origem < 1 || origem > 25) {
                System.out.println(" OPÇÃO INVÁLIDA! ORIGEM INCORRETA!\n\n");
                caso1();
            }

            if (origem == 1) {
                System.out.print("\n DIGITE O NÚMERO CORRESPONDENTE À POSICAO DA CARTA DA PILHA DE ORIGEM: ");
                posicaoCarta = Integer.parseInt(ler.nextLine());
            }

            System.out.print(" DIGITE O NÚMERO CORRESPONDENTE À PILHA DE DESTINO: ");
            int destino = Integer.parseInt(ler.nextLine());

            if (destino < 2 || destino > 25 || destino == origem) {
                System.out.println(" OPÇÃO INVÁLIDA! DESTINO INCORRETO!\n\n");
                caso1();
            }

            System.out.print(" DIGITE O NÚMERO CORRESPONDENTE À QUANTIDADE DE CARTAS A SEREM MOVIDAS: ");
            int cartas = Integer.parseInt(ler.nextLine());

            if (cartas < 1) {
                System.out.println(" OPÇÃO INVÁLIDA! NÃO É POSSÍVEL MOVER 0 CARTAS!\n\n");
                caso1();
            } else {
                if (origem != 1) {
                    mesa.mover(origem, destino, cartas, 0);
                    jogarBigBertha();
                } else {
                    mesa.mover(origem, destino, cartas, posicaoCarta);
                    jogarBigBertha();
                }

            }
        } catch (NumberFormatException nfe) {
            System.out.println(" OPÇÃO INVÁLIDA!\n\n");
            caso1();
        }
    }
}
