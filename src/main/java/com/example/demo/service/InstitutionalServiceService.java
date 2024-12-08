package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.InstitutionalService;
import com.example.demo.repository.InstitutionalServiceRepository;

@Service
public class InstitutionalServiceService {
    @Autowired
    private InstitutionalServiceRepository institutionalServiceRepository;

    public void saveService(InstitutionalService service) {
        institutionalServiceRepository.save(service);
    }
}
