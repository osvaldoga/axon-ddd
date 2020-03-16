package cl.osvaldoga.payment.paymentunit.aggregates;

import cl.osvaldoga.payment.paymentunit.commands.CreateUnitCommand;
import cl.osvaldoga.payment.paymentunit.events.UnitCreatedEvent;
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
public class UnitAggregate {
    @AggregateIdentifier
    private UUID id;
    private String name;
    private String description;
    private String status;

    @CommandHandler
    public UnitAggregate(CreateUnitCommand command) {
        AggregateLifecycle.apply(new UnitCreatedEvent(command.getId(), command.getName(), command.getDescription(), command.getStatus()));
    }

    @EventSourcingHandler
    public void on(UnitCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.status = event.getStatus();
    }
}
