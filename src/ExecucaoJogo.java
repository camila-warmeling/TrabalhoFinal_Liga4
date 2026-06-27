import java.util.Scanner;

public class ExecucaoJogo {
    private Scanner teclado = new Scanner(System.in);
    private char corUsuario, corComputador;
    private boolean vezDoUsuario = true;
    private int colunaEscolhida;

    private Tabuleiro meuTabuleiro;
    private JogadorUsuario usuario;
    private JogadorComputador computador;

    public ExecucaoJogo(){
        meuTabuleiro = new Tabuleiro();
        System.out.println("Seja bem-vindo ao jogo Liga-4");
        System.out.println("Para começar, escolha uma opção do menu");  
        mostrarMenu();
    }

    private void mostrarMenu(){
        System.out.println("Menu:");
        System.out.println("1 - Como Jogar");
        System.out.println("2 - Regras do Jogo Liga-4");
        System.out.println("3 - Mostrar Tabuleiro");
        System.out.println("4 - Novo Jogo");
        System.out.println("5 - Continuar Jogo");
        System.out.println("6 - Sair");

        System.out.println("Digite a opção:");
        int opcaoMenu = teclado.nextInt();

        switch(opcaoMenu){
            case 1:
                comoJogar();
                mostrarMenu();            
                break;
        
            case 2:
                regrasDoJogo();
                mostrarMenu();
                break;

            case 3:
                System.out.println("Ainda não foi iniciado um jogo.");
                System.out.println("Este é o tabuleiro vazio");
                meuTabuleiro.mostrarTabuleiro();
                mostrarMenu();
                break;

            case 4:
                escolherCorPecaUsuarioComputador();
                sortearJogadorQueComeca();
                iniciarPartida();
                break;

            case 5:
                if(meuTabuleiro == null){
                    System.out.println("Ainda não foi iniciado um jogo.");
                }else{
                    iniciarPartida();
                }
                mostrarMenu();              
                break;

            case 6:
                System.out.println("Você decidiu sair do jogo. Até a próxima!");      
                break;

            default:
                System.out.println("Essa opção não existe.");
                mostrarMenu();
                break;
        }
    }

    private void comoJogar(){
        System.out.println("\n========================================================");
        System.out.println("                      COMO JOGAR                        ");
        System.out.println("========================================================");
        System.out.println("1. ESCOLHA DE CORES: No início de um 'Novo Jogo', você");
        System.out.println("   deve escolher sua cor: (V)ermelho ou (A)zul.");
        System.out.println("   O computador ficará automaticamente com a outra cor.");
        System.out.println("\n2. SORTEIO INICIAL: O sistema fará um sorteio aleatório");
        System.out.println("   para definir se você ou o computador começa a partida.");
        System.out.println("\n3. SEU TURNO: Quando for a sua vez, o sistema pedirá para");
        System.out.println("   você digitar o número de uma coluna.");
        System.out.println("\n4. JOGADA DO COMPUTADOR: Logo após a sua jogada, o robô");
        System.out.println("   irá sortear uma coluna livre para jogar a peça dele.");
        System.out.println("\n5. FLUXO DO JOGO: O jogo segue esse 'pingue-pongue' de");
        System.out.println("   turnos até que haja um vencedor ou o tabuleiro lote.");
        System.out.println("========================================================\n");
    }

    private void regrasDoJogo(){
        System.out.println("\n========================================================");
        System.out.println("                    REGRAS DO JOGO                      ");
        System.out.println("========================================================");
        System.out.println("• O TABULEIRO: É composto por 6 linhas e 7 colunas.");
        System.out.println("  As colunas são numeradas de 0 a 6.");
        System.out.println("\n• A GRAVIDADE: Você escolhe a COLUNA. A peça cai sempre");
        System.out.println("  na posição mais baixa que estiver livre naquela coluna.");
        System.out.println("  Não é possível escolher a linha.");
        System.out.println("\n• COLUNA CHEIA: Uma coluna suporta no máximo 6 peças.");
        System.out.println("  Se tentar jogar em uma coluna cheia, o sistema dará");
        System.out.println("  erro e pedirá para você escolher outra.");
        System.out.println("\n• COMO GANHAR: O objetivo é ser o primeiro a alinhar");
        System.out.println("  4 peças da sua cor seguidas. O alinhamento pode ser:");
        System.out.println("  -> Na Horizontal (na mesma linha)");
        System.out.println("  -> Na Vertical (na mesma coluna)");
        System.out.println("  -> Nas Diagonais (inclinadas)");
        System.out.println("\n• EMPATE (VELHA): Se todas as 42 casas do tabuleiro");
        System.out.println("  forem preenchidas e ninguém tiver alinhado 4 peças,");
        System.out.println("  o jogo termina empatado por falta de espaço.");
        System.out.println("========================================================\n");
    }

    public void escolherCorPecaUsuarioComputador() {
        System.out.println("Cores disponíveis para jogar:");
        System.out.println("V - Vermelho");
        System.out.println("A - Azul");

        System.out.println("Qual cor deseja?");
        corUsuario = teclado.next().toUpperCase().charAt(0);
        if(corUsuario == 'V'){
            corComputador = 'A';
        }else if(corUsuario == 'A'){
            corComputador = 'V';
        }else{
            System.out.println("Cor inserida de forma incorreta");
            escolherCorPecaUsuarioComputador();
        }

        usuario = new JogadorUsuario(corUsuario);
        computador = new JogadorComputador(corComputador);
    }

    private void sortearJogadorQueComeca(){
        int num;
        System.out.println("O jogador que começa jogando é:");
        num = (int)(Math.random()*2); //se for igual ou maior que 0,50 vai ser 1.
        if(num == 0){
            System.out.println("Usuário");
        }else{
            System.out.println("Computador");
            vezDoUsuario = false;
        }
    }

    private void iniciarPartida(){
        do{//variável vezDoUsuario faz a alternância entre o usuário e o computador
            if(vezDoUsuario){
                meuTabuleiro.mostrarTabuleiro();
                System.out.println("------ JOGADA USUÁRIO -------");
                System.out.println("Escolha qual coluna deseja ou -1 para voltar ao menu.");
                colunaEscolhida = teclado.nextInt();
                if(colunaEscolhida == -1){
                    mostrarMenu();
                    break;//impede que o programa continue a partir dessa linha após ser selecionado alguma opcao do menu
                }

                boolean colunaExiste = meuTabuleiro.verificarColunaExiste(colunaEscolhida);
                boolean colunaDisponivel = meuTabuleiro.verificarEspacoDisponivelNaColuna(colunaEscolhida);

                if(colunaExiste && colunaDisponivel){
                    meuTabuleiro.posicionarPecaNoTabuleiro(usuario.obterCor());
                    System.out.println("Sua peça foi adicionada com sucesso!");
                }
                vezDoUsuario = false;
            }else{// n precisa verificar se coluna existe
                System.out.println("------ JOGADA COMPUTADOR -------");
                colunaEscolhida = computador.sortearColuna();
                boolean colunaDisponivel = meuTabuleiro.verificarEspacoDisponivelNaColuna(colunaEscolhida);
                
                if(colunaDisponivel){
                    meuTabuleiro.posicionarPecaNoTabuleiro(computador.obterCor());
                    System.out.println("Peça do computador foi adicionada com sucesso!");                    
                }
                vezDoUsuario = true;
           } 
        }while(true);
    }

    public static void main(String[] args){
        ExecucaoJogo execucao = new ExecucaoJogo();
    
    }

}
