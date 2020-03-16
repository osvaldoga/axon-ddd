package cl.osvaldoga.payment.paymentinvoice.controller;

import cl.osvaldoga.payment.paymentinvoice.dto.InvoiceCreationDTO;
import cl.osvaldoga.payment.paymentinvoice.entities.InvoiceEntity;
import cl.osvaldoga.payment.paymentinvoice.services.InvoiceCommandService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/invoice")
@Api(value = "Customer Invoice Commands", description = "Customer Invoice Commands API")
public class InvoiceCommandController {
    @Autowired
    private InvoiceCommandService invoiceCommandService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public CompletableFuture<InvoiceEntity> createInvoice(@RequestBody InvoiceCreationDTO invoice) {
        return invoiceCommandService.createInvoice(invoice);
    }

    @PutMapping("/send/{invoiceId}")
    public void sendInvoice(@PathVariable("invoiceId") String invoiceId) {
        invoiceCommandService.sendInvoice(invoiceId);
    }

    @PutMapping("/pay/{invoiceId}")
    public void payInvoice(@PathVariable("invoiceId") String invoiceId) {
        invoiceCommandService.payInvoice(invoiceId);
    }

    @PutMapping("/overdue/{invoiceId}")
    public void overdueInvoice(@PathVariable("invoiceId") String invoiceId) {
        invoiceCommandService.overdueInvoice(invoiceId);
    }

    @PutMapping("/cancel/{invoiceId}")
    public void cancelInvoice(@PathVariable("invoiceId") String invoiceId) {
        invoiceCommandService.cancelInvoice(invoiceId);
    }
}
