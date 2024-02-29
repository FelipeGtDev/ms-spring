package org.felipelima.hrpayroll.resources;

import org.felipelima.hrpayroll.entities.Payment;
import org.felipelima.hrpayroll.services.IPaymentServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    private final IPaymentServices services;

    public PaymentResource(IPaymentServices services) {
        this.services = services;
    }

    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable int days){
        var payment =  services.getPayment(workerId, days);

        return ResponseEntity.ok(payment);
    }
}
