
package controller;

import infra.CartaoManager;
import javax.ejb.Stateless;
import model.Cartao;

/**
 *
 * Created by rodger on Mar 27, 2019 5:59:14 PM
 */
@Stateless
public class AnalisaCartao {

    CartaoManager cManager = new CartaoManager();
    
    public boolean validarCompra(String cartaoNumero, Double valorCompra) {
        Cartao cartao = buscarCartao(cartaoNumero);//cManager.buscarCartao(cartaoNumero);
        Double limiteDisponivel = cartao.getValorLimite() ;
        if(limiteDisponivel >= valorCompra){
            return novoLimite(limiteDisponivel, valorCompra, cartao);
        }
        return false;
    }

    private Cartao buscarCartao(String cartaoNumero) {
        return cManager.buscarCartao(cartaoNumero);
    }
    
    private boolean novoLimite(Double limiteDisponivel, Double valorCompra, Cartao cartao) {
        Double novoLimite = limiteDisponivel - valorCompra;
        cManager.alterarValorLimite(cartao.getId(), novoLimite);
        return true;
    }

}
