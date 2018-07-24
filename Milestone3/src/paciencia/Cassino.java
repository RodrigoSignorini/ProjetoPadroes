package paciencia;

import control.FacadeController;
import java.util.Scanner;
import view.InterfaceBigBertha;
import view.InterfaceCaractere;

/**
 * Classe principal do projeto. É o ponto de partida para rodar o programa.
 *
 * @author Jhansen Barreto -> Gustavo e Jadson
 */
public class Cassino {

    /**
     * A Main dá o "start" no programa.
     *
     * @param args
     */
    public static void main(String[] args) {
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
