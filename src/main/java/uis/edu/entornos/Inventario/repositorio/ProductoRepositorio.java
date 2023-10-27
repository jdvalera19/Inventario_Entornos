/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uis.edu.entornos.Inventario.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import uis.edu.entornos.Inventario.modelo.Producto;

/**
 *
 * @author USUARIO
 */
public interface ProductoRepositorio extends JpaRepository<Producto, Integer>{
    
}
