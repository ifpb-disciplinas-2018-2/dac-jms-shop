package br.edu.ifpb.venda.controller;

import br.edu.ifpb.venda.api.ProdutoClient;
import br.edu.ifpb.venda.dao.ProdutoDaoIF;
import br.edu.ifpb.venda.entity.Produto;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Amanda
 */
@Named
@RequestScoped
public class ControllerProduto {

    @EJB//(mappedName = "consumirCliente")
    private ProdutoClient prodDao;
    private Produto produto = new Produto();

    public String cadastrar() {
        this.prodDao.salvar(
                this.produto
        );
        this.produto = new Produto();
        return null;
    }

    public List<Produto> listar() {
        return prodDao.listar();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
