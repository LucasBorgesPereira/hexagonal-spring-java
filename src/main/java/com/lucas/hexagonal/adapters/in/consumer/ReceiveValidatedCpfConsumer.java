package com.lucas.hexagonal.adapters.in.consumer;

import com.lucas.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.lucas.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.lucas.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    private final UpdateCustomerInputPort updateCustomerInputPort;
    private final CustomerMessageMapper customerMessageMapper;

    public ReceiveValidatedCpfConsumer(UpdateCustomerInputPort updateCustomerInputPort, CustomerMessageMapper customerMessageMapper) {
        this.updateCustomerInputPort = updateCustomerInputPort;
        this.customerMessageMapper = customerMessageMapper;
    }

    @KafkaListener(topics = "tp-cpf-validated", groupId = "lucas")
    public void receive(CustomerMessage customerMessage) {
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }
}
