/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Mesa;
import java.util.Scanner;
import model.Baralho;

/**
 *
 * @author Gustavo e Jadson
 */
public class main {

    public static void main(String[] args) {

        System.out.println("MENU PRINCIPAL");
        Scanner scanner = new Scanner(System.in);
        int escolhaMenu = 0;
        do {
            System.out.println("\nEscolha uma das opcoes abaixo:"
                    + "\n1 - Jogar Paciencia"
                    + "\n2 - Jogar Big Bertha"
                    + "\n3 - Sair\n");
            System.out.print("Digite a opção: ");
            escolhaMenu = scanner.nextInt();
            switch (escolhaMenu) {
                case 1:
                    Baralho baralho = new Baralho();
                    Mesa mesa = new Mesa(baralho.getBaralho());
                    System.out.println("\n======================="
                                        + "\nBEM VINDO AO PACIENCIA!"
                                        + "\n=======================");
                    baralho.criarCartas();
                    baralho.embaralhar();
                    
                    int qtdCartas = 0;
                    System.out.println("\nEscolha a quantidade de cartas a serem exibidas no descarte: 1 ou 3 carta(s)?\n");
                    int x = 0;
                    do {
                        System.out.print("Digite a opcao: ");
                        qtdCartas = scanner.nextInt();
                        if (qtdCartas == 1 || qtdCartas == 3) {
                            x = 1;
                        } else {
                            System.out.println("\n================"
                            + "\nOPCAO INVALIDA!"
                            + "\n================");
                            System.out.println("\nEscolha a quantidade correta: 1 ou 3?\n");
                        }
                    } while (x != 1);
                    
                    mesa.iniciarJogo(qtdCartas);

                    int fileiraO, fileiraD = 0;
                    System.out.println("\n======================="
                                        + "\nINICIANDO..."
                                        + "\n=======================");
                    mesa.exibirJogo(qtdCartas);

                    int escolha = 0;
                    do {
                        if(mesa.verificaVitoria()) {
                            System.out.println("\n============================="
                                        + "\nPARABÉNS!!! VOCÊ CONSEGUIU!"
                                        + "\n=============================");
                            System.exit(1);
                        }
                        System.out.println("\nEscolha uma das opcoes abaixo:"
                                + "\n1 - Exibir Mesa de Jogo"
                                + "\n2 - Mover Carta"
                                + "\n3 - Mover Conjunto de Cartas"
                                + "\n4 - Atualizar Descarte"
                                + "\n5 - Sair do Jogo\n");
                        System.out.print("Digite a opcao: ");
                        escolha = scanner.nextInt();
                        switch (escolha) {
                            case 1:
                                System.out.println("\n======================="
                                        + "\nEXIBIR MESA DE JOGO"
                                        + "\n=======================");
                                mesa.exibirJogo(qtdCartas);
                                break;

                            case 2:
                                System.out.println("\n======================="
                                        + "\nMOVER CARTA"
                                        + "\n=======================");
                                
                                mesa.exibirJogo(qtdCartas);
                                
                                System.out.print("\n");
                                System.out.println("Digite o numero da origem");
                                System.out.print("Origem: ");
                                fileiraO = scanner.nextInt();
                                System.out.print("\n");
                                System.out.println("Digite o numero do destino");
                                System.out.print("Destino: ");
                                fileiraD = scanner.nextInt();
                                
                                String acao = mesa.moverCartas(fileiraO, fileiraD, qtdCartas);
                                if (!acao.equals("")) {
                                    if (acao.equals("ERRO ESTOQUE")) {
                                        System.out.println("\n======================="
                                        + "\nERRO: JOGADA INVALIDA"
                                        + "\n=======================");
                                    } else if (acao.equals("FILEIRA VAZIA")) {
                                        System.out.println("\n===================================="
                                        + "\nERRO: ORIGEM VAZIA. ESCOLHA OUTRA OPCAO!"
                                        + "\n====================================");
                                    } else {
                                        System.out.println("\n================================"
                                        + "\nERRO: " + acao
                                        + "\n================================");
                                    }
                                } else {
                                    System.out.println("\n======================="
                                        + "\nCARTA MOVIDA COM SUCESSO!"
                                        + "\n=======================");
                                    mesa.exibirJogo(qtdCartas);
                                }
                                break;
                            
                            case 3:
                                System.out.println("\n======================="
                                        + "\nMOVER CONJUNTO DE CARTAS"
                                        + "\n=======================");
                                
                                mesa.exibirJogo(qtdCartas);
                                
                                System.out.print("\n");
                                System.out.println("Digite o numero da origem");
                                System.out.print("Origem: ");
                                fileiraO = scanner.nextInt();
                                System.out.print("\n");
                                System.out.println("Digite o numero do destino");
                                System.out.print("Destino: ");
                                fileiraD = scanner.nextInt();
                                
                                String resp = mesa.moverConjuntoDeCartas(fileiraO, fileiraD);
                                if (!resp.equals("")) {
                                    if (resp.equals("ERRO ESTOQUE")) {
                                        System.out.println("\n======================="
                                        + "\nERRO: JOGADA INVALIDA"
                                        + "\n=======================");
                                    } else if (resp.equals("FILEIRA VAZIA")) {
                                        System.out.println("\n===================================="
                                        + "\nERRO: ORIGEM VAZIA. ESCOLHA OUTRA OPCAO!"
                                        + "\n====================================");
                                    } else {
                                        System.out.println("\n================================"
                                        + "\nERRO: " + resp
                                        + "\n================================");
                                    }
                                } else {
                                    System.out.println("\n======================="
                                        + "\nCARTAS MOVIDAS COM SUCESSO!"
                                        + "\n=======================");
                                    mesa.exibirJogo(qtdCartas);
                                }
                                break;
                                
                            case 4:
                                String atualizarDescarte = mesa.moverCartas(1, 2, qtdCartas);
                                if (!atualizarDescarte.equals("")) {
                                    if (atualizarDescarte.equals("ESTOQUE VAZIO")) {
                                        System.out.println("\n======================================"
                                        + "\nERRO: NAO EXISTEM MAIS CARTAS DISPONIVEIS PARA ESTOQUE!"
                                        + "\n======================================");
                                    } else {
                                        System.out.println("\n======================="
                                        + "\nERRO: " + atualizarDescarte
                                        + "\n=======================");
                                    }
                                } else {
                                    System.out.println("\n======================="
                                        + "\nDESCARTE ATUALIZADO!"
                                        + "\n=======================");
                                    mesa.exibirJogo(qtdCartas);
                                }
                                break;
                                
                            case 5:
                                System.out.println("\nSaindo...\n\n");
                                System.out.println("Sistema encerrado.\n");
                                System.exit(1);

                            default:
                                System.out.println("\n================"
                                        + "\nOPCAO INVALIDA!"
                                        + "\n================");
                        }
                    } while (escolha != 5);
                    break;
                case 2:
                    System.out.println("\nJogo ainda nao implementado.");
                    System.out.println("\nSaindo...\n\n");
                    System.out.println("Sistema encerrado.\n");
                    System.exit(1);
                case 3:
                    System.out.println("\nSaindo...\n\n");
                    System.out.println("Sistema encerrado.\n");
                    System.exit(1);

                default:
                    System.out.println("\n================"
                            + "\nOPCAO INVALIDA!"
                            + "\n================");
            }
        } while (escolhaMenu != 3);
    }
}
