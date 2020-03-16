package cl.osvaldoga.payment.paymentunit.controller;

import cl.osvaldoga.payment.paymentunit.dto.UnitCreationDTO;
import cl.osvaldoga.payment.paymentunit.entities.UnitEntity;
import cl.osvaldoga.payment.paymentunit.services.UnitCommandService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/unit")
@Api(value = "Unit Payment Commands", description = "Unit Payment Commands API")
@AllArgsConstructor
public class UnitCommandController {

    @Autowired
    private UnitCommandService unitCommandService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public CompletableFuture<UnitEntity> createUnit(@RequestBody UnitCreationDTO unitCreationDTO) {
        return unitCommandService.createUnit(unitCreationDTO);
    }
}
