package domain;
import java.util.*;
/**
 *
 * @author david
 */
public class Orden {
    //Atributos de la Clase Orden
    private String id;
    private Cliente cliente;
    private List<ItemOrden> items;
    private double totalBruto;
    private double impuestos;
    private double descuentos;
    private double totalNeto;
     // Constructor
    public Orden(String id, Cliente cliente, List<ItemOrden> items) {
        this.id = id;
        this.cliente = cliente;
        this.items = items;
        calcularTotales();
    }
    // Método para calcular totales
    private void calcularTotales() {
        totalBruto = items.stream().mapToDouble(item -> item.getPrecioUnitario() * item.getCantidad()).sum();
        impuestos = totalBruto * 0.13;  // Supongamos que es un 13% de impuestos
        descuentos = totalBruto * 0.05;  // Supongamos que hay un descuento del 5%
        totalNeto = totalBruto + impuestos - descuentos;
    }
    //Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemOrden> getItems() {
        return items;
    }

    public void setItems(List<ItemOrden> items) {
        this.items = items;
    }

    public double getTotalBruto() {
        return totalBruto;
    }

    public void setTotalBruto(double totalBruto) {
        this.totalBruto = totalBruto;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    public double getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(double descuentos) {
        this.descuentos = descuentos;
    }

    public double getTotalNeto() {
        return totalNeto;
    }

    public void setTotalNeto(double totalNeto) {
        this.totalNeto = totalNeto;
    }
    
    
    
}