package me.hanwook.server.service;

import io.grpc.stub.StreamObserver;
import me.hanwook.order.service.OrderRequest;
import me.hanwook.order.service.OrderResponse;
import me.hanwook.order.service.OrderServiceGrpc;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class OrderServiceImpl extends OrderServiceGrpc.OrderServiceImplBase {

    @Override
    public void create(OrderRequest request, StreamObserver<OrderResponse> responseObserver) {
        OrderResponse response = OrderResponse.newBuilder()
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
