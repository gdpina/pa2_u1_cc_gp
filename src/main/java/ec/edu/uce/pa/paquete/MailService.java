package ec.edu.uce.pa.paquete;

import io.quarkus.arc.Unremovable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Singleton;

//@ApplicationScoped //Delego el control al contenedor ArC
//@RequestScoped //para aplicaciones web
@Singleton  
public class MailService implements Notificacion {

@Override
public void enviar(String destino, String mensaje) {
    System.out.println("Enviando correo a: " + destino);
    System.out.println("Mensaje: " + mensaje);
    System.out.println("Correo enviado con éxito.");
    System.out.println("Fin del envío del correo.");
}
}
