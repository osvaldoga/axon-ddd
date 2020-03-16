package cl.osvaldoga.payment.paymentinvoice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceCreationDTO {
    private BigDecimal amount;
    private String serviceId;
    private Date dueDate;
    private String customerId;
}
