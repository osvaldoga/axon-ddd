package cl.osvaldoga.payment.paymentinvoice.aggregates;


import cl.osvaldoga.payment.paymentinvoice.commands.*;
import cl.osvaldoga.payment.paymentinvoice.events.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Aggregate
public class InvoiceAggregate {
    @AggregateIdentifier
    private UUID id;
    private BigDecimal amount;
    private String status;
    private String serviceId;
    private Date dueDate;
    private UUID customerId;

    @CommandHandler
    public InvoiceAggregate(CreateInvoiceCommand command) {
        AggregateLifecycle.apply(new InvoiceCreatedEvent(command.getId(), command.getAmount(), command.getServiceId(), command.getDueDate(), command.getCustomerId(), command.getStatus()));
    }

    @EventSourcingHandler
    public void on(InvoiceCreatedEvent event) {
        this.id = event.getId();
        this.amount = event.getAmount();
        this.serviceId = event.getServiceId();
        this.dueDate = event.getDueDate();
        this.customerId = event.getCustomerId();
        this.status = event.getStatus();
    }

    @CommandHandler
    public void handle(SendInvoiceCommand command) {
        AggregateLifecycle.apply(new InvoiceSentEvent(command.getId(), command.getStatus()));
    }

    @EventSourcingHandler
    public void on(InvoiceSentEvent event) {
        this.status = event.getStatus();
    }

    @CommandHandler
    public void handle(PayInvoiceCommand command) {
        AggregateLifecycle.apply(new InvoicePaidEvent(command.getId(), command.getStatus()));
    }

    @EventSourcingHandler
    public void on(InvoicePaidEvent event) {
        this.status = event.getStatus();
    }

    @CommandHandler
    public void handle(OverdueInvoiceCommand command) {
        AggregateLifecycle.apply(new InvoiceWasOverdueEvent(command.getId(), command.getStatus()));
    }

    @EventSourcingHandler
    public void on(InvoiceWasOverdueEvent event) {
        this.status = event.getStatus();
    }

    @CommandHandler
    public void handle(CancelInvoiceCommand command) {
        AggregateLifecycle.apply(new InvoiceCancelledEvent(command.getId(), command.getStatus()));
    }

    @EventSourcingHandler
    public void on(InvoiceCancelledEvent event) {
        this.status = event.getStatus();
    }


}
