/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.entornos.Inventario.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name= Producto.TABLE_NAME)
public class Producto {
    public static final String TABLE_NAME="producto";
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria idCategoria;
    private String nombre;
    private Double precio;
    private String descripcion;
    private int cantidad;

    public Producto() {
    }

    public Producto(int id, int idCategoria, String nombre, Double precio, String descripcion, int cantidad) {
        this.id = id;
        this.idCategoria = getCategoria(idCategoria);
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public static String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public int getId() {
        return id;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", idCategoria=" + idCategoria + ", nombre=" + nombre + ", precio=" + precio + ", descripcion=" + descripcion + ", cantidad=" + cantidad + '}';
    }

    private Categoria getCategoria(int idCategoria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
}
