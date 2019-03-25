package br.edu.ifpb.venda.dao;

import br.edu.ifpb.venda.entity.Produto;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Amanda
 */
@Stateless//(mappedName = "produtoDao")
//@Remote(ProdutoDaoIF.class)
public class ProdutoDao{ //implements ProdutoDaoIF {
    
    @PersistenceContext
    EntityManager em;

//    public EntityManager getEntityManager() {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JMSVendaPU");
//        return factory.createEntityManager();
//    }

//    @Override
    public void salvar(Produto produto) {
        em.persist(produto);
    }

//    @Override
    public Produto buscar(long id) {
        Produto p = em.find(Produto.class, id);
        return  p;
    }

//    @Override
    public List<Produto> listar() {
        String sql = "SELECT p FROM Produto p";
        TypedQuery<Produto> query = em.createQuery(sql, Produto.class);
        return query.getResultList();
    }

}
