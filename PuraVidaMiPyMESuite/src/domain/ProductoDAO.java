package domain;
import java.io.*;
import java.util.*;
import java.nio.file.*;
/**
 *
 * @author david
 */
public class ProductoDAO {
    private static final String CSV_FILE = "data/productos.csv";
    
    public void guardarProductos(List<Producto> productos) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(CSV_FILE))) {
            for (Producto producto : productos) {
                writer.write(producto.getCodigo() + ";" + producto.getNombre() + ";" + producto.getCategoria() + ";" 
                        + producto.getPrecio() + ";" + producto.getStockMin() + ";" + producto.getStockActual());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Producto> cargarProductos() {
        List<Producto> productos = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                Producto producto = new Producto(fields[0], fields[1], fields[2], 
                        Double.parseDouble(fields[3]), Integer.parseInt(fields[4]), Integer.parseInt(fields[5]));
                productos.add(producto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productos;
    }
}