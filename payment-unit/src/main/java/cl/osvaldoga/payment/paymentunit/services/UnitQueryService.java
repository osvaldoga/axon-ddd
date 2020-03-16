package cl.osvaldoga.payment.paymentunit.services;

import cl.osvaldoga.payment.paymentunit.entities.UnitEntity;
import cl.osvaldoga.payment.paymentunit.query.FindUnitQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class UnitQueryService {
    @Autowired
    private QueryGateway queryGateway;

    public CompletableFuture<UnitEntity> findById(String unitId) {
        return queryGateway.query(new FindUnitQuery(UUID.fromString(unitId)), ResponseTypes.instanceOf(UnitEntity.class));
    }
}
