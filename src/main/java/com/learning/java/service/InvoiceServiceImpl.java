package com.learning.java.service;

import com.learning.java.entity.Invoice;
import com.learning.java.exception.InvoiceNotFoundException;
import com.learning.java.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    @CachePut(value = "Invoice", key = "#invoiceId")
    public Invoice updateInvoice(Invoice invoice, Integer invoiceId) {
        Invoice inv = invoiceRepository.findById(invoiceId).orElseThrow(() -> new InvoiceNotFoundException("Invoice not found"));
        inv.setInvoiceAmount(invoice.getInvoiceAmount());
        inv.setInvoiceName(invoice.getInvoiceName());
        return invoiceRepository.save(inv);
    }

    @Override
    @CacheEvict(value = "Invoice", key = "#invoiceId")
    public void deleteInvoice(Integer invoiceId) {
        Invoice inv = invoiceRepository.findById(invoiceId).orElseThrow(() -> new InvoiceNotFoundException("Invoice not found"));
        invoiceRepository.delete(inv);
    }

    @Override
    @Cacheable(value = "Invoice", key = "#invoiceId")
    public Invoice getOneInvoice(Integer invoiceId) {
        return invoiceRepository.findById(invoiceId).orElseThrow(() -> new InvoiceNotFoundException("Invoice not found"));
    }

    @Override
    @Cacheable(value = "Invoice")
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }
}
