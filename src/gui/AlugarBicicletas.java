package gui;

import Interface.IFuncionalidades;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import negocio.AluguelDTO;
import negocio.BicicletaDTO;
import negocio.PostoDTO;
import persistencia.ConexaoDAO;

/**
 *
 * @author Yasmin
 */
public class AlugarBicicletas extends javax.swing.JFrame implements IFuncionalidades{

    /**
     * Creates new form Bicicletas
     */
    public AlugarBicicletas() {
        initComponents();
        exibir();
        jSpinner1.setModel(new SpinnerNumberModel(0, 0, 35, 1));
    }

//    public static String nome_posto;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTBicicletas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTxtPosto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Alugar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTBicicletas.setBackground(new java.awt.Color(204, 204, 204));
        jTBicicletas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTBicicletas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Quantidade", "Modelo", "Tipo", "Tamanho", "Cor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTBicicletas.setGridColor(new java.awt.Color(102, 102, 102));
        jScrollPane2.setViewportView(jTBicicletas);

        jLabel1.setText("Quantidade: ");

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Posto selecionado:");

        jTxtPosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtPostoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtPosto, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtPosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(298, 298, 298)))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    PostoDTO posto;
    
    private void exibir(){  
       ArrayList<BicicletaDTO> lista = ConexaoDAO.getInstance().BikeList();
       DefaultTableModel tabmodel = (DefaultTableModel)jTBicicletas.getModel(); 
       tabmodel.setNumRows(0);
       
       for (int i = 0; i < lista.size(); i++)
          tabmodel.addRow(new Object[]{lista.get(i).getId(),lista.get(i).getQuantidade(),lista.get(i).getModelo(), lista.get(i).getTipo_bicicleta(), lista.get(i).getTamanho(), lista.get(i).getCor()});
    }
    
    @Override
    public final void importarPosto(String str){
        jTxtPosto.setText(str);
    }
    
    public int[] exportarIdBicicleta(){
        int[] arrayIDs ={Integer.parseInt(jTBicicletas.getValueAt(jTBicicletas.getSelectedRow(), 0).toString()), Integer.parseInt(jTBicicletas.getValueAt(jTBicicletas.getSelectedRow(), 1).toString())};
        return arrayIDs;
    }
      
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       alugar(); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTxtPostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtPostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtPostoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlugarBicicletas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlugarBicicletas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlugarBicicletas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlugarBicicletas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlugarBicicletas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTBicicletas;
    private javax.swing.JTextField jTxtPosto;
    // End of variables declaration//GEN-END:variables

    @Override
    public void alugar() {
           try {
            AlugarAcessorios acess = new AlugarAcessorios();
            CadastroCliente cadastro = new CadastroCliente();
            Postos posto = new Postos();
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String d = sdf.format(new Date(System.currentTimeMillis())); //data sistema
            
            Date data1, data2;
            
            data1 = new java.sql.Date(sdf.parse(d).getTime());
            data2 = data1;
            
            if(cadastro.exportarIDsCadastro()[0] == 1){
                data2.setDate(data1.getDate());
            } else if (cadastro.exportarIDsCadastro()[0] == 2){
                data2.setDate(data1.getDate() + 5);
            } else if (cadastro.exportarIDsCadastro()[0] == 3 || cadastro.exportarIDsCadastro()[0] == 5){
                data2.setDate(data1.getDate() + 30);
            } else if (cadastro.exportarIDsCadastro()[0] == 4 || cadastro.exportarIDsCadastro()[0] == 6){
                data2.setDate(data1.getDate() + 365);
            }
            
            AluguelDTO aluguei = new AluguelDTO(data1, data2, cadastro.exportarIDsCadastro()[1], 0, (int)cadastro.exportarIDsCadastro()[0], exportarIdBicicleta()[0], posto.exportarIdPosto(), jSpinner1.getComponentCount());
            ConexaoDAO.getInstance().createAluguel(aluguei);
            
        } catch (ParseException ex) {
            Logger.getLogger(AlugarBicicletas.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}
