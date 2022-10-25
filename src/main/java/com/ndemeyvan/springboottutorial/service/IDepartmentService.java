package com.ndemeyvan.springboottutorial.service;

import java.util.List;

import com.ndemeyvan.springboottutorial.entities.DepartementEntity;

public interface IDepartmentService {
    public DepartementEntity saveDepartement( DepartementEntity departement);
    List<DepartementEntity> getAllDepartementsList();
}
