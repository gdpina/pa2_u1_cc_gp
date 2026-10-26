package ec.edu.uce.pa.paquete;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain 
public class Main implements QuarkusApplication {

    @Inject 
    VentaService ventaService;

    @Override 
    public int run(String... args){

        System.out.println("\nSimulador de descuentos...");

        ventaService.procesarVenta(1, "REGULAR", 100.00);
        ventaService.procesarVenta(2, "VIP", 200.00);
        ventaService.procesarVenta(3, "REGULAR", 300.00);
        ventaService.procesarVenta(4, "VIP", 500.00);

        System.out.println("\nSimulacion finalizada...");

        return 0;
        
    }
}
