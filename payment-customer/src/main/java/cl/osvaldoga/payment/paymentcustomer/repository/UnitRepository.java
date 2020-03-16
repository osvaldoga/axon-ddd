package cl.osvaldoga.payment.paymentcustomer.repository;

import cl.osvaldoga.payment.paymentcustomer.entity.UnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UnitRepository extends JpaRepository<UnitEntity, UUID> {
}
