package com.CoderEntrega.PreEntregaUnoCoder.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CoderEntrega.PreEntregaUnoCoder.Sucursal;
import com.CoderEntrega.PreEntregaUnoCoder.Repositories.SucursalesRepository;

@Service
public class SucursalService {

    @Autowired
    private SucursalesRepository sucursalesRepository;
    public Sucursal saveSucursal(Sucursal sucursal) {
        return sucursalesRepository.save(sucursal);
    }
}
