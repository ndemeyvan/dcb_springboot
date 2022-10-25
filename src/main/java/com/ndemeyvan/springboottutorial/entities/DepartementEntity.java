package com.ndemeyvan.springboottutorial.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class DepartementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message = "Please add department name")
    @Length(min = 3)
    private String departmentName;

    private String departmentAddress;
    private String departmentCode;

}
