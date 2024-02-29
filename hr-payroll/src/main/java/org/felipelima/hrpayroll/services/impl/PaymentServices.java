package org.felipelima.hrpayroll.services.impl;

import org.felipelima.hrpayroll.entities.Payment;
import org.felipelima.hrpayroll.entities.Worker;
import org.felipelima.hrpayroll.services.IPaymentServices;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentServices implements IPaymentServices {

    @Value("${hr-worker.host}")
    private String workerHost;
    private RestTemplate restTemplate;

    public PaymentServices(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment getPayment(long workerId, int days){
        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("id", ""+workerId);


        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
