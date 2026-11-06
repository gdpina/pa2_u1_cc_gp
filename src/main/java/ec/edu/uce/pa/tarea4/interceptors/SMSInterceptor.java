package ec.edu.uce.pa.tarea4.interceptors;

import ec.edu.uce.pa.tarea4.GestionPedido;
import ec.edu.uce.pa.tarea4.PedidoBebida;
import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@SMS 
@Interceptor 
@Priority(Interceptor.Priority.APPLICATION + 20)
public class SMSInterceptor {

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
        Object resultado = context.proceed();
 
        PedidoBebida pedido = (PedidoBebida) context.getParameters()[0];
        
        double total = pedido.getCantidad() * pedido.getPrecioUnitario();
        
        System.out.println("---------------------------------------------------------");
        System.out.println("[SMSInterceptor] Se envió un SMS a: " + pedido.getCliente()
                + " con el mensaje: Su pedido de " + pedido.getProducto()
                + " por un total de $" + total
                + " ha sido realizado con éxito.");
 
        return resultado;
    }



}
