/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;

/**
 *
 * @author gboan
 */
public class menuPrincipal {
    
    public void menu(){
    System.out.println("### BEM VINDO AO CASSINO ! ###");
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
                    //Paciência -> 4 fundações e 7 fileiras
                    new InterfaceCaractere();
                    break;
                case 2:
                    //Big Bertha -> 9 fundações e 15 fileiras
                    new InterfaceBigBertha();
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
