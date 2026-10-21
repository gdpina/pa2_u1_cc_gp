package ec.edu.uce.pa.tarea2;

public class PedidoBebida {

    private String numero;
    private String cliente;
    private String correo;
    private String producto;
    private int cantidad;
    private double precioUnitario;

    public PedidoBebida() {
    }

    public PedidoBebida(String numero, String cliente, String correo, String producto, int cantidad,
            double precioUnitario) {
        this.numero = numero;
        this.cliente = cliente;
        this.correo = correo;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

}
