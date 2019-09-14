package negocio;

/**
 *
 * @author Yasmin
 */
public class PostoDTO {
    private int id_posto;
    private String nome_posto, endereco;
    private int baias;

    public int getId_posto() {
        return id_posto;
    }

    public void setId_posto(int id_posto) {
        this.id_posto = id_posto;
    }

    public String getNome_posto() {
        return nome_posto;
    }

    public void setNome_posto(String nome_posto) {
        this.nome_posto = nome_posto;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getBaias() {
        return baias;
    }

    public void setBaias(int baias) {
        this.baias = baias;
    }
    
    
}
