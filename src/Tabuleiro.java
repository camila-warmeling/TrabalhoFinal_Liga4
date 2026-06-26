public class Tabuleiro {
    private char[][] tabuleiro = new char[6][7]; //[linha][coluna]
    private int numColuna = -1;
    private boolean colunaExiste, colunaDisponivel;
    
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
        if(coluna >=0 && coluna <=6){
            colunaExiste = true;
        }else{
            colunaExiste = false;
        }

        return colunaExiste;
    }
        
    public boolean verificarEspacoDisponivelNaColuna(int coluna){

        return colunaDisponivel;
    }

    public void posicionarPecaNoTabuleiro(char corPeca){

    }


}
