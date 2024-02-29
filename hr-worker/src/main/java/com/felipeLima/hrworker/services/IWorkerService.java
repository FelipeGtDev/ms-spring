package com.felipeLima.hrworker.services;

import com.felipeLima.hrworker.entities.Worker;

import java.util.List;

public interface IWorkerService {
    List<Worker> findAll();

    Worker findById(Long id);
}
