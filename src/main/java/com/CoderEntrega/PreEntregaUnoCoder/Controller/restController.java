package com.CoderEntrega.PreEntregaUnoCoder.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CoderEntrega.PreEntregaUnoCoder.Empleado;
import com.CoderEntrega.PreEntregaUnoCoder.Sucursal;
import com.CoderEntrega.PreEntregaUnoCoder.Services.EmpleadoService;
import com.CoderEntrega.PreEntregaUnoCoder.Services.SucursalService;
import com.CoderEntrega.PreEntregaUnoCoder.modelo.EmpleadoDTO;
import com.CoderEntrega.PreEntregaUnoCoder.modelo.SucursalDTO;

@RestController
@RequestMapping("/ControlEntradaSalida")

public class restController {
    @Autowired
	private EmpleadoService empleadoService;
	@Autowired
	private SucursalService sucursalService;
    @GetMapping
    
    public String getEntrCadaSalida() {
        return "Control de Entrada y Salida de empleados";
    }

    @GetMapping ("/CrearEmpleado")
    public ResponseEntity <EmpleadoDTO> CrearEmpleado() {

        /* Proceso de lectura bajo postman */

        //Sucursal s1= new Sucursal( 1, "Bogota", "Calle 100", "1234567");
        //Empleado e1= new Empleado(1, "jose", "Florez","1013684240", "Gerente", s1);

        /*Creacion de Sucursal + empleado en base de datos y mostrar resultado por postman*/

        Sucursal s1 = new Sucursal("centro","Cr 24 # 19-03","3109894050");
        sucursalService.saveSucursal(s1);
        Empleado e1 = new Empleado("Juan","Perez","1254377","Gerente",s1);
        empleadoService.saveEmpleado(e1);
        SucursalDTO sucursalDTO = new SucursalDTO(s1.getId().intValue(), s1.getNombre(), s1.getDireccion(), s1.getTelefono());
        EmpleadoDTO empleadoDTO = new EmpleadoDTO(e1.getId().intValue(), e1.getNombre(), e1.getApellido(), e1.getDocumento(), e1.getCargo(), sucursalDTO);
        return ResponseEntity.ok(empleadoDTO);
    }


    @GetMapping ("/ApiResponsive")
    public ResponseEntity <EmpleadoDTO> ApiResponsive() {
        Sucursal s1 = new Sucursal("nororiente","Cr 12 # 119-03","3109334050");
        sucursalService.saveSucursal(s1);
        Empleado e1 = new Empleado("pepito","mendieto","125411377","vendedor",s1);
        empleadoService.saveEmpleado(e1);
        SucursalDTO sucursalDTO = new SucursalDTO(s1.getId().intValue(), s1.getNombre(), s1.getDireccion(), s1.getTelefono());
        EmpleadoDTO empleadoDTO = new EmpleadoDTO(e1.getId().intValue(), e1.getNombre(), e1.getApellido(), e1.getDocumento(), e1.getCargo(), sucursalDTO);
        return ResponseEntity.ok(empleadoDTO);
    }


}
