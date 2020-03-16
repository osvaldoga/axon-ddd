package cl.osvaldoga.payment.paymentinvoice.repository;

import cl.osvaldoga.payment.paymentinvoice.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {

}
