package model;

import java.util.Stack;

/**
 * Classe responsável por armazenar todas as informações da Mesa de jogo, que são mostradas no tabuleiro.
 * É também quem executa todas as ações escolhidas pelo usuário.
 * 
 * @author Jhansen Barreto
 */
public final class Mesa {
    
    private final Stack<Carta>[] fundacoes;
    private final Stack<Carta>[] fileiras;
    private final Stack<Carta> estoque;
    private final Stack<Carta> descarte;
    private int qtdEstoque;
    
    /**
     * Construtor.
     */
    public Mesa(){
        this.fundacoes = new Stack[4];
        this.fileiras = new Stack[7];
        
        this.criarPilhas();
        
        this.estoque = new Baralho().getBaralho();
        this.descarte = new Stack<>();
                
        this.qtdEstoque = 1;
        
        this.distribuirJogo(estoque);
    }
    
    /**
     * Método que cria as pilhas de cartas necessárias para uma partida.
     */
    private void criarPilhas(){
        for(int i = 0; i < 4; i++){
            fundacoes[i] = new Stack<>();
        }
        for(int i = 0; i < 7; i++){
            fileiras[i] = new Stack<>();
        }
    }
    
    /**
     * Método responsável por distribuir as cartas do baralho para o estado inicial do jogo.
     * @param baralho 
     */
    private void distribuirJogo(Stack<Carta> baralho){
        fileiras[0].push(baralho.pop());
        
        fileiras[1].push(baralho.pop());
        fileiras[1].push(baralho.pop());
        
        fileiras[2].push(baralho.pop());
        fileiras[2].push(baralho.pop());
        fileiras[2].push(baralho.pop());
        
        fileiras[3].push(baralho.pop());
        fileiras[3].push(baralho.pop());
        fileiras[3].push(baralho.pop());
        fileiras[3].push(baralho.pop());
        
        fileiras[4].push(baralho.pop());
        fileiras[4].push(baralho.pop());
        fileiras[4].push(baralho.pop());
        fileiras[4].push(baralho.pop());
        fileiras[4].push(baralho.pop());
        
        fileiras[5].push(baralho.pop());
        fileiras[5].push(baralho.pop());
        fileiras[5].push(baralho.pop());
        fileiras[5].push(baralho.pop());
        fileiras[5].push(baralho.pop());
        fileiras[5].push(baralho.pop());
        
        fileiras[6].push(baralho.pop());
        fileiras[6].push(baralho.pop());
        fileiras[6].push(baralho.pop());
        fileiras[6].push(baralho.pop());
        fileiras[6].push(baralho.pop());
        fileiras[6].push(baralho.pop());
        fileiras[6].push(baralho.pop());
        
        fileiras[0].peek().mostrarCarta();
        fileiras[1].peek().mostrarCarta();
        fileiras[2].peek().mostrarCarta();
        fileiras[3].peek().mostrarCarta();
        fileiras[4].peek().mostrarCarta();
        fileiras[5].peek().mostrarCarta();
        fileiras[6].peek().mostrarCarta();
    }
    
    /**
     * Método que altera a quantidade de cartas que devem ser viradas da pilha de estoque.
     * @param qtd
     */
    public void alterarQtdCartas(int qtd){
        qtdEstoque = qtd;
    }
    
    /**
     * Método que retorna o estado atual da pilha de estoque.
     * @return
     */
    public String getEstoque(){
        String nome = "";
        
        for (Carta c : estoque) {
            nome += c.toString();
        }
        
        return nome;
    }
    
    /**
     * Método que retorna o estado atual da pilha de descarte.
     * @return
     */
    public String getDescarte(){
        String topo = "";
        
        if(descarte.empty()){
            return "";
        }
        else{
            if(qtdEstoque == 1){
                return descarte.peek().toString();
            }
            else{
                Stack<Carta> aux = new Stack<>();
                aux.addAll(descarte);
                
                for(int i = 0; i < 3; i++){
                    if(!aux.empty()){
                        topo += aux.pop();
                    }
                }
                return topo;
            }
        }
    }
    
    /**
     * Método que retorna o estado atual da primeira fundação de cartas.
     * @return
     */
    public String getFundacao1(){
        if(fundacoes[0].empty()){
            return "";
        }
        else{
            return fundacoes[0].peek().toString();
        }
    }
    
    /**
     * Método que retorna o estado atual da segunda fundação de cartas.
     * @return
     */
    public String getFundacao2(){
        if(fundacoes[1].empty()){
            return "";
        }
        else{
            return fundacoes[1].peek().toString();
        }
    }
    
    /**
     * Método que retorna o estado atual da terceira fundação de cartas.
     * @return
     */
    public String getFundacao3(){
        if(fundacoes[2].empty()){
            return "";
        }
        else{
            return fundacoes[2].peek().toString();
        }
    }
    
    /**
     * Método que retorna o estado atual da quarta fundação de cartas.
     * @return
     */
    public String getFundacao4(){
        if(fundacoes[3].empty()){
            return "";
        }
        else{
            return fundacoes[3].peek().toString();
        }
    }
    
    /**
     * Método que retorna o estado atual da primeira pilha de cartas.
     * @return
     */
    public String getPilhaA(){
        String pilha = "";
        
        for (Carta c : fileiras[0]) {
            pilha += c.toString();
        }
        
        return pilha;
    }
    
    /**
     * Método que retorna o estado atual da segunda pilha de cartas.
     * @return
     */
    public String getPilhaB(){
        String pilha = "";
        
        for (Carta c : fileiras[1]) {
            pilha += c.toString();
        }
        
        return pilha;
    }
    
    /**
     * Método que retorna o estado atual da terceira pilha de cartas.
     * @return
     */
    public String getPilhaC(){
        String pilha = "";
        
        for (Carta c : fileiras[2]) {
            pilha += c.toString();
        }
        
        return pilha;
    }
    
    /**
     * Método que retorna o estado atual da quarta pilha de cartas.
     * @return
     */
    public String getPilhaD(){
        String pilha = "";
        
        for (Carta c : fileiras[3]) {
            pilha += c.toString();
        }
        
        return pilha;
    }
    
    /**
     * Método que retorna o estado atual da quinta pilha de cartas.
     * @return
     */
    public String getPilhaE(){
        String pilha = "";
        
        for (Carta c : fileiras[4]) {
            pilha += c.toString();
        }
        
        return pilha;
    }
    
    /**
     * Método que retorna o estado atual da sexta pilha de cartas.
     * @return
     */
    public String getPilhaF(){
        String pilha = "";
        
        for (Carta c : fileiras[5]) {
            pilha += c.toString();
        }
        
        return pilha;
    }
    
    /**
     * Método que retorna o estado atual da sétima pilha de cartas.
     * @return
     */
    public String getPilhaG(){
        String pilha = "";
        
        for (Carta c : fileiras[6]) {
            pilha += c.toString();
        }
        
        return pilha;
    }
    
    /**
     * Método que move as cartas da pilha de estoque para a pilha de descarte.
     * @return
     */
    public String pedirCarta(){
        if(estoque.empty() && descarte.empty()){
            return "Não há mais cartas!";
        }
        else if(!estoque.empty()){
            for(int i = 0; i < qtdEstoque; i++){
                if(!estoque.empty()){
                    descarte.push(estoque.pop());
                    descarte.peek().mostrarCarta();
                }                
            }           
        }
        else{
            while(!descarte.empty()){
                Carta c = descarte.pop();
                c.esconderCarta();
                estoque.push(c);
            }
        }
        return "";
    }
    
    /**
     * Método que analisa o pedido de movimento de cartas e direciona para o método adequado.
     * @param origem (pilha de origem)
     * @param destino (pilha de destino)
     * @param qtdCartas (quantidade de cartas à serem movidas)
     */
    public void mover(int origem, int destino, int qtdCartas){
        if(origem == 2){
            descarteParaFundacao(destino, qtdCartas);
        }
        else if(origem == 3 || origem == 4 || origem == 5 || origem == 6){
            fundacoesParaFileiras(origem, destino, qtdCartas);
        }
        else if(origem == 7 || origem == 8 || origem == 9 || origem == 10 || origem == 11 || origem == 12 || origem == 13){
            if(destino == 3 || destino == 4 || destino == 5 || destino == 6){
                fileirasParaFundacoes(origem, destino, qtdCartas);
            }
            else{
                fileirasParaFileiras(origem, destino, qtdCartas);
            }
        }
    }
    
    /**
     * Método que move cartas da pilha de descarte para as pilhas de fundação.
     * @param destino (pilha de destino)
     * @param qtd (quantidade de cartas)
     */
    private void descarteParaFundacao(int destino, int qtd){
        if(qtd > 1){
            System.out.println("\n SÓ É POSSÍVEL MOVER UMA CARTA DA PILHA DE DESCARTE!");
        }
        else{
            if(destino == 3 || destino == 4 || destino == 5 || destino == 6){
                if(fundacoes[destino - 3].empty()){
                    if(!descarte.empty()){
                        if(descarte.peek().getNum() == 1){
                            fundacoes[destino - 3].push(descarte.pop());
                        }
                        else{
                            System.out.println("\n MOVIMENTO PROIBIDO! A BASE DAS FUNDAÇÕES SÃO FORMADAS POR ÁSES!");
                        }
                    }
                    else{
                        System.out.println("\n NÃO HÁ CARTAS NA PILHA DE DESCARTE!");
                    }
                }
                else{
                    if(!descarte.empty()){
                        if(descarte.peek().getNaipe().equals(fundacoes[destino - 3].peek().getNaipe())){
                            if((descarte.peek().getNum() - fundacoes[destino - 3].peek().getNum()) == 1){
                                fundacoes[destino - 3].push(descarte.pop());
                            }
                            else{
                                System.out.println("\n MOVIMENTO PROIBIDO! CARTA INVÁLIDA!");
                            }
                        }
                        else{
                            System.out.println("\n MOVIMENTO PROIBIDO! NAIPES DIFERENTES!");
                        }
                    }
                    else{
                        System.out.println("\n NÃO HÁ CARTAS NA PILHA DE DESCARTE!");
                    }
                }
            }
            else{
                descarteParaFileira(destino, qtd);
            }
        }
    }
    
    /**
     * Método que move cartas da pilha de descarte para as fileiras.
     * @param destino (pilha de destino)
     * @param qtd (quantidade de cartas)
     */
    private void descarteParaFileira(int destino, int qtd){
        if(qtd > 1){
            System.out.println("\n SÓ É POSSÍVEL MOVER UMA CARTA DA PILHA DE DESCARTE!");
        }
        else{
            if(destino == 7 || destino == 8 || destino == 9 || destino == 10 || destino == 11 || destino == 12 || destino == 13){
                if(fileiras[destino - 7].empty()){
                    if(!descarte.empty()){
                        if(descarte.peek().getNum() == 13){
                            fileiras[destino - 7].push(descarte.pop());
                        }
                        else{
                            System.out.println("\n MOVIMENTO PROIBIDO! A BASE DAS FILEIRAS SÃO FORMADAS POR REIS!");
                        }
                    }
                    else{
                        System.out.println("\n NÃO HÁ CARTAS NA PILHA DE DESCARTE!");
                    }
                }
                else{
                    if(!descarte.empty()){
                        if(!descarte.peek().getCor().equals(fileiras[destino - 7].peek().getCor())){
                            if((fileiras[destino - 7].peek().getNum() - descarte.peek().getNum()) == 1){
                                fileiras[destino - 7].push(descarte.pop());
                            }
                            else{
                                System.out.println("\n MOVIMENTO PROIBIDO! CARTA INVÁLIDA!");
                            }
                        }
                        else{
                            System.out.println("\n MOVIMENTO PROIBIDO! CARTA INVÁLIDA!");
                        }
                    }
                    else{
                        System.out.println("\n NÃO HÁ CARTAS NA PILHA DE DESCARTE!");
                    }
                }
            }
            else{
                System.out.println("\n DESTINO INCORRETO!");
            }
        }
    }
    
    /**
     * Método que move cartas das fundações de volta para as fileiras.
     * @param origem (pilha de origem)
     * @param destino (pilha de destino)
     * @param qtd (quantidade de cartas)
     */
    private void fundacoesParaFileiras(int origem, int destino, int qtd){
        if(qtd > 1){
            System.out.println("\n SÓ É POSSÍVEL MOVER UMA CARTA DA FUNDAÇÃO!");
        }
        else{
            if(destino == 7 || destino == 8 || destino == 9 || destino == 10 || destino == 11 || destino == 12 || destino == 13){
                if(fileiras[destino - 7].empty()){
                    if(!fundacoes[origem - 3].empty()){
                        if(fundacoes[origem - 3].peek().getNum() == 13){
                            fileiras[destino - 7].push(fundacoes[origem - 3].pop());
                        }
                        else{
                            System.out.println("\n MOVIMENTO PROIBIDO! A BASE DAS FILEIRAS SÃO FORMADAS POR REIS!");
                        }
                    }
                    else{
                        System.out.println("\n NÃO HÁ CARTAS NA FUNDAÇÃO!");
                    }
                }
                else{
                    if(!fundacoes[origem - 3].empty()){
                        if(!fundacoes[origem - 3].peek().getCor().equals(fileiras[destino - 7].peek().getCor())){
                            if((fileiras[destino - 7].peek().getNum() - fundacoes[origem - 3].peek().getNum()) == 1){
                                fileiras[destino - 7].push(fundacoes[origem - 3].pop());
                            }
                            else{
                                System.out.println("\n MOVIMENTO PROIBIDO! CARTA INVÁLIDA!");
                            }
                        }
                        else{
                            System.out.println("\n MOVIMENTO PROIBIDO! CARTA INVÁLIDA!");
                        }
                    }
                    else{
                        System.out.println("\n NÃO HÁ CARTAS NA FUNDAÇÃO!");
                    }
                }
            }
            else{
                System.out.println("\n DESTINO INCORRETO!");
            }
        }
    }
    
    /**
     * Método que move cartas das fileiras para as pilhas de fundação.
     * @param origem (pilha de origem)
     * @param destino (pilha de destino)
     * @param qtd (quantidade de cartas)
     */
    private void fileirasParaFundacoes(int origem, int destino, int qtd){
        if(qtd > 1){
            System.out.println("\n SÓ É POSSÍVEL MOVER UMA CARTA PARA A FUNDAÇÃO!");
        }
        else{
            if(destino == 3 || destino == 4 || destino == 5 || destino == 6){
                if(fundacoes[destino - 3].empty()){
                    if(!fileiras[origem - 7].empty()){
                        if(fileiras[origem - 7].peek().getNum() == 1){
                            fundacoes[destino - 3].push(fileiras[origem - 7].pop());
                            if(!fileiras[origem - 7].empty()){
                                fileiras[origem - 7].peek().mostrarCarta();
                            }
                        }
                        else{
                            System.out.println("\n MOVIMENTO PROIBIDO! A BASE DAS FUNDAÇÕES SÃO FORMADAS POR ÁSES!");
                        }
                    }
                    else{
                        System.out.println("\n NÃO HÁ CARTAS NA FILEIRA!");
                    }
                }
                else{
                    if(!fileiras[origem - 7].empty()){
                        if(fileiras[origem - 7].peek().getNaipe().equals(fundacoes[destino - 3].peek().getNaipe())){
                            if((fileiras[origem - 7].peek().getNum() - fundacoes[destino - 3].peek().getNum()) == 1){
                                fundacoes[destino - 3].push(fileiras[origem - 7].pop());
                                if(!fileiras[origem - 7].empty()){
                                    fileiras[origem - 7].peek().mostrarCarta();
                                }
                            }
                            else{
                                System.out.println("\n MOVIMENTO PROIBIDO! CARTA INVÁLIDA!");
                            }
                        }
                        else{
                            System.out.println("\n MOVIMENTO PROIBIDO! NAIPES DIFERENTES!");
                        }
                    }
                    else{
                        System.out.println("\n NÃO HÁ CARTAS NA FILEIRA!");
                    }
                }
            }
            else{
                fileirasParaFileiras(origem, destino, qtd);
            }
        }
    }
    
    /**
     * Método que move cartas entre fileiras.
     * @param origem (pilha de origem)
     * @param destino (pilha de destino)
     * @param qtd (quantidade de cartas)
     */
    private void fileirasParaFileiras(int origem, int destino, int qtd){
        if(qtd > fileiras[origem - 7].size()){
            System.out.println("\n NÃO EXISTEM TANTAS CARTAS ASSIM PARA MOVER!");
        }
        else{
            if(destino == 7 || destino == 8 || destino == 9 || destino == 10 || destino == 11 || destino == 12 || destino == 13){
                Stack<Carta> aux = new Stack<>();
                Stack<Carta> aux2 = new Stack<>();
                Stack<Carta> aux3 = new Stack<>();
                
                aux.addAll(fileiras[origem - 7]);
                aux3.addAll(fileiras[destino - 7]);
                
                for(int i = 0; i < qtd; i++){
                    Carta c = aux.pop();
                    if(c.toString().equals("[<>]")){
                        System.out.println("\n NÃO É POSSÍVEL MOVER CARTAS VIRADAS!");
                        return;
                    }
                    aux2.push(c);                    
                }
                
                aux.removeAllElements();
                aux.addAll(aux2);
                
                while(!aux2.empty()){
                    if(!aux3.empty()){
                        if(!aux3.peek().getCor().equals(aux2.peek().getCor())){
                            if(aux3.peek().getNum() - aux2.peek().getNum() == 1){
                                aux3.push(aux2.pop());
                            }
                            else{
                                System.out.println("\n MOVIMENTO INVÁLIDO!");
                                return;
                            }
                        }
                        else{
                            System.out.println("\n MOVIMENTO INVÁLIDO!");
                            return;
                        }
                    }
                    else{
                        if(aux2.peek().getNum() == 13){
                            aux3.push(aux2.pop());
                        }
                    }
                }
                
                for(int i = 0; i < qtd; i++){
                    fileiras[destino - 7].push(aux.pop());
                    fileiras[origem - 7].pop();
                }
                if(!fileiras[origem - 7].empty()){
                    fileiras[origem - 7].peek().mostrarCarta();
                }
            }
            else{
                System.out.println("\n DESTINO INCORRETO!");
            }
        }
    }

    /**
     * Método que analisa se a partida já foi vencida.
     * @return
     */
    public boolean condicaoDeVitoria(){
        return (fundacoes[0].size() == 13 && fundacoes[1].size() == 13 && fundacoes[2].size() == 13 && fundacoes[3].size() == 13);
    }
}