package com.CoderEntrega.PreEntregaUnoCoder.Services;

import lombok.Data;

@Data
public class ApiResponsive {
    
    private String mensaje;
    private String estado;
    private Object objeto;

    public ApiResponsive(String mensaje, String estado, Object objeto) {
        this.mensaje = mensaje;
        this.estado = estado;
        this.objeto = objeto;
    }

    public ApiResponsive() {
    }
    
}
