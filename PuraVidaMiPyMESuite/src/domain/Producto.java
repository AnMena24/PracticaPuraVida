package domain;

/**
 *
 * @author david
 */
public class Producto {
    //Atributos de la clase Producto
     private String codigo;
     private String nombre;
     private String categoria;
     private double precio;
     private int stockMin;
     private int stockActual;
    //Metodo Contructor
    public Producto(String codigo, String nombre, String categoria, double precio, int stockMin, int stockActual) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stockMin = stockMin;
        this.stockActual = stockActual;
    }
     
     //Getters and Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStockMin() {
        return stockMin;
    }

    public void setStockMin(int stockMin) {
        this.stockMin = stockMin;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }
     
}
