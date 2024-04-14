package com.gezer.lib;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Hospital service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: app.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class HospitalServiceGrpc {

  private HospitalServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.gezer.lib.HospitalService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.gezer.lib.CreateHospitalRequest,
      com.gezer.lib.CreateHospitalResponse> getCreateHospitalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateHospital",
      requestType = com.gezer.lib.CreateHospitalRequest.class,
      responseType = com.gezer.lib.CreateHospitalResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.gezer.lib.CreateHospitalRequest,
      com.gezer.lib.CreateHospitalResponse> getCreateHospitalMethod() {
    io.grpc.MethodDescriptor<com.gezer.lib.CreateHospitalRequest, com.gezer.lib.CreateHospitalResponse> getCreateHospitalMethod;
    if ((getCreateHospitalMethod = HospitalServiceGrpc.getCreateHospitalMethod) == null) {
      synchronized (HospitalServiceGrpc.class) {
        if ((getCreateHospitalMethod = HospitalServiceGrpc.getCreateHospitalMethod) == null) {
          HospitalServiceGrpc.getCreateHospitalMethod = getCreateHospitalMethod =
              io.grpc.MethodDescriptor.<com.gezer.lib.CreateHospitalRequest, com.gezer.lib.CreateHospitalResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateHospital"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gezer.lib.CreateHospitalRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gezer.lib.CreateHospitalResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HospitalServiceMethodDescriptorSupplier("CreateHospital"))
              .build();
        }
      }
    }
    return getCreateHospitalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gezer.lib.ModifyHospitalRequest,
      com.gezer.lib.ModifyHospitalResponse> getModifyHospitalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ModifyHospital",
      requestType = com.gezer.lib.ModifyHospitalRequest.class,
      responseType = com.gezer.lib.ModifyHospitalResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.gezer.lib.ModifyHospitalRequest,
      com.gezer.lib.ModifyHospitalResponse> getModifyHospitalMethod() {
    io.grpc.MethodDescriptor<com.gezer.lib.ModifyHospitalRequest, com.gezer.lib.ModifyHospitalResponse> getModifyHospitalMethod;
    if ((getModifyHospitalMethod = HospitalServiceGrpc.getModifyHospitalMethod) == null) {
      synchronized (HospitalServiceGrpc.class) {
        if ((getModifyHospitalMethod = HospitalServiceGrpc.getModifyHospitalMethod) == null) {
          HospitalServiceGrpc.getModifyHospitalMethod = getModifyHospitalMethod =
              io.grpc.MethodDescriptor.<com.gezer.lib.ModifyHospitalRequest, com.gezer.lib.ModifyHospitalResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ModifyHospital"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gezer.lib.ModifyHospitalRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gezer.lib.ModifyHospitalResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HospitalServiceMethodDescriptorSupplier("ModifyHospital"))
              .build();
        }
      }
    }
    return getModifyHospitalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gezer.lib.DeleteHospitalRequest,
      com.gezer.lib.DeleteHospitalResponse> getDeleteHospitalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteHospital",
      requestType = com.gezer.lib.DeleteHospitalRequest.class,
      responseType = com.gezer.lib.DeleteHospitalResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.gezer.lib.DeleteHospitalRequest,
      com.gezer.lib.DeleteHospitalResponse> getDeleteHospitalMethod() {
    io.grpc.MethodDescriptor<com.gezer.lib.DeleteHospitalRequest, com.gezer.lib.DeleteHospitalResponse> getDeleteHospitalMethod;
    if ((getDeleteHospitalMethod = HospitalServiceGrpc.getDeleteHospitalMethod) == null) {
      synchronized (HospitalServiceGrpc.class) {
        if ((getDeleteHospitalMethod = HospitalServiceGrpc.getDeleteHospitalMethod) == null) {
          HospitalServiceGrpc.getDeleteHospitalMethod = getDeleteHospitalMethod =
              io.grpc.MethodDescriptor.<com.gezer.lib.DeleteHospitalRequest, com.gezer.lib.DeleteHospitalResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteHospital"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gezer.lib.DeleteHospitalRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gezer.lib.DeleteHospitalResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HospitalServiceMethodDescriptorSupplier("DeleteHospital"))
              .build();
        }
      }
    }
    return getDeleteHospitalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gezer.lib.CreatePatientRequest,
      com.gezer.lib.CreatePatientResponse> getCreatePatientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePatient",
      requestType = com.gezer.lib.CreatePatientRequest.class,
      responseType = com.gezer.lib.CreatePatientResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.gezer.lib.CreatePatientRequest,
      com.gezer.lib.CreatePatientResponse> getCreatePatientMethod() {
    io.grpc.MethodDescriptor<com.gezer.lib.CreatePatientRequest, com.gezer.lib.CreatePatientResponse> getCreatePatientMethod;
    if ((getCreatePatientMethod = HospitalServiceGrpc.getCreatePatientMethod) == null) {
      synchronized (HospitalServiceGrpc.class) {
        if ((getCreatePatientMethod = HospitalServiceGrpc.getCreatePatientMethod) == null) {
          HospitalServiceGrpc.getCreatePatientMethod = getCreatePatientMethod =
              io.grpc.MethodDescriptor.<com.gezer.lib.CreatePatientRequest, com.gezer.lib.CreatePatientResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePatient"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gezer.lib.CreatePatientRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gezer.lib.CreatePatientResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HospitalServiceMethodDescriptorSupplier("CreatePatient"))
              .build();
        }
      }
    }
    return getCreatePatientMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gezer.lib.ModifyPatientRequest,
      com.gezer.lib.ModifyPatientResponse> getModifyPatientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ModifyPatient",
      requestType = com.gezer.lib.ModifyPatientRequest.class,
      responseType = com.gezer.lib.ModifyPatientResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.gezer.lib.ModifyPatientRequest,
      com.gezer.lib.ModifyPatientResponse> getModifyPatientMethod() {
    io.grpc.MethodDescriptor<com.gezer.lib.ModifyPatientRequest, com.gezer.lib.ModifyPatientResponse> getModifyPatientMethod;
    if ((getModifyPatientMethod = HospitalServiceGrpc.getModifyPatientMethod) == null) {
      synchronized (HospitalServiceGrpc.class) {
        if ((getModifyPatientMethod = HospitalServiceGrpc.getModifyPatientMethod) == null) {
          HospitalServiceGrpc.getModifyPatientMethod = getModifyPatientMethod =
              io.grpc.MethodDescriptor.<com.gezer.lib.ModifyPatientRequest, com.gezer.lib.ModifyPatientResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ModifyPatient"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gezer.lib.ModifyPatientRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gezer.lib.ModifyPatientResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HospitalServiceMethodDescriptorSupplier("ModifyPatient"))
              .build();
        }
      }
    }
    return getModifyPatientMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gezer.lib.DeletePatientRequest,
      com.gezer.lib.DeletePatientResponse> getDeletePatientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePatient",
      requestType = com.gezer.lib.DeletePatientRequest.class,
      responseType = com.gezer.lib.DeletePatientResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.gezer.lib.DeletePatientRequest,
      com.gezer.lib.DeletePatientResponse> getDeletePatientMethod() {
    io.grpc.MethodDescriptor<com.gezer.lib.DeletePatientRequest, com.gezer.lib.DeletePatientResponse> getDeletePatientMethod;
    if ((getDeletePatientMethod = HospitalServiceGrpc.getDeletePatientMethod) == null) {
      synchronized (HospitalServiceGrpc.class) {
        if ((getDeletePatientMethod = HospitalServiceGrpc.getDeletePatientMethod) == null) {
          HospitalServiceGrpc.getDeletePatientMethod = getDeletePatientMethod =
              io.grpc.MethodDescriptor.<com.gezer.lib.DeletePatientRequest, com.gezer.lib.DeletePatientResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePatient"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gezer.lib.DeletePatientRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gezer.lib.DeletePatientResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HospitalServiceMethodDescriptorSupplier("DeletePatient"))
              .build();
        }
      }
    }
    return getDeletePatientMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gezer.lib.RegisterPatientRequest,
      com.gezer.lib.RegisterPatientResponse> getRegisterPatientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterPatient",
      requestType = com.gezer.lib.RegisterPatientRequest.class,
      responseType = com.gezer.lib.RegisterPatientResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.gezer.lib.RegisterPatientRequest,
      com.gezer.lib.RegisterPatientResponse> getRegisterPatientMethod() {
    io.grpc.MethodDescriptor<com.gezer.lib.RegisterPatientRequest, com.gezer.lib.RegisterPatientResponse> getRegisterPatientMethod;
    if ((getRegisterPatientMethod = HospitalServiceGrpc.getRegisterPatientMethod) == null) {
      synchronized (HospitalServiceGrpc.class) {
        if ((getRegisterPatientMethod = HospitalServiceGrpc.getRegisterPatientMethod) == null) {
          HospitalServiceGrpc.getRegisterPatientMethod = getRegisterPatientMethod =
              io.grpc.MethodDescriptor.<com.gezer.lib.RegisterPatientRequest, com.gezer.lib.RegisterPatientResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RegisterPatient"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gezer.lib.RegisterPatientRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gezer.lib.RegisterPatientResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HospitalServiceMethodDescriptorSupplier("RegisterPatient"))
              .build();
        }
      }
    }
    return getRegisterPatientMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gezer.lib.RegisterPatientRequest,
      com.gezer.lib.UnregisterPatientResponse> getUnregisterPatientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnregisterPatient",
      requestType = com.gezer.lib.RegisterPatientRequest.class,
      responseType = com.gezer.lib.UnregisterPatientResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.gezer.lib.RegisterPatientRequest,
      com.gezer.lib.UnregisterPatientResponse> getUnregisterPatientMethod() {
    io.grpc.MethodDescriptor<com.gezer.lib.RegisterPatientRequest, com.gezer.lib.UnregisterPatientResponse> getUnregisterPatientMethod;
    if ((getUnregisterPatientMethod = HospitalServiceGrpc.getUnregisterPatientMethod) == null) {
      synchronized (HospitalServiceGrpc.class) {
        if ((getUnregisterPatientMethod = HospitalServiceGrpc.getUnregisterPatientMethod) == null) {
          HospitalServiceGrpc.getUnregisterPatientMethod = getUnregisterPatientMethod =
              io.grpc.MethodDescriptor.<com.gezer.lib.RegisterPatientRequest, com.gezer.lib.UnregisterPatientResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UnregisterPatient"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gezer.lib.RegisterPatientRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gezer.lib.UnregisterPatientResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HospitalServiceMethodDescriptorSupplier("UnregisterPatient"))
              .build();
        }
      }
    }
    return getUnregisterPatientMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gezer.lib.ListPatientsRequest,
      com.gezer.lib.ListPatientsResponse> getListPatientsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPatients",
      requestType = com.gezer.lib.ListPatientsRequest.class,
      responseType = com.gezer.lib.ListPatientsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.gezer.lib.ListPatientsRequest,
      com.gezer.lib.ListPatientsResponse> getListPatientsMethod() {
    io.grpc.MethodDescriptor<com.gezer.lib.ListPatientsRequest, com.gezer.lib.ListPatientsResponse> getListPatientsMethod;
    if ((getListPatientsMethod = HospitalServiceGrpc.getListPatientsMethod) == null) {
      synchronized (HospitalServiceGrpc.class) {
        if ((getListPatientsMethod = HospitalServiceGrpc.getListPatientsMethod) == null) {
          HospitalServiceGrpc.getListPatientsMethod = getListPatientsMethod =
              io.grpc.MethodDescriptor.<com.gezer.lib.ListPatientsRequest, com.gezer.lib.ListPatientsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPatients"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gezer.lib.ListPatientsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gezer.lib.ListPatientsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HospitalServiceMethodDescriptorSupplier("ListPatients"))
              .build();
        }
      }
    }
    return getListPatientsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gezer.lib.ListHospitalsRequest,
      com.gezer.lib.ListHospitalsResponse> getListHospitalsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListHospitals",
      requestType = com.gezer.lib.ListHospitalsRequest.class,
      responseType = com.gezer.lib.ListHospitalsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.gezer.lib.ListHospitalsRequest,
      com.gezer.lib.ListHospitalsResponse> getListHospitalsMethod() {
    io.grpc.MethodDescriptor<com.gezer.lib.ListHospitalsRequest, com.gezer.lib.ListHospitalsResponse> getListHospitalsMethod;
    if ((getListHospitalsMethod = HospitalServiceGrpc.getListHospitalsMethod) == null) {
      synchronized (HospitalServiceGrpc.class) {
        if ((getListHospitalsMethod = HospitalServiceGrpc.getListHospitalsMethod) == null) {
          HospitalServiceGrpc.getListHospitalsMethod = getListHospitalsMethod =
              io.grpc.MethodDescriptor.<com.gezer.lib.ListHospitalsRequest, com.gezer.lib.ListHospitalsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListHospitals"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gezer.lib.ListHospitalsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gezer.lib.ListHospitalsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HospitalServiceMethodDescriptorSupplier("ListHospitals"))
              .build();
        }
      }
    }
    return getListHospitalsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HospitalServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HospitalServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HospitalServiceStub>() {
        @java.lang.Override
        public HospitalServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HospitalServiceStub(channel, callOptions);
        }
      };
    return HospitalServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HospitalServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HospitalServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HospitalServiceBlockingStub>() {
        @java.lang.Override
        public HospitalServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HospitalServiceBlockingStub(channel, callOptions);
        }
      };
    return HospitalServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HospitalServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HospitalServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HospitalServiceFutureStub>() {
        @java.lang.Override
        public HospitalServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HospitalServiceFutureStub(channel, callOptions);
        }
      };
    return HospitalServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Hospital service definition.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Create a new Hospital
     * </pre>
     */
    default void createHospital(com.gezer.lib.CreateHospitalRequest request,
        io.grpc.stub.StreamObserver<com.gezer.lib.CreateHospitalResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateHospitalMethod(), responseObserver);
    }

    /**
     * <pre>
     * Update an existing Hospital
     * </pre>
     */
    default void modifyHospital(com.gezer.lib.ModifyHospitalRequest request,
        io.grpc.stub.StreamObserver<com.gezer.lib.ModifyHospitalResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getModifyHospitalMethod(), responseObserver);
    }

    /**
     * <pre>
     * Delete a Hospital by ID
     * </pre>
     */
    default void deleteHospital(com.gezer.lib.DeleteHospitalRequest request,
        io.grpc.stub.StreamObserver<com.gezer.lib.DeleteHospitalResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteHospitalMethod(), responseObserver);
    }

    /**
     * <pre>
     * Create a new patient
     * </pre>
     */
    default void createPatient(com.gezer.lib.CreatePatientRequest request,
        io.grpc.stub.StreamObserver<com.gezer.lib.CreatePatientResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreatePatientMethod(), responseObserver);
    }

    /**
     * <pre>
     * Update an existing patient
     * </pre>
     */
    default void modifyPatient(com.gezer.lib.ModifyPatientRequest request,
        io.grpc.stub.StreamObserver<com.gezer.lib.ModifyPatientResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getModifyPatientMethod(), responseObserver);
    }

    /**
     * <pre>
     * Delete a patient by ID
     * </pre>
     */
    default void deletePatient(com.gezer.lib.DeletePatientRequest request,
        io.grpc.stub.StreamObserver<com.gezer.lib.DeletePatientResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeletePatientMethod(), responseObserver);
    }

    /**
     * <pre>
     * Register a patient in a hospital
     * </pre>
     */
    default void registerPatient(com.gezer.lib.RegisterPatientRequest request,
        io.grpc.stub.StreamObserver<com.gezer.lib.RegisterPatientResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRegisterPatientMethod(), responseObserver);
    }

    /**
     * <pre>
     * Unregister a patient in a hospital
     * </pre>
     */
    default void unregisterPatient(com.gezer.lib.RegisterPatientRequest request,
        io.grpc.stub.StreamObserver<com.gezer.lib.UnregisterPatientResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUnregisterPatientMethod(), responseObserver);
    }

    /**
     * <pre>
     * List all patients of a hospital
     * </pre>
     */
    default void listPatients(com.gezer.lib.ListPatientsRequest request,
        io.grpc.stub.StreamObserver<com.gezer.lib.ListPatientsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListPatientsMethod(), responseObserver);
    }

    /**
     * <pre>
     * List all hospitals in which a patient has been registered
     * </pre>
     */
    default void listHospitals(com.gezer.lib.ListHospitalsRequest request,
        io.grpc.stub.StreamObserver<com.gezer.lib.ListHospitalsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListHospitalsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service HospitalService.
   * <pre>
   * Hospital service definition.
   * </pre>
   */
  public static abstract class HospitalServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return HospitalServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service HospitalService.
   * <pre>
   * Hospital service definition.
   * </pre>
   */
  public static final class HospitalServiceStub
      extends io.grpc.stub.AbstractAsyncStub<HospitalServiceStub> {
    private HospitalServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HospitalServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HospitalServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create a new Hospital
     * </pre>
     */
    public void createHospital(com.gezer.lib.CreateHospitalRequest request,
        io.grpc.stub.StreamObserver<com.gezer.lib.CreateHospitalResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateHospitalMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Update an existing Hospital
     * </pre>
     */
    public void modifyHospital(com.gezer.lib.ModifyHospitalRequest request,
        io.grpc.stub.StreamObserver<com.gezer.lib.ModifyHospitalResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getModifyHospitalMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Delete a Hospital by ID
     * </pre>
     */
    public void deleteHospital(com.gezer.lib.DeleteHospitalRequest request,
        io.grpc.stub.StreamObserver<com.gezer.lib.DeleteHospitalResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteHospitalMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Create a new patient
     * </pre>
     */
    public void createPatient(com.gezer.lib.CreatePatientRequest request,
        io.grpc.stub.StreamObserver<com.gezer.lib.CreatePatientResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePatientMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Update an existing patient
     * </pre>
     */
    public void modifyPatient(com.gezer.lib.ModifyPatientRequest request,
        io.grpc.stub.StreamObserver<com.gezer.lib.ModifyPatientResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getModifyPatientMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Delete a patient by ID
     * </pre>
     */
    public void deletePatient(com.gezer.lib.DeletePatientRequest request,
        io.grpc.stub.StreamObserver<com.gezer.lib.DeletePatientResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePatientMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Register a patient in a hospital
     * </pre>
     */
    public void registerPatient(com.gezer.lib.RegisterPatientRequest request,
        io.grpc.stub.StreamObserver<com.gezer.lib.RegisterPatientResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterPatientMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Unregister a patient in a hospital
     * </pre>
     */
    public void unregisterPatient(com.gezer.lib.RegisterPatientRequest request,
        io.grpc.stub.StreamObserver<com.gezer.lib.UnregisterPatientResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnregisterPatientMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * List all patients of a hospital
     * </pre>
     */
    public void listPatients(com.gezer.lib.ListPatientsRequest request,
        io.grpc.stub.StreamObserver<com.gezer.lib.ListPatientsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPatientsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * List all hospitals in which a patient has been registered
     * </pre>
     */
    public void listHospitals(com.gezer.lib.ListHospitalsRequest request,
        io.grpc.stub.StreamObserver<com.gezer.lib.ListHospitalsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListHospitalsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service HospitalService.
   * <pre>
   * Hospital service definition.
   * </pre>
   */
  public static final class HospitalServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<HospitalServiceBlockingStub> {
    private HospitalServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HospitalServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HospitalServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create a new Hospital
     * </pre>
     */
    public com.gezer.lib.CreateHospitalResponse createHospital(com.gezer.lib.CreateHospitalRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateHospitalMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Update an existing Hospital
     * </pre>
     */
    public com.gezer.lib.ModifyHospitalResponse modifyHospital(com.gezer.lib.ModifyHospitalRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getModifyHospitalMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Delete a Hospital by ID
     * </pre>
     */
    public com.gezer.lib.DeleteHospitalResponse deleteHospital(com.gezer.lib.DeleteHospitalRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteHospitalMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Create a new patient
     * </pre>
     */
    public com.gezer.lib.CreatePatientResponse createPatient(com.gezer.lib.CreatePatientRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePatientMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Update an existing patient
     * </pre>
     */
    public com.gezer.lib.ModifyPatientResponse modifyPatient(com.gezer.lib.ModifyPatientRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getModifyPatientMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Delete a patient by ID
     * </pre>
     */
    public com.gezer.lib.DeletePatientResponse deletePatient(com.gezer.lib.DeletePatientRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePatientMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Register a patient in a hospital
     * </pre>
     */
    public com.gezer.lib.RegisterPatientResponse registerPatient(com.gezer.lib.RegisterPatientRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterPatientMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Unregister a patient in a hospital
     * </pre>
     */
    public com.gezer.lib.UnregisterPatientResponse unregisterPatient(com.gezer.lib.RegisterPatientRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnregisterPatientMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * List all patients of a hospital
     * </pre>
     */
    public com.gezer.lib.ListPatientsResponse listPatients(com.gezer.lib.ListPatientsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPatientsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * List all hospitals in which a patient has been registered
     * </pre>
     */
    public com.gezer.lib.ListHospitalsResponse listHospitals(com.gezer.lib.ListHospitalsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListHospitalsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service HospitalService.
   * <pre>
   * Hospital service definition.
   * </pre>
   */
  public static final class HospitalServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<HospitalServiceFutureStub> {
    private HospitalServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HospitalServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HospitalServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create a new Hospital
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.gezer.lib.CreateHospitalResponse> createHospital(
        com.gezer.lib.CreateHospitalRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateHospitalMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Update an existing Hospital
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.gezer.lib.ModifyHospitalResponse> modifyHospital(
        com.gezer.lib.ModifyHospitalRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getModifyHospitalMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Delete a Hospital by ID
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.gezer.lib.DeleteHospitalResponse> deleteHospital(
        com.gezer.lib.DeleteHospitalRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteHospitalMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Create a new patient
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.gezer.lib.CreatePatientResponse> createPatient(
        com.gezer.lib.CreatePatientRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePatientMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Update an existing patient
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.gezer.lib.ModifyPatientResponse> modifyPatient(
        com.gezer.lib.ModifyPatientRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getModifyPatientMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Delete a patient by ID
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.gezer.lib.DeletePatientResponse> deletePatient(
        com.gezer.lib.DeletePatientRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePatientMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Register a patient in a hospital
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.gezer.lib.RegisterPatientResponse> registerPatient(
        com.gezer.lib.RegisterPatientRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterPatientMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Unregister a patient in a hospital
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.gezer.lib.UnregisterPatientResponse> unregisterPatient(
        com.gezer.lib.RegisterPatientRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnregisterPatientMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * List all patients of a hospital
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.gezer.lib.ListPatientsResponse> listPatients(
        com.gezer.lib.ListPatientsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPatientsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * List all hospitals in which a patient has been registered
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.gezer.lib.ListHospitalsResponse> listHospitals(
        com.gezer.lib.ListHospitalsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListHospitalsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_HOSPITAL = 0;
  private static final int METHODID_MODIFY_HOSPITAL = 1;
  private static final int METHODID_DELETE_HOSPITAL = 2;
  private static final int METHODID_CREATE_PATIENT = 3;
  private static final int METHODID_MODIFY_PATIENT = 4;
  private static final int METHODID_DELETE_PATIENT = 5;
  private static final int METHODID_REGISTER_PATIENT = 6;
  private static final int METHODID_UNREGISTER_PATIENT = 7;
  private static final int METHODID_LIST_PATIENTS = 8;
  private static final int METHODID_LIST_HOSPITALS = 9;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_HOSPITAL:
          serviceImpl.createHospital((com.gezer.lib.CreateHospitalRequest) request,
              (io.grpc.stub.StreamObserver<com.gezer.lib.CreateHospitalResponse>) responseObserver);
          break;
        case METHODID_MODIFY_HOSPITAL:
          serviceImpl.modifyHospital((com.gezer.lib.ModifyHospitalRequest) request,
              (io.grpc.stub.StreamObserver<com.gezer.lib.ModifyHospitalResponse>) responseObserver);
          break;
        case METHODID_DELETE_HOSPITAL:
          serviceImpl.deleteHospital((com.gezer.lib.DeleteHospitalRequest) request,
              (io.grpc.stub.StreamObserver<com.gezer.lib.DeleteHospitalResponse>) responseObserver);
          break;
        case METHODID_CREATE_PATIENT:
          serviceImpl.createPatient((com.gezer.lib.CreatePatientRequest) request,
              (io.grpc.stub.StreamObserver<com.gezer.lib.CreatePatientResponse>) responseObserver);
          break;
        case METHODID_MODIFY_PATIENT:
          serviceImpl.modifyPatient((com.gezer.lib.ModifyPatientRequest) request,
              (io.grpc.stub.StreamObserver<com.gezer.lib.ModifyPatientResponse>) responseObserver);
          break;
        case METHODID_DELETE_PATIENT:
          serviceImpl.deletePatient((com.gezer.lib.DeletePatientRequest) request,
              (io.grpc.stub.StreamObserver<com.gezer.lib.DeletePatientResponse>) responseObserver);
          break;
        case METHODID_REGISTER_PATIENT:
          serviceImpl.registerPatient((com.gezer.lib.RegisterPatientRequest) request,
              (io.grpc.stub.StreamObserver<com.gezer.lib.RegisterPatientResponse>) responseObserver);
          break;
        case METHODID_UNREGISTER_PATIENT:
          serviceImpl.unregisterPatient((com.gezer.lib.RegisterPatientRequest) request,
              (io.grpc.stub.StreamObserver<com.gezer.lib.UnregisterPatientResponse>) responseObserver);
          break;
        case METHODID_LIST_PATIENTS:
          serviceImpl.listPatients((com.gezer.lib.ListPatientsRequest) request,
              (io.grpc.stub.StreamObserver<com.gezer.lib.ListPatientsResponse>) responseObserver);
          break;
        case METHODID_LIST_HOSPITALS:
          serviceImpl.listHospitals((com.gezer.lib.ListHospitalsRequest) request,
              (io.grpc.stub.StreamObserver<com.gezer.lib.ListHospitalsResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCreateHospitalMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.gezer.lib.CreateHospitalRequest,
              com.gezer.lib.CreateHospitalResponse>(
                service, METHODID_CREATE_HOSPITAL)))
        .addMethod(
          getModifyHospitalMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.gezer.lib.ModifyHospitalRequest,
              com.gezer.lib.ModifyHospitalResponse>(
                service, METHODID_MODIFY_HOSPITAL)))
        .addMethod(
          getDeleteHospitalMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.gezer.lib.DeleteHospitalRequest,
              com.gezer.lib.DeleteHospitalResponse>(
                service, METHODID_DELETE_HOSPITAL)))
        .addMethod(
          getCreatePatientMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.gezer.lib.CreatePatientRequest,
              com.gezer.lib.CreatePatientResponse>(
                service, METHODID_CREATE_PATIENT)))
        .addMethod(
          getModifyPatientMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.gezer.lib.ModifyPatientRequest,
              com.gezer.lib.ModifyPatientResponse>(
                service, METHODID_MODIFY_PATIENT)))
        .addMethod(
          getDeletePatientMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.gezer.lib.DeletePatientRequest,
              com.gezer.lib.DeletePatientResponse>(
                service, METHODID_DELETE_PATIENT)))
        .addMethod(
          getRegisterPatientMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.gezer.lib.RegisterPatientRequest,
              com.gezer.lib.RegisterPatientResponse>(
                service, METHODID_REGISTER_PATIENT)))
        .addMethod(
          getUnregisterPatientMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.gezer.lib.RegisterPatientRequest,
              com.gezer.lib.UnregisterPatientResponse>(
                service, METHODID_UNREGISTER_PATIENT)))
        .addMethod(
          getListPatientsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.gezer.lib.ListPatientsRequest,
              com.gezer.lib.ListPatientsResponse>(
                service, METHODID_LIST_PATIENTS)))
        .addMethod(
          getListHospitalsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.gezer.lib.ListHospitalsRequest,
              com.gezer.lib.ListHospitalsResponse>(
                service, METHODID_LIST_HOSPITALS)))
        .build();
  }

  private static abstract class HospitalServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HospitalServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.gezer.lib.AppProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HospitalService");
    }
  }

  private static final class HospitalServiceFileDescriptorSupplier
      extends HospitalServiceBaseDescriptorSupplier {
    HospitalServiceFileDescriptorSupplier() {}
  }

  private static final class HospitalServiceMethodDescriptorSupplier
      extends HospitalServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    HospitalServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (HospitalServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HospitalServiceFileDescriptorSupplier())
              .addMethod(getCreateHospitalMethod())
              .addMethod(getModifyHospitalMethod())
              .addMethod(getDeleteHospitalMethod())
              .addMethod(getCreatePatientMethod())
              .addMethod(getModifyPatientMethod())
              .addMethod(getDeletePatientMethod())
              .addMethod(getRegisterPatientMethod())
              .addMethod(getUnregisterPatientMethod())
              .addMethod(getListPatientsMethod())
              .addMethod(getListHospitalsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
