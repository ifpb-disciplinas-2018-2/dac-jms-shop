package model;

import database.ConsultaDados;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author fernanda
 */
@Entity
public class CartaoCredito implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    private Integer numero;
    private Double valorLimite;

    public CartaoCredito() {
    }

    public CartaoCredito(Integer id, Integer numero, Double valorLimite) {
        this.id = id;
        this.numero = numero;
        this.valorLimite = valorLimite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
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
    
    private void validarCartao(Double valorTotal) {
        ConsultaDados consultaDados = new ConsultaDados();
        Double limiteDisponivel = consultaDados.consultarCartao((EntityManager) this);
        if(limiteDisponivel >= valorTotal){
            limiteDisponivel -= valorTotal;
        }
    }
}
