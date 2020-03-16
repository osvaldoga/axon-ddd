package cl.osvaldoga.payment.paymentinvoice.projection;

import cl.osvaldoga.payment.paymentinvoice.constants.InvoiceStatus;
import cl.osvaldoga.payment.paymentinvoice.dto.InvoiceResponseDTO;
import cl.osvaldoga.payment.paymentinvoice.entities.CustomerEntity;
import cl.osvaldoga.payment.paymentinvoice.entities.InvoiceEntity;
import cl.osvaldoga.payment.paymentinvoice.events.*;
import cl.osvaldoga.payment.paymentinvoice.query.FindInvoiceQuery;
import cl.osvaldoga.payment.paymentinvoice.repository.CustomerRepository;
import cl.osvaldoga.payment.paymentinvoice.repository.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InvoiceProjection {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @EventHandler
    public void on(InvoiceCreatedEvent event) {
        CustomerEntity customerEntity = customerRepository.findById(event.getCustomerId()).orElse(null);

        InvoiceEntity invoiceEntity = new InvoiceEntity();
        invoiceEntity.setId(event.getId());
        invoiceEntity.setAmmount(event.getAmount());
        invoiceEntity.setDueDate(event.getDueDate());
        invoiceEntity.setServiceId(event.getServiceId());
        invoiceEntity.setStatus(InvoiceStatus.DRAFT.toString());
        invoiceEntity.setCustomerEntity(customerEntity);

        invoiceRepository.save(invoiceEntity);
    }

    @EventHandler
    public void on(InvoiceSentEvent event) {
        InvoiceEntity invoiceEntity = invoiceRepository.findById(event.getId()).orElse(null);

        invoiceEntity.setStatus(event.getStatus());

        invoiceRepository.save(invoiceEntity);
    }

    @EventHandler
    public void on(InvoicePaidEvent event) {
        InvoiceEntity invoiceEntity = invoiceRepository.findById(event.getId()).orElse(null);

        invoiceEntity.setStatus(event.getStatus());

        invoiceRepository.save(invoiceEntity);
    }

    @EventHandler
    public void on(InvoiceWasOverdueEvent event) {
        InvoiceEntity invoiceEntity = invoiceRepository.findById(event.getId()).orElse(null);

        invoiceEntity.setStatus(event.getStatus());

        invoiceRepository.save(invoiceEntity);
    }

    @EventHandler
    public void on(InvoiceCancelledEvent event) {
        InvoiceEntity invoiceEntity = invoiceRepository.findById(event.getId()).orElse(null);

        invoiceEntity.setStatus(event.getStatus());

        invoiceRepository.save(invoiceEntity);
    }

    @QueryHandler
    public InvoiceResponseDTO handle(FindInvoiceQuery query) {
        InvoiceEntity invoiceEntity = invoiceRepository.findById(query.getInvoiceId()).orElse(null);

        InvoiceResponseDTO invoice = new InvoiceResponseDTO();
        invoice.setAmount(invoiceEntity.getAmmount());
        invoice.setCustomerId(invoiceEntity.getCustomerEntity().getId().toString());
        invoice.setDueDate(invoiceEntity.getDueDate());
        invoice.setId(invoiceEntity.getId());
        invoice.setServiceId(invoiceEntity.getServiceId());
        invoice.setStatus(invoiceEntity.getStatus());

        return invoice;
    }
}
