package model;

import static java.util.Collections.shuffle;
import java.util.Stack;

/**
 * Classe responsável por criar o baralho utilizado no jogo.
 *
 * @author Jhansen Barreto
 */
public class Baralho {

    private final Stack<Carta> baralho;

    /**
     * Construtor.
     */
    public Baralho() {
        this.baralho = new Stack<>();
    }

    /**
     * Método que cria o baralho. Uma coleção com 52 objetos do tipo Carta.
     *
     * @return baralho
     */
    public Stack<Carta> getBaralho(int qtd) {
        for (int j = 0; j < qtd; j++) {
            for (int i = 1; i <= 13; i++) {
                baralho.push(new Carta("" + i, "Espadas", i, "Black"));
            }
            for (int i = 1; i <= 13; i++) {
                baralho.push(new Carta("" + i, "Ouros", i, "Red"));
            }
            for (int i = 1; i <= 13; i++) {
                baralho.push(new Carta("" + i, "Paus", i, "Black"));
            }
            for (int i = 1; i <= 13; i++) {
                baralho.push(new Carta("" + i, "Copas", i, "Red"));
            }
        }
        shuffle(baralho);
        return baralho;
    }
}
