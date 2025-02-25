package com.CoderEntrega.PreEntregaUnoCoder.modelo;

public class EmpleadoDTO {
    
    // generando atributos de la clase "SucursalDTO" evitando asi errores con "empleado"

    private int id;
    private String nombre;
    private String apellido;
    private String documento;
    private String cargo;
    private SucursalDTO sucursal;

    public int getId() {
        return id;
    }
    public void setId(int id) {
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
    public EmpleadoDTO(int id, String nombre, String apellido, String documento, String cargo, SucursalDTO sucursal) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.cargo = cargo;
        this.sucursal = sucursal;
    }
    
}
