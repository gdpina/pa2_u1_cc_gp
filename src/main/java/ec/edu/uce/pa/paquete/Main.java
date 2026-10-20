package ec.edu.uce.pa.paquete;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain 
public class Main implements QuarkusApplication {

    @Inject  
    private PedidoService pedidoService;
    public static void main(String[] args) {
        Quarkus.run(Main.class,args);
    }

    @Override 
    public int run(String... args){
        System.out.println("Iniciando la aplicacion Quarkus...");

        Pedido pedido = new Pedido("Juan Perez", "Laptop", 1500.00, "juan.perez@example.com");
 
        this.pedidoService.realizar(pedido);
  
        return 0;
    }
}
