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
 * @author jvboa
 */
public class main {

    public static void main(String[] args) {

        Baralho baralho = new Baralho();
        Mesa mesa = new Mesa(baralho.getBaralho());
//        baralho.criarCartas();
//        baralho.embaralhar();
//
//        baralho.iniciarFileiras();
//        baralho.exibirFileiras();
        System.out.println("Cassino Solitario\n");
        baralho.criarCartas();
        baralho.embaralhar();
        
        mesa.iniciarFileiras();
        Scanner scanner = new Scanner(System.in);
        int fileiraO, fileiraD = 0;
        int escolha = 0;
        do {

            System.out.println("\nEscolha uma das opcoes abaixo:\n1 - Exibir Fileiras\n2 - Mover Carta\n4 - Sair do Jogo\n");
            escolha = scanner.nextInt();
            switch (escolha) {

                case 1:
                    mesa.exibirFileiras();
                    break;

                case 2:
                    System.out.println("Digite o numero da fileira origem:");
                    fileiraO = scanner.nextInt();
                    System.out.println("Digite o numero da fileira destino:");
                    fileiraD = scanner.nextInt();

                    boolean acao = mesa.moverCartas(fileiraO, fileiraD);
                    if(!acao){
                        System.out.println("\nFileira de origem VAZIA.\nEscolha corretamente!");
                    }else{
                        System.out.println("\nCarta movida com sucesso!");
                    }
                    break;
                case 4:
                    System.out.println("Jogo encerrado.\n");
                    System.exit(1);
                default:
                    System.out.println("Opcao invalida!\n");
            }
        } while (escolha != 4);
    }
}
