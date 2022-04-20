package com.bridgelabz.emplyeepayrollapp.dto;

import com.bridgelabz.emplyeepayrollapp.entity.Employee;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

public class EmployeeDTO {
    @NotEmpty(message = "Please enter name")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Please Enter valid Name")
    public String name;

    @Min(value = 100000,message = "Salary should be more that 100000")
    public long salary;

    public String gender;
    public String startDate;
    public String note;
    public String profilePic;
    public List<String> department;


    public EmployeeDTO(String name, long salary, String gender, String startDate, String note, String profilePic, List<String> department) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.startDate = startDate;
        this.note = note;
        this.profilePic = profilePic;
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", startDate=" + startDate +
                ", note='" + note + '\'' +
                ", profilePic='" + profilePic + '\'' +
                ", department=" + department +
                '}';
    }
}