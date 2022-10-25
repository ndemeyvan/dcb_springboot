package com.ndemeyvan.springboottutorial.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.ndemeyvan.springboottutorial.entities.DepartementEntity;

@DataJpaTest
public class IDepartmentRepositoryTest {

    // @MockBean permet de simuler une instance de ctte classe
    @Autowired
    private IDepartmentRepository departmentRepository;

    // Permet de faire persister les donnees dans la bd de facon temporaire pour les
    // tests
    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setup() {
        DepartementEntity departementEntity = new DepartementEntity().builder()
                .departmentName("INFORMATIQUE")
                .departmentAddress("DOUALA")
                .departmentCode("IT")
                .build();
        // Sauvegarde une copie temp dans la bd
        entityManager.persist(departementEntity);
    }

    @Test
    public void whenFindById_thenReturnDepartment() {
        DepartementEntity departementEntity = departmentRepository.findById(1L).get();
        assertEquals(departementEntity.getDepartmentName(), "INFORMATIQUE");
    }

}
