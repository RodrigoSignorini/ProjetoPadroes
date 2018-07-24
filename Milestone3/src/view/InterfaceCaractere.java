package view;

import control.FacadeController;
import java.util.Scanner;

/**
 * Classe responsável pela interação do usuário com as ações do jogo.
 * 
 * @author Jhansen Barreto
 */
public class InterfaceCaractere {
    
    private FacadeController fc;
    private final Scanner ler;
    
    /**
     * Construtor.
     */
    public InterfaceCaractere(){
        this.ler = new Scanner(System.in);
        System.out.println("### BEM VINDO AO CASSINO ! ###");
        this.menu();
    }
    
    /**
     * Mátodo que imprime o estado atual do tabuleiro de jogo depois de cada ação.
     */
    private void jogarPaciencia(){    
        System.out.println("\n *********** INICIANDO PACIÊNCIA ... ***********");
        System.out.println("  1: ESTOQUE == " + fc.getEstoque());
        System.out.println("  2: DESCARTE == " + fc.getDescarte());
        
        System.out.println("");
        System.out.println("  3: FUNDAÇÃO 1 == " + fc.getFundacao1());
        System.out.println("  4: FUNDAÇÃO 2 == " + fc.getFundacao2());
        System.out.println("  5: FUNDAÇÃO 3 == " + fc.getFundacao3());
        System.out.println("  6: FUNDAÇÃO 4 == " + fc.getFundacao4());
        
        System.out.println("");
        System.out.println("  7: TABLEAU1 == " + fc.getPilhaA());
        System.out.println("  8: TABLEAU2 == " + fc.getPilhaB());
        System.out.println("  9: TABLEAU3 == " + fc.getPilhaC());
        System.out.println(" 10: TABLEAU4 == " + fc.getPilhaD());
        System.out.println(" 11: TABLEAU5 == " + fc.getPilhaE());
        System.out.println(" 12: TABLEAU6 == " + fc.getPilhaF());
        System.out.println(" 13: TABLEAU7 == " + fc.getPilhaG());
        
        if(!fc.condicaoDeVitoria()){
            imprimirMenu();
        }
        else{
            System.err.println(fc.getMsgVitoria());
            System.exit(0);
        }
    }
    
    /**
     * Método que imprime as ações disponíveis para jogar.
     */
    private void imprimirMenu(){
        System.out.println("");
        System.out.println(" ATENÇÃO, VÁ COM CALMA!");
        
        System.out.println("");
        System.out.println(" ESCOLHA UMA DAS OPÇÕES ABAIXO [1 - 6]:");
        System.out.println("  1 - ALTERAR QUANTIDADE DE CARTAS À VIRAR DO ESTOQUE");
        System.out.println("  2 - PEDIR CARTA");
        System.out.println("  3 - MOVER CARTA");
        System.out.println("  4 - NOVO JOGO");
        System.out.println("  5 - FINALIZAR");
        System.out.print(" DIGITE O Nº DA OPÇÃO DESEJADA: ");
        
        this.casosDeUso();
    }
    
    /**
     * Método que aguarda a escolha do usuário e a direciona, para a ação ser executada.
     */
    private void casosDeUso(){
        try {
            int x = Integer.parseInt(ler.nextLine());
            if(x < 1 || x > 5){
                System.out.println(" OPÇÃO INVÁLIDA!\n\n");
                jogarPaciencia();
            }
            else{
                switch(x){
                    case 1:
                        caso1(); 
                        jogarPaciencia();
                        break;
                    case 2:
                        fc.pedirCarta();
                        jogarPaciencia();
                        break;
                    case 3:
                        caso3(); 
                        jogarPaciencia();
                        break;
                    case 4:
                        //Paciência -> 4 fundações e 7 fileiras
                        this.fc = new FacadeController(4, 7, "paciencia");
                        System.out.println("\n BOA SORTE!");
                        jogarPaciencia();
                        break;
                    case 5:
                        System.err.println("\n OBRIGADO POR JOGAR! ;)");
                        System.exit(0);
                        break;
                }
            }
        }catch(NumberFormatException nfe){
            System.out.println(" OPÇÃO INVÁLIDA!\n\n");
            jogarPaciencia();
        }
    }
    
    /**
     * Método responsável por direcionar a ação de mudar o número de cartas à virar do estoque.
     */
    private void caso1() {
        System.out.println("_______________________________________________________________________________________________________________________________________\n");
        System.out.print("\n DESEJA VIRAR 1 OU 3 CARTAS? ");
        
        try{
            int x = Integer.parseInt(ler.nextLine());
            if(x != 1 && x != 3){
                System.out.println(" OPÇÃO INVÁLIDA!\n\n");
                caso1();
            }
            else{
                fc.alterarQtdCartas(x);
            }
        }catch(NumberFormatException nfe){
            System.out.println(" OPÇÃO INVÁLIDA!\n\n");
            caso1();
        }
    }
    
    /**
     * Método responsável por direcionar a ação de mover cartas.
     */
    private void caso3() {
        System.out.println("_______________________________________________________________________________________________________________________________________\n");
        System.out.println("  2: DESCARTE == " + fc.getDescarte());
        
        System.out.println("");
        System.out.println("  3: FUNDAÇÃO 1 == " + fc.getFundacao1());
        System.out.println("  4: FUNDAÇÃO 2 == " + fc.getFundacao2());
        System.out.println("  5: FUNDAÇÃO 3 == " + fc.getFundacao3());
        System.out.println("  6: FUNDAÇÃO 4 == " + fc.getFundacao4());
        
        System.out.println("");
        System.out.println("  7: TABLEAU1 == " + fc.getPilhaA());
        System.out.println("  8: TABLEAU2 == " + fc.getPilhaB());
        System.out.println("  9: TABLEAU3 == " + fc.getPilhaC());
        System.out.println(" 10: TABLEAU4 == " + fc.getPilhaD());
        System.out.println(" 11: TABLEAU5 == " + fc.getPilhaE());
        System.out.println(" 12: TABLEAU6 == " + fc.getPilhaF());
        System.out.println(" 13: TABLEAU7 == " + fc.getPilhaG());
        
        try{
            System.out.print("\n DIGITE O NÚMERO CORRESPONDENTE À PILHA DE ORIGEM: ");
            int origem = Integer.parseInt(ler.nextLine());
            
            if(origem < 2 || origem > 13){
                System.out.println(" OPÇÃO INVÁLIDA! ORIGEM INCORRETA!\n\n");
                caso3();
            }
            
            System.out.print(" DIGITE O NÚMERO CORRESPONDENTE À PILHA DE DESTINO: ");
            int destino = Integer.parseInt(ler.nextLine());
            
            if(destino < 2 || destino > 13 || destino == origem){
                System.out.println(" OPÇÃO INVÁLIDA! DESTINO INCORRETO!\n\n");
                caso3();
            }
            
            System.out.print(" DIGITE O NÚMERO CORRESPONDENTE À QUANTIDADE DE CARTAS A SEREM MOVIDAS: ");
            int cartas = Integer.parseInt(ler.nextLine());
            
            if(cartas < 1){
                System.out.println(" OPÇÃO INVÁLIDA! NÃO É POSSÍVEL MOVER 0 CARTAS!\n\n");
                caso3();
            }
            else{
                fc.moverCarta(origem, destino, cartas);
                jogarPaciencia();
            }   
        }catch(NumberFormatException nfe){
            System.out.println(" OPÇÃO INVÁLIDA!\n\n");
            caso3();
        }
    }

    /**
     * Método reponsável por montar o menu inicial do cassino
     */
    private void menu() {
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
                    this.fc = new FacadeController(4, 7, "paciencia");
                    this.jogarPaciencia();
                    break;
                case 2:
                    //Big Bertha -> 9 fundações e 15 fileiras
                    this.fc = new FacadeController(9, 15, "bigbertha");
                    System.out.println("\nJogo ainda nao implementado.");
                    System.out.println("\nSaindo...\n\n");
                    System.out.println("Sistema encerrado.\n");
                    System.exit(1);
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