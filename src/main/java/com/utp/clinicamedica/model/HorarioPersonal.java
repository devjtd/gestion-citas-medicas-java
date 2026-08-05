package com.utp.clinicamedica.model;

import java.util.Scanner;

public class HorarioPersonal {

    //Scanner
    Scanner scan = new Scanner(System.in);

    //Atributos
    private String nombrePersonal;
    private String fotoPersonal;
    private String cargoPersonal;

    private String horaEntrada;
    private String horaSalida;

    //Constructor
    public HorarioPersonal() {
        this.nombrePersonal = "";
        this.fotoPersonal = "";
        this.cargoPersonal = "";
        this.horaEntrada = null;
        this.horaSalida = null;
    }

    public HorarioPersonal(String nombrePersonal, String fotoPersonal, String cargoPersonal, String horaEntrada, String horaSalida) {
        this.nombrePersonal = nombrePersonal;
        this.fotoPersonal = fotoPersonal;
        this.cargoPersonal = cargoPersonal;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    //Getters and Setters
    public String getNombrePersonal() {
        return nombrePersonal;
    }

    public void setNombrePersonal(String nombrePersonal) {
        this.nombrePersonal = nombrePersonal;
    }

    public String getFotoPersonal() {
        return fotoPersonal;
    }

    public void setFotoPersonal(String fotoPersonal) {
        this.fotoPersonal = fotoPersonal;
    }

    public String getCargoPersonal() {
        return cargoPersonal;
    }

    public void setCargoPersonal(String cargoPersonal) {
        this.cargoPersonal = cargoPersonal;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    //Métodos
    public void leerDatosNuevoPersonal() {
        System.out.print("Nombre completo: ");
        boolean nombreValido = false;
        do {
            try {
                String nombre = scan.nextLine();
                if (nombre.matches(".*\\d.*")) {
                    throw new RuntimeException("Error: El nombre no puede contener números.");
                }
                this.nombrePersonal = nombre;
                nombreValido = true;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (!nombreValido);

        System.out.print("Cargo: ");
        boolean cargoValido = false;
        do {
            try {
                String cargo = scan.nextLine();
                if (cargo.matches(".*\\d.*")) {
                    throw new RuntimeException("Error: El cargo no puede contener números.");
                }
                this.cargoPersonal = cargo;
                cargoValido = true;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (!cargoValido);

        System.out.print("Nombre del archivo de foto: ");
        this.fotoPersonal = scan.nextLine();

        System.out.print("Hora de entrada (HH:mm): ");
        boolean horaEntradaValida = false;
        do {
            try {
                String horaEntradaString = scan.nextLine();
                // Aquí puedes validar si el formato de la hora es correcto
                // o simplemente asignarlo si no necesitas una validación específica
                this.horaEntrada = horaEntradaString;
                horaEntradaValida = true;
            } catch (Exception e) {
                System.out.println("Error: Ingrese una hora de entrada válida (formato: HH:mm).");
            }
        } while (!horaEntradaValida);

        System.out.print("Hora de salida (HH:mm): ");
        boolean horaSalidaValida = false;
        do {
            try {
                String horaSalidaString = scan.nextLine();
                // Aquí también puedes validar el formato de la hora si es necesario
                this.horaSalida = horaSalidaString;
                horaSalidaValida = true;
            } catch (Exception e) {
                System.out.println("Error: Ingrese una hora de salida válida (formato: HH:mm).");
            }
        } while (!horaSalidaValida);

        System.out.println("");
        System.out.println("");

    }

    public static String generarInformeHTML(HorarioPersonal[] personalArray, String rutaCarpetaFotos) {
        StringBuilder tablaHTML = new StringBuilder();
        tablaHTML.append("<div style=\"text-align: center; margin-top: 20px;\">");
        tablaHTML.append("<h1>Reporte de Horario del Personal</h1>");
        tablaHTML.append("</div>");
        tablaHTML.append("<table style=\"border-collapse: collapse; width: 70%; margin-left: auto; margin-right: auto; border: 1px solid #ddd;\">");
        tablaHTML.append("<tr style=\"background-color: #f2f2f2;\">");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">Foto Personal</th>");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">Nombre Personal</th>");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">Cargo Personal</th>");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">Hora Entrada</th>");
        tablaHTML.append("<th style=\"border: 1px solid #ddd; padding: 8px;\">Hora Salida</th>");
        tablaHTML.append("</tr>");

        for (HorarioPersonal personal : personalArray) {
            if (personal != null) {
                tablaHTML.append("<tr>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\">").append(personal.getFotoPersonal()).append("</td>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\">").append(personal.getNombrePersonal()).append("</td>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\">").append(personal.getCargoPersonal()).append("</td>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\">").append(personal.getHoraEntrada()).append("</td>");
                tablaHTML.append("<td style=\"border: 1px solid #ddd; padding: 8px;\">").append(personal.getHoraSalida()).append("</td>");

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

    public static void generarInformeConsola(HorarioPersonal[] horarioArray) {
        int maxNombreLength = 0;
        int maxCargoLength = 0;
        int maxHoraEntradaLength = 0;
        int maxHoraSalidaLength = 0;
        boolean hayDatos = false;

        // Encuentra la longitud máxima de cada columna y verifica si hay datos
        for (HorarioPersonal horario : horarioArray) {
            if (horario != null) {
                maxNombreLength = Math.max(maxNombreLength, horario.getNombrePersonal().length());
                maxCargoLength = Math.max(maxCargoLength, horario.getCargoPersonal().length());
                maxHoraEntradaLength = Math.max(maxHoraEntradaLength, horario.getHoraEntrada().length());
                maxHoraSalidaLength = Math.max(maxHoraSalidaLength, horario.getHoraSalida().length());
                hayDatos = true;
            }
        }

        if (hayDatos) {
            String titulo = "Reporte del Horario Personal";
            int totalLength = maxNombreLength + maxCargoLength + maxHoraEntradaLength + maxHoraSalidaLength + 30;

            int espaciosAntes = (totalLength - titulo.length()) / 2;

            System.out.println("*".repeat(totalLength));
            System.out.println(" ".repeat(espaciosAntes) + titulo);
            System.out.println("*".repeat(totalLength));

            System.out.printf(" %-" + maxNombreLength + "s | %-" + maxCargoLength + "s | %-" + maxHoraEntradaLength + "s | %-" + maxHoraSalidaLength + "s%n",
                    "Nombre personal", "Cargo", "Hora entrada", "Hora salida");

            System.out.println("*".repeat(totalLength));

            for (HorarioPersonal horario : horarioArray) {
                if (horario != null) {
                    System.out.printf(" %-" + maxNombreLength + "s | %-" + maxCargoLength + "s | %-" + maxHoraEntradaLength + "s       | %-" + maxHoraSalidaLength + "s%n",
                            horario.getNombrePersonal(), horario.getCargoPersonal(),
                            horario.getHoraEntrada(), horario.getHoraSalida());
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
