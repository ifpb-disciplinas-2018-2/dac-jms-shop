package mensegerDB;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;

/**
 *
 * Created by rodger on Mar 27, 2019 5:16:03 PM
 */
public class EnviarCompra {
    
    @Resource(lookup = "jms/cartaoMsg")
    private Queue queue;

    @Inject
    private JMSContext context;


    public void enviarMsg(String numeroCartao,int valorCompra) {
        
        try {
            
            JMSProducer producer = context.createProducer();
            ObjectMessage createObjectMessage = context.createObjectMessage();
            
            createObjectMessage.setStringProperty("cartao",numeroCartao);
            createObjectMessage.setIntProperty("compra",valorCompra);
            
            producer.send(queue,createObjectMessage);
            System.out.println("ENVIADOR:: Mensagem enviada");
            
        } catch (JMSException ex) {
            Logger.getLogger(EnviarCompra.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }
}
