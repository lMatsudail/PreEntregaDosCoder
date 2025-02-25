package com.CoderEntrega.PreEntregaUnoCoder.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CoderEntrega.PreEntregaUnoCoder.Empleado;
import com.CoderEntrega.PreEntregaUnoCoder.Repositories.EmpleadoRepository;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public Empleado saveEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }
}
