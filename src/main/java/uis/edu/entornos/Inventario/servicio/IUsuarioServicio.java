/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uis.edu.entornos.Inventario.servicio;
import uis.edu.entornos.Inventario.modelo.Usuario;

import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface IUsuarioServicio {
 
    //Listar todos los usuarios
    public List<Usuario> getUsuarios();
    
    //Buscar un cliente por id
    public Usuario getUsuario(Integer id);
    
    //Guardar un usuario
    public Usuario grabarUsuario(Usuario usuario);
    
    //Eliminar un usuarii
    public void delete(Integer id);
}
