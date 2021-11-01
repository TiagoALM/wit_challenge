package com.wit.calculator.services;

import com.wit.calculator.models.Operation;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

import static com.wit.calculator.utils.Constants.HEADER;

@Service
public class Receiver implements RabbitListenerConfigurer {

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {}

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public BigDecimal receivedMessage(Operation operation,
                                      @Header(HEADER) String header) {

        return Calculator.compute(operation);

    }

}
