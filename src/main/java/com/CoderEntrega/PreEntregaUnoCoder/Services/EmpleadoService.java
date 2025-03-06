package com.CoderEntrega.PreEntregaUnoCoder.Services;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.CoderEntrega.PreEntregaUnoCoder.Empleado;
import com.CoderEntrega.PreEntregaUnoCoder.Sucursal;
import com.CoderEntrega.PreEntregaUnoCoder.Repositories.EmpleadoRepository;
import com.CoderEntrega.PreEntregaUnoCoder.modelo.EmpleadoDTO;
import com.CoderEntrega.PreEntregaUnoCoder.modelo.SucursalDTO;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public EmpleadoDTO saveEmpleado(EmpleadoDTO empleado) {
        Sucursal sucursal = new Sucursal(empleado.getSucursal().getId(), empleado.getSucursal().getNombre(),empleado.getSucursal().getDireccion(), empleado.getSucursal().getTelefono());
        Empleado empleado1 = new Empleado(empleado.getId(), empleado.getNombre(), empleado.getApellido(), empleado.getDocumento(),empleado.getCargo(),sucursal, empleado.getFechaEntrada(), empleado.getFechaSalida());
        Empleado empleadoRespuesta = empleadoRepository.save(empleado1);
        return new EmpleadoDTO(empleadoRespuesta.getId(), empleadoRespuesta.getNombre(), empleadoRespuesta.getApellido(), empleadoRespuesta.getDocumento(), empleadoRespuesta.getCargo(), 
                                new SucursalDTO(empleadoRespuesta.getSucursal().getId(), empleadoRespuesta.getSucursal().getNombre(), empleadoRespuesta.getSucursal().getDireccion(), empleadoRespuesta.getSucursal().getTelefono()),
                                 empleadoRespuesta.getFechaEntrada(), empleadoRespuesta.getFechaSalida());
        
    }
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }
       public Empleado registrarEntrada(Long empleadoId) {
        Empleado empleado = empleadoRepository.findById(empleadoId).orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
        empleado.setFechaEntrada(LocalDateTime.now());
        return empleadoRepository.save(empleado);
    }

    public Empleado registrarSalida(Long empleadoId) {
        Empleado empleado = empleadoRepository.findById(empleadoId).orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
        empleado.setFechaSalida(LocalDateTime.now());
        return empleadoRepository.save(empleado);
    }
}
