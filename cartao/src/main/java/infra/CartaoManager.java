/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infra;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Cartao;

/**
 *
 * Created by rodger, fernanda on Mar 27, 2019 5:55:44 PM
 */
public class CartaoManager {

    private final static String PERSISTENCE_UNIT = "cartao";
    
    private EntityManager em;
    
    public CartaoManager() {
        this.em = Persistence
            .createEntityManagerFactory(PERSISTENCE_UNIT)
            .createEntityManager();
    }
    
    public void inserirDados(Cartao cartao){
        em.persist(cartao);
        em.getTransaction().commit();
    }
    
    public Double consultarCartao(String cartao) {
        String sql = "SELECT c.valorLimite FROM CartaoCredito c WHERE c.numero = :cartao"; 
         
        TypedQuery<Double> query = em.createQuery(sql, Double.class);
        Double valorLimite = query.setParameter("cartao", cartao).getSingleResult();
     
        return valorLimite;
    }

    public void alterarValorLimite(String cartaoNumero, Double novoLimite) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
