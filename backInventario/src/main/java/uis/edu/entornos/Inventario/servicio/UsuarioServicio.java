/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.entornos.Inventario.servicio;

import jakarta.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uis.edu.entornos.Inventario.modelo.LoginDto;
import uis.edu.entornos.Inventario.modelo.Usuario;
import uis.edu.entornos.Inventario.modelo.UsuarioDto;
import uis.edu.entornos.Inventario.repositorio.UsuarioRepositorio;

/**
 *
 * @author USUARIO
 */
@Service
@Transactional
public class UsuarioServicio implements IUsuarioServicio {

    @Autowired
    UsuarioRepositorio usuarioRepo;

    @Override
    public Usuario nuevoUsuario(UsuarioDto usuarioDto) {

        Usuario usuario = new Usuario();

        usuario.setId(usuarioDto.getId());
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setPassword(usuarioDto.getPassword());
        usuario.setNombreusuario(usuarioDto.getNombreusuario());
        return usuarioRepo.save(usuario);
    }

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

    @Override
    public int login(LoginDto usuarioDto) {
        int u = usuarioRepo.findByNombreusuarioAndPassword(usuarioDto.getNombreusuario(), usuarioDto.getPassword());
        return u;
    }

    @Override
    public ResponseEntity<?> ingresar(LoginDto usuarioDto) {
        Map<String, Object> response = new HashMap<>();
        Usuario usuario = null;
        try {
            usuario = usuarioRepo.findByNameAndPassword(usuarioDto.getNombreusuario(), usuarioDto.getPassword());
            if (usuario == null) {
                response.put("Usuario", null);
                response.put("Mensaje", "Alerta:Usuario o Password incorrectos");
                response.put("statusCode", HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            } else {
                response.put("Usuario", usuario);
                response.put("Mensaje", "Datos correctos");
                response.put("statusCode", HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            response.put("Usuario", null);
            response.put("Mensaje", "Ha ocurrido un error");
            response.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
