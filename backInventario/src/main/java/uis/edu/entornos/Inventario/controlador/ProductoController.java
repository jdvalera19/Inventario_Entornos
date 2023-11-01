/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.entornos.Inventario.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uis.edu.entornos.Inventario.modelo.Producto;
import uis.edu.entornos.Inventario.servicio.ProductoServicio;

/**
 *
 * @author USUARIO
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/productos")
public class ProductoController {
    
    @Autowired
    private ProductoServicio productoService;
    
    @GetMapping("/list")
    public List<Producto> consultarTodo(){
        return (productoService.getProductos());
    }
    
    @GetMapping("/list/{id}")
    public Producto buscaPorId(@PathVariable Integer id){
        return productoService.getProducto(id);
    }
    
    @PostMapping("/")
    public org.springframework.http.ResponseEntity<Producto> agregar(@RequestBody Producto producto){
        Producto obj = productoService.grabarProducto(producto);
        return new ResponseEntity<> (obj, HttpStatus.OK);
    }
    
    
    @PutMapping("/")
    public org.springframework.http.ResponseEntity<Producto> editar(@RequestBody Producto producto){
        Producto obj = productoService.getProducto(producto.getId());
        if (obj != null){
        obj.setIdCategoria(producto.getIdCategoria());
        obj.setNombre(producto.getNombre());
        obj.setPrecio(producto.getPrecio());
        obj.setDescripcion(producto.getDescripcion());
        obj.setCantidad(producto.getCantidad());
        productoService.grabarProducto(obj);
        }else{
            return new ResponseEntity<> (obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
            return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public org.springframework.http.ResponseEntity<Producto> eliminar(@PathVariable Integer id){
    Producto obj = productoService.getProducto(id);
    if(obj != null){
        productoService.delete(id);
    } else {
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
