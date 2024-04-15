Dev Log for this project:

[Friday] Initialized a new Spring Boot project. Implemented the gRPC interface using github.com/yidongnan/grpc-spring-boot-starter. Defined the HospitalService with a test method (CreatePatient).
[Saturday] Completed the implementation of remaining protobuffers. grpc-lib setup was finalized today. Extended the HospitalService for all methods. Implemented Patient and Hospital entities. 
Set up patient and hospital repositories. Configured an H2 in-memory database.
[Sunday]  Implemented test methods for HospitalService. grpc-server set up was completed today.

Project Structure:

grpc/
│
├── grpc-lib/
│   ├── build/
│   └── src/
│       ├── generated/                  
│       └── main/
│           ├── java/
│           ├── proto/
│           │     └── app.proto
│           └── resources/                  
│
├── grpc-server/
│   ├── build/
│   └── src/
│       ├── main/
│       │   ├── java/
│       │   │   └── com.gezer.grpcserver/   
│       │   │       ├── model/ 
│       │   │       │   ├── Hospital.java
│       │   │       │   └── Patient.java
│       │   │       ├── repository/  
│       │   │       │   ├── HospitalRepository.java
│       │   │       │   └── PatientRepository.java
│       │   │       ├── service/
│       │   │       │   └──HospitalServiceImpl.java
│       │   │       └── GrpcServerApplication.java         
│       │   └── resources/               
│       └── test/
│           └── java/
│                   └── com.gezer.grpcserver/   
│                       └──  service/ 
│                              └── GrpcServerApplicationTests.java
│
├── build.gradle
├── settings.gradle
└── README.md
