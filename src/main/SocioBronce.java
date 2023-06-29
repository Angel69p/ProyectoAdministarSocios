package main;

public class SocioBronce extends SocioAbstracto{

	public SocioBronce(String nombre, String sexo, 
			  byte edad, String telefono, 
			  String direccion) {
		
		super(nombre, sexo, edad, telefono, direccion);
		
	}

	@Override
	public String dameCategoría() {
		return "bronce";
	}
	
}
