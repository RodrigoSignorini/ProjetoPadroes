package paciencia;

import control.FacadeController;
import java.util.Scanner;
import view.InterfaceBigBertha;
import view.InterfaceCaractere;
import view.menuPrincipal;

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
        menuPrincipal menu = new menuPrincipal();
        menu.menu();
    }
}
