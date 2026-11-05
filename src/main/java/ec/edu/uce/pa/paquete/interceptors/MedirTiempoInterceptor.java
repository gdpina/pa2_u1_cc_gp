package ec.edu.uce.pa.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@MedirTiempo 
@Interceptor 
@Priority(Interceptor.Priority.APPLICATION + 40)
public class MedirTiempoInterceptor {

    @AroundInvoke 
    public Object interceptar(InvocationContext contex) throws Exception{
        long init = System.currentTimeMillis();
        Object resultado = contex.proceed();
        long fin = System.currentTimeMillis();
        System.out.println("[MedirInteceptor] El metodo demoro: " + (fin-init));
        return resultado;
    }
}
