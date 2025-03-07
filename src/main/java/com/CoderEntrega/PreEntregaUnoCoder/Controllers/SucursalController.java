package com.CoderEntrega.PreEntregaUnoCoder.Controllers;
import com.CoderEntrega.PreEntregaUnoCoder.DTOs.SucursalDTO;
import com.CoderEntrega.PreEntregaUnoCoder.Services.SucursalService;
import com.CoderEntrega.PreEntregaUnoCoder.modelo.Sucursal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {
    @Autowired
    private SucursalService sucursalService;

    @PostMapping
    public SucursalDTO createSucursal(@RequestBody SucursalDTO sucursal) {
        return sucursalService.saveSucursal(sucursal);
    }


    @GetMapping
    public List<SucursalDTO> getAllSucursales() {
        return sucursalService.getAllSucursales();
    }
}
