package mensegerDB;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import model.CartaoCredito;


/**
 *
 * @author fernanda, rogerio
 */

@MessageDriven(
    mappedName = "jms/cartaoMsg",
    activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType",
                                  propertyValue = "javax.jms.Queue")
        ,@ActivationConfigProperty(propertyName = "destinationLookup",
                                  propertyValue = "jms/cartaoMsg")
        ,@ActivationConfigProperty(propertyName = "destination",
                                  propertyValue = "queue")
    }
)
public class LerCompra implements MessageListener{

    @Inject
    private CartaoCredito cartaoCredito;
    
    @Override
    public void onMessage(Message msg) {
        
        try {
            
            System.out.println("LEITOR:: Mensagem recebida");
            
            String cartaoNumero = msg.getStringProperty("cartao");
            Double valorCompra = msg.getDoubleProperty("compra");
            

            System.out.println("LEITOR:: Analisando valor da compra");
            
            boolean validaCompra = cartaoCredito.validarCartao(cartaoNumero, valorCompra);
           
            if (validaCompra) {

                System.out.println("LEITOR:: Compra aprovada");
            } else {

                System.out.println("LEITOR:: Compra negada");
            }
            
        } catch (JMSException ex) {
            Logger.getLogger(LerCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
