
package com.utp.clinicamedica.repository;

import com.utp.clinicamedica.model.Doctor;

import java.util.ArrayList;
import java.util.List;

public class RegistroDoctor {
    private List<Doctor> listaDoctores;

    public RegistroDoctor() {
        this.listaDoctores = new ArrayList<>();
    }

    public void agregarDoctor(Doctor doctor) {
        listaDoctores.add(doctor);
    }

    public List<Doctor> obtenerDoctores() {
        return listaDoctores;
    }
}
