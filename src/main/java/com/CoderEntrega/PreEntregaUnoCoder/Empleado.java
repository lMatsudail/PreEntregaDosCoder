package com.CoderEntrega.PreEntregaUnoCoder;
import jakarta.persistence.*;


@Entity
@Table(name = "EMPLEADOS")

public class Empleado {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long id;

private String nombre;

private String apellido;

private String documento;

private String cargo;

@ManyToOne (optional = false)
@JoinColumn(name = "SUCURSAL_ID")
private Sucursal sucursal;

// generando getters y setters en class "empleado"

public Long getId() {
    return id;
}

public void setId(Long id) {
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

public Sucursal getSucursal() {
    return sucursal;
}

public void setSucursal(Sucursal sucursal) {
    this.sucursal = sucursal;
}

public Empleado(String nombre, String apellido, String documento, String cargo, Sucursal sucursal) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.documento = documento;
    this.cargo = cargo;
    this.sucursal = sucursal;
}

public Empleado(String nombre) {
    this.nombre = nombre;
}

}
