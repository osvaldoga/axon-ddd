package cl.osvaldoga.payment.paymentcustomer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO {
    private String name;
    private String lastname;
    private String email;
    private String externalId;
    private String unitId;
    private String status;
}
