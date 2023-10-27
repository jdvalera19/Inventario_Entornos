/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.entornos.Inventario.servicio;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uis.edu.entornos.Inventario.modelo.Categoria;
import uis.edu.entornos.Inventario.repositorio.CategoriaRepositorio;

/**
 *
 * @author USUARIO
 */
@Service
@Transactional
public class CategoriaServicio implements ICategoriaServicio{

    @Autowired
    private CategoriaRepositorio categoriaRepo;
    
    
    @Override
    public List<Categoria> getCategorias() {
        return categoriaRepo.findAll();
    }

    @Override
    public Categoria getCategoria(Integer id) {
        return categoriaRepo.findById(id).orElse(null);
    }

    @Override
    public Categoria grabarCategoria(Categoria categoria) {
        return categoriaRepo.save(categoria);
    }

    @Override
    public void delete(Integer id) {
        categoriaRepo.deleteById(id);
    }
    
}
