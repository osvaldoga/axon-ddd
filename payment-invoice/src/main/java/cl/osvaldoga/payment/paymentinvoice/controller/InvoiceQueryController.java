package cl.osvaldoga.payment.paymentinvoice.controller;

import cl.osvaldoga.payment.paymentinvoice.dto.InvoiceResponseDTO;
import cl.osvaldoga.payment.paymentinvoice.services.InvoiceQueryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/invoice")
@Api(value = "Customer Invoice Commands", description = "Customer Invoice Commands API")
public class InvoiceQueryController {
    @Autowired
    private InvoiceQueryService invoiceQueryService;

    @GetMapping("/{invoiceId}")
    public CompletableFuture<InvoiceResponseDTO> findInvoice(@PathVariable("invoiceId") String invoiceId) {
        return invoiceQueryService.findById(invoiceId);
    }

    @GetMapping("/{invoiceId}/history")
    public List<Object> historyInvoice(@PathVariable("invoiceId") String invoiceId) {
        return invoiceQueryService.historyById(invoiceId);
    }


}
