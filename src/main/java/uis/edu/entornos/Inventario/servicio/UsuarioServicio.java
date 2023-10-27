/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.entornos.Inventario.servicio;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uis.edu.entornos.Inventario.modelo.Usuario;
import uis.edu.entornos.Inventario.repositorio.UsuarioRepositorio;

/**
 *
 * @author USUARIO
 */
@Service
@Transactional
public class UsuarioServicio implements IUsuarioServicio{

    @Autowired
    private UsuarioRepositorio usuarioRepo;
    
    
    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario getUsuario(Integer id) {
        return usuarioRepo.findById(id).orElse(null);
    }

    @Override
    public Usuario grabarUsuario(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    @Override
    public void delete(Integer id) {
        usuarioRepo.deleteById(id);
    }
    
}
