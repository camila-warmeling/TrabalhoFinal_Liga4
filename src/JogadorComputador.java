public class JogadorComputador extends JogadorModelo{

    public JogadorComputador(char cor){
        super(cor);
    }

    public int sortearColuna(){
        int coluna = (int)(Math.random() * 7);
        return coluna;
    }
}
