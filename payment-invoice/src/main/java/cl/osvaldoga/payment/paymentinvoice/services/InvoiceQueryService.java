package cl.osvaldoga.payment.paymentinvoice.services;


import cl.osvaldoga.payment.paymentinvoice.dto.InvoiceResponseDTO;
import cl.osvaldoga.payment.paymentinvoice.query.FindInvoiceQuery;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class InvoiceQueryService {
    @Autowired
    private QueryGateway queryGateway;

    @Autowired
    private EventStore eventStore;

    public CompletableFuture<InvoiceResponseDTO> findById(String invoiceId) {
        return queryGateway.query(new FindInvoiceQuery(UUID.fromString(invoiceId)), ResponseTypes.instanceOf(InvoiceResponseDTO.class));
    }

    public List<Object> historyById(String invoiceId) {
        return eventStore.readEvents(invoiceId).asStream().map(s -> s.getPayload()).collect(Collectors.toList());
    }
}
