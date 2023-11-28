/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Produto;
import db.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class ProdutoDAO {
    private Connection con;  //Conecta com banco
    private PreparedStatement stm; //prepara a ação no banco
    private ResultSet rs; //retorna dados do banco
    
    public boolean salvar(Produto produto){
        try{
            String sql = "insert into produtos values(?,?,?,?,?)";
            con = Conexao.getConnection();
            stm = con.prepareStatement(sql);
            stm.setLong(1, produto.getCodigo());
            stm.setString(2, produto.getNome());
            stm.setString(3, produto.getDescricao());
            stm.setDouble(4, produto.getPreco());
            stm.setInt(5, produto.getQtde());
            stm.execute();
                return true;
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return false;
    }

    public List<Produto> listaProdutos(String param) {
        try{
            String sql = "";
            if(param.equals("todos")){
                sql = "select * from produtos";
            }else {
                sql = "select * from produtos where "
                        + "produto like '%"+param+"%'";
            }
            
            con = Conexao.getConnection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            Produto produto = null;
            List<Produto> lista = new ArrayList<>();
            while(rs.next()){
                produto = new Produto();
                produto.setCodigo(rs.getLong("codigo"));
                produto.setNome(rs.getString("produto"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQtde(rs.getInt("estoque"));
                lista.add(produto);
            }
            return lista;
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } return null;
    }
    public boolean validaProduto(Long id){
        try{
            String sql = "select * from produtos where codigo = ?";
            con = Conexao.getConnection();
            stm = con.prepareStatement(sql);
            stm.setLong(1, id);
            System.out.println(stm.executeQuery());
            if(stm.executeQuery().equals("")){
                return true;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao validar o produto"+
                    ex.getMessage());
        }
        return false;
    }

    public boolean validaProduto(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


