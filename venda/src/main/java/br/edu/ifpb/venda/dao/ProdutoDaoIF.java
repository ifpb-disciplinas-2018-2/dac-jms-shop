package br.edu.ifpb.venda.dao;

import br.edu.ifpb.venda.entity.Produto;
import java.util.List;

/**
 *
 * @author Amanda
 */
public interface ProdutoDaoIF {
    public void salvar(Produto produto);
    public Produto buscar(long id);
    public List<Produto> listar();
}
