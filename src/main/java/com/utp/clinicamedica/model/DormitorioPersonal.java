package com.utp.clinicamedica.model;

import java.util.Scanner;

public class DormitorioPersonal {

    //Scanner
    Scanner scan = new Scanner(System.in);

    //Atributos
    private String ocupante;
    private int numeroPiso;
    private int numeroDormitorio;
    private String baño;
    private String estado;

    //Constructor
    public DormitorioPersonal(String ocupante, int numeroPiso, int numeroDormitorio, String baño, String estado) {
        this.ocupante = ocupante;
        this.numeroPiso = numeroPiso;
        this.numeroDormitorio = numeroDormitorio;
        this.baño = baño;
        this.estado = estado;
    }

    //Getters and Setters
    public String getOcupante() {
        return ocupante;
    }

    public void setOcupante(String ocupante) {
        this.ocupante = ocupante;
    }

    public int getNumeroPiso() {
        return numeroPiso;
    }

    public void setNumeroPiso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
    }

    public int getNumeroDormitorio() {
        return numeroDormitorio;
    }

    public void setNumeroDormitorio(int numeroDormitorio) {
        this.numeroDormitorio = numeroDormitorio;
    }

    public String getBaño() {
        return baño;
    }

    public void setBaño(String baño) {
        this.baño = baño;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //Métodos
    public void leerDatosDormitoriosPersonal() {
        // Ocupante (sin números)
        boolean ocupanteValido = false;
        do {
            System.out.print("Nombre del ocupante: ");
            ocupante = scan.nextLine();
            if (ocupante.matches(".*\\d.*")) {
                System.out.println("El nombre del ocupante no puede contener números.");
            } else {
                ocupanteValido = true;
            }
        } while (!ocupanteValido);

        // Número de piso
        boolean numeroPisoValido = false;
        do {
            try {
                System.out.print("Número de piso: ");
                numeroPiso = Integer.parseInt(scan.nextLine());
                if (numeroPiso <= 0) {
                    throw new NumberFormatException();
                }
                numeroPisoValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número de piso válido (mayor que cero).");
            }
        } while (!numeroPisoValido);

        // Número de dormitorio
        boolean numeroDormitorioValido = false;
        do {
            try {
                System.out.print("Número de dormitorio: ");
                numeroDormitorio = Integer.parseInt(scan.nextLine());
                if (numeroDormitorio <= 0) {
                    throw new NumberFormatException();
                }
                numeroDormitorioValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número de dormitorio válido (mayor que cero).");
            }
        } while (!numeroDormitorioValido);

        // Estado del dormitorio (Ocupado/Disponible)
        boolean estadoValido = false;
        do {
            System.out.print("Estado del dormitorio (Ocupado/Disponible): ");
            estado = scan.nextLine().toLowerCase();
            if (!estado.equals("ocupado") && !estado.equals("disponible")) {
                System.out.println("Ingrese un estado válido (Ocupado/Disponible).");
            } else {
                estadoValido = true;
            }
        } while (!estadoValido);

        // Baño (Sí/No)
        boolean bañoValido = false;
        do {
            System.out.print("¿El dormitorio tiene baño? (Sí/No): ");
            baño = scan.nextLine().toLowerCase();
            if (!baño.equals("sí") && !baño.equals("no")) {
                System.out.println("Ingrese una respuesta válida (Sí/No).");
            } else {
                bañoValido = true;
            }
        } while (!bañoValido);

        System.out.println("");
        System.out.println("");
    }

    public static String generarInformeHTML(DormitorioPersonal[] dormitoriosArray) {
        StringBuilder tablaHTML = new StringBuilder();
        tablaHTML.append("<div style=\"text-align: center; margin-top: 20px;\">");
        tablaHTML.append("<h1>Reporte de Dormitorios del Personal</h1>");
        tablaHTML.append("</div>");
        tablaHTML.append("<table style=\"border-collapse: collapse; width: 70%; margin-left: auto; margin-right: auto; border: 1px solid #ddd;\">");
        tablaHTML.append("<tr style=\"background-color: #f2f2f2;\">");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">Ocupante</th>");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">Número de Piso</th>");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">Número de Dormitorio</th>");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">Baño</th>");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">Estado</th>");
        tablaHTML.append("</tr>");

        for (DormitorioPersonal dormitorio : dormitoriosArray) {
            if (dormitorio != null) {
                tablaHTML.append("<tr>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\">").append(dormitorio.getOcupante()).append("</td>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\">").append(dormitorio.getNumeroPiso()).append("</td>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\">").append(dormitorio.getNumeroDormitorio()).append("</td>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\">").append(dormitorio.getBaño()).append("</td>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\">").append(dormitorio.getEstado()).append("</td>");
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

    public static void generarInformeConsola(DormitorioPersonal[] dormitoriosArray) {
        int maxOcupanteLength = 0;
        int maxNumeroPisoLength = 0;
        int maxNumeroDormitorioLength = 0;
        int maxBañoLength = 2; // Longitud máxima para "Si"/"No"
        int maxEstadoLength = 7; // Longitud máxima para "Ocupado"/"Disponible"
        boolean hayDatos = false;

        for (DormitorioPersonal dormitorio : dormitoriosArray) {
            if (dormitorio != null) {
                maxOcupanteLength = Math.max(maxOcupanteLength, dormitorio.getOcupante().length());
                maxNumeroPisoLength = Math.max(maxNumeroPisoLength, String.valueOf(dormitorio.getNumeroPiso()).length());
                maxNumeroDormitorioLength = Math.max(maxNumeroDormitorioLength, String.valueOf(dormitorio.getNumeroDormitorio()).length());
                hayDatos = true;
            }
        }

        if (hayDatos) {
            // Sumar los caracteres y los espacios adicionales requeridos
            int totalCharacters = maxOcupanteLength + maxNumeroPisoLength + maxNumeroDormitorioLength + maxBañoLength + maxEstadoLength;
            int totalSpaces = 6 * 4 + 6 + 9 + 2; // Se suman los espacios adicionales según los requisitos
            int totalLength = totalCharacters + totalSpaces;

            String titulo = "Reporte de Dormitorios del Personal";
            int espaciosAntes = (totalLength - titulo.length()) / 2;

            System.out.println("*".repeat(totalLength));
            System.out.println(" ".repeat(espaciosAntes) + titulo);
            System.out.println("*".repeat(totalLength));

            System.out.printf(" %-" + maxOcupanteLength + "s | %" + maxNumeroPisoLength + "s | %" + maxNumeroDormitorioLength + "s | %-" + maxBañoLength + "s | %-" + maxEstadoLength + "s%n",
                    "Ocupante", "N° Piso", "N° Dormitorio", "Baño", "Estado");

            System.out.println("*".repeat(totalLength));

            for (DormitorioPersonal dormitorio : dormitoriosArray) {
                if (dormitorio != null) {
                    System.out.printf(" %-" + maxOcupanteLength + "s | %" + maxNumeroPisoLength + "d%6s | %" + maxNumeroDormitorioLength + "d%11s | %-" + maxBañoLength + "s | %-" + maxEstadoLength + "s%n",
                            dormitorio.getOcupante(), dormitorio.getNumeroPiso(), "", dormitorio.getNumeroDormitorio(), "", dormitorio.getBaño(), dormitorio.getEstado());
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
