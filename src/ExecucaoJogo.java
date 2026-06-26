import java.util.Scanner;

public class execucaoJogo {
    public Scanner teclado = new Scanner(System.in);
    char corUsuario, corComputador;

    private execucaoJogo(){
        
    }

    private void mostrarMenu(){
        System.out.println("Menu:");
        System.out.println("1 - Como Jogar");
        System.out.println("2 - Mostrar Tabuleiro");
        System.out.println("3 - Novo Jogo");
        System.out.println("4 - Continuar Jogo");
        System.out.println("5 - Sair");

    }

    private void escolherCorPecaUsuarioComputador() {
        System.out.println("Cores disponíveis para jogar:");
        System.out.println("V - Vermelho");
        System.out.println("A - Azul");

        System.out.println("Qual cor deseja?");
        corUsuario = teclado.next().toUpperCase().charAt(0);
        if (corUsuario == 'V') {
            corComputador = 'A';
        } else {
            corComputador = 'V';
        }
    }

    private void sortearJogadorQueComeca(){
        int num;
        System.out.println("O jogador que começa jogando é:");
        num = (int)(Math.random());
        if(num == 0){
            System.out.println("Usuário");

        }else(num == 1){
            System.out.println("Computador");
        }
    }

    public static void main(String[] args){

        System.out.println("Seja bem-vindo ao jogo Liga-4");
        System.out.println("Para começar, escolha uma opção do menu");
        mostrarMenu();
    }

}
