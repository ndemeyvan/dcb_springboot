package com.ndemeyvan.springboottutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndemeyvan.springboottutorial.entities.DepartementEntity;
import com.ndemeyvan.springboottutorial.repository.IDepartmentRepository;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
    // Inject the repository
    @Autowired
    private IDepartmentRepository departmentRepository;

    @Override
    public DepartementEntity saveDepartement(DepartementEntity departement) {
        // All The repository and save new departement
        return departmentRepository.save(departement);
    }

    @Override
    public List<DepartementEntity> getAllDepartementsList() {
        // TODO Auto-generated method stub
        return departmentRepository.findAll();
    }

}
