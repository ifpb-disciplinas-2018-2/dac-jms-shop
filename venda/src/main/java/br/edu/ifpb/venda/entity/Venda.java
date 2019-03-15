/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.venda.entity;

import java.io.Serializable;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Cliente
 */
@Entity
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long venda_id;
    private Integer numeroCartao;
    private double valor;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @OneToMany
    private List <ItemDeVenda> itens;

    public Venda(Integer numeroCartao, double valor, List<ItemDeVenda> itens) {
        this.venda_id =  venda_id;
        this.numeroCartao = numeroCartao;
        this.data = new Date();
        this.valor = total(itens);
    }

    public Venda() {
        this.itens= new ArrayList<>();
       
    }

    public long getId() {
        return venda_id;
    }

    public void setId(long id) {
        this.venda_id = id;
    }

    public int getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(int numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (this.venda_id ^ (this.venda_id >>> 32));
        hash = 23 * hash + Objects.hashCode(this.numeroCartao);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 23 * hash + Objects.hashCode(this.itens);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venda other = (Venda) obj;
        if (this.venda_id != other.venda_id) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.numeroCartao, other.numeroCartao)) {
            return false;
        }
        if (!Objects.equals(this.itens, other.itens)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + venda_id + ", numeroCartao=" + numeroCartao + ""
                + ", valor=" + valor + ", itens=" + itens + '}';
    }

    public double total(List<ItemDeVenda> item) {
        double valorTotal = 0;
        for (int i = 0; i < item.size(); i++) {

            valorTotal += item.get(i).getSubtotal();

        }
        return valorTotal;
    }
}
