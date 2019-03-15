/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.venda.dao;


import br.edu.ifpb.venda.entity.Venda;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Cliente
 */
@Stateless
public class VendaDao implements VendaIF {
  public EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JMSVendaPU");
        EntityManager em = factory.createEntityManager();

        return em;
    }
    @Override
    public void salvar(Venda v) {
         EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        
        
        em.persist(v);
        
        transaction.commit();
    }

    @Override
    public Venda Buscar(int id) {
         EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Venda v;

        v = em.find(Venda.class, id);

        transaction.commit();
        return v;
    }

    @Override
    public List<Venda> listar() {
         EntityManager em = getEntityManager();
        String sql = "SELECT v FROM venda v";
        TypedQuery<Venda> query = em.createQuery(sql, Venda.class);
        List<Venda> resultList = query.getResultList();

        return resultList;
    }

    @Override
    public void remove(int id) {
         EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Venda v;

        v = em.find(Venda.class, id);
        em.remove(v);
        transaction.commit();
    }

}
