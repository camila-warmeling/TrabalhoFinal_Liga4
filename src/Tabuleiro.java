public class Tabuleiro {

    public char[][] tabuleiro = new char[6][7]; //[linha][coluna]
    public char corUsuario, corComputador;

    

    private void criarTabuleiro(){
        for(int linha=0; linha<6; linha++){
            for(int coluna=0; coluna<7; coluna++){
                tabuleiro[linha][coluna] = 'B';
            }
        }
    }

    private void mostrarTabuleiro(){
        for(int linha=0; linha<6; linha++){
            for(int coluna=0; coluna<7; coluna++){
                System.out.printf(tabuleiro[linha][coluna] + " ");
            }
            System.out.println();
        }
    }




}
