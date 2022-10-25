package com.ndemeyvan.springboottutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ndemeyvan.springboottutorial.entities.DepartementEntity;
import com.ndemeyvan.springboottutorial.service.DepartmentServiceImpl;

@RestController
public class DepartmentController {

    // Inject Departement service
    // @AutoWired permet d'injecter le service dans cette classe
    @Autowired
    private DepartmentServiceImpl departmentServiceImpl;

    @PostMapping("/departments")
    public DepartementEntity saveDepartement(@RequestBody DepartementEntity departement) {
        return departmentServiceImpl.saveDepartement(departement);
    }

    @GetMapping("/departments")
    public List<DepartementEntity> getAllDepartementsList() {
        return departmentServiceImpl.getAllDepartementsList();
    }

}
