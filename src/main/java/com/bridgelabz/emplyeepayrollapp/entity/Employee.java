package com.bridgelabz.emplyeepayrollapp.entity;

import com.bridgelabz.emplyeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.emplyeepayrollapp.dto.ResponseDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "employee_payroll")
public @Data class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private long salary;
    public String gender;
    public LocalDate startDate;
    private String note;
    private String profilePic;

    @ElementCollection
    @CollectionTable(name = "employee_department",joinColumns = @JoinColumn(name = "id"))
    private List<String> department;

    public Employee(long id, String name, long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employee( EmployeeDTO dto) {
        this.updateEmployeePayroll(dto);
    }


    public Employee() {

    }

    public void updateEmployeePayroll(EmployeeDTO dto){
        //  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy");
        this.id = id;
        this.name = dto.name;
        this.salary = dto.salary;
        this.gender=dto.gender;
        this.startDate=LocalDate.parse(dto.startDate);
        this.note=dto.note;
        this.profilePic=dto.profilePic;
        this.department=dto.department;
    }
}