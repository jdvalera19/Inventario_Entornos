/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.entornos.Inventario.modelo;

/**
 *
 * @author USUARIO
 */
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name= Usuario.TABLE_NAME)
public class Usuario {
    
    //Atributos
    public static final String TABLE_NAME = "usuario";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String email;
    private String password;
    private String nombreusuario;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String email, String password, String nombreusuario) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.nombreusuario = nombreusuario;
    }

    public static String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", password=" + password + ", nombreusuario=" + nombreusuario + '}';
    }
    
    
    
}
