package com.gezer.grpcserver.repository;

import com.gezer.grpcserver.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
    Patient findBySocialSecurityNumber(long socialSecurityNumber);
}
