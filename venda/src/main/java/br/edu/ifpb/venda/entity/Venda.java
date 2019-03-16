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
import javax.persistence.CascadeType;

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
    @OneToMany(cascade = CascadeType.ALL)
    private List <ItemDeVenda> itens;

    public Venda(Integer numeroCartao, List<ItemDeVenda> itens) {
        this.numeroCartao = numeroCartao;
        this.data = new Date();
        total();
    }

    public Venda() {
        this.itens= new ArrayList<>();
        this.data = new Date();
    }

    public long getVenda_id() {
        return venda_id;
    }

    public void setVenda_id(long venda_id) {
        this.venda_id = venda_id;
    }

    public Integer getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(Integer numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public double getValor() {
        total();
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ItemDeVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemDeVenda> itens) {
        this.itens = itens;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (int) (this.venda_id ^ (this.venda_id >>> 32));
        hash = 71 * hash + Objects.hashCode(this.numeroCartao);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 71 * hash + Objects.hashCode(this.data);
        hash = 71 * hash + Objects.hashCode(this.itens);
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
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.itens, other.itens)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venda{" + "venda_id=" + venda_id + ", numeroCartao=" + numeroCartao + ", valor=" + valor + ", data=" + data + ", itens=" + itens + '}';
    }

    private void total() {
        double valorTotal = 0;
        for (int i = 0; i < itens.size(); i++) {

            valorTotal += itens.get(i).getSubtotal();

        }
        this.valor = valorTotal;
    }
}
