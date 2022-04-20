package com.bridgelabz.emplyeepayrollapp.service;

import com.bridgelabz.emplyeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.emplyeepayrollapp.entity.Employee;
import com.bridgelabz.emplyeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.emplyeepayrollapp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeePayrollServiceimpl implements IEmployeePayrollService {

    @Autowired
    private EmployeeRepository employeeRepository;
    /**
     * Get the all employee data
     * @return list
     */
    @Override
    public List<Employee> getEmployeePayrollData() {
//       List<Employee> employeeList=new ArrayList<>();
//       employeeList.add(new Employee(1,new EmployeeDTO("Makrand",560000)));
        //return employeeList;
        return employeeRepository.findAll();

    }

    /**
     * getting the employee data by using ID
     * @param empId employee Id
     * @return employee object having one data
     */
    @Override
    public Employee getEmployeePayrollDataByID(long empId) {

        //return new Employee(2,new EmployeeDTO("Sam",570000));

        return employeeRepository.findById(empId)
                .orElseThrow(()->new EmployeePayrollException("Employee with is id does not exit"));
    }

    @Override
    public Employee cretaeEmployeeData(EmployeeDTO employeeDTO) {
        //return new Employee(3,employeeDTO);

        Employee employee=new Employee(employeeDTO);
        log.debug("Employee data :"+employee.toString());
        return employeeRepository.save(employee);
    }

    @Override

    public Employee updateEmployeeData(int empId,EmployeeDTO employeeDTO) {
        //  return null;
        Employee employee=this.getEmployeePayrollDataByID(empId);
        employee.updateEmployeePayroll(employeeDTO);
        return employeeRepository.save(employee);

    }

    @Override
    public void deleteEmployeeData(int empId) {
        Employee employee=this.getEmployeePayrollDataByID(empId);
        employeeRepository.delete(employee);

    }
}