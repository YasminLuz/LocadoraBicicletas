package negocio;

/**
 *
 * @author Yasmin
 */
public class EnderecoDTO {
    private String logradouro, nomeLogradouro, numero, bloco, apartamento, bairro, cidade, estado;

    public EnderecoDTO(String logradouro, String nomeLogradouro, String numero, String bloco, String apartamento, String bairro, String cidade, String estado) {
        this.logradouro = logradouro;
        this.nomeLogradouro = nomeLogradouro;
        this.numero = numero;
        this.bloco = bloco;
        this.apartamento = apartamento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return  logradouro + " " + nomeLogradouro + ", numero " + numero + ", bloco " + bloco + ", apartamento " + apartamento + ", " + cidade + " - " + estado;
    }
    
    
}
