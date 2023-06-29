package main;

public abstract class SocioAbstracto {

	protected String nombre;
	protected String sexo;
	protected byte edad;
	protected String telefono;
	protected String direccion;
	
	protected int id;
	
	
	
	public SocioAbstracto(String nombre, String sexo, 
						  byte edad, String telefono, 
						  String direccion){
		
	
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
		this.telefono = telefono;
		this.direccion = direccion;
		
	}
	
	
	public abstract String dameCategoría();
	
	public String dameNombre() {
		return this.nombre;
	}
	
	public String dameSexo() {
		return this.sexo;
	}
	
	public byte dameEdad() {
		return this.edad;
	}
	
	public String dameTelefono() {
		return this.telefono;
	}
	
	public String dameDirecciom() {
		return this.direccion;
	}
	
	public int dameId() {
		return this.id;
	}
	
	public void configuraId(int id) {
		this.id = id;
	}
		
	
	
}
