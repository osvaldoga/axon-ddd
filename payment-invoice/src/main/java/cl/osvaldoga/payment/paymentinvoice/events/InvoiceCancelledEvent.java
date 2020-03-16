package cl.osvaldoga.payment.paymentinvoice.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceCancelledEvent {
    private UUID id;
    private String status;
}
