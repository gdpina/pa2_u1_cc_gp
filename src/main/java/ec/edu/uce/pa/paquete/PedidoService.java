package ec.edu.uce.pa.paquete;

import ec.edu.uce.pa.paquete.interceptors.Auditoria;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

@ApplicationScoped 
public class PedidoService {
 
@Auditoria 
public String realizar(Pedido pedido, String valor1){
        //Medir el tiempo de forma incorrecta
        long init = System.currentTimeMillis();
        try{
            Thread.sleep(1500);
        } catch(Exception e){

        }

        System.out.println("Realizando pedido...");
        System.out.println("Pedido realizado al cliente: " + pedido.getCliente());
        System.out.println("Producto: " + pedido.getProducto());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
        System.out.println("Pedido realizado con exito.");
        
        long fin = System.currentTimeMillis() - init;
        return "[PedidoService] Se ha ejecutado correctamente \nTiempo de ejecucion: " + fin;
  
    }
}
