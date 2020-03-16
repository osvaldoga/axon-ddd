package cl.osvaldoga.payment.paymentunit.controller;

import cl.osvaldoga.payment.paymentunit.entities.UnitEntity;
import cl.osvaldoga.payment.paymentunit.services.UnitQueryService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/unit")
@Api(value = "Unit Payment Query", description = "Unit Payment Query API")
@AllArgsConstructor
public class UnitQueryController {

    @Autowired
    private UnitQueryService unitQueryService;

    @GetMapping("/{unitId}")
    public CompletableFuture<UnitEntity> findById(@PathVariable("unitId") String unitId) {
        return unitQueryService.findById(unitId);
    }
}
