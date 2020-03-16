package cl.osvaldoga.payment.paymentinvoice.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateInvoiceCommand {
    @TargetAggregateIdentifier
    private UUID id;
    private BigDecimal amount;
    private String serviceId;
    private Date dueDate;
    private UUID customerId;
    private String status;
}
