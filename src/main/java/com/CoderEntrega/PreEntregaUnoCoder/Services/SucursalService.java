package com.CoderEntrega.PreEntregaUnoCoder.Services;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.CoderEntrega.PreEntregaUnoCoder.DTOs.SucursalDTO;
import com.CoderEntrega.PreEntregaUnoCoder.Repositories.SucursalesRepository;
import com.CoderEntrega.PreEntregaUnoCoder.modelo.Sucursal;

@Service
public class SucursalService {

    @Autowired
    private SucursalesRepository sucursalesRepository;

    public SucursalDTO saveSucursal(SucursalDTO s1) {
         Sucursal sucursal1 = new Sucursal (null, s1.getNombre(), s1.getDireccion(), s1.getTelefono());
         Sucursal sucursalRespuesta = sucursalesRepository.save(sucursal1);
         return new SucursalDTO(sucursalRespuesta.getId(), sucursalRespuesta.getNombre(), sucursalRespuesta.getDireccion(), sucursalRespuesta.getTelefono());
    }
    public List<SucursalDTO> getAllSucursales() {
        List<Sucursal> listaSucursales = sucursalesRepository.findAll();
        List<SucursalDTO> listaSucursalesDTO = new ArrayList<>();
        for (Sucursal sucursal : listaSucursales) {
            listaSucursalesDTO.add(new SucursalDTO(sucursal.getId(), sucursal.getNombre(), sucursal.getDireccion(), sucursal.getTelefono()));
        }
        return listaSucursalesDTO;
    }
}
