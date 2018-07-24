/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author gboan
 */
public class InterfaceGrafica {

    public InterfaceGrafica() {
        janela();
    }

    public void janela() {
        JFrame janela = new JFrame("Argentum");
        JButton botaoCarregar = new JButton("Carregar XML");
        JButton botaoSair = new JButton("Sair");
        JButton botao = new JButton("Carregar XML");
        JPanel painel = new JPanel();
        painel.add(botaoCarregar);
        painel.add(botaoSair);
        janela.add(painel);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.pack();
        janela.setVisible(true);
    }

}
