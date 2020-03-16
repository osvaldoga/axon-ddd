package cl.osvaldoga.payment.paymentinvoice.repository;

import cl.osvaldoga.payment.paymentinvoice.entities.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, UUID> {
}
