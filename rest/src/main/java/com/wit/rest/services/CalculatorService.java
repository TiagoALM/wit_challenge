package com.wit.rest.services;

import com.wit.rest.models.Operation;
import com.wit.rest.models.Results;
import com.wit.rest.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.wit.rest.utils.Constants.HEADER;

@Service
public class CalculatorService {
    public static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);

    private final RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingKey;

    @Autowired
    public CalculatorService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public Results<BigDecimal> calculate(Operation operation) {
        Results<BigDecimal> results = new Results<>(send(operation));
        return results;
    }

    public BigDecimal send(Operation operation) {

        BigDecimal result = (BigDecimal) rabbitTemplate.convertSendAndReceive(exchange,
                                                                              routingKey,
                                                                              operation,
                                                                              message -> {
                                                                                  message.getMessageProperties()
                                                                                          .getHeaders()
                                                                                          .put(HEADER,
                                                                                               Utils.getUuid());
                                                                                  return message;
                                                                              },
                                                                  null);


        return result;
    }
}
