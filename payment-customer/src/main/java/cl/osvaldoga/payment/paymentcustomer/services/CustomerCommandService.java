package cl.osvaldoga.payment.paymentcustomer.services;

import cl.osvaldoga.payment.paymentcustomer.commands.CreateCustomerCommand;
import cl.osvaldoga.payment.paymentcustomer.commands.UpdateCustomerCommand;
import cl.osvaldoga.payment.paymentcustomer.constants.CustomerStatus;
import cl.osvaldoga.payment.paymentcustomer.dto.CustomerCreationDTO;
import cl.osvaldoga.payment.paymentcustomer.dto.CustomerUpdateDTO;
import cl.osvaldoga.payment.paymentcustomer.entity.CustomerEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class CustomerCommandService {
    @Autowired
    private CommandGateway commandGateway;

    public CompletableFuture<CustomerEntity> createCustomer(CustomerCreationDTO customerCreationDTO) {
        return commandGateway.send(new CreateCustomerCommand(UUID.randomUUID(), customerCreationDTO.getName(), customerCreationDTO.getLastname(), customerCreationDTO.getEmail(), customerCreationDTO.getExternalId(), customerCreationDTO.getUnitId(), CustomerStatus.CREATED.toString()));
    }

    public CompletableFuture<CustomerEntity> updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        return commandGateway.send(new UpdateCustomerCommand(customerUpdateDTO.getId(), customerUpdateDTO.getName(), customerUpdateDTO.getLastname(), customerUpdateDTO.getEmail()));
    }
}
