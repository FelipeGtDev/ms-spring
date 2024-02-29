package org.felipelima.hrpayroll.services.impl;

import org.felipelima.hrpayroll.entities.Payment;
import org.felipelima.hrpayroll.services.IPaymentServices;
import org.springframework.stereotype.Service;

@Service
public class PaymentServices implements IPaymentServices {

    public Payment getPayment(long workerId, int days){

        return new Payment("Bob", 200.0, days);
    }
}
