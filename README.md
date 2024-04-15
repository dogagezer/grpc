## Dev log for this project:

### [Friday]
Initialized a new Spring Boot project. Implemented the gRPC interface using github.com/yidongnan/grpc-spring-boot-starter. Defined the HospitalService with a test method (CreatePatient).
### [Saturday]
 Completed the implementation of remaining protobuffers. grpc-lib setup was finalized today. Extended the HospitalService for all methods. Implemented Patient and Hospital entities. 
Set up patient and hospital repositories. Configured an H2 in-memory database.
### [Sunday]
 Implemented test methods for HospitalService. grpc-server set up was completed today.

## Project Structure:

 ```
grpc/
├── grpc-lib/                      // This is the library that contains the proto file and the generated classes
│   ├── build/
│   └── src/
│       ├── generated/             // This is where the generated classes are stored      
│       └── main/
│           ├── java/
│           ├── proto/
│           │   └── app.proto      //This is the proto file
│           └── resources/ 
├── grpc-server/
│   ├── build/
│   └── src/
│       ├── main/
│       │   ├── java/
│       │   │   └── com.gezer.grpcserver/            
│       │   │       ├── model/                       // This is where the entities are stored
│       │   │       │   ├── Hospital.java
│       │   │       │   └── Patient.java
│       │   │       ├── repository/                  // This is where the repositories are stored
│       │   │       │   ├── HospitalRepository.java
│       │   │       │   └── PatientRepository.java
│       │   │       ├── service/                     // This is where the service is stored
│       │   │       │   └── HospitalServiceImpl.java
│       │   │       └── GrpcServerApplication.java
│       │   └── resources/
│       └── test/
│           └── java/
│               └── com.gezer.grpcserver/
│                   └── service/                     // This is where the service tests are stored
│                       └── GrpcServerApplicationTests.java
├── build.gradle
├── settings.gradle
└── README.md
 ```
