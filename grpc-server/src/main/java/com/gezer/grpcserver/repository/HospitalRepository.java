package com.gezer.grpcserver.repository;
import com.gezer.grpcserver.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long>{
    Hospital findByName(String name);
}
