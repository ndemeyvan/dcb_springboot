package com.ndemeyvan.springboottutorial.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.ndemeyvan.springboottutorial.entities.DepartementEntity;
import com.ndemeyvan.springboottutorial.service.IDepartmentService;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IDepartmentService idepartmentService;

    private DepartementEntity globalDepartment;

    @BeforeEach
    void setup() {
        globalDepartment = new DepartementEntity().builder()
                .departmentName("INFORMATIQUE")
                .departmentAddress("DOUALA")
                .departmentCode("IT")
                .departmentId(1L)
                .build();
    }

    @Test
    void getDepartementById()  {
    
    }

    @Test
    void saveDepartement() throws Exception {
        DepartementEntity inputDepartment = new DepartementEntity().builder()
        .departmentName("INFORMATIQUE")
        .departmentAddress("DOUALA")
        .departmentCode("IT")
        .build();
        // Mock the method
        Mockito.when(idepartmentService.saveDepartement(inputDepartment)).thenReturn(globalDepartment);
        // Mock Http Request and assert
        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
                "\t\n" +
                "\t\"departmentAddress\":\"DOUALA\",\n" +
                "\t\"departmentName\":\"INFORMATIQUE\",\n" +
                "\t\"departmentCode\":\"IT\"\n" +
                "}")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
