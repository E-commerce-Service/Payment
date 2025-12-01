package com.example.payment.consumer;

import com.example.payment.dto.PaymentRequest;
import com.example.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentConsumer {
    private final PaymentService paymentService;

    @RabbitListener(queues = "${rabbitmq.queue.payment}")
    public void consumePaymentMessage(PaymentRequest request) {
        paymentService.processSecurePayment(request);
    }
}
