package negocio;

/**
 *
 * @author Yasmin
 */
public class AcessoriosDTO {
    private int id;
    private String nome_acessorio;
    private double preco;

    public int getId_acessorios() {
        return id;
    }

    public void setId_acessorios(int id_aluguel) {
        this.id = id_aluguel;
    }
 
    public String getNome_acessorio() {
        return nome_acessorio;
    }

    public void setNome_acessorio(String nome_acessorio) {
        this.nome_acessorio = nome_acessorio;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

  
}
