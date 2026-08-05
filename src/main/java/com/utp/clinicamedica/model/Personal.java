package com.utp.clinicamedica.model;

import java.util.Scanner;

public class Personal {

    //Scanner
    Scanner scan = new Scanner(System.in);

    //Atributos
    private String nombreCompleto;
    private int dni;
    private String foto;
    private String cargo;
    private int numeroTelefonico;
    private String email;

    //Constructor
    public Personal(String nombreCompleto, int dni, String foto, String cargo, int numeroTelefonico, String email) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.foto = foto;
        this.cargo = cargo;
        this.numeroTelefonico = numeroTelefonico;
        this.email = email;
    }

    //Getters y Setters
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(int numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Método Leer Datos
    public void LeerDatosPersonal() {
        System.out.print("Nombre completo: ");
        boolean nombreValido = false;

        do {
            try {
                String nombre = scan.nextLine();
                if (nombre.matches(".*\\d.*")) { // Verifica si hay números en el nombre
                    throw new RuntimeException("Error: El nombre no puede contener números.");
                }
                this.nombreCompleto = nombre;
                nombreValido = true; // Nombre válido, salimos del bucle

                // Resto del código para otros datos...
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (!nombreValido);

        System.out.print("DNI: ");
        boolean dniValido;
        do {
            try {
                this.dni = scan.nextInt();
                scan.nextLine(); // Consumir el salto de línea
                dniValido = true;
            } catch (Exception ex) {
                System.out.println("Error: Ingrese un DNI válido (solo números).");
                scan.nextLine(); // Limpiar el buffer del scanner
                dniValido = false;
            }
        } while (!dniValido);

        System.out.print("Nombre del archivo de foto: ");
        this.foto = scan.nextLine();

        System.out.print("Cargo: ");
        boolean cargoValido = false;
        do {
            try {
                this.cargo = scan.nextLine();
                if (this.cargo.matches(".*\\d.*")) { // Verifica si hay números en el cargo
                    throw new RuntimeException("Error: El cargo no puede contener números.");
                }
                cargoValido = true;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (!cargoValido);

        System.out.print("Número telefónico: ");
        boolean numeroValido;
        do {
            try {
                this.numeroTelefonico = scan.nextInt();
                scan.nextLine(); // Consumir el salto de línea
                numeroValido = true;
            } catch (Exception ex) {
                System.out.println("Error: Ingrese un número telefónico válido (solo números).");
                scan.nextLine(); // Limpiar el buffer del scanner
                numeroValido = false;
            }
        } while (!numeroValido);

        System.out.print("Email: ");
        boolean emailValido = false;
        do {
            try {
                this.email = scan.nextLine();
                if (!this.email.contains("@") || !this.email.contains(".")) {
                    throw new RuntimeException("Error: El correo electrónico debe contener '@' y un dominio (por ejemplo, '.com').");
                }
                emailValido = true; // Email válido, salimos del bucle

                // Resto del código para otros datos...
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (!emailValido);

        System.out.println("");
        System.out.println("");
    }

    public static void borrarDatosPersonal(Personal[] personalArray) {
        Scanner scanner = new Scanner(System.in);
        boolean hayDatos = false;

        for (Personal persona : personalArray) {
            if (persona != null) {
                hayDatos = true;
                break;
            }
        }

        if (!hayDatos) {
            System.out.println("No hay datos para borrar.");
            return;
        }

        System.out.println("Ingrese el número de la persona a eliminar:");

        for (int i = 0; i < personalArray.length; i++) {
            Personal persona = personalArray[i];
            if (persona != null) {
                System.out.println((i + 1) + " - " + persona.getNombreCompleto());
            }
        }

        int opcion = scanner.nextInt();
        int indiceAEliminar = opcion - 1;

        if (indiceAEliminar >= 0 && indiceAEliminar < personalArray.length && personalArray[indiceAEliminar] != null) {
            personalArray[indiceAEliminar] = null;
            // Ajustar el array moviendo los elementos hacia adelante para llenar el espacio vacío
            for (int i = indiceAEliminar; i < personalArray.length - 1; i++) {
                personalArray[i] = personalArray[i + 1];
            }
            personalArray[personalArray.length - 1] = null; // Última posición vacía
            System.out.println("Datos eliminados correctamente.");
        } else {
            System.out.println("Opción inválida, no se pudo eliminar.");
        }
    }

    public static String generarInformeHTML(Personal[] personalArray, String rutaCarpetaFotos) {
        StringBuilder tablaHTML = new StringBuilder();
        tablaHTML.append("<div style=\"text-align: center; margin-top: 20px;\">");
        tablaHTML.append("<h1>Reporte de Personal</h1>");
        tablaHTML.append("</div>");
        tablaHTML.append("<table style=\"border-collapse: collapse; width: 70%; margin-left: auto; margin-right: auto; border: 1px solid #ddd;\">");
        tablaHTML.append("<tr style=\"background-color: #f2f2f2;\">");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">Foto</th>");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">Nombre completo</th>");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">DNI</th>");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">Cargo</th>");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">Teléfono</th>");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">Email</th>");
        tablaHTML.append("</tr>");

        for (Personal persona : personalArray) {
            if (persona != null) {
                tablaHTML.append("<tr>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\"><img src=\"").append(rutaCarpetaFotos).append(persona.getFoto()).append("\" alt=\"Foto de ").append(persona.getNombreCompleto()).append("\" style=\"width: 100px; height: auto;\"></td>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\">").append(persona.getNombreCompleto()).append("</td>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\">").append(persona.getDni()).append("</td>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\">").append(persona.getCargo()).append("</td>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\">").append(persona.getNumeroTelefonico()).append("</td>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\">").append(persona.getEmail()).append("</td>");

                tablaHTML.append("</tr>");
            }
        }

        tablaHTML.append("</table>");
        
        //Footer
        tablaHTML.append("<footer style=\"text-align: center; margin-top: 40px; background-color: #f5f5f5; padding: 10px;\">");
        tablaHTML.append("Powered By Grupo 6. Universidad Tecnológica del Perú.");
        tablaHTML.append("</footer>");
        
        return tablaHTML.toString();
    }

    public static void generarInformeConsola(Personal[] personalArray) {
        int maxNombreLength = 0;
        int maxCargoLength = 0;
        int maxEmailLength = 0;
        boolean hayDatos = false;

        // Encuentra la longitud máxima de cada columna y verifica si hay datos
        for (Personal persona : personalArray) {
            if (persona != null) {
                maxNombreLength = Math.max(maxNombreLength, persona.getNombreCompleto().length());
                maxCargoLength = Math.max(maxCargoLength, persona.getCargo().length());
                maxEmailLength = Math.max(maxEmailLength, persona.getEmail().length());
                hayDatos = true;
            }
        }

        if (hayDatos) {
            // Resto del código para generar el informe de consola...
            String titulo = "Reporte del Personal";
            int totalLength = maxNombreLength + maxCargoLength + maxEmailLength + 36;

            int espaciosAntes = (totalLength - titulo.length()) / 2;

            System.out.println("*".repeat(totalLength));
            System.out.println(" ".repeat(espaciosAntes) + titulo);
            System.out.println("*".repeat(totalLength));

            System.out.printf(" %-" + maxNombreLength + "s | %-10s | %-" + maxCargoLength + "s | %-10s | %-" + maxEmailLength + "s%n",
                    "Nombre completo", "DNI", "Cargo", "Teléfono", "Email");

            System.out.println("*".repeat(totalLength));

            for (Personal persona : personalArray) {
                if (persona != null) {
                    System.out.printf(" %-" + maxNombreLength + "s | %10d | %-" + maxCargoLength + "s | %10d | %-" + maxEmailLength + "s%n",
                            persona.getNombreCompleto(), persona.getDni(), persona.getCargo(),
                            persona.getNumeroTelefonico(), persona.getEmail());
                }
            }

            System.out.println("*".repeat(totalLength));
            System.out.println("");
            System.out.println("");
        } else {
            System.out.println("No hay datos para generar el informe en la consola.");
        }
    }

}
