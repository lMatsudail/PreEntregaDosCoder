package com.CoderEntrega.PreEntregaUnoCoder.Controllers;

import com.CoderEntrega.PreEntregaUnoCoder.DTOs.SucursalDTO;
import com.CoderEntrega.PreEntregaUnoCoder.Services.SucursalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sucursal")
@Tag(name = "Sistema de manejo de Sucursales", description = "Operaciones relativas a Sucursal en el sistema de gestión de Sucursal")
public class SucursalController {
    @Autowired
    private SucursalService sucursalService;

    @PostMapping
    @Operation(summary = "Crear una nueva Sucursal", description = "Crear nueva Sucursal", tags = { "Sistema de manejo de sucursales" })
    public SucursalDTO createSucursal(@RequestBody SucursalDTO sucursal) {
        return sucursalService.saveSucursal(sucursal);
    }

    @GetMapping
    @Operation(summary = "List disponible de las Sucursales", description = "Ver lista de sucursales disponibles", tags = { "Sistema de manejo de sucursales" })
    public List<SucursalDTO> getAllSucursales() {
        return sucursalService.getAllSucursales();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Sucursal", description = "Actualizar una sucursal existente", tags = { "Sistema de manejo de sucursales" })
    public SucursalDTO actualizarSucursal(@PathVariable Long id, @RequestBody SucursalDTO sucursal) {
        return sucursalService.actualizarSucursal(id, sucursal);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar Sucursal", description = "Borrado de sucursales", tags = { "Sistema de manejo de sucursales" })
    public void deleteSucursal(@PathVariable Long id) {
        sucursalService.deleteSucursal(id);
    }
}
