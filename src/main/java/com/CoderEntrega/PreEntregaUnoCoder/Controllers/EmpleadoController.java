package com.CoderEntrega.PreEntregaUnoCoder.Controllers;
import com.CoderEntrega.PreEntregaUnoCoder.Empleado;
import com.CoderEntrega.PreEntregaUnoCoder.Services.EmpleadoService;
import com.CoderEntrega.PreEntregaUnoCoder.modelo.EmpleadoDTO;
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
    public List<Empleado> getAllEmpleados() {
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
}