/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.CartaoCredito;

/**
 *
 * @author fernanda
 */
public class ConsultaDados {

    public ConsultaDados() {
    }
    
    public Double consultarCartao(EntityManager em) {
        String sql = "SELECT c.valorLimite FROM CartaoCredito c"; 
        TypedQuery<CartaoCredito> query = em.createQuery(sql, CartaoCredito.class);
        List<CartaoCredito> resultList = query.getResultList();
        return resultList.get(0).getValorLimite();
    }
}
