package com.gezer.grpcserver.model;
import com.gezer.lib.HospitalMessage;
import com.gezer.lib.PatientMessage;
import jakarta.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(fetch=FetchType.EAGER)
    private Set<Patient> patients;

    public Hospital(String name) {
        this.name = name;
    }

    public Hospital() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long hospital_id) {
        this.id = hospital_id;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    public void registerPatient(Patient patient){
        this.patients.add(patient);
    }

    public void unregisterPatient(Patient patient){
        patients.remove(patient);
    }


    public HospitalMessage toHospitalMessage() {
        return HospitalMessage.newBuilder()
                .setHospitalId(Math.toIntExact(id))
                .setName(name)
                .build();
    }

    @Override
    public String toString() {
        return "Hospital=" + name +" Hospital ID=" + id;
    }


}