package com.learning.java.controller;

import com.learning.java.entity.Invoice;
import com.learning.java.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;

    @PostMapping("/v1/invoices")
    public Invoice saveInvoice(@RequestBody Invoice invoice) {
        return invoiceService.saveInvoice(invoice);
    }

    @GetMapping("/v1/invoices")
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        return ResponseEntity.ok(invoiceService.getAllInvoices());
    }

    @GetMapping("/v1/invoices/{id}")
    public Invoice getOneInvoice(@PathVariable Integer id){
        return invoiceService.getOneInvoice(id);
    }

    @PutMapping("/v1/invoices/{id}")
    public Invoice updateInvoice(@RequestBody Invoice inv, @PathVariable Integer id) {
        return invoiceService.updateInvoice(inv, id);
    }

    @DeleteMapping("/v1/invoices/{id}")
    public String deleteInvoice(@PathVariable Integer id) {
        invoiceService.deleteInvoice(id);
        return "Employee with id: "+id+ " Deleted !";
    }
}
