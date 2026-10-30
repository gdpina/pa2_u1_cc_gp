package ec.edu.uce.pa.paquete;

import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Singleton 
@Named("sms")
public class SMSService implements Notificacion {

    private Integer cantidad = 0;
    

@Override
public void enviar(String destino, String mensaje) {
    System.out.println("Enviando SMS a: " + destino);
    System.out.println("Mensaje: " + mensaje);
    System.out.println("SMS enviado con éxito.");
    System.out.println("Fin del envío del SMS.");
}

public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String getNombre() {
       return null;
    }

    @Override
    public void setNombre(String nombre) {
    }


}
