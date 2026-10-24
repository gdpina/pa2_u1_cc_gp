package ec.edu.uce.pa.paquete;

public class Compra {

    private String Cliente;
    private String producto;
    private double total;
    private String correo;
    private String telefono;
    
 
  
    public Compra() {
    }
 
    public Compra(String cliente, String producto, double total, String correo) {
        Cliente = cliente;
        this.producto = producto;
        this.total = total;
        this.correo = correo;
    }
 
    //SET Y GET
    public String getCliente() {
        return Cliente;
    }
 
    public String getProducto() {
        return producto;
    }
 
    public double getTotal() {
        return total;
    }
 
    public String getCorreo() {
        return correo;
    }
 
    public void setCliente(String cliente) {
        Cliente = cliente;
    }
 
    public void setProducto(String producto) {
        this.producto = producto;
    }
 
    public void setTotal(double total) {
        this.total = total;
    }
 
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
