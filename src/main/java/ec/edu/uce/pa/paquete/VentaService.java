package ec.edu.uce.pa.paquete;

import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped 
public class VentaService {

    private final CalculadoraDescuento descuentoRegular;

    //Inyeccion por constructor
    @Inject
    public VentaService(@Named("REGULAR")CalculadoraDescuento descuentoRegular){
        this.descuentoRegular = descuentoRegular;
        System.out.println("Creando VentaService");   
    }

    //Inyeccion por atributo
    @Inject 
    @Named("VIP")
    CalculadoraDescuento descuentoVIP;

    @Inject 
    Instance<Auditoria> auditorias;

    public void procesarVenta(int numeroVenta, String tipoCliente, double monto){

        CalculadoraDescuento calculadora;
        String tipo = tipoCliente.toUpperCase();
           
        if (tipo.equals("REGULAR")) {
            calculadora = descuentoRegular;
        } else {
            calculadora = descuentoVIP;
        }

        double descuento = calculadora.calcular(monto);
        double total = monto - descuento;

        System.out.println("\n-------------------------------------------------------");
        System.out.println("Venta N° " + numeroVenta);
        System.out.println("Tipo de cliente: " + tipo);
        System.out.println("Monto original: $" + monto);
        System.out.println("Descuento aplicado: $" + descuento);
        System.out.println("Total a pagar: $" + total);

        Auditoria auditoria = auditorias.get();

        auditoria.registrar(numeroVenta, tipo, monto, descuento, total);
    }

}
