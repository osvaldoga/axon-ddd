package cl.osvaldoga.payment.paymentcustomer.controller;

import cl.osvaldoga.payment.paymentcustomer.dto.CustomerResponseDTO;
import cl.osvaldoga.payment.paymentcustomer.services.CustomerQueryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/customer")
@Api(value = "Customer Payment Query", description = "Customer Payment Query API")
public class CustomerQueryController {
    @Autowired
    private CustomerQueryService customerQueryService;

    @GetMapping("{customerId}")
    public CompletableFuture<CustomerResponseDTO> findById(@PathVariable("customerId") String customerId) {
        return customerQueryService.findById(customerId);
    }

}
