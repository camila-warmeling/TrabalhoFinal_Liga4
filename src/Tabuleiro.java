public class Tabuleiro {
    private char[][] tabuleiro = new char[6][7]; //[linha][coluna]
    private int linhaVazia, colunaVazia, quantPecasPosicionadas = 0;
    
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
                    numColuna ++;
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
        quantPecasPosicionadas ++;
        tabuleiro[linhaVazia][colunaVazia] = corPosicionar;
    }

    public String verificacaoVitoria(int coluna, boolean jogadorUsuario){
        String vencedor = "null";
        boolean vertical = false, vitoria = false;
        char corJogador = tabuleiro[linhaVazia][coluna];
        int contadorPontos = 0;

        if(linhaVazia <= 2){
            vertical = verificarVitoriaVertical(coluna, corJogador, contadorPontos);
        }

        if(vertical){
            vitoria = true;
        }else if(verificarVitoriaHorizontal(coluna, corJogador, contadorPontos)){
            vitoria = true;
        //}else if(verificarVitoriaDiagonalDireta(coluna, corJogador, contadorPontos)){
            vitoria = true;
        //}else{
            vitoria = true;
        }

        if(vitoria){
            if(jogadorUsuario){
                vencedor = "Usuário";
            }else{
                vencedor = "Computador";
            }
        }
        return vencedor;
    }

    private boolean verificarVitoriaVertical(int coluna, char cor, int contadorPontos){
        for(int linha = linhaVazia; linha <= linhaVazia+3; linha ++){
            if(tabuleiro[linha][coluna] == cor){
                contadorPontos ++;
            }else{//peça de baixo pertence ao adversário
                contadorPontos = 0;
                break;
            }
        }
        if(contadorPontos == 4){
            return true;
        }
        return false;
    }

    private boolean verificarVitoriaHorizontal(int coluna, char cor, int contadorPontos){
        int posicoes = 0; //quantidade de posições que devem ser subtraídas.
        if(coluna >= 3){
            posicoes = 3;
        }else{
            posicoes = coluna;
        }

        //não vai testar além da sexta coluna nem testar desnessariamente colunas a mais.
        for(int colunaAtual=coluna-posicoes; colunaAtual<coluna+4 && colunaAtual<7 ; colunaAtual ++){
            if(tabuleiro[linhaVazia][colunaAtual] == cor){
                contadorPontos ++;
            }else{
                contadorPontos = 0;
            }

            if(contadorPontos == 4){
                return true;
            }
        }

        return false;
    }

    //private boolean verificarVitoriaDiagonalDireta(int coluna, char cor, int contadorPontos){
        
    //}

    //private boolean verificarVitoriaDiagonalEsquerda(int coluna, char cor, int contadorPontos){
        
    //}

    public boolean verificacaoEmpate(){
        boolean empate = (quantPecasPosicionadas == 42); 
        return empate;
    }
}
