package cl.osvaldoga.payment.paymentcustomer.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class CustomerUpdatedEvent {
    private String id;
    private String name;
    private String lastname;
    private String email;
}
