package com.ndemeyvan.springboottutorial.service;

import java.util.List;
import java.util.Objects;

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
        return departmentRepository.findAll();
    }

    @Override
    public DepartementEntity getDepartementById(Long id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public void deleteDepartementById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public DepartementEntity updateDepartementById(Long id, DepartementEntity departement) {
        DepartementEntity DepartementEntityInDb = departmentRepository.findById(id).get();
        if (Objects.nonNull(departement.getDepartmentName())
                && !"".equals(departement.getDepartmentName())) {
            DepartementEntityInDb.setDepartmentName(departement.getDepartmentName());
        }

        if (Objects.nonNull(departement.getDepartmentAddress())
                && !"".equals(departement.getDepartmentAddress())) {
            DepartementEntityInDb.setDepartmentAddress(departement.getDepartmentAddress());
        }

        if (Objects.nonNull(departement.getDepartmentCode())
                && !"".equals(departement.getDepartmentCode())) {
            DepartementEntityInDb.setDepartmentCode(departement.getDepartmentCode());
        }
        return departmentRepository.save(DepartementEntityInDb);
    }

    @Override
    public DepartementEntity getDepartementByName(String name) {
        return departmentRepository.findByDepartmentNameIgnoreCase(name);
    }

}
