
package com.utp.clinicamedica.repository;

import com.utp.clinicamedica.model.Paciente;

import java.util.ArrayList;
import java.util.List;

public class RegistroPacientes {
    private List<Paciente> pacientes;

    public RegistroPacientes() {
        pacientes = new ArrayList<>();
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public List<Paciente> obtenerPacientes() {
        return pacientes;
    }
}
