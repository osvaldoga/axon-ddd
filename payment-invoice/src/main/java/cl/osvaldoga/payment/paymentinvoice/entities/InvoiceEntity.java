package cl.osvaldoga.payment.paymentinvoice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceEntity {
    @Id
    private UUID id;
    private BigDecimal ammount;
    private String status;
    private String serviceId;
    private Date dueDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customerId", nullable = false)
    private CustomerEntity customerEntity;

}
