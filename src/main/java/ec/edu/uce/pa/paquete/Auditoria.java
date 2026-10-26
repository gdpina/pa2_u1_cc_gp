package ec.edu.uce.pa.paquete;

import java.util.UUID;

import jakarta.enterprise.context.Dependent;

@Dependent 
public class Auditoria {

    private final String id = UUID.randomUUID().toString();

    public Auditoria(){
        System.out.println("Creando Auditoria: " + id);
    }

    public void registrar(int numeroVenta, String tipoCliente, double monto, double descuento, double total){
        System.out.printf("AUDITORIA | Venta: " + numeroVenta + " | Cliente: " + tipoCliente + " | Monto: $" + monto +
            "| Descuento: $" + descuento + " | Total: $" + total + " | Instancia: " + id);
    }

    public String getId() {
        return id;
    }

}
