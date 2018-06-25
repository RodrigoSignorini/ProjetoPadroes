/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Stack;
import model.Baralho;
import model.Carta;

/**
 *
 * @author jvboa
 */
public class main {

    public static void main(String[] args) {
        Baralho baralho = new Baralho();
        baralho.criarCartas();
        baralho.embaralhar();

        Stack<Carta> cards = baralho.getBaralho();
        System.out.println("tamanho cards: " + cards.size());

        Stack<Carta> fileira0 = new Stack<>();
        Stack<Carta> fileira1 = new Stack<>();
        Stack<Carta> fileira2 = new Stack<>();
        Stack<Carta> fileira3 = new Stack<>();
        Stack<Carta> fileira4 = new Stack<>();
        Stack<Carta> fileira5 = new Stack<>();
        Stack<Carta> fileira6 = new Stack<>();

        fileira0.push(cards.pop());
                       
        for (int x = 0; x < 2; x++) {
            fileira1.push(cards.pop());
        }

        for (int x = 0; x < 3; x++) {
            fileira2.push(cards.pop());
        }

        for (int x = 0; x < 4; x++) {
            fileira3.push(cards.pop());
        }
                        
        for (int x = 0; x < 5; x++) {
            fileira4.push(cards.pop());
        }
                        
        for (int x = 0; x < 6; x++) {
            fileira5.push(cards.pop());
        }
            
        for (int x = 0; x < 7; x++) {
            fileira6.push(cards.pop());
            System.out.println("fileira6: " + x);
        }
                        



            
        

        fileira0.forEach((carta) -> {
            System.out.printf("Fileira0 Carta: %s, Naipe: %s, Cor:%s\n", carta.getValor(), carta.getNaipe().getTipo(), carta.getNaipe().getCor());
        });

        fileira1.forEach((carta) -> {
            System.out.printf("Fileira1 Carta: %s, Naipe: %s, Cor:%s\n", carta.getValor(), carta.getNaipe().getTipo(), carta.getNaipe().getCor());
        });
        fileira2.forEach((carta) -> {
            System.out.printf("Fileira2 Carta: %s, Naipe: %s, Cor:%s\n", carta.getValor(), carta.getNaipe().getTipo(), carta.getNaipe().getCor());
        });
    }
}
