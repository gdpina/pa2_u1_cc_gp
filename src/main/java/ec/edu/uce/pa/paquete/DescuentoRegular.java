package ec.edu.uce.pa.paquete;

import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped 
@Named("REGULAR")
public class DescuentoRegular implements CalculadoraDescuento{

    private final String id = UUID.randomUUID().toString();
    

    public double calcular(double monto){
        System.out.println("\n-------------------------------------------------------");
        System.out.println("\nAplicando Descuento Regular: " + id);
        return monto * 0.05;
    }

    public String getId() {
        return id;
    }

}
