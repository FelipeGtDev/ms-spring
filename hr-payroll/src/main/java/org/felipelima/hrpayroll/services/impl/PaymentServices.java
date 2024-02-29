package org.felipelima.hrpayroll.services.impl;

import org.felipelima.hrpayroll.entities.Payment;
import org.felipelima.hrpayroll.entities.Worker;
import org.felipelima.hrpayroll.fengClients.WorkerFeingClient;
import org.felipelima.hrpayroll.services.IPaymentServices;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentServices implements IPaymentServices {

    private WorkerFeingClient workerFeingClient;

    public PaymentServices(WorkerFeingClient workerFeingClient) {
        this.workerFeingClient = workerFeingClient;
    }

    public Payment getPayment(long workerId, int days){



        Worker worker = workerFeingClient.findById(workerId).getBody();

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
