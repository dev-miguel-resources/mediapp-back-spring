package com.tlaxcala.service;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tlaxcala.model.Patient;
import com.tlaxcala.repo.IPatientRepo;
//import com.tlaxcala.repo.PatientRepoImpl;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements IPatientService {

    private final IPatientRepo repo;

    @Override
    public Patient save(Patient patient) {
        return repo.save(patient);
    }

    @Override
    public Patient update(Patient patient, Integer id) {
        patient.setIdPatient(id);
        return repo.save(patient);
    }

    @Override
    public List<Patient> findAll() {
        return repo.findAll();
    }

    @Override
    public Patient findById(Integer id) {
        return repo.findById(id).orElse(new Patient());
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    // forma 1: private PatientRepo repo = new PatientRepo();
    // forma 2: private PatientRepoImpl repo = new PatientRepoImpl();
    // forma 3: singleton
    //@Autowired
    //private PatientRepoImpl repo;
    // forma 4: utilizar como inyección la definición de la fachada directamente mediante constructor
    /*private final IPatientRepo repo;

    public PatientServiceImpl(IPatientRepo repo) {
        this.repo = repo;
    }*/
    // forma 5: utilizar como inyección una interfaz de manera directa
    /*@Autowired
    private IPatientRepo repo;*/
    // forma 6: utilizar como inyección una interfaz + una anotación
    /*private final IPatientRepo repo;

    public String sayHelloLogic(Patient patient) {
        if (patient != null) {
            return repo.sayHello(patient);
        } else {
            return "There is no patient";
        }
    }*/
}