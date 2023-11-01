/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uis.edu.entornos.Inventario.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uis.edu.entornos.Inventario.modelo.Usuario;

/**
 *
 * @author USUARIO
 */
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    // JPQL: Se hace la consulta sobre la clase 

    @Query("SELECT count(*) from Usuario as p where p.nombreusuario= :nombreusuario and p.password=:password")
    Integer findByNombreusuarioAndPassword(@Param("nombreusuario") String nombreusuario,
            @Param("password") String password);

    @Query("SELECT p from Usuario as p where p.nombreusuario= :nombreusuario and p.password=:password")
    Usuario findByNameAndPassword(@Param("nombreusuario") String nombreusuario,
            @Param("password") String password);
}
