import java.util.Scanner;

public class ExecucaoJogo {
    private Scanner teclado = new Scanner(System.in);
    private char corUsuario, corComputador;
    private boolean vezDoUsuario = true, partidaIniciada = false;
    private int colunaEscolhida;
    private String vencedor;

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
                if(partidaIniciada){
                    System.out.println("Este é o tabuleiro do jogo atual:");
                }else{
                    System.out.println("Ainda não foi iniciado um jogo.");
                    System.out.println("Este é o tabuleiro vazio:");
                }
                meuTabuleiro.mostrarTabuleiro();
                mostrarMenu();
                break;

            case 4:
                iniciarNovoJogo();
                break;

            case 5:
                if(partidaIniciada){
                    iniciarPartida();
                }else{
                    System.out.println("Ainda não foi iniciado um jogo.");
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

    public void escolherCoresDasPecas() {
        System.out.println();//espaço para ficar mais limpo o terminal
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
            escolherCoresDasPecas();
        }

        usuario = new JogadorUsuario(corUsuario);
        computador = new JogadorComputador(corComputador);
    }

    private void sortearJogadorQueComeca(){
        System.out.println();//espaço para ficar mais limpo o terminal
        int num;
        System.out.println("O jogador que começa jogando é:");
        num = (int)(Math.random()*2); //se for igual ou maior que 0,50 vai ser 1.
        if(num == 0){
            System.out.println("Usuário");
        }else{
            System.out.println("Computador");
            vezDoUsuario = false;
        }
        System.out.println();//espaço para ficar mais limpo o terminal
    }

    private void iniciarPartida(){
        partidaIniciada = true;
        do{//variável vezDoUsuario faz a alternância entre o usuário e o computador
            if(vezDoUsuario){
                meuTabuleiro.mostrarTabuleiro();
                System.out.println("------ JOGADA USUÁRIO -------");
                System.out.println("Escolha qual coluna deseja ou -1 para voltar ao menu.");
                colunaEscolhida = teclado.nextInt();
                if(colunaEscolhida == -1){
                    mostrarMenu();
                    break;
                }

                boolean colunaExiste = meuTabuleiro.verificarColunaExiste(colunaEscolhida);
                if(colunaExiste){
                    boolean colunaDisponivel = meuTabuleiro.verificarEspacoDisponivelNaColuna(colunaEscolhida);
                    if(colunaDisponivel){
                        meuTabuleiro.posicionarPecaNoTabuleiro(usuario.obterCor());
                    }else{
                        System.out.println("Coluna sem espaços vazio. Tente escolher outra!");
                    }
                }else{
                    System.out.println("Coluna incorreta. Tente novamente!");
                    continue;
                }
                if(verificarSeAcabouJogo()){
                    break;
                }else{
                    vezDoUsuario = false; 
                }   

            }else{
                System.out.println("------ JOGADA COMPUTADOR -------");
                colunaEscolhida = computador.sortearColuna();

                boolean colunaDisponivel = meuTabuleiro.verificarEspacoDisponivelNaColuna(colunaEscolhida);
                if(colunaDisponivel){
                    meuTabuleiro.posicionarPecaNoTabuleiro(computador.obterCor());
                    System.out.println("Peça do computador foi adicionada com sucesso!");                    
                }else{
                    System.out.println("Coluna sorteada está sem espeaços vazios!");
                    continue;
                }
                if(verificarSeAcabouJogo()){
                    break;
                }else{
                    vezDoUsuario = true; 
                }
           } 
        }while(true);
    }

    private boolean verificarSeAcabouJogo(){
        boolean jogoAcabou = true;
        vencedor = meuTabuleiro.verificacaoVitoria(colunaEscolhida, vezDoUsuario);
        if(!vencedor.equals("null")){ //! no começo da sentença para negação
            fimDeJogoVitoria();
        }else if(meuTabuleiro.verificacaoEmpate()){
            fimDeJogoEmpate();
        }else{
            jogoAcabou = false;
        }
        return jogoAcabou;
    }

    private void fimDeJogoVitoria(){
        System.out.println("========================================================");
        if(vencedor.equals("Usuário")){
            System.out.println("VOCÊ VENCEU! PARABÉNS!");
        }else{
            System.out.println("VOCÊ PERDEU! MAIS SORTE DA PRÓXIMA VEZ");
        }
        System.out.println("========================================================");
        System.out.println("Tabuleiro final:");
        meuTabuleiro.mostrarTabuleiro();
        finalizarJogo();
    }

    private void fimDeJogoEmpate(){
        System.out.println("========================================================");
        System.out.println("EMPATE!");
        System.out.println("========================================================");
        System.out.println("Não tem mais espaços livres.");
        System.out.println("Tabuleiro final:");
        meuTabuleiro.mostrarTabuleiro();
        finalizarJogo();
    }

    private void finalizarJogo(){
        int jogarNovamente;
        do{
            System.out.println("Deseja jogar novamente?(1 - Sim, 2 - Não)");
            jogarNovamente = teclado.nextInt();
            switch(jogarNovamente){
            case 1:
                iniciarNovoJogo();
                break;
        
            case 2: 
                System.out.println("Muito obrigado por jogar!");
                break;

            default:
                System.out.println("Opção incorreta, tente novamente");
                break;
            }
        }while(jogarNovamente != 1 && jogarNovamente != 2);
    }

    private void iniciarNovoJogo(){
        meuTabuleiro = new Tabuleiro();
        escolherCoresDasPecas();
        sortearJogadorQueComeca();
        iniciarPartida();    
    }

    public static void main(String[] args){
        new ExecucaoJogo();
    }
}
