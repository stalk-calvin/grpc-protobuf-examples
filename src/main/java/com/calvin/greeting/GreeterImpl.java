package com.calvin.greeting;

/*
 * Copyright Calvin Lee Since 2017.
 * All Rights Reserved.
 */

import com.calvin.HelloReply;
import io.grpc.stub.StreamObserver;

public class GreeterImpl extends com.calvin.GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(
        com.calvin.HelloRequest req, StreamObserver<HelloReply> responseObserver) {
        com.calvin.HelloReply
            reply = com.calvin.HelloReply.newBuilder().setMessage("Hello " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
