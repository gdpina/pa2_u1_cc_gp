package ec.edu.uce.pa.paquete;

import io.quarkus.arc.Unremovable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

//Ambitos y contextos
//@ApplicationScoped //Su ambito es durante toda la aplicacion, es decir se crea una sola instancia de la clase y se comporta entre todos los componentes q lo utiliza.
//@RequestScoped //Su ambito es en aplicaciones web durante el request/peticion  http, es decir se crea una instancia de la clase y se comparte entre todos los componentes que la utilizan.
//@SessionScoped //su ambito es en aplicaciones web durante la sesion del usuario, es decir se crea una instancia de la clase y se comparte entre todos los componentes que la utilizan durante la sesion del usuario.
//@Singleton //Su ambito es durante toda la aplicacion, es decir se crea una sola instancia de la clase y se comporta entre todos los componentes que la utilizan. 
//@Dependent //su ambito es durante la inyeccion de dependencia , es decir se crea una instancia de la clase y se comparte entre todos los componentes que la utilizan durante la inyeccion de dependencia.

//Taller 8

@Singleton 
@Named("mail") 
public class MailService implements Notificacion {

private Integer cantidad = 0;
private String nombre;


@Override
public void enviar(String destino, String mensaje) {
    System.out.println("Enviando correo a: " + destino);
    System.out.println("Mensaje: " + mensaje);
    System.out.println("Correo enviado con éxito.");
    System.out.println("Fin del envío del correo.");
}

public Integer getCantidad() {
    return cantidad;
}


public void setCantidad(Integer cantidad) {
    this.cantidad = cantidad;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

}
