package org.felipelima.hrpayroll.fengClients;

import org.felipelima.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker", path = "/workers", url = "localhost:8001")
public interface WorkerFeingClient {

    @GetMapping("/{id}")
    ResponseEntity<Worker> findById(@PathVariable Long id);

}
