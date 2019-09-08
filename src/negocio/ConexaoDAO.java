package negocio;

import persistencia.SQLConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Yasmin
 */

public class ConexaoDAO {

    private static Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private static ConexaoDAO connect;
    
    
    private final String createCliente = "INSERT INTO CLIENTE(cpf, nome, telefone, endereco, usuario, senha) VALUES (?, ?, ?, ?, ?, ?)";
    private final String createPlano = "INSERT INTO PLANO_ALUGUEL(tipo_plano, fidelidade) VALUES (?, ?)";
    private final String createPag = "INSERT INTO PAGAMENTO(tipo) VALUES (?)";
    private final String queryCliente = "SELECT * FROM CLIENTE";
    private final String queryValidate = "SELECT usuario, senha FROM CLIENTE";
    private final String queryBicicleta= "SELECT CONT(id), modelo, tipo, tamanho, cor FROM BICICLETA";
    private final String queryAcessorios = "SELECT nome_acessorios FROM ACESSORIOS";
    
    private ConexaoDAO() { 
        conn = SQLConnection.getInstance().startConnection();
        stmt = null;
    }

    public static ConexaoDAO getInstance(){
       if(connect == null) 
          connect = new ConexaoDAO();
        return connect;
    }
      
    public void create(ClienteDTO c){
        
        try {
            stmt = conn.prepareStatement(createCliente);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getTelefone());
            stmt.setString(3, c.getEndereco());
            stmt.setString(4, c.getUsuario());
            stmt.setString(5, c.getSenha());
//            stmt.setDate(7,new Date(Calendar.getInstance().getTimeInMillis()));  
            
            stmt.execute();
            
        } catch (SQLException ex) {
            System.err.println("Não foi possivel criar usuario"+ ex);
            
        } finally{
            SQLConnection.getInstance().closeConnection();
            
        }   
    }
    
    public void create2(PlanoDTO p, PagamentoDTO pgm){
        
        try {
            stmt = conn.prepareStatement(createPlano);
            stmt.setString(1, p.getEscolher_plano());
            stmt.setString(2, p.getFidelidade_plano());
            
            stmt = conn.prepareStatement(createPag);
            stmt.setString(1, pgm.getForma_pagamento());
                                 
            stmt.execute();
            
        } catch (SQLException ex) {
            System.err.println("Não foi possivel cadastrar os campos"+ ex);
            
        } finally{
            SQLConnection.getInstance().closeConnection();
            
        }   
    }
    
    public ArrayList<BicicletaDTO> BikeList(){
        ArrayList<BicicletaDTO> bicicletas = new ArrayList<>();
        
        try {
            conn.prepareStatement(queryBicicleta);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                BicicletaDTO bike = new BicicletaDTO();
                bike.setQuantidade(rs.getInt("quantidade"));
                bike.setModelo(rs.getString("modelo"));
                bike.setTipo_bicicleta(rs.getString("tipo_bicicleta"));
                bike.setTamanho(rs.getString("tamanho"));
                bike.setCor(rs.getString("cor"));
                            
                bicicletas.add(bike);
            }
           
            conn.close();
            
        } catch (SQLException ex) {
            System.err.println("Erro ao capturar dados do SGBD"+ ex);
        }
        
        return bicicletas;
    }
    
      public ArrayList<AcessoriosDTO> AcessorioList(){
        ArrayList<AcessoriosDTO> acessorios = new ArrayList<>();
        
        try {
            conn.prepareStatement(queryAcessorios);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                AcessoriosDTO acessory = new AcessoriosDTO();
                acessory.setNome_acessorio(rs.getString("nome_acessorio"));
                acessory.setPreco(rs.getDouble("preco"));
                
                acessorios.add(acessory);
            }
           
            conn.close();
            
        } catch (SQLException ex) {
            System.err.println("Erro ao capturar dados do SGBD"+ ex);
        }
        
        return acessorios;
    }
      
    public ArrayList<ClienteDTO> Validacao(){
        ArrayList<ClienteDTO> logon = new ArrayList<>();
        
        try {
            conn.prepareStatement(queryCliente);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                ClienteDTO logar = new ClienteDTO();
                logar.setUsuario(rs.getString("usuario"));
                logar.setSenha(rs.getString("senha"));
                
                logon.add(logar);
            }
           
            conn.close();
            
        } catch (SQLException ex) {
            System.err.println("Erro ao capturar dados do SGBD"+ ex);
        }
        
        return logon;
    }   
 
    
    
}
