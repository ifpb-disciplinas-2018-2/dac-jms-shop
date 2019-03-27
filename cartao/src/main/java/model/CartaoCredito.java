package model;

import database.ConsultaDados;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author fernanda
 */

@Stateless
public class CartaoCredito implements Serializable{
    
    private int id;
    private int numero;
    private Double valorLimite;

    public CartaoCredito() {
    }

    public CartaoCredito(int id, int numero, Double valorLimite) {
        this.id = id;
        this.numero = numero;
        this.valorLimite = valorLimite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Double getValorLimite() {
        return valorLimite;
    }

    public void setValorLimite(Double valorLimite) {
        this.valorLimite = valorLimite;
    }

    @Override
    public String toString() {
        return "CartaoCredito{" + "id=" + id + ", numero=" + numero + ", valorLimite=" + valorLimite + '}';
    } 
    
    public void validarCartao(Double valorTotal) {
        ConsultaDados consultaDados = new ConsultaDados();
        Double limiteDisponivel = consultaDados.consultarCartao((EntityManager) this);
        if(limiteDisponivel >= valorTotal){
            limiteDisponivel -= valorTotal;
        }
    }

    public boolean validarCartao(String cartaoNumero, Double valorCompra) {
        return valorCompra <= 1000;
    }
}
