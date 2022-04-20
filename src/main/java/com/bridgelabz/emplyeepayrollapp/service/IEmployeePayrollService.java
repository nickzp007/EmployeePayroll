package com.bridgelabz.emplyeepayrollapp.service;

import com.bridgelabz.emplyeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.emplyeepayrollapp.entity.Employee;

import java.util.List;

public interface IEmployeePayrollService {

    //Get all employee data
    List<Employee>getEmployeePayrollData();

    //Get employee data using employee id
    Employee getEmployeePayrollDataByID(long empId);

    Employee cretaeEmployeeData(EmployeeDTO responseDTO);

    Employee updateEmployeeData(int id,EmployeeDTO employeeDTO);

    void deleteEmployeeData(int empId);
}