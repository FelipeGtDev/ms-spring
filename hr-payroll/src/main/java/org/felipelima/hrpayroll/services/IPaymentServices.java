package org.felipelima.hrpayroll.services;

import org.felipelima.hrpayroll.entities.Payment;

public interface IPaymentServices {

    Payment getPayment(long workerId, int days);
}
