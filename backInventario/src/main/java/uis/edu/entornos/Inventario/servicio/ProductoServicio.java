/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.entornos.Inventario.servicio;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uis.edu.entornos.Inventario.modelo.Producto;
import uis.edu.entornos.Inventario.repositorio.ProductoRepositorio;

/**
 *
 * @author USUARIO
 */
@Service
@Transactional
public class ProductoServicio implements IProductoServicio{

    @Autowired
    private ProductoRepositorio productoRepo;
    
    
    @Override
    public List<Producto> getProductos() {
        return productoRepo.findAll();
    }

    @Override
    public Producto getProducto(Integer id) {
        return productoRepo.findById(id).orElse(null);
    }

    @Override
    public Producto grabarProducto(Producto producto) {
        return productoRepo.save(producto);
    }

    @Override
    public void delete(Integer id) {
        productoRepo.deleteById(id);
    }
    
}
