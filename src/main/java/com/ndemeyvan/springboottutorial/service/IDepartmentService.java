package com.ndemeyvan.springboottutorial.service;

import java.util.List;

import com.ndemeyvan.springboottutorial.entities.DepartementEntity;
import com.ndemeyvan.springboottutorial.error.DepartementNotFoundException;

public interface IDepartmentService {
    public DepartementEntity saveDepartement( DepartementEntity departement);
    public List<DepartementEntity> getAllDepartementsList();
    public DepartementEntity getDepartementById(Long id) throws DepartementNotFoundException;
    public void deleteDepartementById(Long id) throws DepartementNotFoundException ;
    public DepartementEntity updateDepartementById(Long id,DepartementEntity departement) throws DepartementNotFoundException;
    public DepartementEntity getDepartementByName(String name) throws DepartementNotFoundException;
}
