
package controller;

import infra.CartaoManager;
import javax.ejb.Stateless;

/**
 *
 * Created by rodger on Mar 27, 2019 5:59:14 PM
 */
@Stateless
public class AnalisaCartao {

    CartaoManager cManager = new CartaoManager();
    
    public boolean validarCompra(String cartaoNumero, Double valorCompra) {
        
//        Double limiteDisponivel = cManager.consultarCartao(cartaoNumero);
//        if(limiteDisponivel >= valorCompra){
//            Double novoLimite = limiteDisponivel - valorCompra;
//            cManager.alterarValorLimite(cartaoNumero, novoLimite);
//            return true;
//        }
//        return false;
        
        return valorCompra <= 1000;
    }

}
