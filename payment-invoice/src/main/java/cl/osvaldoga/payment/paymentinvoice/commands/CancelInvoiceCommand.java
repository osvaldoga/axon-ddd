package cl.osvaldoga.payment.paymentinvoice.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CancelInvoiceCommand {
    @TargetAggregateIdentifier
    private UUID id;
    private String status;
}
