package com.utp.clinicamedica.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class RecetaMedica {

    //Scanner
    Scanner scan = new Scanner(System.in);

    //Atributos
    private String nombre;
    private int hora;
    private String medicina;
    private int dosis;
    private String indicaciones;

    public RecetaMedica() {

    }

    //Constructor
    public RecetaMedica(String nombre, int hora, String medicina, int dosis, String indicaciones) {
        this.nombre = nombre;
        this.hora = hora;
        this.medicina = medicina;
        this.dosis = dosis;
        this.indicaciones = indicaciones;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getMedicina() {
        return medicina;
    }

    public void setMedicina(String medicina) {
        this.medicina = medicina;
    }

    public double getDosis() {
        return dosis;
    }

    public void setDosis(int dosis) {
        this.dosis = dosis;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    //Métodos
    public void LeerDatosRecetaMedica() {
        System.out.println("");
        System.out.println("");

        System.out.println("Ingresando datos de la receta médica");
        System.out.println("-----------------------------");
        
        boolean datosValidos = false;

        do {
            try {
                System.out.print("Nombre del paciente: ");
                this.nombre = scan.nextLine();
                if (this.nombre.matches(".*\\d.*")) {
                    throw new RuntimeException("Error: El nombre no puede contener números.");
                }

                datosValidos = true;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (!datosValidos);

        do {
            try {
                System.out.print("Medicina: ");
                this.medicina = scan.nextLine();
                if (this.medicina.matches(".*\\d.*")) {
                    throw new RuntimeException("Error: El nombre de la medicina no puede contener números.");
                }

                datosValidos = true;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (!datosValidos);

        do {
            try {
                System.out.print("Hora de consumir: ");
                this.hora = scan.nextInt();
                scan.nextLine();

                datosValidos = true;
            } catch (Exception e) {
                System.out.println("Error: Ingrese una hora válida (número entero).");
                scan.nextLine();
                datosValidos = false;
            }
        } while (!datosValidos);

        do {
            try {
                System.out.print("Dosis por día: ");
                this.dosis = scan.nextInt();
                scan.nextLine();

                datosValidos = true;
            } catch (Exception e) {
                System.out.println("Error: Ingrese una dosis válida (número).");
                scan.nextLine();
                datosValidos = false;
            }
        } while (!datosValidos);

        System.out.print("Indicaciones: ");
        this.indicaciones = scan.nextLine();

        System.out.println("Datos ingresados correctamente.");
    }

    public static String generarInformeHTML(RecetaMedica receta) {
        LocalDate fechaEmision = LocalDate.now();
        LocalTime horaActual = LocalTime.now();
        DateTimeFormatter fechaFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter horaFormatter = DateTimeFormatter.ofPattern("HH:mm");

        StringBuilder tablaHTML = new StringBuilder();
        tablaHTML.append("<html>");
        tablaHTML.append("<head>");
        tablaHTML.append("<style>");
        tablaHTML.append("body { font-family: Arial, sans-serif; margin: 0; padding-bottom: 60px; position: relative; min-height: 100vh; box-sizing: border-box; background-color: #F0F8FF;}");
        tablaHTML.append("h1 { text-align: center; font-size: 24px;}");
        tablaHTML.append(".receta-box { width: 70%; margin: 20px auto; border: 1px solid #000; padding: 20px; background-color: #FFFFFF;}");
        tablaHTML.append("table { width: 100%; border-collapse: collapse; margin-bottom: 20px;}");
        tablaHTML.append("th, td { border: 1px solid #000; padding: 10px;}");
        tablaHTML.append("th { background-color: #f2f2f2;}");
        tablaHTML.append(".nombre-seccion { font-weight: bold; font-size: 18px;}");
        tablaHTML.append(".fecha-hora { font-size: 14px;}");
        tablaHTML.append("footer { position: absolute; bottom: 0; width: 100%; height: 50px; line-height: 50px; background-color: #f5f5f5; text-align: center;}");
        tablaHTML.append("</style>");
        tablaHTML.append("</head>");
        tablaHTML.append("<body>");

        tablaHTML.append("<h1>Receta Médica</h1>");

        tablaHTML.append("<div class=\"receta-box\">");
        tablaHTML.append("<table>");
        tablaHTML.append("<tr><td colspan=\"2\" class=\"nombre-seccion\">Nombre del paciente:</td></tr>");
        tablaHTML.append("<tr><td colspan=\"2\" style=\"text-align: center;\">").append(receta.getNombre()).append("</td></tr>");
        tablaHTML.append("<tr><td class=\"fecha-hora\">Fecha de emisión:</td><td class=\"fecha-hora\">Hora de emisión:</td></tr>");
        tablaHTML.append("<tr><td class=\"fecha-hora\">").append(fechaEmision.format(fechaFormatter)).append("</td><td class=\"fecha-hora\">").append(horaActual.format(horaFormatter)).append("</td></tr>");
        tablaHTML.append("<tr><th>Medicina</th><td>").append(receta.getMedicina()).append("</td></tr>");
        tablaHTML.append("<tr><th>Dosis por día</th><td>").append(receta.getDosis()).append("</td></tr>");
        tablaHTML.append("<tr><th>Indicaciones</th><td>").append(receta.getIndicaciones()).append("</td></tr>");
        tablaHTML.append("</table>");
        tablaHTML.append("</div>");

        tablaHTML.append("<footer>Powered By Grupo 6. Universidad Tecnológica del Perú.</footer>");

        tablaHTML.append("</body>");
        tablaHTML.append("</html>");

        return tablaHTML.toString();
    }

    public static void generarInformeConsola(RecetaMedica receta) {
        int maxLength = 0;

        maxLength = Math.max(maxLength, ("Nombre del paciente: " + receta.getNombre()).length());
        maxLength = Math.max(maxLength, ("Medicina: " + receta.getMedicina()).length());
        maxLength = Math.max(maxLength, ("Dosis por día: " + receta.getDosis()).length());
        maxLength = Math.max(maxLength, ("Indicaciones: " + receta.getIndicaciones()).length());

        String title = "Reporte Receta Médica";
        int titleLength = title.length();
        int width = Math.max(maxLength + 4, titleLength + 4); // Asegurarse de que la longitud sea al menos la del título

        // Imprimir título
        System.out.println("*".repeat(width));
        System.out.println(" ".repeat((width - titleLength) / 2) + title + " ".repeat((width - titleLength + 1) / 2));

        imprimirSeccion("Datos de la Receta", width);
        imprimirDatos("Nombre del paciente: ", receta.getNombre(), width);
        imprimirDatos("Medicina: ", receta.getMedicina(), width);
        imprimirDatos("Dosis por día: ", String.valueOf(receta.getDosis()), width);
        imprimirDatos("Indicaciones: ", receta.getIndicaciones(), width);

        // Línea inferior
        System.out.println("*".repeat(width));
    }

    private static void imprimirDatos(String label, String value, int width) {
        System.out.println(" " + label + value + " ".repeat(width - (label.length() + value.length()) - 2));
    }

    private static void imprimirSeccion(String label, int width) {
        System.out.println("*".repeat(width));
        System.out.println(" " + label + " ".repeat(width - label.length() - 3));
    }
}
