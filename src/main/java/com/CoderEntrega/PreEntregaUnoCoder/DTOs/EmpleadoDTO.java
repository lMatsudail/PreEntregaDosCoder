package com.CoderEntrega.PreEntregaUnoCoder.DTOs;
import java.time.LocalDateTime;

public class EmpleadoDTO {
    
    private long id;
    private String nombre;
    private String apellido;
    private String documento;
    private String cargo;
    private SucursalDTO sucursal;
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public SucursalDTO getSucursal() {
        return sucursal;
    }
    public void setSucursal(SucursalDTO sucursal) {
        this.sucursal = sucursal;
    }
    
    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }
    public void setFechaEntrada(LocalDateTime fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }
    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public EmpleadoDTO(long id, String nombre, String apellido, String documento, String cargo, SucursalDTO sucursal,
            LocalDateTime fechaEntrada, LocalDateTime fechaSalida) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.cargo = cargo;
        this.sucursal = sucursal;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }
    public EmpleadoDTO() {
    }
    
    
}
