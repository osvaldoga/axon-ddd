package cl.osvaldoga.payment.paymentunit.projection;

import cl.osvaldoga.payment.paymentunit.entities.UnitEntity;
import cl.osvaldoga.payment.paymentunit.events.UnitCreatedEvent;
import cl.osvaldoga.payment.paymentunit.query.FindUnitQuery;
import cl.osvaldoga.payment.paymentunit.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class UnitProjection {
    @Autowired
    UnitRepository unitRepository;

    @EventHandler
    public void on(UnitCreatedEvent event) {
        log.debug("Unit creation command {}", event.getId());

        UnitEntity unitEntity = new UnitEntity(event.getId(), event.getName(), event.getDescription(), event.getStatus());

        unitRepository.save(unitEntity);
    }

    @QueryHandler
    public UnitEntity handle(FindUnitQuery query) {
        return unitRepository.findById(query.getUnitId()).orElse(null);
    }
}
