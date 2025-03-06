package com.CoderEntrega.PreEntregaUnoCoder.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CoderEntrega.PreEntregaUnoCoder.Sucursal;
import com.CoderEntrega.PreEntregaUnoCoder.Repositories.SucursalesRepository;
import com.CoderEntrega.PreEntregaUnoCoder.modelo.SucursalDTO;

@Service
public class SucursalService {

    @Autowired
    private SucursalesRepository sucursalesRepository;

    public SucursalDTO saveSucursal(SucursalDTO s1) {
         Sucursal sucursal1 = new Sucursal (s1.getId(), s1.getNombre(), s1.getDireccion(), s1.getTelefono());
         Sucursal sucursalRespuesta = sucursalesRepository.save(sucursal1);
         return new SucursalDTO(sucursalRespuesta.getId(), sucursalRespuesta.getNombre(), sucursalRespuesta.getDireccion(), sucursalRespuesta.getTelefono());
    }
    public List<Sucursal> getAllSucursales() {
        return sucursalesRepository.findAll();
    }
    public void saveSucursal2(Sucursal s2) {
        throw new UnsupportedOperationException("Unimplemented method 'saveSucursal'");
    }
}
