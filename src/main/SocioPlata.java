package main;

public class SocioPlata extends SocioAbstracto{

	public SocioPlata(String nombre, String sexo, 
			  byte edad, String telefono, 
			  String direccion) {
		
		super(nombre, sexo, edad, telefono, direccion);
		
	}

	@Override
	public String dameCategoría() {
		return "plata";
	}
	
}
