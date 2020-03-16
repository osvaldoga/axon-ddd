package cl.osvaldoga.payment.paymentcustomer.services;

import cl.osvaldoga.payment.paymentcustomer.dto.CustomerResponseDTO;
import cl.osvaldoga.payment.paymentcustomer.query.FindCustomerQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class CustomerQueryService {
    @Autowired
    private QueryGateway queryGateway;

    public CompletableFuture<CustomerResponseDTO> findById(String customerId) {
        return queryGateway.query(new FindCustomerQuery(UUID.fromString(customerId)), ResponseTypes.instanceOf(CustomerResponseDTO.class));
    }
}
