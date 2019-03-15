package br.teste;


import br.edu.ifpb.venda.dao.ProdutoDao;
import br.edu.ifpb.venda.dao.ProdutoDaoIF;
import br.edu.ifpb.venda.entity.Produto;
import java.util.List;


public class TesteMain {

    public static void main(String[] args) {
        ProdutoDaoIF daoIF = new ProdutoDao();
        
        daoIF.salvar(new Produto("Testando no main", 1));
        
        List<Produto> lista = daoIF.listar();
        
        for(Produto list : lista){
            System.out.println(list.getDescricao());
        }
    }
}
