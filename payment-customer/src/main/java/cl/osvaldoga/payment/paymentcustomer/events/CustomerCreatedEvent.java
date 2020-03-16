package cl.osvaldoga.payment.paymentcustomer.events;

import lombok.Data;

import java.util.UUID;

@Data
public class CustomerCreatedEvent {
    private final UUID id;
    private final String name;
    private final String lastname;
    private final String email;
    private final String externalId;
    private final String unitId;
    private  final String status;
}
