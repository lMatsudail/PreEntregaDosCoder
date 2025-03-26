package com.CoderEntrega.PreEntregaUnoCoder.Controllers;
import com.CoderEntrega.PreEntregaUnoCoder.DTOs.EmpleadoDTO;
import com.CoderEntrega.PreEntregaUnoCoder.Services.EmpleadoService;
import com.CoderEntrega.PreEntregaUnoCoder.modelo.Empleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping
    public EmpleadoDTO createEmpleado(@RequestBody EmpleadoDTO empleado) {
        return empleadoService.saveEmpleado(empleado);
    }

    @GetMapping
    public List<EmpleadoDTO> getAllEmpleados() {
        return empleadoService.getAllEmpleados();
    }

    @PostMapping("/{id}/entrada")
    public Empleado registrarEntrada(@PathVariable Long id) {
        return empleadoService.registrarEntrada(id);
    }

    @PostMapping("/{id}/salida")
    public Empleado registrarSalida(@PathVariable Long id) {
        return (Empleado) empleadoService.registrarSalida(id);
    }
    @DeleteMapping("/{id}")
    public void deleteEmpleado(@PathVariable Long id) {
       empleadoService.deleteEmpleado(id);
    }
    @PutMapping
    public EmpleadoDTO actualizarEmpleado(@RequestBody EmpleadoDTO empleado) {;
        return empleadoService.actualizarEmpleado(empleado);
    }
}