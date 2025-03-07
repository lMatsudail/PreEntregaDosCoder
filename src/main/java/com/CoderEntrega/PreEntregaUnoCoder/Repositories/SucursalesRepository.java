package com.CoderEntrega.PreEntregaUnoCoder.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CoderEntrega.PreEntregaUnoCoder.modelo.Sucursal;

@Repository
public interface SucursalesRepository extends JpaRepository<Sucursal, Long> {



}
