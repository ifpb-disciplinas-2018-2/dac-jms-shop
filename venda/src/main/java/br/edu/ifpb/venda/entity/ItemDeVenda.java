package br.edu.ifpb.venda.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemDeVenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    private Produto produto;
    
    private int quant;
   
    private double subtotal;
    public ItemDeVenda() {
    }

    public ItemDeVenda( Produto produto, int quant) {
        this.produto = produto;
        this.quant = quant;
        this.subtotal=calculoSub(); 
    }

    public double getSubtotal() {
        this.subtotal = calculoSub();
        return this.subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    private  double calculoSub() { 
       return quant * produto.getValor();
    }
    
}
