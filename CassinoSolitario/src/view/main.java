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

        System.out.println("Menu Principal");
        Scanner scannerMenu = new Scanner(System.in);
        int escolhaMenu = 0;
        do {
            System.out.println("\nEscolha uma das opcoes abaixo:"
                    + "\n1 - Jogar Cassino Solitário"
                    + "\n4 - Sair\n");
            escolhaMenu = scannerMenu.nextInt();
            switch (escolhaMenu) {
                case 1:
                    Baralho baralho = new Baralho();
                    Mesa mesa = new Mesa(baralho.getBaralho());
                    //        baralho.criarCartas();
                    //        baralho.embaralhar();
                    //
                    //        baralho.iniciarFileiras();
                    //        baralho.exibirFileiras();
                    System.out.println("\n\n\nBem vindo ao Cassino Solitario!\n");
                    //permitir ao usuário escolher numero de cartas exibidas na pilha de descartes
                    baralho.criarCartas();
                    baralho.embaralhar();
                    mesa.iniciarJogo();
                    Scanner scanner = new Scanner(System.in);
                    int fileiraO,
                     fileiraD = 0;
                    int qtdCartas = 0;

                    System.out.println("\nEscolha a quantidade de cartas a serem exibidas no descarte: 1 ou 3 carta(s)\n");

                    int x = 0;
                    do {
                        qtdCartas = scanner.nextInt();
                        if (qtdCartas == 1 || qtdCartas == 3) {
                            x = 1;

                        } else {
                            System.out.println("\nEscolha a quantidade correta = 1 ou 3\n");

                        }
                    } while (x != 1);

                    int escolha = 0;
                    do {
                        System.out.println("\nEscolha uma das opcoes abaixo:"
                                + "\n1 - Exibir Jogo"
                                + "\n2 - Mover Carta"
                                + "\n4 - Sair do Jogo\n");
                        escolha = scanner.nextInt();
                        switch (escolha) {
                            case 1:
                                mesa.exibirJogo(qtdCartas);
                                break;

                            case 2:
                                System.out.println("Digite o numero da fileira origem:");
                                fileiraO = scanner.nextInt();
                                //verificar se a fileira de origem tem carta para ser movida
                                System.out.println("Digite o numero da fileira destino:");
                                fileiraD = scanner.nextInt();
                                //verificar se a fileira de destino pode receber a(s) carta(s)
                                //verificar o numero digitado para nao selecionar fileira que nao existe
                                boolean acao = mesa.moverCartas(fileiraO, fileiraD);
                                if (!acao) {
                                    System.out.println("\n--------------------------\nFileira de origem VAZIA.\nEscolha corretamente!\n--------------------------");
                                } else {
                                    System.out.println("\n--------------------------\nCarta movida com sucesso!"
                                            + "\n--------------------------");
                                }

                                mesa.exibirEstoque();
                                mesa.exibirDescarte(3);
                                mesa.exibirFileiras();
                                break;

                            case 4:
                                System.out.println("Jogo encerrado.\n");
                                System.exit(1);

                            default:
                                System.out.println("Opcao invalida!\n");
                        }
                    } while (escolha != 4);
                    break;

                case 4:
                    System.out.println("Sistema encerrado.\n");
                    System.exit(1);

                default:
                    System.out.println("Opcao invalida!\n");
            }
        } while (escolhaMenu != 4);

    }
}
