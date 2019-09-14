package persistencia;

 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.AcessoriosDTO;
import negocio.AluguelDTO;
import negocio.BicicletaDTO;
import negocio.ClienteDTO;
import negocio.PostoDTO;

/**
 *
 * @author Yasmin
 */

public class ConexaoDAO {

    private static Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private static ConexaoDAO connect;
    
    
    private final String createCliente = "INSERT INTO CLIENTE(cpf, nome, telefone, endereco, usuario, senha, email, tipo_plano) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String createAluguel = "INSERT INTO ALUGUEL(data_aluguel, data_devolucao, id_cliente, id_funcionario, pagamento, id_bicicleta, id_posto_retirada, quantidade_retirada) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String createPlano = "INSERT INTO PLANO_ALUGUEL(tipo_plano, fidelidade) VALUES (?, ?)";
    private final String createPag = "INSERT INTO PAGAMENTO(tipo) VALUES (?)";
    private final String queryCliente = "SELECT * FROM CLIENTE";
    private final String queryValidate = "SELECT usuario, senha FROM CLIENTE WHERE usuario=? AND senha=?";
    private final String queryBicicleta= "SELECT id, quantidade, modelo, tipo_bicicleta, tamanho, cor FROM BICICLETA ";
    private final String queryAcessorios = "SELECT id, nome_acessorio, preco FROM ACESSORIOS";// WHERE id_posto=?";
    private final String queryPostos = "SELECT * FROM POSTO";
    private final String queryAluguel = "SELECT * FROM ALUGUEL";
    
    
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
            stmt.setLong(1, c.getCpf());
            stmt.setString(2, c.getNome());
            stmt.setString(3, c.getTelefone());
            stmt.setString(4, c.getEndereco());
            stmt.setString(5, c.getUsuario());
            stmt.setString(6, c.getSenha());
            stmt.setString(7, c.getEmail());
            stmt.setInt(8, c.getPacote());
//            stmt.setDate(7,new Date(Calendar.getInstance().getTimeInMillis()));  
            
            stmt.execute();
            
        } catch (SQLException ex) {
            System.err.println("Não foi possivel cadastrar usuario"+ ex);
            
        } finally{
            SQLConnection.getInstance().closeConnection();
            
        }   
    }
    
    
    public void createAluguel(AluguelDTO a){
        
        try {
            stmt = conn.prepareStatement(createAluguel);
            stmt.setDate(1, a.getData_aluguel());
            stmt.setDate(2, a.getData_devolucao());
            stmt.setLong(3, a.getId_cliente());
            stmt.setLong(4, a.getIdfuncionario());
            stmt.setInt(5, a.getPagamento());
            stmt.setInt(6, a.getId_bicicleta());
            stmt.setInt(7, a.getId_posto_retirada());
            stmt.setInt(8, a.getQuantidade_retirada());
            
            stmt.execute();
            
        } catch (SQLException ex) {
            System.err.println("Não foi possivel criar reserva"+ ex);
            
        } finally{
            SQLConnection.getInstance().closeConnection();
            
        }   
    }
        
    public ArrayList<BicicletaDTO> BikeList(){
        ArrayList<BicicletaDTO> bicicletas = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement(queryBicicleta);
//            stmt.setInt(1,id_posto);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                BicicletaDTO bike = new BicicletaDTO();
                bike.setId(rs.getInt("id"));
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
            stmt = conn.prepareStatement(queryAcessorios);
//            stmt.setInt(1,id_posto);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                AcessoriosDTO acessorio = new AcessoriosDTO();
                acessorio.setId_acessorios(rs.getInt("id"));
                acessorio.setNome_acessorio(rs.getString("nome_acessorio"));
                acessorio.setPreco(rs.getDouble("preco"));
                
                acessorios.add(acessorio);
            }
           
            conn.close();
            
        } catch (SQLException ex) {
            System.err.println("Erro ao capturar dados do SGBD"+ ex);
        }
        
        return acessorios;
    }
    
      public ArrayList<PostoDTO> PostosList(){
        ArrayList<PostoDTO> postos = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement(queryPostos);
            ResultSet rs = stmt.executeQuery();
     
            while(rs.next()){
                PostoDTO posto = new PostoDTO();
                posto.setId_posto(rs.getInt("id"));
                posto.setNome_posto(rs.getString("nome_posto"));
                posto.setEndereco(rs.getString("endereco"));
                posto.setBaias(rs.getInt("baias"));
                
                postos.add(posto);
            }
           
            conn.close();
            
        } catch (SQLException ex) {
            System.err.println("Erro ao capturar dados do SGBD"+ ex);
        }
        
        return postos;
    }
      
    
    public boolean Validacao(String usuario, String senha){
        
        try {
            stmt = conn.prepareStatement(queryValidate);      
            stmt.setString(1,usuario);
            stmt.setString(2,senha);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
                if(usuario.equals(rs.getString("usuario")) && senha.equals(rs.getString("senha")))
                    return true;
                       
            conn.close();
            
        } catch (SQLException ex) {
            System.err.println("Erro ao capturar dados do SGBD"+ ex);
        }
        return false;
    }   
 
    
    
}
