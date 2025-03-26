package com.CoderEntrega.PreEntregaUnoCoder.Services;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CoderEntrega.PreEntregaUnoCoder.DTOs.EmpleadoDTO;
import com.CoderEntrega.PreEntregaUnoCoder.DTOs.SucursalDTO;
import com.CoderEntrega.PreEntregaUnoCoder.Repositories.EmpleadoRepository;
import com.CoderEntrega.PreEntregaUnoCoder.modelo.Empleado;
import com.CoderEntrega.PreEntregaUnoCoder.modelo.Sucursal;

import Excepciones.UsuarioYaExisteException;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public EmpleadoDTO saveEmpleado(EmpleadoDTO empleado) {
        if ((boolean) empleadoRepository.existsByDocumento(empleado.getDocumento())) {
            throw new UsuarioYaExisteException("El empleado ya existe");
        }
        Sucursal sucursal = new Sucursal(
            empleado.getSucursal().getId(), 
            empleado.getSucursal().getNombre(),
            empleado.getSucursal().getDireccion(), 
            empleado.getSucursal().getTelefono()
            );
        Empleado empleado1 = new Empleado(
            null, 
            empleado.getNombre(), 
            empleado.getApellido(), 
            empleado.getDocumento(),
            empleado.getCargo(),sucursal, 
            empleado.getFechaEntrada(), 
            empleado.getFechaSalida()
            );

        Empleado empleadoRespuesta = empleadoRepository.save(empleado1);

        return new EmpleadoDTO(
            empleadoRespuesta.getId(), 
            empleadoRespuesta.getNombre(), 
            empleadoRespuesta.getApellido(), 
            empleadoRespuesta.getDocumento(), 
            empleadoRespuesta.getCargo(), 
        new SucursalDTO(
            empleadoRespuesta.getSucursal().getId(), 
            empleadoRespuesta.getSucursal().getNombre(), 
            empleadoRespuesta.getSucursal().getDireccion(), 
            empleadoRespuesta.getSucursal().getTelefono()
            ),
            empleadoRespuesta.getFechaEntrada(), 
            empleadoRespuesta.getFechaSalida()
            );
        
    }
    public List <EmpleadoDTO> getAllEmpleados() {
        List <Empleado> listaEmpleados = empleadoRepository.findAll();
        List <EmpleadoDTO> listaEmpleadosDTO = new ArrayList<>();
        for (Empleado empleado : listaEmpleados) {
            listaEmpleadosDTO.add(
        new EmpleadoDTO(
            empleado.getId(), 
            empleado.getNombre(), 
            empleado.getApellido(), 
            empleado.getDocumento(), 
            empleado.getCargo(), 
        new SucursalDTO(
            empleado.getSucursal().getId(), 
            empleado.getSucursal().getNombre(), 
            empleado.getSucursal().getDireccion(), 
            empleado.getSucursal().getTelefono()
            ),
            empleado.getFechaEntrada(),
            empleado.getFechaSalida()
            ));
        }
        return listaEmpleadosDTO;
    }
    public Empleado registrarEntrada(Long empleadoId) {
        Empleado empleado = empleadoRepository.findById(empleadoId).orElseThrow(()
        -> new RuntimeException("Empleado no encontrado"));
        empleado.setFechaEntrada(LocalDateTime.now());
        return empleadoRepository.save(empleado);
    }

    public Empleado registrarSalida(Long empleadoId) {
        Empleado empleado = empleadoRepository.findById(empleadoId).orElseThrow(() 
        -> new RuntimeException("Empleado no encontrado"));
        empleado.setFechaSalida(LocalDateTime.now());
        return empleadoRepository.save(empleado);
    }
    public void deleteEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }
    public EmpleadoDTO actualizarEmpleado(EmpleadoDTO empleadoDTO) {
        Empleado empleadoExistente = empleadoRepository.findById(empleadoDTO.getId())
            .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    
        empleadoExistente.setNombre(empleadoDTO.getNombre());
        empleadoExistente.setApellido(empleadoDTO.getApellido());
        empleadoExistente.setDocumento(empleadoDTO.getDocumento());
        empleadoExistente.setCargo(empleadoDTO.getCargo());
    
        Sucursal sucursal = new Sucursal(
            empleadoDTO.getSucursal().getId(), 
            empleadoDTO.getSucursal().getNombre(),
            empleadoDTO.getSucursal().getDireccion(), 
            empleadoDTO.getSucursal().getTelefono()
        );
        empleadoExistente.setSucursal(sucursal);
    
        empleadoExistente.setFechaEntrada(empleadoDTO.getFechaEntrada());
        empleadoExistente.setFechaSalida(empleadoDTO.getFechaSalida());
    
        Empleado empleadoActualizado = empleadoRepository.save(empleadoExistente);
    
        return new EmpleadoDTO(
            empleadoActualizado.getId(), 
            empleadoActualizado.getNombre(), 
            empleadoActualizado.getApellido(), 
            empleadoActualizado.getDocumento(), 
            empleadoActualizado.getCargo(), 
        new SucursalDTO(
            empleadoActualizado.getSucursal().getId(), 
            empleadoActualizado.getSucursal().getNombre(), 
            empleadoActualizado.getSucursal().getDireccion(), 
            empleadoActualizado.getSucursal().getTelefono()
        ),
            empleadoActualizado.getFechaEntrada(), 
            empleadoActualizado.getFechaSalida()
        );

       
    }
}
