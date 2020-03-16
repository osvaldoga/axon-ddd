package cl.osvaldoga.payment.paymentcustomer.aggregates;

import cl.osvaldoga.payment.paymentcustomer.commands.CreateCustomerCommand;
import cl.osvaldoga.payment.paymentcustomer.commands.UpdateCustomerCommand;
import cl.osvaldoga.payment.paymentcustomer.events.CustomerCreatedEvent;
import cl.osvaldoga.payment.paymentcustomer.events.CustomerUpdatedEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Aggregate
public class CustomerAggregate {
    @AggregateIdentifier
    private UUID id;
    private String name;
    private String lastname;
    private String email;
    private String externalId;
    private String unitId;
    private String status;

    @CommandHandler
    public CustomerAggregate(CreateCustomerCommand command) {
        AggregateLifecycle.apply(new CustomerCreatedEvent(UUID.randomUUID(), command.getName(), command.getLastmane(), command.getEmail(), command.getExternalId(), command.getUnitId(), command.getStatus()));
    }

    @EventSourcingHandler
    public void on(CustomerCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.lastname = event.getLastname();
        this.email = event.getEmail();
        this.externalId = event.getExternalId();
        this.unitId = event.getUnitId();
        this.status = event.getStatus();
    }

    @CommandHandler
    public void handle(UpdateCustomerCommand command) {
        AggregateLifecycle.apply(new CustomerUpdatedEvent(command.getId(), command.getName(), command.getLastname(), command.getEmail()));
    }

    @EventSourcingHandler
    public void on(CustomerUpdatedEvent event) {
        this.name = event.getName();
        this.lastname = event.getLastname();
        this.email = event.getEmail();
    }
}
