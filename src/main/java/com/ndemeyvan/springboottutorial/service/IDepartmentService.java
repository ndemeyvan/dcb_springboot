package com.ndemeyvan.springboottutorial.service;

import java.util.List;

import com.ndemeyvan.springboottutorial.entities.DepartementEntity;

public interface IDepartmentService {
    public DepartementEntity saveDepartement( DepartementEntity departement);
    public List<DepartementEntity> getAllDepartementsList();
    public DepartementEntity getDepartementById(Long id);
    public void deleteDepartementById(Long id);
    public DepartementEntity updateDepartementById(Long id,DepartementEntity departement);
}
