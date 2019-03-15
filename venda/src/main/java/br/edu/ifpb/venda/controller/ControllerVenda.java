package br.edu.ifpb.venda.controller;

import br.edu.ifpb.venda.dao.VendaIF;
import br.edu.ifpb.venda.entity.ItemDeVenda;
import br.edu.ifpb.venda.entity.Produto;
import br.edu.ifpb.venda.entity.Venda;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Amanda
 */
@Named
@RequestScoped
public class ControllerVenda {
    
    @EJB
    private VendaIF vendaDao;
    private Venda venda = new Venda();
    private ItemDeVenda itemDeVenda = new ItemDeVenda();
    
    public String salvar(){
        this.vendaDao.salvar(
                this.venda
        );
        this.venda = new Venda();
        return null;
    }
    
    public List<ItemDeVenda> listarItensVenda(){
        return this.venda.getItens();
    }
    
    public String addItemVenda(){
        this.venda.getItens().add(this.itemDeVenda);
        this.itemDeVenda = new ItemDeVenda();
        return null;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public ItemDeVenda getItemDeVenda() {
        return itemDeVenda;
    }

    public void setItemDeVenda(ItemDeVenda itemDeVenda) {
        this.itemDeVenda = itemDeVenda;
    }

}
