package cl.osvaldoga.payment.paymentcustomer.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerCommand {
    @TargetAggregateIdentifier
    private UUID id;
    private String name;
    private String lastmane;
    private String email;
    private String externalId;
    private String unitId;
    private String status;
}
