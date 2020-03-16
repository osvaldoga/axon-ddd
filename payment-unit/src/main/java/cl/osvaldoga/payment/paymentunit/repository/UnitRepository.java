package cl.osvaldoga.payment.paymentunit.repository;

import cl.osvaldoga.payment.paymentunit.entities.UnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UnitRepository extends JpaRepository<UnitEntity, UUID> {
}
