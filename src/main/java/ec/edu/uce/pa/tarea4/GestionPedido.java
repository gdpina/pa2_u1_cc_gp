package ec.edu.uce.pa.tarea4;

import ec.edu.uce.pa.tarea4.interceptors.SeguimientoPedido;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped // Delego el control al contenedor ArC
public class GestionPedido {

    @SeguimientoPedido 
    public String realizar(PedidoBebida pedido) {

        double subtotal = pedido.getCantidad() * pedido.getPrecioUnitario();

        System.out.println("-----PEDIDO COCA-COLA-----");
        System.out.println("Pedido: " + pedido.getNumero());
        System.out.println("Cliente: " + pedido.getCliente());
        System.out.println("Producto: " + pedido.getProducto());
        System.out.println("Cantidad: " + pedido.getCantidad());
        System.out.println("Precio unitario: " + pedido.getPrecioUnitario());
        System.out.println("Total del pedido: " + subtotal);

        System.out.println("Pedido realizado con éxito.");
        System.out.println("---------------------------------------------------------");


        return "Pedido realizado con éxito.";

    }
}
