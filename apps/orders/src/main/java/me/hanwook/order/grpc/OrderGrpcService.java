package me.hanwook.order.grpc;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import me.hanwook.order.entity.Order;
import me.hanwook.order.service.OrderRequest;
import me.hanwook.order.service.OrderResponse;
import me.hanwook.order.service.OrderService;
import me.hanwook.order.service.OrderServiceGrpc;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * order grpc service.
 */
@GrpcService
@RequiredArgsConstructor
public class OrderGrpcService extends OrderServiceGrpc.OrderServiceImplBase {

    private final OrderService orderService;

    /**
     * 주문 생성
     * @param request
     * @param responseObserver
     */
    @Override
    public void create(OrderRequest request, StreamObserver<OrderResponse> responseObserver) {
        Order order = orderService.create(request.getUserId(), request.getName(), request.getQuantity(), request.getPrice());

        responseObserver.onNext(
                OrderResponse.newBuilder()
                        .setId(order.getId())
                        .setUserId(order.getUserId())
                        .setName(order.getName())
                        .setPrice(order.getPrice())
                        .setQuantity(order.getQuantity())
                        .build()
        );

        responseObserver.onCompleted();
    }
}
