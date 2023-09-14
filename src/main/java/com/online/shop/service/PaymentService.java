package com.online.shop.service;

import com.online.shop.entity.Payment;
import com.online.shop.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment createPayment(Payment payment) {
        // implement validation or business logic if needed
        return paymentRepository.save(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Payment not found"));
    }

    public Payment updatePayment(Payment payment) {
        // implement validation or business logic if needed
        return paymentRepository.save(payment);
    }

    public void deletePaymentById(Long id) {
        paymentRepository.deleteById(id);
    }

    // other methods as needed
}
