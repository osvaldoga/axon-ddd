package cl.osvaldoga.payment.paymentunit.events;

import lombok.Data;

import java.util.UUID;

@Data
public class UnitCreatedEvent {
    private final UUID id;
    private final String name;
    private final String description;
    private final String status;
}
