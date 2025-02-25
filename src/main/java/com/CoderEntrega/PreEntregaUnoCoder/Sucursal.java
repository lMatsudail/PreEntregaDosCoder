package com.CoderEntrega.PreEntregaUnoCoder;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;


@Entity
@Table(name = "SUCURSALES")

public class Sucursal {

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)

// generando columnas con @column para nombres y tipos de datos

@Column(name = "ID_SUCURSAL")
private Long id;
@Column(name = "NOMBRE")
private String nombre;
@Column(name = "DIRECCION")
private String direccion;
@Column(name = "TELEFONO")
private String telefono;

public Sucursal(String nombre, String direccion, String telefono) {
    this.nombre = nombre;
    this.direccion = direccion;
    this.telefono = telefono;
    this.empleados = new ArrayList<>();
}

@OneToMany (mappedBy = "sucursal", cascade = CascadeType.ALL)
private List<Empleado> empleados;

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

public String getDireccion() {
    return direccion;
}

public void setDireccion(String direccion) {
    this.direccion = direccion;
}

public String getTelefono() {
    return telefono;
}

public void setTelefono(String telefono) {
    this.telefono = telefono;
}

public List<Empleado> getEmpleados() {
    return empleados;
}

public void setEmpleados(List<Empleado> empleados) {
    this.empleados = empleados;
}

public Sucursal(Long id, String nombre, String direccion, String telefono) {
    this.id = id;
    this.nombre = nombre;
    this.direccion = direccion;
    this.telefono = telefono;
}


}
