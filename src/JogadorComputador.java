public class JogadorComputador {
    private char cor;
    private int coluna;

    public JogadorComputador(char corEscolhida){
        this.cor = corEscolhida;
    }

    public char obterCor(){
        return this.cor;
    }

    public int sortearColuna(){
        coluna = (int)(Math.random() * 7);
        return coluna;
    }

}
