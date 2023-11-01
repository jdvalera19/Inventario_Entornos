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
import uis.edu.entornos.Inventario.modelo.LoginDto;
import uis.edu.entornos.Inventario.modelo.Usuario;
import uis.edu.entornos.Inventario.servicio.UsuarioServicio;

/**
 *
 * @author USUARIO
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioServicio usuarioService;

    @GetMapping("/list")
    public List<Usuario> consultarTodo() {
        return (usuarioService.getUsuarios());
    }

    @GetMapping("/list/{id}")
    public Usuario buscaPorId(@PathVariable Integer id) {
        return usuarioService.getUsuario(id);
    }

    @PostMapping("/")
    public ResponseEntity<Usuario> agregar(@RequestBody Usuario usuario) {
        Usuario obj = usuarioService.grabarUsuario(usuario);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Usuario> editar(@RequestBody Usuario usuario) {
        Usuario obj = usuarioService.getUsuario(usuario.getId());
        if (obj != null) {
            obj.setNombre(usuario.getNombre());
            obj.setEmail(usuario.getEmail());
            obj.setPassword(usuario.getPassword());
            obj.setNombreusuario(usuario.getNombreusuario());
            usuarioService.grabarUsuario(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> eliminar(@PathVariable Integer id) {
        Usuario obj = usuarioService.getUsuario(id);
        if (obj != null) {
            usuarioService.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    // @CrossOrigin indica desde que sitios se van a realizar peticiones
    //@CrossOrigin(origins = {"http://localhost:8095"})
    @PostMapping("/loginclient") // ruta del servicio desde el front deben direccionar a esta ruta
    public int login(@RequestBody LoginDto usuario) {
        int responseLogin = usuarioService.login(usuario);
        return responseLogin;
    }

    @PostMapping("/login") // ruta del servicio desde el front deben direccionar a esta ruta
    public ResponseEntity<?> loginCliente(@RequestBody LoginDto usuario) {
        return usuarioService.ingresar(usuario);
    }

}
