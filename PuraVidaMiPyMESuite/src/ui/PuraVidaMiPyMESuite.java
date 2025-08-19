package ui;

import javax.swing.*;
import domain.*;
import java.util.*;

public class PuraVidaMiPyMESuite {
    
    private static List<Producto> productos = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Orden> ordenes = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            String[] opciones = {"Catálogo", "Clientes", "Órdenes", "Salir"};
            int opcion = JOptionPane.showOptionDialog(null, 
                "Seleccione una opción", 
                "PuraVida MiPyME Suite", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, opciones, opciones[0]);
            
            switch (opcion) {
                case 0: // Catálogo
                    menuCatalogo();
                    break;
                case 1: // Clientes
                    menuClientes();
                    break;
                case 2: // Órdenes
                    menuOrdenes();
                    break;
                case 3: // Salir
                    JOptionPane.showMessageDialog(null, "Gracias por usar PuraVida MiPyME Suite.");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    // Menú de Catálogo
    private static void menuCatalogo() {
        String[] opciones = {"Agregar Producto", "Mostrar Productos", "Volver"};
        int opcion = JOptionPane.showOptionDialog(null, 
                "Seleccione una opción para el Catálogo", 
                "Catálogo", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, opciones, opciones[0]);
        
        switch (opcion) {
            case 0: // Agregar Producto
                agregarProducto();
                break;
            case 1: // Mostrar Productos
                mostrarProductos();
                break;
            case 2: // Volver
                break;
            default:
                break;
        }
    }

    // Menú de Clientes
    private static void menuClientes() {
        String[] opciones = {"Agregar Cliente", "Mostrar Clientes", "Volver"};
        int opcion = JOptionPane.showOptionDialog(null, 
                "Seleccione una opción para Clientes", 
                "Clientes", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, opciones, opciones[0]);
        
        switch (opcion) {
            case 0: // Agregar Cliente
                agregarCliente();
                break;
            case 1: // Mostrar Clientes
                mostrarClientes();
                break;
            case 2: // Volver
                break;
            default:
                break;
        }
    }

    // Menú de Órdenes
    private static void menuOrdenes() {
        String[] opciones = {"Crear Orden", "Mostrar Órdenes", "Volver"};
        int opcion = JOptionPane.showOptionDialog(null, 
                "Seleccione una opción para Órdenes", 
                "Órdenes", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, opciones, opciones[0]);
        
        switch (opcion) {
            case 0: // Crear Orden
                crearOrden();
                break;
            case 1: // Mostrar Órdenes
                mostrarOrdenes();
                break;
            case 2: // Volver
                break;
            default:
                break;
        }
    }

    // Agregar Producto
    private static void agregarProducto() {
        String codigo = JOptionPane.showInputDialog("Ingrese código del producto:");
        String nombre = JOptionPane.showInputDialog("Ingrese nombre del producto:");
        String categoria = JOptionPane.showInputDialog("Ingrese categoría del producto:");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio del producto:"));
        int stockMin = Integer.parseInt(JOptionPane.showInputDialog("Ingrese stock mínimo del producto:"));
        int stockActual = Integer.parseInt(JOptionPane.showInputDialog("Ingrese stock actual del producto:"));
        
        Producto producto = new Producto(codigo, nombre, categoria, precio, stockMin, stockActual);
        productos.add(producto);
        JOptionPane.showMessageDialog(null, "Producto agregado exitosamente.");
    }

    // Mostrar Productos
    private static void mostrarProductos() {
        StringBuilder sb = new StringBuilder("Lista de Productos:\n");
        for (Producto p : productos) {
            sb.append("Código: ").append(p.getCodigo()).append(", Nombre: ").append(p.getNombre()).append(", Precio: ").append(p.getPrecio()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    // Agregar Cliente
    private static void agregarCliente() {
        String idInterno = JOptionPane.showInputDialog("Ingrese ID Interno del cliente:");
        String nombre = JOptionPane.showInputDialog("Ingrese nombre del cliente:");
        String correo = JOptionPane.showInputDialog("Ingrese correo del cliente:");
        String telefono = JOptionPane.showInputDialog("Ingrese teléfono del cliente:");
        String cedula = JOptionPane.showInputDialog("Ingrese cédula del cliente:");

        Cliente cliente = new Cliente(idInterno, nombre, correo, telefono, cedula);
        clientes.add(cliente);
        JOptionPane.showMessageDialog(null, "Cliente agregado exitosamente.");
    }

    // Mostrar Clientes
    private static void mostrarClientes() {
        StringBuilder sb = new StringBuilder("Lista de Clientes:\n");
        for (Cliente c : clientes) {
            sb.append("ID Interno: ").append(c.getIdInterno()).append(", Nombre: ").append(c.getNombre()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    // Crear Orden
    private static void crearOrden() {
        // Crear una orden de ejemplo
        Cliente cliente = clientes.isEmpty() ? null : clientes.get(0); // Obtener el primer cliente para ejemplo
        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "No hay clientes disponibles.");
            return;
        }
        
        Producto producto = productos.isEmpty() ? null : productos.get(0); // Obtener el primer producto para ejemplo
        if (producto == null) {
            JOptionPane.showMessageDialog(null, "No hay productos disponibles.");
            return;
        }

        List<ItemOrden> items = new ArrayList<>();
        items.add(new ItemOrden(producto, 1, producto.getPrecio())); // Añadir un item a la orden

        Orden orden = new Orden("O001", cliente, items);
        ordenes.add(orden);
        JOptionPane.showMessageDialog(null, "Orden creada exitosamente.");
    }

    // Mostrar Órdenes
    private static void mostrarOrdenes() {
        StringBuilder sb = new StringBuilder("Lista de Órdenes:\n");
        for (Orden o : ordenes) {
            sb.append("ID Orden: ").append(o.getId()).append(", Cliente: ").append(o.getCliente().getNombre()).append(", Total Neto: ").append(o.getTotalNeto()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}