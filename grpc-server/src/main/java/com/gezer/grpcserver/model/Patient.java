package com.gezer.grpcserver.model;

import com.gezer.lib.Gender;
import com.gezer.lib.PatientMessage;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Long socialSecurityNumber;

    public Patient(String name, int age, Gender gender, Long socialSecurityNumber) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.socialSecurityNumber = socialSecurityNumber;
        hospitals = new HashSet<>();
    }

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name = "patient_hospital",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "hospital_id")
    )
    private Set<Hospital> hospitals;

    public Patient() {

    }

    // Getters and setters


    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Long getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(Long socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public Set<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(Set<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    public void registerToHospital(Hospital hospital) {
        this.hospitals.add(hospital);
        hospital.registerPatient(this);
    }

    @Override
    public String toString() {
        return "Name=" + name + ", Age=" + age + ", Gender=" + gender + ", Social Security Number=" + socialSecurityNumber;
    }

    public PatientMessage toPatientMessage() {
        return PatientMessage.newBuilder()
                .setPatientId(Math.toIntExact(id))
                .setName(name)
                .setAge(age)
                .setGender(gender)
                .setSocialSecurityNumber(socialSecurityNumber)
                .build();
    }

    public void unregisterFromHospital(Hospital hospital){
        hospitals.remove(hospital);
    }

}
