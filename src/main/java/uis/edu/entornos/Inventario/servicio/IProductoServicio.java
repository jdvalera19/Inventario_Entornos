/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uis.edu.entornos.Inventario.servicio;

import java.util.List;
import uis.edu.entornos.Inventario.modelo.Producto;

/**
 *
 * @author USUARIO
 */
public interface IProductoServicio {
 
    //Listar todos los productos
    public List<Producto> getProductos();
    
    //Buscar un producto por id
    public Producto getProducto(Integer id);
    
    //Guardar un producto
    public Producto grabarProducto(Producto producto);
    
    //Eliminar un producto
    public void delete(Integer id);
}
