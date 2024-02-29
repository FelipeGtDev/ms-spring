package com.felipeLima.hrworker.resources;

import com.felipeLima.hrworker.entities.Worker;
import com.felipeLima.hrworker.repositories.WorkerRepository;
import com.felipeLima.hrworker.services.IWorkerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workers")
public class WorkerResource {

    private final IWorkerService service;

    public WorkerResource(IWorkerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = service.findAll();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        try {
            Worker worker = service.findById(id);

            return ResponseEntity.ok(worker);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
