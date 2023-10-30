/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.entornos.Inventario.servicio;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uis.edu.entornos.Inventario.modelo.Venta;
import uis.edu.entornos.Inventario.repositorio.VentaRepositorio;

/**
 *
 * @author USUARIO
 */
@Service
@Transactional
public class VentaServicio implements IVentaServicio {

    @Autowired
    private VentaRepositorio ventaRepo;

    @Override
    public List<Venta> getVentas() {
       return ventaRepo.findAll();
    }

    @Override
    public Venta getVenta(Integer id) {
        return ventaRepo.findById(id).orElse(null);
    }

    @Override
    public Venta grabarVenta(Venta venta) {
        return ventaRepo.save(venta);
    }

    @Override
    public void delete(Integer id) {
        ventaRepo.deleteById(id);
    }

}
