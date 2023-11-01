/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.entornos.Inventario.controlador;

import uis.edu.entornos.Inventario.modelo.Categoria;
import org.springframework.http.HttpStatus;
import uis.edu.entornos.Inventario.modelo.Usuario;

/**
 *
 * @author USUARIO
 */
public class ResponseEntity {
    
        public ResponseEntity(Categoria obj, HttpStatus httpStatus) {
    }
            public ResponseEntity(Usuario obj, HttpStatus httpStatus) {
    }
}
