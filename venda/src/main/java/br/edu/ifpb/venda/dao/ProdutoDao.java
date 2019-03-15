package br.edu.ifpb.venda.dao;

import br.edu.ifpb.venda.entity.Produto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Amanda
 */
@Stateless
public class ProdutoDao implements ProdutoDaoIF {

    public EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JMSVendaPU");
        return factory.createEntityManager();
    }

    @Override
    public void salvar(Produto produto) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
    }

    @Override
    public Produto buscar(long id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Produto p = em.find(Produto.class, id);
        em.getTransaction().commit();
        return  p;
    }

    @Override
    public List<Produto> listar() {
        EntityManager em = getEntityManager();
        String sql = "SELECT p FROM Produto p";
        TypedQuery<Produto> query = em.createQuery(sql, Produto.class);
        return query.getResultList();
    }

}
