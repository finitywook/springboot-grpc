package me.hanwook.member.config;

import me.hanwook.order.service.OrderServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import net.devh.boot.grpc.client.inject.GrpcClientBean;
import org.springframework.context.annotation.Configuration;

@Configuration
@GrpcClientBean(
        clazz = OrderServiceGrpc.OrderServiceBlockingStub.class,
        beanName = "orderServiceBlockingStub",
        client = @GrpcClient("orderServiceClient"))
public class GrpcConfiguration {
}
