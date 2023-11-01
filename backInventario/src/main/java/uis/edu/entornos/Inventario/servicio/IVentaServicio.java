/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uis.edu.entornos.Inventario.servicio;

import java.util.List;
import uis.edu.entornos.Inventario.modelo.Venta;

/**
 *
 * @author USUARIO
 */
public interface IVentaServicio {
 
    //Listar todas las ventas
    public List<Venta> getVentas();
    
    //Buscar una venta por id
    public Venta getVenta(Integer id);
    
    //Guardar una venta
    public Venta grabarVenta(Venta venta);
    
    //Eliminar una venta
    public void delete(Integer id);
}

