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
import uis.edu.entornos.Inventario.modelo.Categoria;
import uis.edu.entornos.Inventario.servicio.CategoriaServicio;

/**
 *
 * @author USUARIO
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/categorias")
public class CategoriaController {
    
    @Autowired
    private CategoriaServicio categoriaService;
    
    @GetMapping("/list")
    public List<Categoria> consultarTodo(){
        return (categoriaService.getCategorias());
    }
    
    @GetMapping("/list/{id}")
    public Categoria buscaPorId(@PathVariable Integer id){
        return categoriaService.getCategoria(id);
    }
    
    @PostMapping("/")
    public org.springframework.http.ResponseEntity<Categoria> agregar(@RequestBody Categoria categoria){
        Categoria obj = categoriaService.grabarCategoria(categoria);
        return new ResponseEntity<> (obj, HttpStatus.OK);
    }
    
    
    @PutMapping("/")
    public org.springframework.http.ResponseEntity<Categoria> editar(@RequestBody Categoria categoria){
        Categoria obj = categoriaService.getCategoria(categoria.getId());
        if (obj != null){
        obj.setNombre(categoria.getNombre());
        categoriaService.grabarCategoria(obj);
        }else{
            return new ResponseEntity<> (obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
            return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public org.springframework.http.ResponseEntity<Categoria> eliminar(@PathVariable Integer id){
    Categoria obj = categoriaService.getCategoria(id);
    if(obj != null){
        categoriaService.delete(id);
    } else {
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
