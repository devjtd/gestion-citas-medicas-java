package com.utp.clinicamedica.model;

import java.util.Scanner;

public class Paciente {

    // Scanner
    Scanner scan = new Scanner(System.in);

    //Atributos
    private String nombreCompleto;
    private int dni;
    private int numeroTelefonico;
    private String email;
    private int edad;
    private String genero;

    // Constructor
    public Paciente(String nombreCompleto, int dni, int numeroTelefonico, String email, int edad, String genero) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.numeroTelefonico = numeroTelefonico;
        this.email = email;
        this.edad = edad;
        this.genero = genero;
    }

    // Getters y Setters
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void leerDatosPaciente() {
        System.out.print("Nombre completo: ");
        boolean nombreValido = false;
        do {
            try {
                String nombre = scan.nextLine();
                if (nombre.matches(".*\\d.*")) {
                    throw new RuntimeException("Error: El nombre no puede contener números.");
                }
                this.nombreCompleto = nombre;
                nombreValido = true;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (!nombreValido);

        System.out.print("Género (M/F): ");
        boolean generoValido = false;
        do {
            try {
                String genero = scan.nextLine().toUpperCase();
                if (!genero.equals("M") && !genero.equals("F")) {
                    throw new RuntimeException("Error: Ingrese solo 'M' para masculino o 'F' para femenino.");
                }
                this.genero = genero;
                generoValido = true;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (!generoValido);

        System.out.print("Edad: ");
        boolean edadValida = false;
        do {
            try {
                this.edad = scan.nextInt();
                scan.nextLine(); // Limpiar el buffer del scanner
                if (this.edad <= 0) {
                    throw new RuntimeException("Error: La edad debe ser un número positivo.");
                }
                edadValida = true;
            } catch (Exception ex) {
                System.out.println("Error: Ingrese una edad válida (solo números positivos).");
                scan.nextLine(); // Limpiar el buffer del scanner
                edadValida = false;
            }
        } while (!edadValida);

        System.out.print("DNI: ");
        boolean dniValido;
        do {
            try {
                this.dni = scan.nextInt();
                scan.nextLine(); // Limpiar el buffer del scanner
                dniValido = true;
            } catch (Exception ex) {
                System.out.println("Error: Ingrese un DNI válido (solo números).");
                scan.nextLine(); // Limpiar el buffer del scanner
                dniValido = false;
            }
        } while (!dniValido);

        System.out.print("Número telefónico: ");
        boolean numeroValido;
        do {
            try {
                this.numeroTelefonico = scan.nextInt();
                scan.nextLine(); // Limpiar el buffer del scanner
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
                emailValido = true;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (!emailValido);

        System.out.println("");
        System.out.println("");

    }

    public static void borrarDatosPaciente(Paciente[] pacientesArray) {
        Scanner scanner = new Scanner(System.in);

        boolean hayDatos = false;
        for (Paciente paciente : pacientesArray) {
            if (paciente != null) {
                hayDatos = true;
                break;
            }
        }

        if (hayDatos) {
            System.out.println("Ingrese el número del paciente a eliminar:");

            for (int i = 0; i < pacientesArray.length; i++) {
                Paciente paciente = pacientesArray[i];
                if (paciente != null) {
                    System.out.println((i + 1) + " - " + paciente.getNombreCompleto());
                }
            }

            int opcion = scanner.nextInt();
            int indiceAEliminar = opcion - 1;

            if (indiceAEliminar >= 0 && indiceAEliminar < pacientesArray.length && pacientesArray[indiceAEliminar] != null) {
                pacientesArray[indiceAEliminar] = null;
                // Ajustar el array moviendo los elementos hacia adelante para llenar el espacio vacío
                for (int i = indiceAEliminar; i < pacientesArray.length - 1; i++) {
                    pacientesArray[i] = pacientesArray[i + 1];
                }
                pacientesArray[pacientesArray.length - 1] = null; // Última posición vacía
                System.out.println("Datos del paciente eliminados correctamente.");
            } else {
                System.out.println("Opción inválida, no se pudo eliminar los datos del paciente.");
            }
        } else {
            System.out.println("No hay datos de pacientes para eliminar.");
        }
    }

    public static String generarInformeHTML(Paciente[] pacientesArray) {
        StringBuilder tablaHTML = new StringBuilder();
        tablaHTML.append("<div style=\"text-align: center; margin-top: 20px;\">");
        tablaHTML.append("<h1>Reporte de Pacientes</h1>");
        tablaHTML.append("</div>");
        tablaHTML.append("<table style=\"border-collapse: collapse; width: 70%; margin-left: auto; margin-right: auto; border: 1px solid #ddd;\">");
        tablaHTML.append("<tr style=\"background-color: #f2f2f2;\">");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">Nombre completo</th>");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">DNI</th>");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">Teléfono</th>");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">Edad</th>");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">Género</th>");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">Email</th>");
        tablaHTML.append("</tr>");

        for (Paciente paciente : pacientesArray) {
            if (paciente != null) {
                tablaHTML.append("<tr>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\">").append(paciente.getNombreCompleto()).append("</td>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\">").append(paciente.getDni()).append("</td>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\">").append(paciente.getNumeroTelefonico()).append("</td>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\">").append(paciente.getEdad()).append("</td>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\">").append(paciente.getGenero()).append("</td>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\">").append(paciente.getEmail()).append("</td>");
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

    public static void generarInformeConsola(Paciente[] pacientesArray) {
        int maxNombreLength = 0;
        int maxEmailLength = 0;
        int maxTelefonoLength = 0;
        int maxEdadLength = 0;
        int maxGeneroLength = 1; // Ajustado a un solo carácter para el género
        boolean hayDatos = false;

        for (Paciente paciente : pacientesArray) {
            if (paciente != null) {
                maxNombreLength = Math.max(maxNombreLength, paciente.getNombreCompleto().length());
                maxEmailLength = Math.max(maxEmailLength, paciente.getEmail().length());
                maxTelefonoLength = Math.max(maxTelefonoLength, String.valueOf(paciente.getNumeroTelefonico()).length());
                maxEdadLength = Math.max(maxEdadLength, String.valueOf(paciente.getEdad()).length());
                hayDatos = true;
            }
        }

        if (hayDatos) {
            int totalLength = maxNombreLength + maxEmailLength + maxTelefonoLength + maxEdadLength + maxGeneroLength + 35; // Cambiado a 6 espacios después del género

            String titulo = "Reporte de Pacientes";
            int espaciosAntes = (totalLength - titulo.length()) / 2;

            System.out.println("*".repeat(totalLength));
            System.out.println(" ".repeat(espaciosAntes) + titulo);
            System.out.println("*".repeat(totalLength));

            System.out.printf(" %-" + maxNombreLength + "s | %-10s | %-" + maxTelefonoLength + "s | %-" + maxEmailLength + "s | %-" + maxGeneroLength + "s | %-" + maxEdadLength + "s%n",
                    "Nombre completo", "DNI", "Teléfono", "Email", "Género", "Edad");

            System.out.println("*".repeat(totalLength));

            for (Paciente paciente : pacientesArray) {
                if (paciente != null) {
                    System.out.printf(" %-" + maxNombreLength + "s | %10d | %-" + maxTelefonoLength + "s | %-" + maxEmailLength + "s | %-" + maxGeneroLength + "s      | %-" + maxEdadLength + "d%n",
                            paciente.getNombreCompleto(), paciente.getDni(), paciente.getNumeroTelefonico(), paciente.getEmail(), paciente.getGenero(), paciente.getEdad());
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
