/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uis.edu.entornos.Inventario.servicio;

import java.util.List;
import uis.edu.entornos.Inventario.modelo.Categoria;

/**
 *
 * @author USUARIO
 */
public interface ICategoriaServicio {
 
    //Listar todos los categorias
    public List<Categoria> getCategorias();
    
    //Buscar una categoria por id
    public Categoria getCategoria(Integer id);
    
    //Guardar una categoria
    public Categoria grabarCategoria(Categoria categoria);
    
    //Eliminar una categoria
    public void delete(Integer id);
}
