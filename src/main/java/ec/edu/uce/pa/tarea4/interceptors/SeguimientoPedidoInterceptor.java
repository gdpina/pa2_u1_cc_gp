package ec.edu.uce.pa.tarea4.interceptors;

import java.lang.reflect.Parameter;

import ec.edu.uce.pa.tarea4.PedidoBebida;
import ec.edu.uce.pa.tarea4.SeguimientoPedidoService;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@SeguimientoPedido
@Interceptor
public class SeguimientoPedidoInterceptor {

    @Inject
    private SeguimientoPedidoService seguimientoPedidoService;

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
        
        Object resultado = context.proceed();

        System.out.println("Mensaje luego que se ejecuta el método interceptado.");
        System.out.println("Retorno: " + resultado);

        String nombreMetodo = context.getMethod().getName();
        System.out.println("Seguimiento -> Se está ejecutando el método: " + nombreMetodo);

        Parameter[] parametros = context.getMethod().getParameters();

        for (Parameter parametro : parametros) {
            System.out.println("Parametro: " + parametro.getName());
        }

        Object[] valores = context.getParameters();

        PedidoBebida pedido = (PedidoBebida) valores[0];

        String numero = pedido.getNumero();
        String cliente = pedido.getCliente();
        String producto = pedido.getProducto();
        double total = pedido.getCantidad() * pedido.getPrecioUnitario();
        String correo = pedido.getCorreo();

        this.seguimientoPedidoService.registrarPedido(numero, cliente, producto, total, correo);

        return resultado;
    }
}