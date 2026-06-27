public abstract class JogadorModelo{ //abstract - classe que serve apenas como modelo/contrato para outras classes. Não pode ser istanciada
    protected char cor;

    public JogadorModelo(char cor){
        this.cor = cor;
    }
    
    public char obterCor(){
        return this.cor;
    }
}
