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
@Table(name = Venta.TABLE_NAME)
public class Venta {

    public static final String TABLE_NAME = "venta";

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto idProducto;

    private int cantidadVendida;
    private Double valorVenta;

    public Venta() {
    }

    public Venta(int id) {
        this.id = id;
    }

    public Venta(int id, Usuario idUsuario, Producto idProducto, int cantidadVendida, Double valorVenta) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idProducto = idProducto;
        this.cantidadVendida = cantidadVendida;
        this.valorVenta = valorVenta;
    }

    public static String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public int getId() {
        return id;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public Double getValorVenta() {
        return valorVenta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public void setValorVenta(Double valorVenta) {
        this.valorVenta = valorVenta;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", idUsuario=" + idUsuario + ", idProducto=" + idProducto + ", cantidadVendida=" + cantidadVendida + ", valorVenta=" + valorVenta + '}';
    }

}
