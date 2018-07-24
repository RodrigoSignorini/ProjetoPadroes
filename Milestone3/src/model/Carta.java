package model;

/**
 * Classe que define o objeto Carta. * 
 * 
 * @author Jhansen Barreto
 */
public class Carta {
    
    private final String icone;
    private final String naipe;
    private final int num;
    private final String cor;
    private boolean virada;

    /**
     * Construtor.
     * 
     * @param icon (icone da carta)
     * @param naipe (naipe da carta)
     * @param numero (valor correspondente ao icone)
     * @param cor (cor da carta [preta ou vermelha])
     */
    public Carta(String icon, String naipe, int numero, String cor){
        switch(icon){
            case "1":
                this.icone = "A";
                break;
            case "11":
                this.icone = "J";
                break;
            case "12":
                this.icone = "Q";
                break;
            case "13":
                this.icone = "K";
                break;
            default:
                this.icone = icon;
                break;
        }
        this.naipe = naipe;
        this.num = numero;
        this.cor = cor;
        this.virada = false;
    }

    /**
     * Retorna o ícone da Carta.
     * @return icone
     */
    public String getIcone(){
        return icone;
    }

    /**
     * Retorna o naipe da Carta.
     * @return naipe
     */
    public String getNaipe(){
        return naipe;
    }
    
    /**
     * Retorna o valor numérico da Carta.
     * @return num
     */
    public int getNum(){
        return num;
    }
    
    /**
     * Retorna a cor da Carta.
     * @return cor
     */
    public String getCor(){
        return cor;
    }
    
    /**
     * Método para poder esconder a face da Carta.
     */
    public void esconderCarta(){
        this.virada = false;
    }
    
    /**
     * Método para poder mostrar a face da Carta.
     */
    public void mostrarCarta(){
        this.virada = true;
    }
    
    /**
     * Método que indica se a Carta está mostrando a face.
     * @return virada
     */
    public boolean estaVirada(){
        return virada;
    }
    
    /**
     * Método para organizar a exibição da Carta.
     * @return 
     */
    @Override
    public String toString() {
        if(virada){
            return "[" + icone + " de " + naipe + "]";
        }
        return "[<>]";
    }
}