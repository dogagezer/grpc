package com.gezer.grpcserver.service;

import com.gezer.grpcserver.model.Hospital;
import com.gezer.grpcserver.model.Patient;
import com.gezer.grpcserver.repository.HospitalRepository;
import com.gezer.grpcserver.repository.PatientRepository;
import com.gezer.lib.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@GrpcService
public class HospitalServiceImpl extends HospitalServiceGrpc.HospitalServiceImplBase {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private HospitalRepository hospitalRepository;


    @Override
    public void createPatient(CreatePatientRequest request, StreamObserver<CreatePatientResponse> responseObserver) {
        try {
            Patient existingPatient = patientRepository.findBySocialSecurityNumber(request.getSocialSecurityNumber()); // Check if the patient already exists
            if (existingPatient != null) { // If the patient already exists, return an error
                responseObserver.onError(Status.ALREADY_EXISTS.withDescription(
                        "Patient with social security number " + request.getSocialSecurityNumber() +
                                " already exists and registered with  patient ID: " + existingPatient.getId()).asException());
                return;
            }
            Patient patient = new Patient(request.getName(), request.getAge(), request.getGender(), request.getSocialSecurityNumber()); // Create a new patient
            patientRepository.save(patient); // Save the patient to the database

            CreatePatientResponse reply = CreatePatientResponse.newBuilder() // Create a response message
                    .setMessage("Patient added successfully: " + patient)
                    .build();

            responseObserver.onNext(reply);  // Send the response message
            responseObserver.onCompleted();
        } catch (Exception e) { // Catch any exceptions
            responseObserver.onError(Status.INTERNAL.withDescription("Error creating patient: " + e.getMessage()).asException());
        }
    }

    @Override
    public void modifyPatient(ModifyPatientRequest request, StreamObserver<ModifyPatientResponse> responseObserver) {
        try {
            Patient patient = patientRepository.findById((long) request.getPatientId())
                    .orElseThrow(() -> new RuntimeException("Patient with ID " + request.getPatientId() + " not found")); // Find the patient by ID

            patient.setName(request.getName());
            patient.setAge(request.getAge());
            patient.setGender(request.getGender());
            patient.setSocialSecurityNumber(request.getSocialSecurityNumber()); // Modify the patient
            patientRepository.save(patient); // Save the modified patient

            ModifyPatientResponse reply = ModifyPatientResponse.newBuilder()
                    .setMessage("Patient modified successfully: " + patient)
                    .build(); // Create a response message

            responseObserver.onNext(reply);
            responseObserver.onCompleted(); // Send the response message
        } catch (RuntimeException e) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(e.getMessage()).asException());
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription("Error modifying patient: " + e.getMessage()).asException());
        }
    }


    @Override
    public void deletePatient(DeletePatientRequest request, StreamObserver<DeletePatientResponse> responseObserver) {
        try {
            Patient patient = patientRepository.findById((long) request.getPatientId())
                    .orElseThrow(() -> new RuntimeException("Patient with ID " + request.getPatientId() + " not found")); // Find the patient by ID

            patient.getHospitals()
                    .forEach(x -> x.unregisterPatient(patient));
            hospitalRepository.saveAll(patient.getHospitals());
            patientRepository.delete(patient);

            DeletePatientResponse reply = DeletePatientResponse.newBuilder()
                    .setMessage("Patient deleted successfully: " + patient)
                    .build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription("Error deleting patient: " + e.getMessage()).asException());
        }
    }

    @Override
    public void createHospital(CreateHospitalRequest request, StreamObserver<CreateHospitalResponse> responseObserver) {
        try {
            Hospital existingHospital = hospitalRepository.findByName(request.getName());
            if (existingHospital != null) {
                responseObserver.onError(Status.ALREADY_EXISTS.withDescription(
                        "Hospital with name " + request.getName() + " already exists and registered with hospital ID: " + existingHospital.getId()).asException());
                return;
            }
            Hospital hospital = new Hospital(request.getName());
            hospitalRepository.save(hospital);

            CreateHospitalResponse reply = CreateHospitalResponse.newBuilder()
                    .setMessage("Hospital added successfully: " + hospital)
                    .build();

            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription("Error creating hospital: " + e.getMessage()).asException());
        }
    }

    @Override
    public void modifyHospital(ModifyHospitalRequest request, StreamObserver<ModifyHospitalResponse> responseObserver) {
        try {
            Hospital existingHospital = hospitalRepository.findById((long) request.getHospitalId())
                    .orElseThrow(() -> new RuntimeException("Hospital with ID " + request.getHospitalId() + " not found"));
            existingHospital.setName(request.getName());
            hospitalRepository.save(existingHospital);

            ModifyHospitalResponse reply = ModifyHospitalResponse.newBuilder()
                    .setMessage("Hospital modified successfully: " + existingHospital)
                    .build();

            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (RuntimeException e) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(e.getMessage()).asException());
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription("Error modifying Hospital: " + e.getMessage()).asException());
        }
    }

    @Override
    public void deleteHospital(DeleteHospitalRequest request, StreamObserver<DeleteHospitalResponse> responseObserver) {
        try {
            Hospital hospital = hospitalRepository.findById((long) request.getHospitalId())
                    .orElseThrow(() -> new RuntimeException("Hospital with ID " + request.getHospitalId() + " not found"));

            hospital.getPatients()
                    .forEach(x -> x.unregisterFromHospital(hospital));

            patientRepository.saveAll(hospital.getPatients());
            hospitalRepository.delete(hospital);

            DeleteHospitalResponse reply = DeleteHospitalResponse.newBuilder()
                    .setMessage("Hospital deleted successfully: " + hospital)
                    .build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription("Error deleting hospital: " + e.getMessage()).asException());
        }
    }

    @Override
    public void registerPatient(RegisterPatientRequest request, StreamObserver<RegisterPatientResponse> responseObserver) {
        try {
            long hospitalId = request.getHospitalId();
            Hospital hospital = hospitalRepository.findById(hospitalId)
                    .orElseThrow(() -> new RuntimeException("Hospital with ID " + hospitalId + " not found"));
            long patientId = request.getPatientId();
            Patient patient = patientRepository.findById(patientId)
                    .orElseThrow(() -> new RuntimeException("Patient with ID " + patientId + " not found")); // Find the hospital and patient by ID

            if (hospital.getPatients().contains(patient)) {
                responseObserver.onError(Status.ALREADY_EXISTS.withDescription(
                        "Patient " + patient + " is already registered to hospital " + hospital).asException());
                return;
            }

            patient.registerToHospital(hospital); // Register the patient to the hospital
            patientRepository.save(patient);
            hospitalRepository.save(hospital); // Save the patient and hospital

            RegisterPatientResponse reply = RegisterPatientResponse.newBuilder()
                    .setMessage("Patient " + patient + " registered to hospital " + hospital + " successfully.")
                    .build(); // Create a response message

            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } catch (RuntimeException e) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(e.getMessage()).asException()); // Return an error if the hospital or patient is not found
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription("Error registering patient: " + e.getMessage()).asException()); // Return an error if there is an exception
        }
    }

    public void unregisterPatient(UnregisterPatientRequest request, StreamObserver<UnregisterPatientResponse> responseObserver) {
        try {
            long hospitalId = request.getHospitalId();
            Hospital hospital = hospitalRepository.findById(hospitalId)
                    .orElseThrow(() -> new RuntimeException("Hospital with ID " + hospitalId + " not found"));
            long patientId = request.getPatientId();
            Patient patient = patientRepository.findById(patientId)
                    .orElseThrow(() -> new RuntimeException("Patient with ID " + patientId + " not found")); // Find the hospital and patient by ID

            if (!hospital.getPatients().contains(patient)) {
                responseObserver.onError(Status.NOT_FOUND.withDescription(
                        "Patient " + patient + " is not registered to hospital " + hospital).asException());
                return;
            }

            patient.unregisterFromHospital(hospital); // Unregister the patient from the hospital
            patientRepository.save(patient);
            hospitalRepository.save(hospital); // Save the patient and hospital

            UnregisterPatientResponse reply = UnregisterPatientResponse.newBuilder()
                    .setMessage("Patient " + patient + " unregistered from hospital " + hospital + " successfully.")
                    .build(); // Create a response message
            responseObserver.onNext(reply);
            responseObserver.onCompleted();

        } catch (RuntimeException e) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(e.getMessage()).asException()); // Return an error if the hospital or patient is not found
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription("Error unregistering patient: " + e.getMessage()).asException()); // Return an error if there is an exception
        }
    }

    @Override
    public void listPatients(ListPatientsRequest request, StreamObserver<ListPatientsResponse> responseObserver) {
        try {
            Long hospitalId = (long) request.getHospitalId();
            Hospital hospital = hospitalRepository.findById(hospitalId)
                    .orElseThrow(() -> new RuntimeException("Hospital with ID " + hospitalId + " not found")); // Find the hospital by ID

            List<PatientMessage> patientMessages = hospital.getPatients().stream() // Convert the patients to messages
                    .map(Patient::toPatientMessage)
                    .toList();

            ListPatientsResponse reply = ListPatientsResponse.newBuilder() // Create a response message
                    .addAllPatients(patientMessages)
                    .build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (RuntimeException e) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(e.getMessage()).asException()); // Return an error if the hospital is not found
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription("Error listing patients: " + e.getMessage()).asException()); // Return an error if there is an exception
        }
    }

    @Override
    public void listHospitals(ListHospitalsRequest request, StreamObserver<ListHospitalsResponse> responseObserver) {
        try {
            Long patientId = (long) request.getPatientId();
            Patient patient = patientRepository.findById(patientId)
                    .orElseThrow(() -> new RuntimeException("Patient with ID " + patientId + " not found")); // Find the patient by ID

            List<HospitalMessage> hospitalMessages = patient.getHospitals().stream() // Convert the hospitals to messages
                    .map(Hospital::toHospitalMessage)
                    .toList();

            ListHospitalsResponse reply = ListHospitalsResponse.newBuilder() // Create a response message
                    .addAllHospitals(hospitalMessages)
                    .build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (RuntimeException e) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(e.getMessage()).asException()); // Return an error if the patient is not found
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription("Error listing hospitals: " + e.getMessage()).asException()); // Return an error if there is an exception
        }
    }
}

