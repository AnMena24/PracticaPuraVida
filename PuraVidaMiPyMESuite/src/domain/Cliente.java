package domain;
import java.security.Key;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Base64;
/**
 *
 * @author david
 */
public class Cliente {
    //Atributos de la clase Cliente
    private String idInterno;
    private String nombre;
    private String correo;
    private String telefono;
    private String cedulaCifrada;
    // Constructor
    public Cliente(String idInterno, String nombre, String correo, String telefono, String cedula) {
        this.idInterno = idInterno;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.cedulaCifrada = cifrarCedula(cedula);
    }
    // Método de cifrado de cédula
    public String cifrarCedula(String cedula) {
        try {
            String claveSecreta = "PuraVida-2025!";
            Key key = new SecretKeySpec(claveSecreta.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] iv = cipher.getIV();
            byte[] encrypted = cipher.doFinal(cedula.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //Getters and Setters

    public String getIdInterno() {
        return idInterno;
    }

    public void setIdInterno(String idInterno) {
        this.idInterno = idInterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
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

    public String getCedulaCifrada() {
        return cedulaCifrada;
    }

    public void setCedulaCifrada(String cedulaCifrada) {
        this.cedulaCifrada = cedulaCifrada;
    }
    
            
}
