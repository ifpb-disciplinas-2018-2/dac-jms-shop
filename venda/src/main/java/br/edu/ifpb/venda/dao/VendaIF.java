/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.venda.dao;


import br.edu.ifpb.venda.entity.Venda;
import java.util.List;

/**
 *
 * @author Cliente
 */
public interface VendaIF {
    public void salvar(Venda v);
    public Venda Buscar(int id);
    public List<Venda> listar();
    public void remove ( int id);
           
}
