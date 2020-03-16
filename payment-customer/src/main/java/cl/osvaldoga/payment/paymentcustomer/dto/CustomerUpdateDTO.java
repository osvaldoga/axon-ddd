package cl.osvaldoga.payment.paymentcustomer.dto;

import lombok.Data;

@Data
public class CustomerUpdateDTO {
    private String id;
    private String name;
    private String lastname;
    private String email;

}
