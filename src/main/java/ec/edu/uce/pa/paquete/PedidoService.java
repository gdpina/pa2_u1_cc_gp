
package ec.edu.uce.pa.paquete;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

@ApplicationScoped //Delego el control al contenedor ArC
//@RequestScoped //para aplicaciones web
//@Singleton 
public class PedidoService {
    @Inject 
    @Named("mail")
    private MailService notificacionCorreo;

    @Inject 
    @Named("sms")
    private SMSService notificacionSMS;

public void realizar(Pedido pedido){
 
        System.out.println("Realizando pedido...");
        System.out.println("Pedido realizado al cliente: " + pedido.getCliente());
        System.out.println("Producto: " + pedido.getProducto());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
        System.out.println("Pedido realizado con exito.");
  
        String cuerpo = "Estimado " + pedido.getCliente() + ", su pedido de " + "'" + pedido.getProducto() + "'" +
        " por un total de $" + pedido.getTotal() + " ha sido realizado con éxito.";
 
        //Notificacion de pedido por correo electronico
        this.notificacionCorreo.enviar(pedido.getCorreo(), cuerpo);

        //Notificacion de pedido por SMS
        this.notificacionSMS.enviar(pedido.getTelefono(), cuerpo);
    }
}
