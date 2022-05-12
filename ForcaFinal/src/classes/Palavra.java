
package classes;

/**
 *
 * @author Pichau
 */
public class Palavra {
    
    protected String colecao;
    
    protected String dica;

    public Palavra(String palavra, String dica) {
        this.colecao = palavra;
        this.dica = dica;
    }

    public Palavra() {
    }

    public String getPalavra() {
        return colecao;
    }

    public void setPalavra(String palavra) {
        this.colecao = palavra;
    }

    public String getDica() {
        return dica;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }
    
   
    
    
    
    
    
}
