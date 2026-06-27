public class Tabuleiro {
    private char[][] tabuleiro = new char[6][7]; //[linha][coluna]
    private int linhaVazia, colunaVazia;
    
    public Tabuleiro(){
        criarTabuleiro();
    }

    private void criarTabuleiro(){
        for(int linha=0; linha<6; linha++){
            for(int coluna=0; coluna<7; coluna++){
                tabuleiro[linha][coluna] = 'B';
            }
        }
    }

    public void mostrarTabuleiro(){
        int numColuna = -1;
        for(int linha=-1; linha<6; linha++){
            for(int coluna=0; coluna<7; coluna++){
                if(linha != -1){
                    System.out.printf(tabuleiro[linha][coluna] + " ");    
                }else{
                    numColuna += 1;
                    System.out.printf(numColuna + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean verificarColunaExiste(int coluna){
        boolean colunaExiste = coluna >=0 && coluna <=6; //retorna verdadeiro ou falso
        return colunaExiste;
    }
        
    public boolean verificarEspacoDisponivelNaColuna(int coluna){        
        boolean colunaDisponivel = false;
        
        for(int linha=5; linha>=0; linha--){
            colunaDisponivel = tabuleiro[linha][coluna] == 'B';
            if(colunaDisponivel){//quando encontra a coluna disponível acaba o for
                linhaVazia = linha;
                colunaVazia = coluna;
                break;
            }
        }
        return colunaDisponivel;
    }

    public void posicionarPecaNoTabuleiro(char corPosicionar){
        tabuleiro[linhaVazia][colunaVazia] = corPosicionar;
    }


}
