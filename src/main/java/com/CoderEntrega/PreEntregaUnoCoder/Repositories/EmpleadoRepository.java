package com.CoderEntrega.PreEntregaUnoCoder.Repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CoderEntrega.PreEntregaUnoCoder.DTOs.EmpleadoDTO;
import com.CoderEntrega.PreEntregaUnoCoder.modelo.Empleado;
import com.CoderEntrega.PreEntregaUnoCoder.modelo.Sucursal;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    Empleado findByNombre(String nombre);
    List <Empleado> findByCargo(String cargo);
    List <Empleado> findBySucursal(Sucursal sucursal);
    EmpleadoDTO save(EmpleadoDTO empleado);
}
