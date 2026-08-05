package com.utp.clinicamedica;

import com.utp.clinicamedica.model.CitaMedica;
import com.utp.clinicamedica.model.Doctor;
import com.utp.clinicamedica.model.DormitorioPersonal;
import com.utp.clinicamedica.model.HorarioPersonal;
import com.utp.clinicamedica.model.Paciente;
import com.utp.clinicamedica.model.Personal;
import com.utp.clinicamedica.model.RecetaMedica;
import com.utp.clinicamedica.repository.RegistroDoctor;
import com.utp.clinicamedica.repository.RegistroPacientes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    private static Personal[] personalArray = new Personal[10];
    private static Paciente[] pacienteArray = new Paciente[10];
    private static RegistroPacientes registroPacientes = new RegistroPacientes();
    private static Doctor[] doctorArray = new Doctor[10];
    private static RegistroDoctor registroDoctor = new RegistroDoctor();
    private static CitaMedica citaMedica = new CitaMedica();
    private static DormitorioPersonal[] dormitoriosArray = new DormitorioPersonal[10];
    private static HorarioPersonal[] personal2Array = new HorarioPersonal[10];
    private static Scanner scan = new Scanner(System.in);
    private static RecetaMedica receta = new RecetaMedica();

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("*************** Menú ****************");
            System.out.println("1 - Ingresar datos del personal");
            System.out.println("2 - Ingresar datos de pacientes");
            System.out.println("3 - Ingresar datos de doctores");
            System.out.println("4 - Registrar y generar cita médica");
            System.out.println("5 - Registrar y generar receta médica");
            System.out.println("6 - Asignar dormitorios");
            System.out.println("7 - Asignar horarios de trabajo");
            System.out.println("8 - Salir");
            System.out.println("*************************************");
            System.out.print("Ingrese una opción: ");
            opcion = scan.nextInt();
            scan.nextLine(); // Consumir el salto de línea
            System.out.println("");
            System.out.println("");

            switch (opcion) {
                case 1:
                    ingresarDatosPersonal();

                    int opcionReporte;
                    do {
                        System.out.println("****** Menú de reportes *******");
                        System.out.println("1 - Borrar datos");
                        System.out.println("2 - Reporte HTML");
                        System.out.println("3 - Reporte Consola");
                        System.out.println("4 - Regresar al menú principal");
                        System.out.println("*******************************");
                        System.out.print("Ingrese una opción: ");
                        opcionReporte = scan.nextInt();
                        scan.nextLine(); // Consumir el salto de línea
                        System.out.println("");
                        System.out.println("");

                        switch (opcionReporte) {
                            case 1:
                                Personal.borrarDatosPersonal(personalArray);
                                System.out.println("");
                                System.out.println("");
                                break;
                            case 2:
                                generarInformePersonal(personalArray);
                                System.out.println("");
                                System.out.println("");
                                break;
                            case 3:
                                Personal.generarInformeConsola(personalArray);
                                System.out.println("");
                                System.out.println("");
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Opción no válida!");
                                System.out.println("");
                                System.out.println("");
                                break;
                        }
                    } while (opcionReporte != 4); 
                    break;
                case 2:
                    ingresarDatosPaciente();
                    do {
                        System.out.println("****** Menú de reportes *******");
                        System.out.println("1 - Borrar datos");
                        System.out.println("2 - Reporte HTML");
                        System.out.println("3 - Reporte Consola");
                        System.out.println("4 - Regresar al menú principal");
                        System.out.println("*******************************");
                        System.out.print("Ingrese una opción: ");
                        opcionReporte = scan.nextInt();
                        scan.nextLine(); // Consumir el salto de línea
                        System.out.println("");
                        System.out.println("");

                        switch (opcionReporte) {
                            case 1:
                                Paciente.borrarDatosPaciente(pacienteArray);
                                System.out.println("");
                                System.out.println("");
                                break;
                            case 2:
                                generarInformePaciente(pacienteArray);
                                System.out.println("");
                                System.out.println("");
                                break;
                            case 3:
                                Paciente.generarInformeConsola(pacienteArray);
                                System.out.println("");
                                System.out.println("");
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Opción no válida!");
                                System.out.println("");
                                System.out.println("");
                                break;
                        }
                    } while (opcionReporte != 4); 
                    break;
                case 3:
                    ingresarDatosDoctor();
                    do {
                        System.out.println("****** Menú de reportes *******");
                        System.out.println("1 - Borrar datos");
                        System.out.println("2 - Reporte HTML");
                        System.out.println("3 - Reporte Consola");
                        System.out.println("4 - Regresar al menú principal");
                        System.out.println("*******************************");
                        System.out.print("Ingrese una opción: ");
                        opcionReporte = scan.nextInt();
                        scan.nextLine(); // Consumir el salto de línea
                        System.out.println("");
                        System.out.println("");

                        switch (opcionReporte) {
                            case 1:
                                Doctor.borrarDatosDoctor(doctorArray);
                                System.out.println("");
                                System.out.println("");
                                break;
                            case 2:
                                generarInformeDoctor(doctorArray);
                                System.out.println("");
                                System.out.println("");
                                break;
                            case 3:
                                Doctor.generarInformeConsola(doctorArray);
                                System.out.println("");
                                System.out.println("");
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Opción no válida!");
                                System.out.println("");
                                System.out.println("");
                                break;
                        }
                    } while (opcionReporte != 4); 
                    break;
                case 4:
                    int opcionMenuPacientes;
                    do {
                        System.out.println("********* Menú de datos de pacientes *********");
                        System.out.println("1 - Ingresar datos de nuevo paciente");
                        System.out.println("2 - Seleccionar datos de pacientes registrados");
                        System.out.println("3 - Regresar al menú principal");
                        System.out.println("**********************************************");
                        System.out.print("Ingrese una opción: ");
                        opcionMenuPacientes = scan.nextInt();
                        scan.nextLine(); // Consumir el salto de línea
                        System.out.println("");
                        System.out.println("");

                        switch (opcionMenuPacientes) {
                            case 1:
                                citaMedica.LeerDatosNuevoPaciente();
                                System.out.println("");
                                System.out.println("");
                                int opcionMenuDoctores;
                                do {
                                    System.out.println("********* Menú de datos de doctores *********");
                                    System.out.println("1 - Ingresar datos de nuevo doctor");
                                    System.out.println("2 - Seleccionar datos de doctores registrados");
                                    System.out.println("3 - Regresar al menú de pacientes");
                                    System.out.println("**********************************************");
                                    System.out.print("Ingrese una opción: ");
                                    opcionMenuDoctores = scan.nextInt();
                                    scan.nextLine(); // Consumir el salto de línea
                                    System.out.println("");
                                    System.out.println("");

                                    switch (opcionMenuDoctores) {
                                        case 1:
                                            citaMedica.leerDatosNuevoDoctor();

                                            System.out.println("Ingrese datos de la cita médica");
                                            citaMedica.leerDatosCitaMedica();
                                            System.out.println("");
                                            System.out.println("");

                                            int opcionMenuReportes;
                                            do {
                                                System.out.println("****** Menú de reportes *******");
                                                System.out.println("1 - Reporte HTML");
                                                System.out.println("2 - Reporte Consola");
                                                System.out.println("3 - Regresar al menú anterior");
                                                System.out.println("*******************************");
                                                System.out.print("Ingrese una opción: ");
                                                opcionMenuReportes = scan.nextInt();
                                                scan.nextLine(); // Consumir el salto de línea
                                                System.out.println("");
                                                System.out.println("");

                                                switch (opcionMenuReportes) {
                                                    case 1:
                                                        generarInformeCitaMedica(citaMedica);
                                                        System.out.println("");
                                                        System.out.println("");
                                                        break;
                                                    case 2:
                                                        CitaMedica.generarInformeConsola(citaMedica);
                                                        System.out.println("");
                                                        System.out.println("");
                                                        break;
                                                    case 3:
                                                        break;
                                                    default:
                                                        System.out.println("Opción no válida!");
                                                        System.out.println("");
                                                        System.out.println("");
                                                        break;
                                                }
                                            } while (opcionMenuReportes != 3); 
                                            break;
                                        case 2:
                                            if (registroDoctor.obtenerDoctores().isEmpty()) {
                                                System.out.println("No hay doctores registrados.");
                                                System.out.println("");
                                                System.out.println("");
                                                break;
                                            } else {
                                                citaMedica.seleccionarDoctor(registroDoctor);
                                            }

                                            System.out.println("Ingrese datos de la cita médica:");
                                            citaMedica.leerDatosCitaMedica();
                                            System.out.println("");
                                            System.out.println("");

                                            int opcionMenuReportes2;
                                            do {
                                                System.out.println("****** Menú de reportes *******");
                                                System.out.println("1 - Reporte HTML");
                                                System.out.println("2 - Reporte Consola");
                                                System.out.println("3 - Regresar al menú anterior");
                                                System.out.println("*******************************");
                                                System.out.print("Ingrese una opción: ");
                                                opcionMenuReportes2 = scan.nextInt();
                                                scan.nextLine(); // Consumir el salto de línea
                                                System.out.println("");
                                                System.out.println("");

                                                switch (opcionMenuReportes2) {
                                                    case 1:
                                                        generarInformeCitaMedica(citaMedica);
                                                        System.out.println("");
                                                        System.out.println("");
                                                        break;
                                                    case 2:
                                                        CitaMedica.generarInformeConsola(citaMedica);
                                                        System.out.println("");
                                                        System.out.println("");
                                                        break;
                                                    case 3:
                                                        break;
                                                    default:
                                                        System.out.println("Opción no válida!");
                                                        System.out.println("");
                                                        System.out.println("");
                                                        break;
                                                }
                                            } while (opcionMenuReportes2 != 3); 
                                            break;
                                        case 3:
                                            break;
                                        default:
                                            System.out.println("Opción no válida!");
                                            System.out.println("");
                                            System.out.println("");
                                            break;
                                    }
                                } while (opcionMenuDoctores != 3); 
                                break;
                            case 2:
                                if (registroPacientes.obtenerPacientes().isEmpty()) {
                                    System.out.println("No hay pacientes registrados.");
                                    System.out.println("");
                                    System.out.println("");
                                    break; // Regresa al menú de pacientes si no hay pacientes registrados
                                } else {
                                    citaMedica.seleccionarPaciente(registroPacientes);
                                }

                                int opcionMenuDoctores2;
                                do {
                                    System.out.println("********* Menú de datos de doctores *********");
                                    System.out.println("1 - Ingresar datos de nuevo doctor");
                                    System.out.println("2 - Seleccionar datos de doctores registrados");
                                    System.out.println("3 - Regresar al menú de pacientes");
                                    System.out.println("**********************************************");
                                    System.out.print("Ingrese una opción: ");
                                    opcionMenuDoctores2 = scan.nextInt();
                                    scan.nextLine(); // Consumir el salto de línea
                                    System.out.println("");
                                    System.out.println("");

                                    switch (opcionMenuDoctores2) {
                                        case 1:
                                            citaMedica.leerDatosNuevoDoctor();

                                            System.out.println("Ingrese datos de la cita médica:");
                                            citaMedica.leerDatosCitaMedica();
                                            System.out.println("");
                                            System.out.println("");

                                            int opcionMenuReportes;
                                            do {
                                                System.out.println("****** Menú de reportes *******");
                                                System.out.println("1 - Reporte HTML");
                                                System.out.println("2 - Reporte Consola");
                                                System.out.println("3 - Regresar al menú anterior");
                                                System.out.println("*******************************");
                                                System.out.print("Ingrese una opción: ");
                                                opcionMenuReportes = scan.nextInt();
                                                scan.nextLine(); // Consumir el salto de línea
                                                System.out.println("");
                                                System.out.println("");

                                                switch (opcionMenuReportes) {
                                                    case 1:
                                                        generarInformeCitaMedica(citaMedica);
                                                        System.out.println("");
                                                        System.out.println("");
                                                        break;
                                                    case 2:
                                                        CitaMedica.generarInformeConsola(citaMedica);
                                                        System.out.println("");
                                                        System.out.println("");
                                                        break;
                                                    case 3:
                                                        break;
                                                    default:
                                                        System.out.println("Opción no válida!");
                                                        System.out.println("");
                                                        System.out.println("");
                                                        break;
                                                }
                                            } while (opcionMenuReportes != 3); 
                                            break;
                                        case 2:
                                            if (registroDoctor.obtenerDoctores().isEmpty()) {
                                                System.out.println("No hay doctores registrados.");
                                                System.out.println("");
                                                System.out.println("");
                                                break;
                                            } else {
                                                citaMedica.seleccionarDoctor(registroDoctor);
                                            }

                                            System.out.println("Ingrese datos de la cita médica");
                                            citaMedica.leerDatosCitaMedica();
                                            System.out.println("");
                                            System.out.println("");

                                            int opcionMenuReportes2;
                                            do {
                                                System.out.println("****** Menú de reportes *******");
                                                System.out.println("1 - Reporte HTML");
                                                System.out.println("2 - Reporte Consola");
                                                System.out.println("3 - Regresar al menú anterior");
                                                System.out.println("*******************************");
                                                System.out.print("Ingrese una opción: ");
                                                opcionMenuReportes2 = scan.nextInt();
                                                scan.nextLine(); // Consumir el salto de línea
                                                System.out.println("");
                                                System.out.println("");

                                                switch (opcionMenuReportes2) {
                                                    case 1:
                                                        generarInformeCitaMedica(citaMedica);
                                                        System.out.println("");
                                                        System.out.println("");
                                                        break;
                                                    case 2:
                                                        CitaMedica.generarInformeConsola(citaMedica);
                                                        System.out.println("");
                                                        System.out.println("");
                                                        break;
                                                    case 3:
                                                        break;
                                                    default:
                                                        System.out.println("Opción no válida!");
                                                        System.out.println("");
                                                        System.out.println("");
                                                        break;
                                                }
                                            } while (opcionMenuReportes2 != 3); 
                                            break;
                                        case 3:
                                            break;
                                        default:
                                            System.out.println("Opción no válida!");
                                            System.out.println("");
                                            System.out.println("");
                                            break;
                                    }
                                } while (opcionMenuDoctores2 != 3);

                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Opción no válida!");
                                System.out.println("");
                                System.out.println("");
                                break;
                        }
                    } while (opcionMenuPacientes != 3); 
                    break;
                case 5:
                    receta.LeerDatosRecetaMedica();
                    System.out.println("");
                    System.out.println("");
                    do {
                        System.out.println("****** Menú de reportes *******");
                        System.out.println("1 - Reporte HTML");
                        System.out.println("2 - Reporte Consola");
                        System.out.println("3 - Regresar al menú principal");
                        System.out.println("*******************************");
                        System.out.print("Ingrese una opción: ");
                        opcion = scan.nextInt();
                        scan.nextLine(); // Consumir el salto de línea
                        System.out.println("");
                        System.out.println("");

                        switch (opcion) {
                            case 1:
                                generarInformeRecetaMedica(receta);
                                System.out.println("");
                                System.out.println("");
                                break;
                            case 2:
                                RecetaMedica.generarInformeConsola(receta);
                                System.out.println("");
                                System.out.println("");
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Opción no válida!");
                                System.out.println("");
                                System.out.println("");
                                break;
                        }
                    } while (opcion != 3); 
                    break;
                case 6:
                    ingresarDatosDormitoriosPersonal();

                    int opcionReporte2;
                    do {
                        System.out.println("****** Menú de reportes *******");
                        System.out.println("1 - Reporte HTML");
                        System.out.println("2 - Reporte Consola");
                        System.out.println("3 - Regresar al menú principal");
                        System.out.println("*******************************");
                        System.out.print("Ingrese una opción: ");
                        opcionReporte2 = scan.nextInt();
                        scan.nextLine(); // Consumir el salto de línea
                        System.out.println("");
                        System.out.println("");

                        switch (opcionReporte2) {
                            case 1:
                                generarInformeDormitoriosPersonal(dormitoriosArray);
                                System.out.println("");
                                System.out.println("");
                                break;
                            case 2:
                                DormitorioPersonal.generarInformeConsola(dormitoriosArray);
                                System.out.println("");
                                System.out.println("");
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Opción no válida!");
                                System.out.println("");
                                System.out.println("");
                                break;
                        }
                    } while (opcionReporte2 != 3); 
                    break;

                case 7:
                    ingresarDatosPersonal2();
                    System.out.println("");
                    System.out.println("");
                    do {
                        System.out.println("****** Menú de reportes *******");
                        System.out.println("1 - Reporte HTML");
                        System.out.println("2 - Reporte Consola");
                        System.out.println("3 - Regresar al menú principal");
                        System.out.println("*******************************");
                        System.out.print("Ingrese una opción: ");
                        opcionReporte2 = scan.nextInt();
                        scan.nextLine(); // Consumir el salto de línea
                        System.out.println("");
                        System.out.println("");

                        switch (opcionReporte2) {
                            case 1:
                                generarInformeHorarioPersonal(personal2Array);
                                System.out.println("");
                                System.out.println("");
                                break;
                            case 2:
                                HorarioPersonal.generarInformeConsola(personal2Array);
                                System.out.println("");
                                System.out.println("");
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Opción no válida!");
                                System.out.println("");
                                System.out.println("");
                                break;
                        }
                    } while (opcionReporte2 != 3);
                    break;

                case 8:
                    System.out.println("");
                    System.out.println("FIN DEL PROGRAMA");
                    break;
                default:
                    System.out.println("Opción no válida!");
                    break;
            }
        } while (opcion != 8);

    }

    //Ingresar datos del personal
    public static void ingresarDatosPersonal() {
        try {
            int indice = 0;

            do {
                System.out.println("");
                System.out.println("");

                System.out.println("Ingresando datos del personal " + (indice + 1));
                System.out.println("-----------------------------");

                personalArray[indice] = new Personal(null, 0, null, null, 0, null);
                personalArray[indice].LeerDatosPersonal();

                indice++;

                // Verificar si hay espacio en el array y preguntar al usuario si desea agregar más personal
                if (indice < personalArray.length) {
                    System.out.print("¿Desea agregar otro personal? (Sí/No): ");
                    String respuesta = scan.nextLine();

                    if (!respuesta.equalsIgnoreCase("Sí") && !respuesta.equalsIgnoreCase("Si") && !respuesta.equalsIgnoreCase("S")) {
                        break; // Salir del bucle si la respuesta no es afirmativa
                    }
                } else {
                    System.out.println("Se ha alcanzado el límite de datos que pueden ingresarse.");
                    break;
                }
            } while (indice < personalArray.length);

            System.out.println("");
            System.out.println("");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static void ingresarDatosPaciente() {
        try {
            int indice = 0;

            do {
                System.out.println("Ingresando datos para el paciente " + (indice + 1));
                System.out.println("-----------------------------");

                pacienteArray[indice] = new Paciente(null, 0, 0, null, 0, null); // Ajustar el constructor para incluir la edad
                pacienteArray[indice].leerDatosPaciente();
                registroPacientes.agregarPaciente(pacienteArray[indice]);

                indice++;

                // Verificar si hay espacio en el array y preguntar al usuario si desea agregar más pacientes
                if (indice < pacienteArray.length) {
                    System.out.print("¿Desea agregar otro paciente? (Sí/No): ");
                    String respuesta = scan.nextLine();

                    if (!respuesta.equalsIgnoreCase("Sí") && !respuesta.equalsIgnoreCase("S")) {
                        break; // Salir del bucle si la respuesta no es afirmativa
                    }
                } else {
                    System.out.println("Se ha alcanzado el límite de datos que pueden ingresarse.");
                    break;
                }
            } while (indice < pacienteArray.length);

            System.out.println("");
            System.out.println("");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    //Ingresar datos de la clase Doctor
    public static void ingresarDatosDoctor() {
        try {
            int indice = 0;

            do {
                System.out.println("");
                System.out.println("");

                System.out.println("Ingresando datos para el doctor " + (indice + 1));
                System.out.println("-----------------------------");

                doctorArray[indice] = new Doctor(null, null, null, 0, null);
                doctorArray[indice].leerDatosDoctor();
                registroDoctor.agregarDoctor(doctorArray[indice]);

                indice++;

                // Verificar si hay espacio en el array y preguntar al usuario si desea agregar más doctores
                if (indice < doctorArray.length) {
                    System.out.print("¿Desea agregar otro doctor? (Sí/No): ");
                    String respuesta = scan.nextLine();

                    if (!respuesta.equalsIgnoreCase("Sí") && !respuesta.equalsIgnoreCase("Si") && !respuesta.equalsIgnoreCase("S")) {
                        break; // Salir del bucle si la respuesta no es afirmativa
                    }
                } else {
                    System.out.println("Se ha alcanzado el límite de doctores que pueden ingresarse.");
                    break;
                }
            } while (indice < doctorArray.length);

            System.out.println("");
            System.out.println("");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static void ingresarDatosDormitoriosPersonal() {
        try {
            int indice = 0;

            do {
                System.out.println("Ingresando datos para el dormitorio del personal " + (indice + 1));
                System.out.println("---------------------------------------------");

                dormitoriosArray[indice] = new DormitorioPersonal(null, 0, 0, null, null); // Instancia un nuevo objeto DormitorioPersonal
                dormitoriosArray[indice].leerDatosDormitoriosPersonal(); // Llama al método para ingresar los datos

                indice++;

                // Verifica si hay espacio en el array y pregunta al usuario si desea agregar más dormitorios
                if (indice < dormitoriosArray.length) {
                    System.out.print("¿Desea agregar otro dormitorio del personal? (Sí/No): ");
                    String respuesta = scan.nextLine();

                    if (!respuesta.equalsIgnoreCase("Sí") && !respuesta.equalsIgnoreCase("S")) {
                        break; // Sale del bucle si la respuesta no es afirmativa
                    }
                } else {
                    System.out.println("Se ha alcanzado el límite de datos que pueden ingresarse.");
                    break;
                }
            } while (indice < dormitoriosArray.length);

            System.out.println("");
            System.out.println("");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static void ingresarDatosPersonal2() {
        try {
            int indice = 0;

            do {
                System.out.println("");
                System.out.println("");

                System.out.println("Ingresando horario para el personal " + (indice + 1));
                System.out.println("-----------------------------");

                personal2Array[indice] = new HorarioPersonal();
                personal2Array[indice].leerDatosNuevoPersonal();

                indice++;

                // Verificar si hay espacio en el array y preguntar al usuario si desea agregar más personal
                if (indice < personal2Array.length) {
                    System.out.print("¿Desea agregar otro horario del personal? (Sí/No): ");
                    String respuesta = scan.nextLine();

                    if (!respuesta.equalsIgnoreCase("Sí") && !respuesta.equalsIgnoreCase("Si") && !respuesta.equalsIgnoreCase("S")) {
                        break; // Salir del bucle si la respuesta no es afirmativa
                    }
                } else {
                    System.out.println("Se ha alcanzado el límite de datos que pueden ingresarse.");
                    break;
                }
            } while (indice < personal2Array.length);

            System.out.println("");
            System.out.println("");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static void generarInformePersonal(Personal[] personalArray) {
        boolean hayDatos = false;

        for (Personal persona : personalArray) {
            if (persona != null) {
                if (!persona.getNombreCompleto().isEmpty() || persona.getDni() != 0 || !persona.getCargo().isEmpty()
                        || persona.getNumeroTelefonico() != 0 || !persona.getEmail().isEmpty() || !persona.getFoto().isEmpty()) {
                    hayDatos = true;
                    break;
                }
            }
        }

        if (hayDatos) {
            // Ruta Carpeta Recursos para fotos
            String rutaFoto = System.getProperty("user.home") + "\\Desktop\\Proyecto G6\\Recursos\\";

            // Obtener la ruta del escritorio del usuario
            String rutaEscritorio = System.getProperty("user.home") + "/Desktop/";

            // Nombre base del archivo
            String nombreBaseArchivo = "ReportePersonal";
            String extensionArchivo = ".html";

            // Inicializar un contador para el número del archivo
            int contador = 1;
            String rutaDelArchivo;

            // Comprobar si el archivo existe y generar un nombre único
            do {
                if (contador == 1) {
                    rutaDelArchivo = rutaEscritorio + nombreBaseArchivo + extensionArchivo;
                } else {
                    rutaDelArchivo = rutaEscritorio + nombreBaseArchivo + contador + extensionArchivo;
                }
                contador++;
            } while (new File(rutaDelArchivo).exists());

            // Generar el contenido HTML del informe
            String informeHTML = Personal.generarInformeHTML(personalArray, rutaFoto);

            try ( PrintWriter out = new PrintWriter(rutaDelArchivo)) {
                out.println(informeHTML);
                System.out.println("Informe HTML generado y guardado en: " + rutaDelArchivo);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No hay datos para generar el informe.");
        }
    }

    public static void generarInformePaciente(Paciente[] pacientesArray) {
        boolean hayDatos = false;

        for (Paciente paciente : pacientesArray) {
            if (paciente != null) {
                if (!paciente.getNombreCompleto().isEmpty() || paciente.getDni() != 0 || !paciente.getEmail().isEmpty()
                        || paciente.getNumeroTelefonico() != 0 || !paciente.getGenero().isEmpty() || paciente.getEdad() != 0) {
                    hayDatos = true;
                    break;
                }
            }
        }

        if (hayDatos) {
            // Obtener la ruta del escritorio del usuario
            String rutaEscritorio = System.getProperty("user.home") + "/Desktop/";

            // Nombre base del archivo
            String nombreBaseArchivo = "ReportePacientes";
            String extensionArchivo = ".html";

            // Inicializar un contador para el número del archivo
            int contador = 1;
            String rutaDelArchivo;

            // Comprobar si el archivo existe y generar un nombre único
            do {
                if (contador == 1) {
                    rutaDelArchivo = rutaEscritorio + nombreBaseArchivo + extensionArchivo;
                } else {
                    rutaDelArchivo = rutaEscritorio + nombreBaseArchivo + contador + extensionArchivo;
                }
                contador++;
            } while (new File(rutaDelArchivo).exists());

            // Generar el contenido HTML del informe
            String informeHTML = Paciente.generarInformeHTML(pacientesArray);

            try ( PrintWriter out = new PrintWriter(rutaDelArchivo)) {
                out.println(informeHTML);
                System.out.println("Informe HTML generado y guardado en: " + rutaDelArchivo);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No hay datos para generar el informe.");
        }
    }

    public static void generarInformeDoctor(Doctor[] doctorArray) {
        boolean hayDatos = false;

        for (Doctor doctor : doctorArray) {
            if (doctor != null) {
                if (!doctor.getNombreCompleto().isEmpty() || !doctor.getEspecialidad().isEmpty()
                        || doctor.getNumeroTelefonico() != 0 || !doctor.getEmail().isEmpty() || !doctor.getFoto().isEmpty()) {
                    hayDatos = true;
                    break;
                }
            }
        }

        if (hayDatos) {
            // Ruta Carpeta Recursos para fotos
            String rutaFoto = System.getProperty("user.home") + "\\Desktop\\Proyecto G6\\Recursos\\";

            // Obtener la ruta del escritorio del usuario
            String rutaEscritorio = System.getProperty("user.home") + "/Desktop/";

            // Nombre base del archivo
            String nombreBaseArchivo = "ReporteDoctor";
            String extensionArchivo = ".html";

            // Inicializar un contador para el número del archivo
            int contador = 1;
            String rutaDelArchivo;

            // Comprobar si el archivo existe y generar un nombre único
            do {
                if (contador == 1) {
                    rutaDelArchivo = rutaEscritorio + nombreBaseArchivo + extensionArchivo;
                } else {
                    rutaDelArchivo = rutaEscritorio + nombreBaseArchivo + contador + extensionArchivo;
                }
                contador++;
            } while (new File(rutaDelArchivo).exists());

            // Generar el contenido HTML del informe
            String informeHTML = Doctor.generarInformeHTML(doctorArray, rutaFoto);

            try ( PrintWriter out = new PrintWriter(rutaDelArchivo)) {
                out.println(informeHTML);
                System.out.println("Informe HTML generado y guardado en: " + rutaDelArchivo);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No hay datos para generar el informe.");
        }
    }

    public static void generarInformeCitaMedica(CitaMedica cita) {
        // Obtener la ruta del escritorio del usuario
        String rutaEscritorio = System.getProperty("user.home") + "/Desktop/";

        // Nombre base del archivo
        String nombreBaseArchivo = "ReporteCitaMedica";
        String extensionArchivo = ".html";

        // Inicializar un contador para el número del archivo
        int contador = 1;
        String rutaDelArchivo;

        // Comprobar si el archivo existe y generar un nombre único
        do {
            if (contador == 1) {
                rutaDelArchivo = rutaEscritorio + nombreBaseArchivo + extensionArchivo;
            } else {
                rutaDelArchivo = rutaEscritorio + nombreBaseArchivo + contador + extensionArchivo;
            }
            contador++;
        } while (new File(rutaDelArchivo).exists());

        String informeHTML = cita.generarInformeHTML();

        try ( PrintWriter out = new PrintWriter(rutaDelArchivo)) {
            out.println(informeHTML);
            System.out.println("Informe HTML generado y guardado en: " + rutaDelArchivo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void generarInformeDormitoriosPersonal(DormitorioPersonal[] dormitoriosArray) {
        boolean hayDatos = false;

        for (DormitorioPersonal dormitorio : dormitoriosArray) {
            if (dormitorio != null) {
                if (!dormitorio.getOcupante().isEmpty() || !dormitorio.getBaño().isEmpty()
                        || !dormitorio.getEstado().isEmpty()) {
                    hayDatos = true;
                    break;
                }
            }
        }

        if (hayDatos) {
            // Obtener la ruta del escritorio del usuario
            String rutaEscritorio = System.getProperty("user.home") + "/Desktop/";

            // Nombre base del archivo
            String nombreBaseArchivo = "ReporteDormitoriosPersonal";
            String extensionArchivo = ".html";

            // Inicializar un contador para el número del archivo
            int contador = 1;
            String rutaDelArchivo;

            // Comprobar si el archivo existe y generar un nombre único
            do {
                if (contador == 1) {
                    rutaDelArchivo = rutaEscritorio + nombreBaseArchivo + extensionArchivo;
                } else {
                    rutaDelArchivo = rutaEscritorio + nombreBaseArchivo + contador + extensionArchivo;
                }
                contador++;
            } while (new File(rutaDelArchivo).exists());

            // Generar el contenido HTML del informe
            String informeHTML = DormitorioPersonal.generarInformeHTML(dormitoriosArray);

            try ( PrintWriter out = new PrintWriter(rutaDelArchivo)) {
                out.println(informeHTML);
                System.out.println("Informe HTML generado y guardado en: " + rutaDelArchivo);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No hay datos para generar el informe.");
        }
    }

    public static void generarInformeHorarioPersonal(HorarioPersonal[] personal2Array) {
        boolean hayDatos = false;

        for (HorarioPersonal personal : personal2Array) {
            if (personal != null) {
                if (!personal.getNombrePersonal().isEmpty() || !personal.getFotoPersonal().isEmpty()
                        || !personal.getCargoPersonal().isEmpty() || personal.getHoraEntrada() != null
                        || personal.getHoraSalida() != null) {
                    hayDatos = true;
                    break;
                }
            }
        }

        if (hayDatos) {
            // Ruta Carpeta Recursos para fotos
            String rutaFoto = System.getProperty("user.home") + "\\Desktop\\Proyecto G6\\Recursos\\";

            // Obtener la ruta del escritorio del usuario
            String rutaEscritorio = System.getProperty("user.home") + "/Desktop/";

            // Nombre base del archivo
            String nombreBaseArchivo = "ReporteHorarioPersonal";
            String extensionArchivo = ".html";

            // Inicializar un contador para el número del archivo
            int contador = 1;
            String rutaDelArchivo;

            // Comprobar si el archivo existe y generar un nombre único
            do {
                if (contador == 1) {
                    rutaDelArchivo = rutaEscritorio + nombreBaseArchivo + extensionArchivo;
                } else {
                    rutaDelArchivo = rutaEscritorio + nombreBaseArchivo + contador + extensionArchivo;
                }
                contador++;
            } while (new File(rutaDelArchivo).exists());

            // Generar el contenido HTML del informe
            String informeHTML = HorarioPersonal.generarInformeHTML(personal2Array, rutaFoto);

            try ( PrintWriter out = new PrintWriter(rutaDelArchivo)) {
                out.println(informeHTML);
                System.out.println("Informe HTML generado y guardado en: " + rutaDelArchivo);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No hay datos para generar el informe.");
        }
    }
    
    public static void generarInformeRecetaMedica(RecetaMedica receta) {
        // Obtener la ruta del escritorio del usuario
        String rutaEscritorio = System.getProperty("user.home") + "/Desktop/";

        // Nombre base del archivo
        String nombreBaseArchivo = "ReporteRecetaMedica";
        String extensionArchivo = ".html";

        // Inicializar un contador para el número del archivo
        int contador = 1;
        String rutaDelArchivo;

        // Comprobar si el archivo existe y generar un nombre único
        do {
            if (contador == 1) {
                rutaDelArchivo = rutaEscritorio + nombreBaseArchivo + extensionArchivo;
            } else {
                rutaDelArchivo = rutaEscritorio + nombreBaseArchivo + contador + extensionArchivo;
            }
            contador++;
        } while (new File(rutaDelArchivo).exists());

        // Generar el informe HTML usando el método de RecetaMedica
        String informeHTML = RecetaMedica.generarInformeHTML(receta);

        try (PrintWriter out = new PrintWriter(rutaDelArchivo)) {
            out.println(informeHTML);
            System.out.println("Informe HTML generado y guardado en: " + rutaDelArchivo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
