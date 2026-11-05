package ec.edu.uce.pa.paquete.interceptors;

import ec.edu.uce.pa.paquete.Pedido;
import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Mail
@Interceptor
@Priority(Interceptor.Priority.APPLICATION + 10)
public class MailInterceptor {
 
    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
        Object resultado = context.proceed();
        Pedido pedido = (Pedido) context.getParameters()[0];
        System.out.println("[MailInterceptor] Se envió un correo a " + pedido.getCorreo() + " a: " + pedido.getCliente() + ", su pedido de " + pedido.getProducto() + " por un total de $" + pedido.getTotal() + " ha sido realizado con éxito.");
        return resultado;
    }
}
