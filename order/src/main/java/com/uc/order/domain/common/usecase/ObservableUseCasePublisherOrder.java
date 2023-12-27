package com.uc.order.domain.common.usecase;

public class ObservableUseCasePublisherOrder extends OrderBeanAwareUseCasePublisher {

    public <R, T extends UseCase> void register(Class<T> useCaseClass, UseCaseHandler<R, T> useCaseHandler) {
        UseCaseHandlerRegistry.INSTANCE.register(useCaseClass, useCaseHandler);
    }

    public <T extends UseCase> void register(Class<T> useCaseClass, VoidUseCaseHandler<T> useCaseHandler) {
        UseCaseHandlerRegistry.INSTANCE.register(useCaseClass, useCaseHandler);
    }

    public <R> void register(Class<R> returnClass, NoUseCaseHandler<R> useCaseHandler) {
        UseCaseHandlerRegistry.INSTANCE.register(returnClass, useCaseHandler);
    }
}
