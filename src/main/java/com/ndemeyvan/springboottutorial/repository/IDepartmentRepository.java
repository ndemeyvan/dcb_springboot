package com.ndemeyvan.springboottutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ndemeyvan.springboottutorial.entities.DepartementEntity;

@Repository
public interface IDepartmentRepository extends JpaRepository<DepartementEntity,Long> {
    DepartementEntity findByDepartmentNameIgnoreCase(String name);
}
