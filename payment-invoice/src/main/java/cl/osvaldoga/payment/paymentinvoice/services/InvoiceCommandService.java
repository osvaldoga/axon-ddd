package cl.osvaldoga.payment.paymentinvoice.services;

import cl.osvaldoga.payment.paymentinvoice.commands.CreateInvoiceCommand;
import cl.osvaldoga.payment.paymentinvoice.commands.OverdueInvoiceCommand;
import cl.osvaldoga.payment.paymentinvoice.commands.SendInvoiceCommand;
import cl.osvaldoga.payment.paymentinvoice.constants.InvoiceStatus;
import cl.osvaldoga.payment.paymentinvoice.dto.InvoiceCreationDTO;
import cl.osvaldoga.payment.paymentinvoice.entities.InvoiceEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class InvoiceCommandService {
    @Autowired
    private CommandGateway commandGateway;

    public CompletableFuture<InvoiceEntity> createInvoice(InvoiceCreationDTO invoice) {
        return commandGateway.send(new CreateInvoiceCommand(
                UUID.randomUUID(),
                invoice.getAmount(),
                invoice.getServiceId(),
                invoice.getDueDate(),
                UUID.fromString(invoice.getCustomerId()),
                InvoiceStatus.DRAFT.toString()));
    }

    public void sendInvoice(String invoiceId) {
        commandGateway.send(new SendInvoiceCommand(UUID.fromString(invoiceId), InvoiceStatus.SENT.toString()));
    }

    public void payInvoice(String invoiceId) {
        commandGateway.send(new SendInvoiceCommand(UUID.fromString(invoiceId), InvoiceStatus.PAID.toString()));
    }

    public void overdueInvoice(String invoiceId) {
        commandGateway.send(new OverdueInvoiceCommand(UUID.fromString(invoiceId), InvoiceStatus.OVERDUE.toString()));
    }

    public void cancelInvoice(String invoiceId) {
        commandGateway.send(new SendInvoiceCommand(UUID.fromString(invoiceId), InvoiceStatus.CANCELLED.toString()));
    }
}
