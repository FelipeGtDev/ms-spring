package com.felipeLima.hrworker.services.impl;

import com.felipeLima.hrworker.entities.Worker;
import com.felipeLima.hrworker.repositories.WorkerRepository;
import com.felipeLima.hrworker.services.IWorkerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService implements IWorkerService {
    private final WorkerRepository repository;

    public WorkerService(WorkerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Worker> findAll() {
        return repository.findAll();
    }

    @Override
    public Worker findById(Long id) {
        return repository.findById(id).get();
    }
}
