package com.gezer.grpcserver.service;

import com.gezer.grpcserver.model.*;
import com.gezer.grpcserver.repository.*;
import com.gezer.lib.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import jakarta.transaction.Transactional;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
class HospitalServiceImplTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private HospitalServiceImpl hospitalService;

    @Test
    public void testCreatePatientSuccess() {
        CreatePatientRequest request = CreatePatientRequest.newBuilder().setName("John Doe").setAge(30).setGender(Gender.MALE).setSocialSecurityNumber(123456789).build();

        StreamObserver<CreatePatientResponse> responseObserver = new StreamObserver<>() {
            CreatePatientResponse response;

            @Override
            public void onNext(CreatePatientResponse value) {
                response = value;
            }

            @Override
            public void onError(Throwable t) {
                Assertions.fail("Error occurred: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                Assertions.assertNotNull(response);
                Assertions.assertTrue(response.getMessage().contains("Patient added successfully"));
            }
        };

        hospitalService.createPatient(request, responseObserver);
    }

    @Test
    public void testCreatePatientAlreadyExists() {
        Patient existingPatient = new Patient("John Doe", 30, Gender.MALE, 123456789L);
        patientRepository.save(existingPatient); // Save the patient to the database

        CreatePatientRequest request = CreatePatientRequest.newBuilder().setName("Jane Doe").setAge(25).setGender(Gender.FEMALE).setSocialSecurityNumber(123456789L).build(); // Same social security number as the existing patient

        StreamObserver<CreatePatientResponse> responseObserver = new StreamObserver<>() {
            Status status;

            @Override
            public void onNext(CreatePatientResponse value) {
                Assertions.fail("Unexpected onNext call");
            }

            @Override
            public void onError(Throwable t) {
                status = Status.fromThrowable(t);
            }

            @Override
            public void onCompleted() {
                Assertions.assertNotNull(status);
                Assertions.assertEquals(Status.ALREADY_EXISTS.getCode(), status.getCode());
                Assertions.assertTrue(status.getDescription().contains("already exists"));
            }
        };

        hospitalService.createPatient(request, responseObserver);
    }

    @Test
    public void modifyPatientSuccess() {
        Patient existingPatient = new Patient("John Doe", 30, Gender.MALE, 123456789L);
        patientRepository.save(existingPatient); // Save the patient to the database

        ModifyPatientRequest request = ModifyPatientRequest.newBuilder().setPatientId(existingPatient.getId()).setName("Jane Doe").setAge(25).setGender(Gender.FEMALE).setSocialSecurityNumber(123456789L).build(); // Same social security number as the existing patient

        StreamObserver<ModifyPatientResponse> responseObserver = new StreamObserver<>() {
            ModifyPatientResponse response;

            @Override
            public void onNext(ModifyPatientResponse value) {
                response = value;
            }

            @Override
            public void onError(Throwable t) {
                Assertions.fail("Error occurred: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                Assertions.assertNotNull(response);
                Assertions.assertTrue(response.getMessage().contains("Patient modified successfully"));
            }
        };

        hospitalService.modifyPatient(request, responseObserver);
    }

    @Test
    public void modifyPatientNotFound() {
        ModifyPatientRequest request = ModifyPatientRequest.newBuilder().setPatientId(1).setName("Jane Doe").setAge(25).setGender(Gender.FEMALE).setSocialSecurityNumber(123456789L).build(); // Request a patient that does not exist

        StreamObserver<ModifyPatientResponse> responseObserver = new StreamObserver<>() {
            Status status;

            @Override
            public void onNext(ModifyPatientResponse value) {
                Assertions.fail("Unexpected onNext call");
            }

            @Override
            public void onError(Throwable t) {
                status = Status.fromThrowable(t);
            }

            @Override
            public void onCompleted() {
                Assertions.assertNotNull(status);
                Assertions.assertEquals(Status.NOT_FOUND.getCode(), status.getCode());
                Assertions.assertTrue(status.getDescription().contains("not found"));
            }
        };

        hospitalService.modifyPatient(request, responseObserver);
    }

    @Test
    public void testDeletePatientSuccess() {
        Patient existingPatient = new Patient("John Doe", 30, Gender.MALE, 123456789L);
        patientRepository.save(existingPatient); // Save the patient to the database

        DeletePatientRequest request = DeletePatientRequest.newBuilder().setPatientId(1).build(); //Request to delete patient with ID 1

        StreamObserver<DeletePatientResponse> responseObserver = new StreamObserver<>() {
            DeletePatientResponse response;

            @Override
            public void onNext(DeletePatientResponse value) {
                response = value;

            }

            @Override
            public void onError(Throwable t) {
                Assertions.fail("Error occurred: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                Assertions.assertNotNull(response);
                Assertions.assertTrue(response.getMessage().contains("deleted successfully"));
            }
        };

        hospitalService.deletePatient(request, responseObserver);
    }

    @Test
    public void testDeletePatientNotFound() {
        DeletePatientRequest request = DeletePatientRequest.newBuilder().setPatientId(1).build(); //Request to delete patient with ID 1 which does not exist

        StreamObserver<DeletePatientResponse> responseObserver = new StreamObserver<>() {
            Status status;

            @Override
            public void onNext(DeletePatientResponse value) {
                Assertions.fail("Unexpected onNext call");
            }

            @Override
            public void onError(Throwable t) {
                status = Status.fromThrowable(t);
            }

            @Override
            public void onCompleted() {
                Assertions.assertNotNull(status);
                Assertions.assertEquals(Status.NOT_FOUND.getCode(), status.getCode());
                Assertions.assertTrue(status.getDescription().contains("not found"));
            }
        };

        hospitalService.deletePatient(request, responseObserver);
    }

    @Test
    public void testCreateHospitalSuccess() {
        CreateHospitalRequest request = CreateHospitalRequest.newBuilder().setName("Test Hospital").build();

        StreamObserver<CreateHospitalResponse> responseObserver = new StreamObserver<CreateHospitalResponse>() {
            CreateHospitalResponse response;

            @Override
            public void onNext(CreateHospitalResponse value) {
                response = value;
            }

            @Override
            public void onError(Throwable t) {
                Assertions.fail("Error occurred: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                Assertions.assertNotNull(response);
                Assertions.assertTrue(response.getMessage().contains("added successfully"));
            }
        };

        hospitalService.createHospital(request, responseObserver);
    }

    @Test
    public void testCreateHospitalAlreadyExists() {
        Hospital existingHospital = new Hospital("Existing Hospital");
        hospitalRepository.save(existingHospital); // Save the hospital to the database

        CreateHospitalRequest request = CreateHospitalRequest.newBuilder().setName("Existing Hospital").build(); // A hospital with the same name already exists

        StreamObserver<CreateHospitalResponse> responseObserver = new StreamObserver<>() {
            Status status;

            @Override
            public void onNext(CreateHospitalResponse value) {
                Assertions.fail("Unexpected onNext call");
            }

            @Override
            public void onError(Throwable t) {
                status = Status.fromThrowable(t);
            }

            @Override
            public void onCompleted() {
                Assertions.assertNotNull(status);
                Assertions.assertEquals(Status.ALREADY_EXISTS.getCode(), status.getCode());
                Assertions.assertTrue(status.getDescription().contains("already exists"));
            }
        };

        hospitalService.createHospital(request, responseObserver);
    }

    @Test
    public void testModifyHospitalSuccess() {
        Hospital existingHospital = new Hospital("Existing Hospital");
        hospitalRepository.save(existingHospital); // Save the hospital to the database

        ModifyHospitalRequest request = ModifyHospitalRequest.newBuilder().setHospitalId(1).setName("Modified Hospital").build();

        StreamObserver<ModifyHospitalResponse> responseObserver = new StreamObserver<ModifyHospitalResponse>() {
            ModifyHospitalResponse response;

            @Override
            public void onNext(ModifyHospitalResponse value) {
                response = value;
            }

            @Override
            public void onError(Throwable t) {
                Assertions.fail("Error occurred: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                Assertions.assertNotNull(response);
                Assertions.assertTrue(response.getMessage().contains("Hospital modified successfully"));
            }
        };

        hospitalService.modifyHospital(request, responseObserver);
    }

    @Test
    public void testModifyHospitalNotFound() {
        ModifyHospitalRequest request = ModifyHospitalRequest.newBuilder().setHospitalId(1).setName("Modified Hospital").build();

        StreamObserver<ModifyHospitalResponse> responseObserver = new StreamObserver<ModifyHospitalResponse>() {
            Status status;

            @Override
            public void onNext(ModifyHospitalResponse value) {
                Assertions.fail("Unexpected onNext call");
            }

            @Override
            public void onError(Throwable t) {
                status = Status.fromThrowable(t);
            }

            @Override
            public void onCompleted() {
                Assertions.assertNotNull(status);
                Assertions.assertEquals(Status.NOT_FOUND.getCode(), status.getCode());
                Assertions.assertTrue(status.getDescription().contains("not found"));
            }
        };

        hospitalService.modifyHospital(request, responseObserver);
    }

    @Test
    public void testRegisterPatientSuccess() {
        // Create a new hospital
        Hospital hospital = new Hospital("Test Hospital");
        hospitalRepository.save(hospital);

        // Create a new patient
        Patient patient = new Patient("John Doe", 30, Gender.MALE, 123456789L);
        patientRepository.save(patient);

        // Request to register the patient to the hospital
        RegisterPatientRequest request = RegisterPatientRequest.newBuilder().setHospitalId(hospital.getId()).setPatientId(patient.getId()).build();

        StreamObserver<RegisterPatientResponse> responseObserver = new StreamObserver<>() {
            RegisterPatientResponse response;

            @Override
            public void onNext(RegisterPatientResponse value) {
                response = value;
            }

            @Override
            public void onError(Throwable t) {
                Assertions.fail("Error occurred: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                Assertions.assertNotNull(response);
                Assertions.assertTrue(response.getMessage().contains("successfully"));
            }
        };

        hospitalService.registerPatient(request, responseObserver);
    }

    @Test
    public void testRegisterPatientNotFoundHospital() {
        // Create a new patient
        Patient patient = new Patient("John Doe", 30, Gender.MALE, 123456789L);
        patientRepository.save(patient);

        // Request to register the patient to a non-existing hospital
        RegisterPatientRequest request = RegisterPatientRequest.newBuilder().setHospitalId(1).setPatientId(patient.getId()).build();

        StreamObserver<RegisterPatientResponse> responseObserver = new StreamObserver<>() {
            Status status;

            @Override
            public void onNext(RegisterPatientResponse value) {
                Assertions.fail("Unexpected onNext call");
            }

            @Override
            public void onError(Throwable t) {
                status = Status.fromThrowable(t);
            }

            @Override
            public void onCompleted() {
                Assertions.assertNotNull(status);
                Assertions.assertEquals(Status.NOT_FOUND.getCode(), status.getCode());
                Assertions.assertTrue(status.getDescription().contains("Patient not found"));
            }
        };

        hospitalService.registerPatient(request, responseObserver);
    }

    @Test
    public void testRegisterPatientNotFoundPatient() {
        // Create a new hospital
        Hospital hospital = new Hospital("Test Hospital");
        hospitalRepository.save(hospital);

        // Request to register the patient to a non-existing hospital
        RegisterPatientRequest request = RegisterPatientRequest.newBuilder().setHospitalId(1).setPatientId(1).build();

        StreamObserver<RegisterPatientResponse> responseObserver = new StreamObserver<>() {
            Status status;

            @Override
            public void onNext(RegisterPatientResponse value) {
                Assertions.fail("Unexpected onNext call");
            }

            @Override
            public void onError(Throwable t) {
                status = Status.fromThrowable(t);
            }

            @Override
            public void onCompleted() {
                Assertions.assertNotNull(status);
                Assertions.assertEquals(Status.NOT_FOUND.getCode(), status.getCode());
                Assertions.assertTrue(status.getDescription().contains("Hospital not found"));
            }
        };

        hospitalService.registerPatient(request, responseObserver);
    }

    @Test
    @Transactional
    public void testUnregisterPatientSuccess() {
        // Create a new hospital
        Hospital hospital = new Hospital("Test Hospital");
        // Create a new patient
        Patient patient = new Patient("John Doe", 30, Gender.MALE, 123456789L);

        patientRepository.save(patient);
        hospitalRepository.save(hospital);
        patient.registerToHospital(hospital); // Register the patient to the hospital
        patientRepository.save(patient);
        hospitalRepository.save(hospital); // Save the patient and hospital

        // Request to register the patient to the hospital
        UnregisterPatientRequest request = UnregisterPatientRequest.newBuilder().setHospitalId(hospital.getId()).setPatientId(patient.getId()).build();

        StreamObserver<UnregisterPatientResponse> responseObserver = new StreamObserver<>() {
            UnregisterPatientResponse response;

            @Override
            public void onNext(UnregisterPatientResponse value) {
                response = value;
            }

            @Override
            public void onError(Throwable t) {
                Assertions.fail("Error occurred: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                Assertions.assertNotNull(response);
                Assertions.assertTrue(response.getMessage().contains("successfully"));
            }
        };

        hospitalService.unregisterPatient(request, responseObserver);
    }

    @Test
    public void testUnregisterPatientNotFoundPatient() {
// Create a new hospital
        Hospital hospital = new Hospital("Test Hospital");
        // Request to register the patient to a non-existing hospital
        UnregisterPatientRequest request = UnregisterPatientRequest.newBuilder().setHospitalId(1).setPatientId(1).build();

        StreamObserver<UnregisterPatientResponse> responseObserver = new StreamObserver<>() {
            Status status;

            @Override
            public void onNext(UnregisterPatientResponse value) {
                Assertions.fail("Unexpected onNext call");
            }

            @Override
            public void onError(Throwable t) {
                status = Status.fromThrowable(t);
            }

            @Override
            public void onCompleted() {
                Assertions.assertNotNull(status);
                Assertions.assertEquals(Status.NOT_FOUND.getCode(), status.getCode());
                Assertions.assertTrue(status.getDescription().contains("Patient not found"));
            }
        };

        hospitalService.unregisterPatient(request, responseObserver);
    }

    @Test
    public void testUnregisterPatientNotFoundHospital() {
        // Create a new hospital
        Hospital hospital = new Hospital("Test Hospital");
        hospitalRepository.save(hospital);

        // Request to register the patient to a non-existing hospital
        UnregisterPatientRequest request = UnregisterPatientRequest.newBuilder().setHospitalId(1).setPatientId(1).build();

        StreamObserver<UnregisterPatientResponse> responseObserver = new StreamObserver<>() {
            Status status;

            @Override
            public void onNext(UnregisterPatientResponse value) {
                Assertions.fail("Unexpected onNext call");
            }

            @Override
            public void onError(Throwable t) {
                status = Status.fromThrowable(t);
            }

            @Override
            public void onCompleted() {
                Assertions.assertNotNull(status);
                Assertions.assertEquals(Status.NOT_FOUND.getCode(), status.getCode());
                Assertions.assertTrue(status.getDescription().contains("Hospital not found"));
            }
        };

        hospitalService.unregisterPatient(request, responseObserver);
    }

    @Test
    public void testUnregisterPatientNotRegistered() {
        // Create a new hospital
        Hospital hospital = new Hospital("Test Hospital");
        hospitalRepository.save(hospital);

        // Create a new patient
        Patient patient = new Patient("John Doe", 30, Gender.MALE, 123456789L);
        patientRepository.save(patient);

        // Request to register the patient to a non-existing hospital
        UnregisterPatientRequest request = UnregisterPatientRequest.newBuilder().setHospitalId(1).setPatientId(1).build();

        StreamObserver<UnregisterPatientResponse> responseObserver = new StreamObserver<>() {
            Status status;

            @Override
            public void onNext(UnregisterPatientResponse value) {
                Assertions.fail("Unexpected onNext call");
            }

            @Override
            public void onError(Throwable t) {
                status = Status.fromThrowable(t);
            }

            @Override
            public void onCompleted() {
                Assertions.assertNotNull(status);
                Assertions.assertEquals(Status.NOT_FOUND.getCode(), status.getCode());
                Assertions.assertTrue(status.getDescription().contains("not registered to the hospital"));
            }
        };

        hospitalService.unregisterPatient(request, responseObserver);
    }

    @Test
    public void testDeleteHospitalSuccess() {
        Hospital existingHospital = new Hospital("Existing Hospital");
        hospitalRepository.save(existingHospital); // Save the Hospital to the database

        DeleteHospitalRequest request = DeleteHospitalRequest.newBuilder().setHospitalId(1).build(); //Request to delete Hospital with ID 1

        StreamObserver<DeleteHospitalResponse> responseObserver = new StreamObserver<>() {
            DeleteHospitalResponse response;

            @Override
            public void onNext(DeleteHospitalResponse value) {
                response = value;

            }

            @Override
            public void onError(Throwable t) {
                Assertions.fail("Error occurred: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                Assertions.assertNotNull(response);
                Assertions.assertTrue(response.getMessage().contains("deleted successfully"));
            }
        };

        hospitalService.deleteHospital(request, responseObserver);
    }

    @Test
    public void testDeleteHospitalNotFound() {
        DeleteHospitalRequest request = DeleteHospitalRequest.newBuilder().setHospitalId(1).build(); //Request to delete Hospital with ID 1 which does not exist

        StreamObserver<DeleteHospitalResponse> responseObserver = new StreamObserver<>() {
            Status status;

            @Override
            public void onNext(DeleteHospitalResponse value) {
                Assertions.fail("Unexpected onNext call");
            }

            @Override
            public void onError(Throwable t) {
                status = Status.fromThrowable(t);
            }

            @Override
            public void onCompleted() {
                Assertions.assertNotNull(status);
                Assertions.assertEquals(Status.NOT_FOUND.getCode(), status.getCode());
                Assertions.assertTrue(status.getDescription().contains("not found"));
            }
        };

        hospitalService.deleteHospital(request, responseObserver);
    }

    @Test
    @Transactional
    public void testListPatientsSuccess() {
        // Create a hospital
        Hospital hospital = new Hospital("Test Hospital");

        hospitalRepository.save(hospital); // Save the hospital to the database
        // Create a new patient
        Patient patient1 = new Patient("John Boe", 30, Gender.MALE, 123456789L);
        patientRepository.save(patient1);

        // Create a new patient
        Patient patient2 = new Patient("John Coe", 30, Gender.MALE, 223456789L);
        patientRepository.save(patient2);

        // Create a new patient
        Patient patient3 = new Patient("John Doe", 30, Gender.MALE, 323456789L);
        patientRepository.save(patient3);

        // Register the patient to the hospital
        patient1.registerToHospital(hospital);
        patient2.registerToHospital(hospital);
        patient3.registerToHospital(hospital);

        hospitalRepository.save(hospital); // Save the hospital to the database
        patientRepository.saveAll(Set.of(patient1, patient2, patient3)); // Save the patients to the database

        // Request to list the patient to the hospital
        ListPatientsRequest request = ListPatientsRequest.newBuilder().setHospitalId(hospital.getId()).build();

        StreamObserver<ListPatientsResponse> responseObserver = new StreamObserver<>() {
            ListPatientsResponse response;

            @Override
            public void onNext(ListPatientsResponse value) {
                response = value;
            }

            @Override
            public void onError(Throwable t) {
                Assertions.fail("Error occurred: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                Assertions.assertNotNull(response);
                Assertions.assertTrue((response.getPatientsList().size() == 3) && response.getPatientsList().contains(patient1.toPatientMessage()) && (response.getPatientsList().contains(patient2.toPatientMessage()) && (response.getPatientsList().contains(patient3.toPatientMessage()))));
            }
        };
        hospitalService.listPatients(request, responseObserver);
    }

    @Test
    @Transactional
    public void testListHospitalsSuccess() {
        // Create a new patient
        Patient patient = new Patient("John Doe", 30, Gender.MALE, 123456789L);
        patientRepository.save(patient);

        // Create 2 new hospitals
        Hospital hospital1 = new Hospital("Test Hospital 1");
        hospital1.registerPatient(patient);

        Hospital hospital2 = new Hospital("Test Hospital 2");
        hospital2.registerPatient(patient);

        hospitalRepository.saveAll(Set.of(hospital1, hospital2)); // Save the hospitals to the database

        // Register the patient to the hospitals
        patient.registerToHospital(hospital1);
        patient.registerToHospital(hospital2);

        patientRepository.save(patient); // Save patient to the database
        hospitalRepository.saveAll(Set.of(hospital1, hospital2)); // Save the hospitals to the database

        // Request to list the hospitals for the patient
        ListHospitalsRequest request = ListHospitalsRequest.newBuilder().setPatientId(patient.getId()).build();

        StreamObserver<ListHospitalsResponse> responseObserver = new StreamObserver<>() {
            ListHospitalsResponse response;

            @Override
            public void onNext(ListHospitalsResponse value) {
                response = value;
            }

            @Override
            public void onError(Throwable t) {
                Assertions.fail("Error occurred: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                Assertions.assertNotNull(response);
                Assertions.assertTrue((response.getHospitalsList().size() == 2) && response.getHospitalsList().contains(hospital1.toHospitalMessage()) && (response.getHospitalsList().contains(hospital2.toHospitalMessage())));
            }
        };
        hospitalService.listHospitals(request, responseObserver);
    }

    @Test
    public void testListHospitalsNotFound() {
        ListHospitalsRequest request = ListHospitalsRequest.newBuilder().setPatientId(1).build(); // Request to list hospitals for a non-existing patient

        StreamObserver<ListHospitalsResponse> responseObserver = new StreamObserver<>() {
            Status status;

            @Override
            public void onNext(ListHospitalsResponse value) {
                Assertions.fail("Unexpected onNext call");
            }

            @Override
            public void onError(Throwable t) {
                status = Status.fromThrowable(t);
            }

            @Override
            public void onCompleted() {
                Assertions.assertNotNull(status);
                Assertions.assertEquals(Status.NOT_FOUND.getCode(), status.getCode());
                Assertions.assertTrue(status.getDescription().contains("not found"));
            }
        };

        hospitalService.listHospitals(request, responseObserver);
    }

    @Test
    public void testListPatientsNotFound() {
        ListPatientsRequest request = ListPatientsRequest.newBuilder().setHospitalId(1).build(); // Request to list patients from a non-existing hospital

        StreamObserver<ListPatientsResponse> responseObserver = new StreamObserver<>() {
            Status status;

            @Override
            public void onNext(ListPatientsResponse value) {
                Assertions.fail("Unexpected onNext call");
            }

            @Override
            public void onError(Throwable t) {
                status = Status.fromThrowable(t);
            }

            @Override
            public void onCompleted() {
                Assertions.assertNotNull(status);
                Assertions.assertEquals(Status.NOT_FOUND.getCode(), status.getCode());
                Assertions.assertTrue(status.getDescription().contains("not found"));
            }
        };

        hospitalService.listPatients(request, responseObserver);
    }
}