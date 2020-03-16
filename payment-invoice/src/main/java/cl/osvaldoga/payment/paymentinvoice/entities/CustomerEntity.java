package cl.osvaldoga.payment.paymentinvoice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {
    @Id
    private UUID id;
    private String name;
    private String lastname;
    private String email;
    private String externalId;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "unitid", nullable = false)
    private UnitEntity unitEntity;


}
