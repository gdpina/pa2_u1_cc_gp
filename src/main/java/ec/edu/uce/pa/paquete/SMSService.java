package ec.edu.uce.pa.paquete;

import jakarta.inject.Singleton;

@Singleton 
public class SMSService implements Notificacion {

@Override
public void enviar(String destino, String mensaje) {
    System.out.println("Enviando SMS a: " + destino);
    System.out.println("Mensaje: " + mensaje);
    System.out.println("SMS enviado con éxito.");
    System.out.println("Fin del envío del SMS.");
}

}
