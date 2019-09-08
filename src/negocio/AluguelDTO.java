package negocio;

import javafx.scene.chart.PieChart.Data;

/**
 *
 * @author Yasmin
 */
public class AluguelDTO {
//    private int id_aluguel;
    private Data data_aluguel;
    private Data data_devolucao;

    public Data getData_aluguel() {
        return data_aluguel;
    }

    public void setData_aluguel(Data data_aluguel) {
        this.data_aluguel = data_aluguel;
    }

    public Data getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Data data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
  
    
}
