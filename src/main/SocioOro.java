package main;

public class SocioOro extends SocioAbstracto{

	public SocioOro(String nombre, String sexo, 
			  byte edad, String telefono, 
			  String direccion) {
		
		super(nombre, sexo, edad, telefono, direccion);
		
	}

	@Override
	public String dameCategoría() {
		return "oro";
	}
	
}
