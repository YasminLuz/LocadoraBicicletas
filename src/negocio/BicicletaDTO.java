package negocio;

import javafx.scene.chart.PieChart.Data;

/**
 *
 * @author Yasmin
 */
public class BicicletaDTO {
    private int id, quantidade;
    private String fabricante, modelo, cor, tipo_bicicleta, tamanho;
    private Data data_compra, data_manutencao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    
    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTipo_bicicleta() {
        return tipo_bicicleta;
    }

    public void setTipo_bicicleta(String tipo_bicicleta) {
        this.tipo_bicicleta = tipo_bicicleta;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public Data getData_compra() {
        return data_compra;
    }

    public void setData_compra(Data data_compra) {
        this.data_compra = data_compra;
    }

    public Data getData_manutencao() {
        return data_manutencao;
    }

    public void setData_manutencao(Data data_manutencao) {
        this.data_manutencao = data_manutencao;
    }


    
}
