package control;

import model.Mesa;

/**
 * Classe responsável por ligar a interface com as demais entidades do programa.
 * 
 * @author Jhansen Barreto
 */
public final class FacadeController {
    
    private final Mesa m;
    private final String msgVitoria;
    
    /**
     * Construtor.
     */
    public FacadeController(int fundacoes, int fileiras, String type){
        //Paciência -> 4 fundações e 7 fileiras
        //Big Bertha -> 9 fundações e 15 fileiras
        this.m = new Mesa(fundacoes, fileiras, type);
        this.msgVitoria = "\n PARABÉNS! VOCÊ COMPLETOU O JOGO!";
    }
    
    /**
     * Método que busca o estado da pilha de estoque da Mesa de jogo.
     * @return
     */
    public String getEstoque(){
        return m.getEstoque();
    }
    
    /**
     * Método que busca o estado da pilha de descarte da Mesa de jogo.
     * @return
     */
    public String getDescarte(){
        return m.getDescarte();
    }

    /**
     * Método que busca o estado da primeira fundação de cartas.
     * @return
     */
    public String getFundacao1(){
        return m.getFundacao1();
    }
    
    /**
     * Método que busca o estado da segunda fundação de cartas.
     * @return
     */
    public String getFundacao2(){
        return m.getFundacao2();
    }
    
    /**
     * Método que busca o estado da terceira fundação de cartas.
     * @return
     */
    public String getFundacao3(){
        return m.getFundacao3();
    }
    
    /**
     * Método que busca o estado da quarta fundação de cartas.
     * @return
     */
    public String getFundacao4(){
        return m.getFundacao4();
    }

    /**
     * Método que busca o estado da primeira fileira de cartas.
     * @return
     */
    public String getPilhaA(){
        return m.getPilhaA();
    }

    /**
     * Método que busca o estado da segunda fileira de cartas.
     * @return
     */
    public String getPilhaB(){
        return m.getPilhaB();
    }

    /**
     * Método que busca o estado da terceira fileira de cartas.
     * @return
     */
    public String getPilhaC(){
        return m.getPilhaC();
    }

    /**
     * Método que busca o estado da quarta fileira de cartas.
     * @return
     */
    public String getPilhaD(){
        return m.getPilhaD();
    }

    /**
     * Método que busca o estado da quinta fileira de cartas.
     * @return
     */
    public String getPilhaE(){
        return m.getPilhaE();
    }

    /**
     * Método que busca o estado da sexta fileira de cartas.
     * @return
     */
    public String getPilhaF(){
        return m.getPilhaF();
    }

    /**
     * Método que busca o estado da sétima fileira de cartas.
     * @return
     */
    public String getPilhaG(){
        return m.getPilhaG();
    }
    
    /**
     * Método que faz o pedido de uma carta.
     * @return
     */
    public String pedirCarta(){
        return m.pedirCarta();
    }

    /**
     * Método que repassa para a Mesa a quantidade de cartas que devem ser viradas do estoque.
     * @param qtd (número de cartas)
     */
    public void alterarQtdCartas(int qtd){
        m.alterarQtdCartas(qtd);
    }
    
    /**
     * Método que repassa para a Mesa quais cartas devem ser movidas.
     * @param origem (pilha de origem)
     * @param destino (pilha de destino)
     * @param cartas (quantidade de cartas que serão movidas)
     */
    public void moverCarta(int origem, int destino, int cartas){
        m.mover(origem, destino, cartas);
    }

    /**
     * Método que busca a verificação da vitória da partida.
     * @return
     */
    public boolean condicaoDeVitoria(){
        return m.condicaoDeVitoria();
    }
    
    /**
     * Método que retorna a mensagem de vitória, caso o jogador vença a partida.
     * @return
     */
    public String getMsgVitoria(){
        return msgVitoria;
    }
}