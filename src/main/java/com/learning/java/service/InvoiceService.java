package com.learning.java.service;

import com.learning.java.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    Invoice saveInvoice(Invoice invoice);
    Invoice updateInvoice(Invoice invoice, Integer invoiceId);
    void deleteInvoice(Integer invoiceId);
    Invoice getOneInvoice(Integer invoiceId);
    List<Invoice> getAllInvoices();
}
