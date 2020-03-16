package cl.osvaldoga.payment.paymentinvoice.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceCreatedEvent {
    private UUID id;
    private BigDecimal amount;
    private String serviceId;
    private Date dueDate;
    private UUID customerId;
    private String status;
}
