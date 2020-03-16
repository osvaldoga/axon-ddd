package cl.osvaldoga.payment.paymentunit.services;

import cl.osvaldoga.payment.paymentunit.commands.CreateUnitCommand;
import cl.osvaldoga.payment.paymentunit.constants.UnitStatus;
import cl.osvaldoga.payment.paymentunit.dto.UnitCreationDTO;
import cl.osvaldoga.payment.paymentunit.entities.UnitEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class UnitCommandService {
    @Autowired
    private CommandGateway commandGateway;

    public CompletableFuture<UnitEntity> createUnit(UnitCreationDTO unitCreationDTO) {
        return commandGateway.send(new CreateUnitCommand(UUID.randomUUID(), unitCreationDTO.getName(), unitCreationDTO.getDescription(), UnitStatus.CREATED.name()));
    }
}
