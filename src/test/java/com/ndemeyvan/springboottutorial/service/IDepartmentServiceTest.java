package com.ndemeyvan.springboottutorial.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ndemeyvan.springboottutorial.entities.DepartementEntity;
import com.ndemeyvan.springboottutorial.error.DepartementNotFoundException;
import com.ndemeyvan.springboottutorial.repository.IDepartmentRepository;

@SpringBootTest
public class IDepartmentServiceTest {

    @Autowired
    private DepartmentServiceImpl departmentServiceImpl;

    // @MockBean permet de simuler une instance de ctte classe
    @MockBean
    private IDepartmentRepository iDepartmentRepository;

    @BeforeEach
    void setup() {
        DepartementEntity departementEntity = new DepartementEntity().builder()
                .departmentName("INFORMATIQUE")
                .departmentAddress("DOUALA")
                .departmentCode("IT")
                .departmentId(1L)
                .build();

                Mockito.when(iDepartmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(departementEntity);
    }

    @Test
    @DisplayName("Get Data Base on correct existing departement name")
    public void whenValidDepartementName_thenDepartmentShouldFound() {
        String departmentName = "INFORMATIQUE";
        DepartementEntity found = new DepartementEntity();
        try {
            found = departmentServiceImpl.getDepartementByName(departmentName);
            assertEquals(departmentName, found.getDepartmentName());
        } catch (DepartementNotFoundException e) {
            System.out.println("Departement not found ...");
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Get Data Base on incorrect existing departement name")
    public void whenValidDepartementName_thenDepartmentShouldNotFound() {
        String departmentName = "GEOGRAPHIE";
        DepartementEntity found = new DepartementEntity();
        try {
            found = departmentServiceImpl.getDepartementByName(departmentName);
            assertNotEquals(departmentName, found.getDepartmentName());
        } catch (DepartementNotFoundException e) {
            System.out.println("Departement not found ...");
            e.printStackTrace();
        }
    }
}
