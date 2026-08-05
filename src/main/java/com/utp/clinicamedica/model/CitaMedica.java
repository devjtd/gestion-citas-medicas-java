package com.utp.clinicamedica.model;

import com.utp.clinicamedica.repository.RegistroDoctor;
import com.utp.clinicamedica.repository.RegistroPacientes;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CitaMedica {

    //Scanner
    Scanner scan = new Scanner(System.in);

    //Atributos
    private String nombrePaciente;
    private int edadPaciente;
    private String generoPaciente;
    private int telefonoPaciente;

    private String nombreDoctor;
    private String especialidadDoctor;
    private int telefonoDoctor;

    private LocalDateTime fechaHora;
    private String motivoConsulta;

    //Constructor
    public CitaMedica() {
        this.nombrePaciente = null;
        this.edadPaciente = 0;
        this.generoPaciente = null;
        this.telefonoPaciente = 0;
        this.nombreDoctor = null;
        this.especialidadDoctor = null;
        this.telefonoDoctor = 0;
        this.fechaHora = null;
        this.motivoConsulta = null;
    }

    public CitaMedica(String nombrePaciente, int edadPaciente, String generoPaciente, int telefonoPaciente, String nombreDoctor, String especialidadDoctor, int telefonoDoctor, LocalDateTime fechaHora, String motivoConsulta) {
        this.nombrePaciente = nombrePaciente;
        this.edadPaciente = edadPaciente;
        this.generoPaciente = generoPaciente;
        this.telefonoPaciente = telefonoPaciente;
        this.nombreDoctor = nombreDoctor;
        this.especialidadDoctor = especialidadDoctor;
        this.telefonoDoctor = telefonoDoctor;
        this.fechaHora = fechaHora;
        this.motivoConsulta = motivoConsulta;
    }

    //Getters and setters
    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public int getEdadPaciente() {
        return edadPaciente;
    }

    public void setEdadPaciente(int edadPaciente) {
        this.edadPaciente = edadPaciente;
    }

    public String getGeneroPaciente() {
        return generoPaciente;
    }

    public void setGeneroPaciente(String generoPaciente) {
        this.generoPaciente = generoPaciente;
    }

    public int getTelefonoPaciente() {
        return telefonoPaciente;
    }

    public void setTelefonoPaciente(int telefonoPaciente) {
        this.telefonoPaciente = telefonoPaciente;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public String getEspecialidadDoctor() {
        return especialidadDoctor;
    }

    public void setEspecialidadDoctor(String especialidadDoctor) {
        this.especialidadDoctor = especialidadDoctor;
    }

    public int getTelefonoDoctor() {
        return telefonoDoctor;
    }

    public void setTelefonoDoctor(int telefonoDoctor) {
        this.telefonoDoctor = telefonoDoctor;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    //Métodos
    public void LeerDatosNuevoPaciente() {
        System.out.println("Ingresar datos del paciente:");

        System.out.print("Nombre completo: ");
        boolean nombreValido = false;
        do {
            try {
                String nombre = scan.nextLine();
                if (nombre.matches(".*\\d.*")) {
                    throw new RuntimeException("Error: El nombre no puede contener números.");
                }
                this.nombrePaciente = nombre;
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
                this.generoPaciente = genero;
                generoValido = true;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (!generoValido);

        System.out.print("Edad: ");
        boolean edadValida = false;
        do {
            try {
                this.edadPaciente = scan.nextInt();
                scan.nextLine(); // Limpiar el buffer del scanner
                if (this.edadPaciente <= 0) {
                    throw new RuntimeException("Error: La edad debe ser un número positivo.");
                }
                edadValida = true;
            } catch (RuntimeException ex) {
                System.out.println("Error: Ingrese una edad válida (solo números positivos).");
                scan.nextLine(); // Limpiar el buffer del scanner
                edadValida = false;
            }
        } while (!edadValida);

        System.out.print("Número telefónico: ");
        boolean numeroValido;
        do {
            try {
                this.telefonoPaciente = scan.nextInt();
                scan.nextLine(); // Limpiar el buffer del scanner
                numeroValido = true;
            } catch (Exception ex) {
                System.out.println("Error: Ingrese un número telefónico válido (solo números).");
                scan.nextLine(); // Limpiar el buffer del scanner
                numeroValido = false;
            }
        } while (!numeroValido);

        System.out.println("");
        System.out.println("");
    }

    public void seleccionarPaciente(RegistroPacientes registroPacientes) {
        do {
            System.out.println("Lista de pacientes:");
            int indice = 1;
            for (Paciente paciente : registroPacientes.obtenerPacientes()) {
                System.out.println(indice + " - " + paciente.getNombreCompleto());
                indice++;
            }

            System.out.print("Ingrese el número del paciente deseado: ");
            int numeroPaciente = scan.nextInt();
            scan.nextLine(); // Limpiar el buffer del scanner

            if (numeroPaciente > 0 && numeroPaciente <= registroPacientes.obtenerPacientes().size()) {
                // Ajustar el índice del paciente seleccionado restando 1
                Paciente pacienteSeleccionado = registroPacientes.obtenerPacientes().get(numeroPaciente - 1);
                System.out.println("Ha seleccionado al paciente: " + pacienteSeleccionado.getNombreCompleto());
                // Asignar los datos del paciente seleccionado a los atributos de la cita médica
                setNombrePaciente(pacienteSeleccionado.getNombreCompleto());
                setEdadPaciente(pacienteSeleccionado.getEdad());
                setGeneroPaciente(pacienteSeleccionado.getGenero());
                setTelefonoPaciente(pacienteSeleccionado.getNumeroTelefonico());

                // Resto del código para operar con el paciente seleccionado
                break; // Salir del bucle cuando se ha seleccionado un paciente válido
            } else {
                System.out.println("Número de paciente inválido.");
            }
        } while (true); // Ciclo para manejar la selección del paciente 
        System.out.println("");
        System.out.println("");
    }

    public void leerDatosNuevoDoctor() {
        System.out.println("Ingresar datos del doctor:");

        // Nombre del doctor
        System.out.print("Nombre completo: ");
        boolean nombreValido = false;
        do {
            try {
                String nombre = scan.nextLine();
                if (nombre.matches(".*\\d.*")) {
                    throw new RuntimeException("Error: El nombre no puede contener números.");
                }
                this.nombreDoctor = nombre;
                nombreValido = true;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (!nombreValido);

        // Especialidad del doctor
        System.out.print("Especialidad: ");
        boolean especialidadValida = false;
        do {
            try {
                String especialidad = scan.nextLine();
                if (especialidad.matches(".*\\d.*")) {
                    throw new RuntimeException("Error: La especialidad no puede contener números.");
                }
                this.especialidadDoctor = especialidad;
                especialidadValida = true;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (!especialidadValida);

        // Número telefónico del doctor
        System.out.print("Número telefónico: ");
        boolean numeroValido = false;
        do {
            try {
                this.telefonoDoctor = Integer.parseInt(scan.nextLine());
                numeroValido = true;
            } catch (NumberFormatException ex) {
                System.out.println("Error: Ingrese un número telefónico válido (solo números).");
            }
        } while (!numeroValido);

        System.out.println("");
        System.out.println("");
    }

    public void seleccionarDoctor(RegistroDoctor registroDoctor) {
        do {
            System.out.println("Lista de doctores:");
            int indice = 1;
            for (Doctor doctor : registroDoctor.obtenerDoctores()) {
                System.out.println(indice + " - " + doctor.getNombreCompleto());
                indice++;
            }

            System.out.print("Ingrese el número del doctor deseado: ");
            int numeroDoctor;
            try {
                numeroDoctor = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
                return;
            }

            if (numeroDoctor > 0 && numeroDoctor <= registroDoctor.obtenerDoctores().size()) {
                Doctor doctorSeleccionado = registroDoctor.obtenerDoctores().get(numeroDoctor - 1);
                this.nombreDoctor = doctorSeleccionado.getNombreCompleto();
                this.especialidadDoctor = doctorSeleccionado.getEspecialidad();
                this.telefonoDoctor = doctorSeleccionado.getNumeroTelefonico();

                System.out.println("Ha seleccionado al doctor: " + doctorSeleccionado.getNombreCompleto());
                // Resto del código para operar con el doctor seleccionado
                break; // Sale del bucle si se selecciona un doctor válido
            } else {
                System.out.println("Número de doctor inválido.");
            }
        } while (true); // Ciclo para manejar la selección del doctor
        System.out.println("");
        System.out.println("");
    }

    public void leerDatosCitaMedica() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        boolean formatoFechaHoraValido = false;
        boolean formatoMotivoConsultaValido = false;

        do {
            try {
                System.out.println("Ingrese la fecha y hora de la cita (Formato: dd-MM-yyyy HH:mm): ");
                String fechaHoraInput = scan.nextLine();
                LocalDateTime fechaHora = LocalDateTime.parse(fechaHoraInput, formatter);
                this.setFechaHora(fechaHora);
                formatoFechaHoraValido = true;
            } catch (DateTimeParseException e) {
                System.out.println("El formato de fecha y hora ingresado no es válido. Intente de nuevo.");
            }
        } while (!formatoFechaHoraValido);

        do {
            System.out.println("Ingrese el motivo de la consulta: ");
            String motivoConsulta = scan.nextLine();
            if (!motivoConsulta.trim().isEmpty()) {
                this.setMotivoConsulta(motivoConsulta);
                formatoMotivoConsultaValido = true;
            } else {
                System.out.println("El motivo de la consulta no puede estar vacío. Intente de nuevo.");
            }
        } while (!formatoMotivoConsultaValido);

        System.out.println("Datos de la cita médica actualizados correctamente.");
    }

    public String generarInformeHTML() {
        StringBuilder htmlBuilder = new StringBuilder();

        // Encabezado del documento HTML
        htmlBuilder.append("<!DOCTYPE html>\n");
        htmlBuilder.append("<html>\n");
        htmlBuilder.append("<head>\n");
        htmlBuilder.append("<title>Informe de Cita Médica</title>\n");

        // Estilos CSS para el informe
        htmlBuilder.append("<style>\n");
        htmlBuilder.append("body { font-family: Arial, sans-serif; }\n");
        htmlBuilder.append(".container { width: 80%; margin: auto; background-color: #f0f0f0; padding: 20px; border: 1px solid #ccc; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }\n");
        htmlBuilder.append(".section { margin-bottom: 20px; background-color: #fff; padding: 15px; border: 1px solid #eee; border-radius: 5px; }\n");
        htmlBuilder.append(".section h2 { font-size: 1.2em; border-bottom: 2px solid #ccc; padding-bottom: 5px; }\n");
        htmlBuilder.append("strong { width: 150px; display: inline-block; }\n");
        htmlBuilder.append("h1 { text-align: center; }\n"); // Estilo para centrar el título
        htmlBuilder.append("</style>\n");

        htmlBuilder.append("</head>\n");
        htmlBuilder.append("<body>\n");
        htmlBuilder.append("<div class=\"container\">\n");
        htmlBuilder.append("<h1>Informe de Cita Médica</h1>\n");

        // Datos del paciente
        htmlBuilder.append("<div class=\"section\">\n");
        htmlBuilder.append("<h2>Datos del paciente</h2>\n");
        htmlBuilder.append("<strong>Nombre:</strong> ").append(this.getNombrePaciente()).append("<br>\n");
        htmlBuilder.append("<strong>Edad:</strong> ").append(this.getEdadPaciente()).append("<br>\n");
        htmlBuilder.append("<strong>Género:</strong> ").append(this.getGeneroPaciente()).append("<br>\n");
        htmlBuilder.append("<strong>Teléfono:</strong> ").append(this.getTelefonoPaciente()).append("<br>\n");
        htmlBuilder.append("</div>\n");

        // Datos del doctor
        htmlBuilder.append("<div class=\"section\">\n");
        htmlBuilder.append("<h2>Datos del doctor</h2>\n");
        htmlBuilder.append("<strong>Nombre:</strong> ").append(this.getNombreDoctor()).append("<br>\n");
        htmlBuilder.append("<strong>Especialidad:</strong> ").append(this.getEspecialidadDoctor()).append("<br>\n");
        htmlBuilder.append("<strong>Teléfono:</strong> ").append(this.getTelefonoDoctor()).append("<br>\n");
        htmlBuilder.append("</div>\n");

        // Detalles de la cita
        htmlBuilder.append("<div class=\"section\">\n");
        htmlBuilder.append("<h2>Detalles de la cita</h2>\n");
        htmlBuilder.append("<strong>Fecha y hora:</strong> ")
                .append(this.getFechaHora().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")))
                .append("<br>\n");
        htmlBuilder.append("<strong>Motivo de la consulta:</strong> ").append(this.getMotivoConsulta()).append("<br>\n");
        htmlBuilder.append("</div>\n");

        htmlBuilder.append("</div>\n");
        htmlBuilder.append("</body>\n");
        htmlBuilder.append("</html>\n");

        //Footer
        htmlBuilder.append("<footer style=\"text-align: center; margin-top: 40px; background-color: #f5f5f5; padding: 10px;\">");
        htmlBuilder.append("Powered By Grupo 6. Universidad Tecnológica del Perú.");
        htmlBuilder.append("</footer>");

        return htmlBuilder.toString();
    }

    public static void generarInformeConsola(CitaMedica cita) {
        int maxLength = 0;

        maxLength = Math.max(maxLength, ("Nombre del paciente: " + cita.getNombrePaciente()).length());
        maxLength = Math.max(maxLength, ("Edad del paciente: " + cita.getEdadPaciente()).length());
        maxLength = Math.max(maxLength, ("Género del paciente: " + cita.getGeneroPaciente()).length());
        maxLength = Math.max(maxLength, ("Teléfono del paciente: " + cita.getTelefonoPaciente()).length());
        maxLength = Math.max(maxLength, ("Nombre del doctor: " + cita.getNombreDoctor()).length());
        maxLength = Math.max(maxLength, ("Especialidad del doctor: " + cita.getEspecialidadDoctor()).length());
        maxLength = Math.max(maxLength, ("Teléfono del doctor: " + cita.getTelefonoDoctor()).length());
        maxLength = Math.max(maxLength, ("Fecha y hora: " + cita.getFechaHora().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))).length());
        maxLength = Math.max(maxLength, ("Motivo de la consulta: " + cita.getMotivoConsulta()).length());

        String title = "Reporte Cita Médica";
        int titleLength = title.length();
        int width = Math.max(maxLength + 4, titleLength + 4); // Asegurarse de que la longitud sea al menos la del título

        // Imprimir título
        System.out.println("*".repeat(width));
        System.out.println(" ".repeat((width - titleLength) / 2) + title + " ".repeat((width - titleLength + 1) / 2));

        imprimirSeccion("Datos del Paciente", width);
        imprimirDatos("Nombre: ", cita.getNombrePaciente(), width);
        imprimirDatos("Edad: ", String.valueOf(cita.getEdadPaciente()), width);
        imprimirDatos("Género: ", cita.getGeneroPaciente(), width);
        imprimirDatos("Teléfono: ", String.valueOf(cita.getTelefonoPaciente()), width);

        imprimirSeccion("Datos del Doctor", width);
        imprimirDatos("Nombre: ", cita.getNombreDoctor(), width);
        imprimirDatos("Especialidad: ", cita.getEspecialidadDoctor(), width);
        imprimirDatos("Teléfono: ", String.valueOf(cita.getTelefonoDoctor()), width);

        imprimirSeccion("Consulta", width);
        imprimirDatos("Fecha y hora: ", cita.getFechaHora().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")), width);
        imprimirDatos("Motivo: ", cita.getMotivoConsulta(), width);

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
