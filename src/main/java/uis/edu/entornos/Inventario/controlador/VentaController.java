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
import uis.edu.entornos.Inventario.modelo.Venta;
import uis.edu.entornos.Inventario.servicio.VentaServicio;

/**
 *
 * @author USUARIO
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaServicio ventaService;

    @GetMapping("/list")
    public List<Venta> consultarTodo() {
        return (ventaService.getVentas());
    }

    @GetMapping("/list/{id}")
    public Venta buscaPorId(@PathVariable Integer id) {
        return ventaService.getVenta(id);
    }

    @PostMapping("/")
    public org.springframework.http.ResponseEntity<Venta> agregar(@RequestBody Venta venta) {
        Venta obj = ventaService.grabarVenta(venta);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping("/")
    public org.springframework.http.ResponseEntity<Venta> editar(@RequestBody Venta venta) {
        Venta obj = ventaService.getVenta(venta.getId());
        if (obj != null) {
            obj.setIdUsuario(venta.getIdUsuario());
            obj.setIdProducto(venta.getIdProducto());
            obj.setCantidadVendida(venta.getCantidadVendida());
            obj.setValorVenta(venta.getValorVenta());
            ventaService.grabarVenta(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public org.springframework.http.ResponseEntity<Venta> eliminar(@PathVariable Integer id) {
        Venta obj = ventaService.getVenta(id);
        if (obj != null) {
            ventaService.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

}
