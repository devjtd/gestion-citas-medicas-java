package com.utp.clinicamedica.model;

import java.util.Scanner;

public class Doctor {

    // Scanner
    Scanner scan = new Scanner(System.in);

    // Atributos
    private String foto;
    private String nombreCompleto;
    private String especialidad;
    private int numeroTelefonico;
    private String email;

    // Constructor
    public Doctor(String foto, String nombreCompleto, String especialidad, int numeroTelefonico, String email) {
        this.foto = foto;
        this.nombreCompleto = nombreCompleto;
        this.especialidad = especialidad;
        this.numeroTelefonico = numeroTelefonico;
        this.email = email;
    }

    // Getters y Setters
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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

    //Método para leer datos de la clase Doctor
    public void leerDatosDoctor() {
        System.out.print("Nombre completo: ");
        boolean nombreValido = false;
        do {
            try {
                this.nombreCompleto = scan.nextLine();
                if (this.nombreCompleto.matches(".*\\d.*")) { // Verifica si hay números en el nombre completo
                    throw new RuntimeException("Error: El nombre no puede contener números.");
                }
                nombreValido = true;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.print("Por favor, ingresa un nombre válido: ");
            }
        } while (!nombreValido);

        System.out.print("Nombre del archivo de foto: ");
        this.foto = scan.nextLine();

        System.out.print("Especialidad: ");
        boolean especialidadValida = false;
        do {
            try {
                this.especialidad = scan.nextLine();
                if (this.especialidad.matches(".*\\d.*")) { // Verifica si hay números en la especialidad
                    throw new RuntimeException("Error: La especialidad no puede contener números.");
                }
                especialidadValida = true;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (!especialidadValida);

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
                emailValido = true;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (!emailValido);

        System.out.println("");
        System.out.println("");
    }

    // Método para borrar datos de un array de Doctores
    public static void borrarDatosDoctor(Doctor[] doctorArray) {
        Scanner scanner = new Scanner(System.in);

        boolean hayDatos = false;
        for (Doctor doctor : doctorArray) {
            if (doctor != null) {
                hayDatos = true;
                break;
            }
        }

        if (hayDatos) {
            System.out.println("Ingrese el número del doctor a eliminar:");

            for (int i = 0; i < doctorArray.length; i++) {
                Doctor doctor = doctorArray[i];
                if (doctor != null) {
                    System.out.println((i + 1) + " - " + doctor.getNombreCompleto());
                }
            }

            int opcion = scanner.nextInt();
            int indiceAEliminar = opcion - 1;

            if (indiceAEliminar >= 0 && indiceAEliminar < doctorArray.length && doctorArray[indiceAEliminar] != null) {
                doctorArray[indiceAEliminar] = null;
                // Ajustar el array moviendo los elementos hacia adelante para llenar el espacio vacío
                for (int i = indiceAEliminar; i < doctorArray.length - 1; i++) {
                    doctorArray[i] = doctorArray[i + 1];
                }
                doctorArray[doctorArray.length - 1] = null; // Última posición vacía
                System.out.println("Datos del doctor eliminados correctamente.");
            } else {
                System.out.println("Opción inválida, no se pudo eliminar.");
            }
        } else {
            System.out.println("No hay datos de doctores para eliminar.");
        }
    }

    //Método para generar un informe HTML
    public static String generarInformeHTML(Doctor[] doctorArray, String rutaCarpetaFotos) {
        StringBuilder tablaHTML = new StringBuilder();
        tablaHTML.append("<div style=\"text-align: center; margin-top: 20px;\">");
        tablaHTML.append("<h1>Reporte de Doctores</h1>");
        tablaHTML.append("</div>");
        tablaHTML.append("<table style=\"border-collapse: collapse; width: 70%; margin-left: auto; margin-right: auto; border: 1px solid #ddd;\">");
        tablaHTML.append("<tr style=\"background-color: #f2f2f2;\">");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">Foto</th>");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">Nombre completo</th>");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">Especialidad</th>");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">Teléfono</th>");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">Email</th>");
        tablaHTML.append("</tr>");

        for (Doctor doctor : doctorArray) {
            if (doctor != null) {
                tablaHTML.append("<tr>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\"><img src=\"").append(rutaCarpetaFotos).append(doctor.getFoto()).append("\" alt=\"Foto de ").append(doctor.getNombreCompleto()).append("\" style=\"width: 100px; height: auto;\"></td>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\">").append(doctor.getNombreCompleto()).append("</td>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\">").append(doctor.getEspecialidad()).append("</td>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\">").append(doctor.getNumeroTelefonico()).append("</td>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\">").append(doctor.getEmail()).append("</td>");
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

    // Método para generar informe en consola
    public static void generarInformeConsola(Doctor[] doctorArray) {
        int maxNombreLength = 0;
        int maxEspecialidadLength = 0;
        int maxTelefonoLength = 0;
        int maxEmailLength = 0;
        boolean hayDatos = false;

        // Encuentra la longitud máxima de cada columna y verifica si hay datos
        for (Doctor doctor : doctorArray) {
            if (doctor != null) {
                maxNombreLength = Math.max(maxNombreLength, doctor.getNombreCompleto().length());
                maxEspecialidadLength = Math.max(maxEspecialidadLength, doctor.getEspecialidad().length());
                maxTelefonoLength = Math.max(maxTelefonoLength, String.valueOf(doctor.getNumeroTelefonico()).length());
                maxEmailLength = Math.max(maxEmailLength, doctor.getEmail().length());
                hayDatos = true;
            }
        }

        if (hayDatos) {
            // Calcula la longitud total de cada fila
            int totalLength = maxNombreLength + maxEspecialidadLength + maxTelefonoLength + maxEmailLength + 15;

            String titulo = "Reporte de Doctores";
            int espaciosAntes = (totalLength - titulo.length()) / 2;

            System.out.println("*".repeat(totalLength));
            System.out.println(" ".repeat(espaciosAntes) + titulo);
            System.out.println("*".repeat(totalLength));

            // Ajusta la alineación de la columna Especialidad con un ancho máximo
            System.out.printf(" %-" + maxNombreLength + "s | %-" + maxEspecialidadLength + "s | %-10s | %-" + maxEmailLength + "s%n",
                    "Nombre completo", "Especialidad", "Teléfono", "Email");

            System.out.println("*".repeat(totalLength));

            // Imprime los datos de los doctores
            for (Doctor doctor : doctorArray) {
                if (doctor != null) {
                    System.out.printf(" %-" + maxNombreLength + "s | %-" + maxEspecialidadLength + "s | %10d | %-" + maxEmailLength + "s%n",
                            doctor.getNombreCompleto(), doctor.getEspecialidad(), doctor.getNumeroTelefonico(), doctor.getEmail());
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
