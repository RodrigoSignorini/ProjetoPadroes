package paciencia;

import java.util.Scanner;
import view.InterfaceCaractere;
import view.InterfaceGrafica;

/**
 * Classe principal do projeto. É o ponto de partida para rodar o programa.
 *
 * @author Jhansen Barreto
 */
public class Paciencia {

    /**
     * A Main dá o "start" no programa.
     *
     * @param args
     */
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
                    new InterfaceCaractere();
                case 2:
                    System.out.println("paciencia.Paciencia.main()");
                    new InterfaceGrafica();
            }
        } while (escolhaMenu != 3);

    }
}
