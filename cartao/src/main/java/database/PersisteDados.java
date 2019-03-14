/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.CartaoCredito;

/**
 *
 * @author fernanda
 */
public class PersisteDados {
    @PersistenceContext(unitName = "cartao")
    private final EntityManager em;

    public PersisteDados(EntityManager em) {
        this.em = em;
    }
    
    public void inserirDados(CartaoCredito cartao){
        em.persist(cartao);
        em.getTransaction().commit();
    }
}
