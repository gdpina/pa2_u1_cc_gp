package ec.edu.uce.pa.tarea4;

import jakarta.inject.Singleton;

import java.time.LocalDateTime;

@Singleton 
public class SeguimientoPedidoService {

    public void registrarPedido(String numero, String cliente, String producto, double total, String correo) {

        System.out.println("---------------------------------------------------------");
        System.out.println("Registrando el seguimiento del pedido: " + numero);

        System.out.println("Cliente: " + cliente + " con el producto de: " + producto + ", con un total de: $" + total + " y correo: " + correo);
    
        System.out.println("Fecha y hora: " + LocalDateTime.now());
    }
}