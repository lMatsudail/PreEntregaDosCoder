package com.CoderEntrega.PreEntregaUnoCoder.Services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.CoderEntrega.PreEntregaUnoCoder.DTOs.SucursalDTO;
import com.CoderEntrega.PreEntregaUnoCoder.Repositories.SucursalesRepository;
import com.CoderEntrega.PreEntregaUnoCoder.modelo.Sucursal;

import Excepciones.SucursalNoEncontradaException;

/**
 * Servicio para gestionar las operaciones relacionadas con las sucursales.
 */
@Service
public class SucursalService {

    @Autowired
    private SucursalesRepository sucursalesRepository;

    /**
     * Guarda una nueva sucursal.
     *
     * @param s1 DTO de la sucursal a guardar.
     * @return DTO de la sucursal guardada.
     */

    public SucursalDTO saveSucursal(SucursalDTO s1) {
        Sucursal sucursal1 = new Sucursal (null,
            s1.getNombre(), 
            s1.getDireccion(), 
            s1.getTelefono());
        Sucursal sucursalRespuesta = sucursalesRepository.save(sucursal1);
        return new SucursalDTO(sucursalRespuesta.getId(), 
            sucursalRespuesta.getNombre(), 
            sucursalRespuesta.getDireccion(), 
            sucursalRespuesta.getTelefono());
    }
    /**
     * Obtiene todas las sucursales.
     *
     * @return Lista de DTOs de las sucursales.
     */
    public List<SucursalDTO> getAllSucursales() {
        List<Sucursal> listaSucursales = sucursalesRepository.findAll();
        List<SucursalDTO> listaSucursalesDTO = new ArrayList<>();
        for (Sucursal sucursal : listaSucursales) {
            listaSucursalesDTO.add(new SucursalDTO(sucursal.getId(), sucursal.getNombre(), sucursal.getDireccion(), sucursal.getTelefono()));
        }
        return listaSucursalesDTO;
    }
    /**
     * Actualiza una sucursal existente.
     *
     * @param id ID de la sucursal a actualizar.
     * @param sucursalDTO DTO de la sucursal con los nuevos datos.
     * @return DTO de la sucursal actualizada.
     */

    public SucursalDTO actualizarSucursal(Long id, SucursalDTO sucursalDTO) {
        Sucursal sucursalExistente = sucursalesRepository.findById(id)
            .orElseThrow(() -> new SucursalNoEncontradaException("Sucursal no encontrada"));

        sucursalExistente.setNombre(sucursalDTO.getNombre());
        sucursalExistente.setDireccion(sucursalDTO.getDireccion());
        sucursalExistente.setTelefono(sucursalDTO.getTelefono());

        Sucursal sucursalActualizada = sucursalesRepository.save(sucursalExistente);

        return new SucursalDTO(
            sucursalActualizada.getId(),
            sucursalActualizada.getNombre(),
            sucursalActualizada.getDireccion(),
            sucursalActualizada.getTelefono()
        );
    }
    /**
     * Elimina una sucursal por su ID.
     *
     * @param id ID de la sucursal a eliminar.
     */
    public void deleteSucursal(Long id) {
        sucursalesRepository.deleteById(id);
    }
}
