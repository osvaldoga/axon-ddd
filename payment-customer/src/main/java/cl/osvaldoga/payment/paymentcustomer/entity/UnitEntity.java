package cl.osvaldoga.payment.paymentcustomer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UnitEntity {
    @Id
    private UUID id;
    private String name;
    private String description;
    private String status;

}
