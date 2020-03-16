package cl.osvaldoga.payment.paymentcustomer.controller;

import cl.osvaldoga.payment.paymentcustomer.dto.CustomerCreationDTO;
import cl.osvaldoga.payment.paymentcustomer.dto.CustomerUpdateDTO;
import cl.osvaldoga.payment.paymentcustomer.entity.CustomerEntity;
import cl.osvaldoga.payment.paymentcustomer.services.CustomerCommandService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/customer")
@Api(value = "Customer Payment Commands", description = "Customer Payment Commands API")
public class CustomerCommandController {
    @Autowired
    private CustomerCommandService customerCommandService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public CompletableFuture<CustomerEntity> createCustomer(@RequestBody CustomerCreationDTO customerCreationDTO) {
        return customerCommandService.createCustomer(customerCreationDTO);

    }

    @PutMapping
    public CompletableFuture<CustomerEntity> updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {
        return customerCommandService.updateCustomer(customerUpdateDTO);
    }
}
