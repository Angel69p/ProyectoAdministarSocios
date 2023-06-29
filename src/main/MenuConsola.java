package main;

import java.util.Scanner;

public class MenuConsola {

    private Scanner entradaTexto = new Scanner(System.in);

    public MenuConsola() {

        while (true) {

            this.menuPrincipal();
            this.sleep(1000);
            this.elegirOtraOpcion();

        }

    }

    public void menuPrincipal() {

        this.entradaTexto = new Scanner(System.in);

        String menu = "[*] Plantilla de socios [*] \n"
                + "[!] Seleccione una opción: \n"
                + "  \n"
                + "1 - Ingresar nuevo socio \n"
                + "2 - Mostrar datos de socios registrados \n"
                + "3 - Mostrar número de socios entre 50 y 80 años \n"
                + "4 - Mostrar número de socios cuyo nombre empieza por la letra D \n"
                + "5 - Mostrar número de socios masculinos y femeninos \n"
                + "6 - Mostrar número de socios por categorías \n"
                + "7 - Mostrar datos de socio por id \n";

        System.out.println(menu);

        switch (entradaTexto.nextInt()) {

            default:
                System.out.println("[ERROR] ¡Elige una opción válida! \n");
                break;
            case 1:
                this.ingresaNuevoSocio();
                break;

            case 2:
                PlantillaSocios.muestraDatosSocios();
                break;

            case 3:
                this.muestraNumeroSociosEntre50y80Años();
                break;

            case 4:
                this.muestraNumeroSociosCuyoNombreEmpiezaPorD();
                break;

            case 5:
                this.muestraNumeroSociosMasculinosYFemeninos();
                break;

            case 6:
                this.muestraNumeroSociosPorCategorías();
                break;

            case 7:
                this.muestraSocioPorID();
                break;

        }

    }

    private void ingresaNuevoSocio() {

        this.entradaTexto = new Scanner(System.in);

        System.out.println("[Nuevo Socio] Ingrese los siguientes datos: \n");

        System.out.println("[Categoría] (oro / plata / bronce): ");
        String categoria = this.entradaTexto.nextLine().toLowerCase().trim();

        System.out.println("[Nombre]: ");
        String nombre = this.entradaTexto.nextLine().toLowerCase().trim();

        System.out.println("[Sexo]: (M/F): ");
        String sexo = this.entradaTexto.nextLine().toLowerCase().trim();

        System.out.println("[Edad]: ");
        byte edad = this.entradaTexto.nextByte();

        // Lo instancio otra vez para evitar un eror que 
        // desconozco por qué ocurre
        this.entradaTexto = new Scanner(System.in);

        System.out.println("[Teléfono]: ");
        String telefono = this.entradaTexto.nextLine().trim();

        System.out.println("[Dirección]: ");
        String direccion = this.entradaTexto.nextLine().toLowerCase();

        switch (categoria) {

            case "oro":
                PlantillaSocios.nuevoSocio(new SocioOro(nombre, sexo,
                        edad, telefono,
                        direccion));

                System.out.println("[*] ¡Nuevo socio añadido!");
                break;

            case "plata":
                PlantillaSocios.nuevoSocio(new SocioPlata(nombre, sexo,
                        edad, telefono,
                        direccion));

                System.out.println("[*] ¡Nuevo socio añadido!");
                break;

            case "bronce":
                PlantillaSocios.nuevoSocio(new SocioBronce(nombre, sexo,
                        edad, telefono,
                        direccion));

                System.out.println("[*] ¡Nuevo socio añadido!");
                break;

            default:
                System.out.println("[Error] ¡No se pudo añadir al socio!");

        }

    }

    private void muestraNumeroSociosEntre50y80Años() {

        System.out.println(String.format("[*] Socios entre 50 y 80 años: %d",
                PlantillaSocios.sociosEntreEdad((byte) 50, (byte) 80)));
    }

    private void muestraNumeroSociosCuyoNombreEmpiezaPorD() {

        System.out.println(String.format("[*] El nombre de %d socios empiza por D",
                PlantillaSocios.sociosCuyoNombreEmpiezaPor("d")));
    }

    private void muestraNumeroSociosMasculinosYFemeninos() {

        System.out.println(String.format("[*] %d socios masculinos",
                PlantillaSocios.numeroSociosMasculinos()));

        System.out.println(String.format("[*] %d socios femeninos",
                PlantillaSocios.numeroSociosFemeninos()));

    }

    private void muestraNumeroSociosPorCategorías() {

        System.out.println(String.format("[*] %d socios oro",
                PlantillaSocios.numeroDeSociosOro()));

        System.out.println(String.format("[*] %d socios plata",
                PlantillaSocios.numeroDeSociosPlata()));

        System.out.println(String.format("[*] %d socios bronce",
                PlantillaSocios.numeroDeSociosBronce()));

    }

    private void muestraSocioPorID() {

        this.entradaTexto = new Scanner(System.in);

        System.out.println("[!] Introduce el ID del socio");
        int idABuscar = this.entradaTexto.nextInt();

        SocioAbstracto socio = null;

        try {
            socio = PlantillaSocios.dameSocioPorId(idABuscar);
            PlantillaSocios.muestraDatosSocio(socio);

        } catch (SocioNoEncontradoError e) {
            System.out.println("[ERROR] ¡Socio no encontrado!");
        }

    }

    private void elegirOtraOpcion() {

        this.entradaTexto = new Scanner(System.in);

        System.out.println("[!] ¿Quieres elegir elegir otra acción (S/N)");

        switch (this.entradaTexto.nextLine().toLowerCase()) {

            case "s":
                System.out.flush();
                break;

            default:
                System.exit(0);
                break;

        }
    }

    private void sleep(int miliseconds) {

        try {
            Thread.sleep(miliseconds);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
