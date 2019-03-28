/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infra;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Cartao;

/**
 *
 * Created by rodger, fernanda on Mar 27, 2019 5:55:44 PM
 */
public class CartaoManager {

    private final static String PERSISTENCE_UNIT_NAME = "cartao";
    
    private EntityManager manager;
    
    public CartaoManager() {
        this.manager = Persistence
            .createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
            .createEntityManager();
    }
    
    public void inserirDados(Cartao cartao){
        manager.persist(cartao);
        manager.getTransaction().commit();
    }
    
    public Cartao buscarCartao(String numeroCartao) {
        String sql = "SELECT c.valorLimite FROM CartaoCredito c WHERE c.numero = :numeroCartao"; 
         
        TypedQuery<Cartao> query = manager.createQuery(sql, Cartao.class);
        Cartao cartao = query.setParameter("numeroCartao", numeroCartao).getSingleResult();
     
        return cartao;
    }

    public void alterarValorLimite(int id, Double novoLimite) {
        Cartao cartao = buscarPorId(id);        
        cartao.setValorLimite(novoLimite);
        manager.merge(cartao);
    }
    
    public Cartao buscarPorId(int cartaoId) {
        Cartao cartao = manager.find(Cartao.class, cartaoId);
        if (cartao == null) {
            throw new EntityNotFoundException("Nenhum artista encontrado para o ID :: "
                + cartaoId);
        }
        return cartao;
    }
    
    public List<Cartao> todosOsCartoes() {
        Query query = manager.createQuery("SELECT C FROM Cartao c", Cartao.class);
        return query.getResultList();
    }
}
