package cl.osvaldoga.payment.paymentinvoice.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindInvoiceQuery {
    private UUID invoiceId;
}
