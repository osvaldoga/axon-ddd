package cl.osvaldoga.payment.paymentcustomer.projection;

import cl.osvaldoga.payment.paymentcustomer.dto.CustomerResponseDTO;
import cl.osvaldoga.payment.paymentcustomer.entity.CustomerEntity;
import cl.osvaldoga.payment.paymentcustomer.entity.UnitEntity;
import cl.osvaldoga.payment.paymentcustomer.events.CustomerCreatedEvent;
import cl.osvaldoga.payment.paymentcustomer.events.CustomerUpdatedEvent;
import cl.osvaldoga.payment.paymentcustomer.query.FindCustomerQuery;
import cl.osvaldoga.payment.paymentcustomer.repository.CustomerRepository;
import cl.osvaldoga.payment.paymentcustomer.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class CustomerProjection {
    @Autowired
    public CustomerRepository customerRepository;

    @Autowired
    public UnitRepository unitRepository;

    @EventHandler
    public void on(CustomerCreatedEvent event) {

        UnitEntity unitEntity = unitRepository.findById(UUID.fromString(event.getUnitId())).orElse(null);

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setEmail(event.getEmail());
        customerEntity.setExternalId(event.getExternalId());
        customerEntity.setId(event.getId());
        customerEntity.setLastname(event.getLastname());
        customerEntity.setName(event.getName());
        customerEntity.setUnitEntity(unitEntity);
        customerEntity.setStatus(event.getStatus());

        customerRepository.save(customerEntity);
    }

    @EventHandler
    public void on(CustomerUpdatedEvent event) {
        CustomerEntity customerEntity = customerRepository.findById(UUID.fromString(event.getId())).orElse(null);

        customerEntity.setName(event.getName());
        customerEntity.setLastname(event.getLastname());
        customerEntity.setEmail(event.getEmail());

        customerRepository.save(customerEntity);
    }

    @QueryHandler
    public CustomerResponseDTO handle(FindCustomerQuery query) {
        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();

        CustomerEntity customerEntity = customerRepository.findById(query.getCustomerId()).orElse(null);

        customerResponseDTO.setEmail(customerEntity.getEmail());
        customerResponseDTO.setExternalId(customerEntity.getExternalId());
        customerResponseDTO.setLastname(customerEntity.getLastname());
        customerResponseDTO.setName(customerEntity.getName());
        customerResponseDTO.setUnitId(customerEntity.getUnitEntity().getId().toString());
        customerResponseDTO.setStatus(customerEntity.getStatus());


        return customerResponseDTO;
    }
}
