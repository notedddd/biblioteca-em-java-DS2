/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ProdutoDAO;
import Model.Produto;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class ProdutoController {

    public boolean Salvar(Produto produto) {
        ProdutoDAO prodDAO = new ProdutoDAO();
        return prodDAO.salvar(produto);
    }
    public List<Produto> listaProdutos(String param){
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.listaProdutos(param);
    }

    public List<Produto> listaProdutos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean alterar(Produto produto){
        ProdutoDAO prodDAO = new ProdutoDAO();
        return produtoDAO.consultaNomeProduto(param);
    }
    
    public boolean validaProduto(Long id){
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.validaProduto(id);
    }
}
