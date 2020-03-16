package cl.osvaldoga.payment.paymentunit.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUnitCommand {
    @TargetAggregateIdentifier
    private UUID id;
    private String name;
    private String description;
    private String status;
}
