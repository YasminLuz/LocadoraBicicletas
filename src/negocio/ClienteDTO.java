package negocio;

/**
 *
 * @author Yasmin
 */
public class ClienteDTO extends PessoaDTO{
    private String usuario, senha;

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
    
    
    
}
