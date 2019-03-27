package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author fernanda
 */

@Entity
public class Cartao implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int numero;
    private Double valorLimite;

    public Cartao() {
    }

    public Cartao(int id, int numero, Double valorLimite) {
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

    public List<Cartao> getResultList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
