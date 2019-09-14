package negocio;

import java.sql.Date;

/**
 *
 * @author Yasmin
 */
public class AluguelDTO {
//    private int id_aluguel;
    private Date data_aluguel, data_devolucao;
    private int pagamento, id_bicicleta, id_posto_retirada,quantidade_retirada;
    private long id_cliente, idfuncionario;

    public AluguelDTO() {
    }

       
    public AluguelDTO(Date data_aluguel, Date data_devolucao, long id_cliente, long idfuncionario, int pagamento, int id_bicicleta, int id_posto_retirada, int quantidade_retirada) {
        this.data_aluguel = data_aluguel;
        this.data_devolucao = data_devolucao;
        this.id_cliente = id_cliente;
        this.idfuncionario = idfuncionario;
        this.pagamento = pagamento;
        this.id_bicicleta = id_bicicleta;
        this.id_posto_retirada = id_posto_retirada;
        this.quantidade_retirada = quantidade_retirada;
    }
    
    public Date getData_aluguel() {
        return data_aluguel;
    }

    public void setData_aluguel(Date data_aluguel) {
        this.data_aluguel = data_aluguel;
    }

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public long getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(int idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public int getPagamento() {
        return pagamento;
    }

    public void setPagamento(int pagamento) {
        this.pagamento = pagamento;
    }

    public int getId_bicicleta() {
        return id_bicicleta;
    }

    public void setId_bicicleta(int id_bicicleta) {
        this.id_bicicleta = id_bicicleta;
    }

    public int getId_posto_retirada() {
        return id_posto_retirada;
    }

    public void setId_posto_retirada(int id_posto_retirada) {
        this.id_posto_retirada = id_posto_retirada;
    }

    public int getQuantidade_retirada() {
        return quantidade_retirada;
    }

    public void setQuantidade_retirada(int quantidade_retirada) {
        this.quantidade_retirada = quantidade_retirada;
    }
  
}
