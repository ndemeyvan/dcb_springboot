package com.ndemeyvan.springboottutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/departments/{id}")
    public DepartementEntity getDepartementById(@PathVariable("id") Long id){
        return departmentServiceImpl.getDepartementById(id);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartementById(@PathVariable("id") Long id){
        departmentServiceImpl.deleteDepartementById(id);
        return "Departement delete successfully";
    };   

    @PutMapping("/departments/{id}")
    public DepartementEntity updateDepartementById(@PathVariable("id") Long id,@RequestBody DepartementEntity departement){
            return departmentServiceImpl.updateDepartementById(id, departement);
    }

}
