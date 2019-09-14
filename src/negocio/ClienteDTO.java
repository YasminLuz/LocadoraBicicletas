package negocio;

/**
 *
 * @author Yasmin
 */
public class ClienteDTO extends PessoaDTO{
    private String usuario, senha, email;
    private int pacote;

    public ClienteDTO() {
        
    }

    public ClienteDTO(String usuario, String senha, String email, long cpf, String nome, String telefone, String endereco, int pacote) {
        super(cpf, nome, telefone, endereco);
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
        this.pacote = pacote;
    }

    
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPacote() {
        return pacote;
    }

    public void setPacote(int pacote) {
        this.pacote = pacote;
    }
    
    
    
}
