package main;

import java.util.ArrayList;

public class PlantillaSocios {

    private static ArrayList<SocioAbstracto> socios = new ArrayList<SocioAbstracto>();
    private static int id = 0;

    public static ArrayList<SocioAbstracto> dameSocios() {
        return socios;
    }

    public static void nuevoSocio(SocioAbstracto socio) {
        socio.configuraId(id);
        id++;
        socios.add(socio);

    }

    public static void eliminarSocio(SocioAbstracto socio) {
        socios.remove(socios.indexOf(socio));
    }

    public static void muestraDatosSocios() {

        for (SocioAbstracto socio : socios) {
            muestraDatosSocio(socio);

        }

    }

    public static void muestraDatosSocio(SocioAbstracto socio) {

        String datos = String.format("id:%d, Nombre:%s, Sexo:%s, Edad: %s , teléfono:%s, dirección:%s, categoría:%s",
                socio.dameId(), socio.dameNombre(),
                socio.dameSexo(), socio.dameEdad(),
                socio.dameTelefono(), socio.dameDirecciom(),
                socio.dameCategoría());
        

        System.out.println("\n ------------------------------ \n"
                + datos
                + "\n ------------------------------ \n");

    }

    public static int sociosEntreEdad(byte edadMin, byte edadMax) {

        int contador = 0;

        for (SocioAbstracto socio : socios) {
            if (socio.dameEdad() > edadMin && socio.dameEdad() < edadMax) {
                contador++;
            }
        }

        return contador;
    }

    public static SocioAbstracto dameSocioPorId(int id) throws SocioNoEncontradoError {

        SocioAbstracto socioADevolver = null;

        for (SocioAbstracto socio : socios) {
            if (socio.dameId() == id) {
                socioADevolver = socio;
            }
        }

        if (socioADevolver == null) {
            throw new SocioNoEncontradoError(String.format("el ID '%s' no se ha encontrado", id));

        } else {
            return socioADevolver;
        }

    }

    public static int dameIdDeSocio(SocioAbstracto socioAObtenerId) throws IdNoEncontradoError {

        Integer id = null;

        for (SocioAbstracto socio : socios) {
            if (socio == socioAObtenerId) {
                id = socio.dameId();
            }
        }

        if (id == null) {
            throw new IdNoEncontradoError(String.format("el ID '%s' no se ha encontrado", id));

        } else {
            return id.intValue();
        }

    }

    public static int sociosCuyoNombreEmpiezaPor(String letra) {

        int contador = 0;

        for (SocioAbstracto socio : socios) {
            if (socio.dameNombre().startsWith(letra.toLowerCase())) {
                contador++;
            }

        }

        return contador;

    }

    public static int numeroSociosMasculinos() {

        int contador = 0;

        for (SocioAbstracto socio : socios) {
            if (socio.dameSexo().equals("m")) {
                contador++;
            }

        }

        return contador;

    }

    public static int numeroSociosFemeninos() {

        int contador = 0;

        for (SocioAbstracto socio : socios) {
            if (socio.dameSexo().equals("f")) {
                contador++;
            }

        }

        return contador;

    }

    public static int numeroDeSociosOro() {

        int contador = 0;

        for (SocioAbstracto socio : socios) {
            if (socio.dameCategoría() == "oro") {
                contador++;
            }
        }

        return contador;

    }

    public static int numeroDeSociosPlata() {

        int contador = 0;

        for (SocioAbstracto socio : socios) {
            if (socio.dameCategoría() == "plata") {
                contador++;
            }
        }

        return contador;

    }

    public static int numeroDeSociosBronce() {

        int contador = 0;

        for (SocioAbstracto socio : socios) {
            if (socio.dameCategoría() == "bronce") {
                contador++;
            }
        }

        return contador;

    }

}
