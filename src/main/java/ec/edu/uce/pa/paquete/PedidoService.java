package ec.edu.uce.pa.paquete;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@ApplicationScoped //Delego el control al contenedor ArC
//@RequestScoped //para aplicaciones web
//@Singleton 
public class PedidoService {

/*
//Inyeccion de dependencia por atributo
    @Inject 
    private MailService mailService;
*/

 
private MailService mailService;

//Inyeccion de dependencia por constructor
@Inject 
public PedidoService(MailService mailService){
 this.mailService = mailService;
}


/* 
private MailService mailService;

//Inyeccion de dependencia por setter
@Inject 
public void setMailService(MailService mailService) {
    System.out.println("Se esta inyectando el servicio de correo electronico en PedidoService");
    
    this.mailService = mailService;
}
*/

public void realizar(Pedido pedido){
 
        System.out.println("Realizando pedido...");
        System.out.println("Pedido realizado al cliente: " + pedido.getCliente());
        System.out.println("Producto: " + pedido.getProducto());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
        System.out.println("Pedido realizado con exito.");
  
        String asunto = "Configuración de pedido.";
        String cuerpo = "Estimado " + pedido.getCliente() + ", su pedido de " + "'" + pedido.getProducto() + "'" +
        " por un total de $" + pedido.getTotal() + " ha sido realizado con éxito.";
 
        this.mailService.enviar(pedido.getCorreo(), asunto, cuerpo);
  
    }
}
