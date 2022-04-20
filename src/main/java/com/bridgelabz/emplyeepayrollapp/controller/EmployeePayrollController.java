package com.bridgelabz.emplyeepayrollapp.controller;

import com.bridgelabz.emplyeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.emplyeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.emplyeepayrollapp.entity.Employee;
import com.bridgelabz.emplyeepayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService iEmployeePayrollService;

    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<Spring> getEmployeePayrollData(){
//        Employee employee=null;
//        employee=new Employee(1,new EmployeeDTO("Nikhil",800000));
//        ResponseDTO responseDTO=new ResponseDTO("Get call Success", employee);
//        return new ResponseEntity(responseDTO,HttpStatus.OK);

        List<Employee> employeeList=null;
        employeeList=iEmployeePayrollService.getEmployeePayrollData();
        ResponseDTO responseDTO=new ResponseDTO("Get call Success", employeeList);
        return new ResponseEntity(responseDTO,HttpStatus.OK);


    }

    @GetMapping("get/{empId}")
    public ResponseEntity<String> getEmployeePayrollDataById(@PathVariable("empId") int empId){
//        Employee employee=null;
//        employee=new Employee(1,new EmployeeDTO("Nikhil",800000));
//        ResponseDTO responseDTO=new ResponseDTO("Get call Success", employee);
//        return new ResponseEntity(responseDTO,HttpStatus.OK);
        //return new ResponseEntity("Get call Success for Id : "+empId, HttpStatus.OK);

        Employee employee=iEmployeePayrollService.getEmployeePayrollDataByID(empId);

        return new ResponseEntity(new ResponseDTO("Get Employee data by ID",employee),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEmployeeData(@Valid @RequestBody EmployeeDTO employeeDTO){
//        Employee employee=null;
//        employee=new Employee(1,employeeDTO);
//        ResponseDTO responseDTO=new ResponseDTO("Create Employee Data", employee);
//        return new ResponseEntity(responseDTO,HttpStatus.OK);
        // return new ResponseEntity("create Employee Data"+employeeDTO, HttpStatus.OK);

        Employee employee1= iEmployeePayrollService.cretaeEmployeeData(employeeDTO);

        return new ResponseEntity(new ResponseDTO("Created Employee by ID"+employee1.getId(),employee1),HttpStatus.OK);

    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<String> updateEmployeeData(@PathVariable("empId") int empId,@RequestBody EmployeeDTO employeeDTO){
//        Employee employee=null;
//        employee=new Employee(1,employeeDTO);
//        ResponseDTO responseDTO=new ResponseDTO("Update Employee Data",employee);
//        return new ResponseEntity(responseDTO,HttpStatus.OK);
        //return new ResponseEntity("Update Employee Data"+employeeDTO+" "+ empId,HttpStatus.OK);


        Employee employee1= iEmployeePayrollService.updateEmployeeData(empId,employeeDTO);
        return null;//new ResponseEntity(new ResponseDTO("Updated Employee by ID"+employee1.getId(),employee1),HttpStatus.OK);


    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
//        Employee employee=null;
//        employee=new Employee(1,new EmployeeDTO("Nikhil",800000));
//        ResponseDTO responseDTO=new ResponseDTO("Delete Employee Data Deleted id"+empId , employee);
//        return new ResponseEntity(responseDTO,HttpStatus.OK);
        //return new ResponseEntity("Delete Success for Id : " + empId, HttpStatus.OK);

        iEmployeePayrollService.deleteEmployeeData(empId);
        return new ResponseEntity(new ResponseDTO("Deleted Employee by ID"+empId,empId),HttpStatus.OK);

    }
}