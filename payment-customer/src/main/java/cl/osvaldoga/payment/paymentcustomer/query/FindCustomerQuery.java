package cl.osvaldoga.payment.paymentcustomer.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindCustomerQuery {
    private UUID customerId;
}
