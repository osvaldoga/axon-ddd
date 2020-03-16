package cl.osvaldoga.payment.paymentinvoice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceResponseDTO {
    private UUID id;
    private BigDecimal amount;
    private String serviceId;
    private Date dueDate;
    private String customerId;
    private String status;
}
