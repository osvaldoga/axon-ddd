package cl.osvaldoga.payment.paymentunit.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FindUnitQuery {
    private UUID unitId;
}
