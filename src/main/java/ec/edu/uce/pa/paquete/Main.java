package ec.edu.uce.pa.paquete;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain 
public class Main implements QuarkusApplication {

    @Inject  
    private PedidoService pedidoService;

    @Inject  
    private CompraService compraService;

    public static void main(String[] args) {
        Quarkus.run(Main.class,args);
    }

    @Override 
    public int run(String... args){
        System.out.println("Iniciando la aplicacion Quarkus...");

        Pedido pedido = new Pedido("Juan Perez", "Laptop", 1500.00, "juan.perez@example.com");
        pedido.setTelefono("0999920011");
        this.pedidoService.realizar(pedido);

        Compra compra = new Compra("Gabriel", "S26 Samsung", 200.00, "gdpina@uce.edu.ec");
        compra.setTelefono("0999920011");
        this.compraService.realizar(compra);
        return 0;
    }
}
