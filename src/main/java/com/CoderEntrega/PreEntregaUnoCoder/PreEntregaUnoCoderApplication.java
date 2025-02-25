package com.CoderEntrega.PreEntregaUnoCoder;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.CoderEntrega.PreEntregaUnoCoder.Services.EmpleadoService;
//import com.CoderEntrega.PreEntregaUnoCoder.Services.SucursalService;

@SpringBootApplication
public class PreEntregaUnoCoderApplication implements CommandLineRunner {

	//@Autowired
	//private EmpleadoService empleadoService;
	//@Autowired
	//private SucursalService sucursalService;

	public static void main(String[] args) {
		SpringApplication.run(PreEntregaUnoCoderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Sucursal s1 = new Sucursal("centro","Cr 24 # 19-03","3109894050");
		Sucursal s2 = new Sucursal("Ciudad Jardin","Cl 11 # 19-32","3201239128");
		Sucursal s3 = new Sucursal("norte","Dg 116 # 19-03","3109894050");
		//sucursalService.saveSucursal(s1);
		//sucursalService.saveSucursal(s2);
		//sucursalService.saveSucursal(s3);
		Empleado e1 = new Empleado("Juan","Perez","1254377","Gerente",s1);
		Empleado e2 = new Empleado("Pedro","Gomez","75643222","Asesor",s2);
		Empleado e3 = new Empleado("Maria","Lopez","971235675","Auxiliar",s3);
		Empleado e4 = new Empleado("Luis","Gonzalez","980845456","Producción",s1);
		Empleado e5 = new Empleado("Ana","Gomez","123123546","Bordado",s2);
		Empleado e6 = new Empleado("Carlos","Lopez","6512347821","Corte",s3);
		//empleadoService.saveEmpleado(e1);
		//empleadoService.saveEmpleado(e2);
		//empleadoService.saveEmpleado(e3);
		//empleadoService.saveEmpleado(e4);
		//empleadoService.saveEmpleado(e5);
		//empleadoService.saveEmpleado(e6);
	}

}
