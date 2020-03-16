package cl.osvaldoga.payment.paymentcustomer.dto;

import lombok.Data;

@Data
public class CustomerCreationDTO {
    private String name;
    private String lastname;
    private String email;
    private String externalId;
    private String unitId;
}
