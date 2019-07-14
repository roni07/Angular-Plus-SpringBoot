package backend.spring.boot.springbackend.service;

import backend.spring.boot.springbackend.model.Employee;
import backend.spring.boot.springbackend.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee save(Employee employee){
        Optional<Employee> optionalEmployee = employeeRepo.findById(employee.getEmpId());
        if (!optionalEmployee.isPresent()){
            return employeeRepo.save(employee);
        }
        else {
            return null;
        }
    }

    public List<Employee> all(){
        return employeeRepo.findAll();
    }

    public Employee findEmpById(String empId){
        Optional<Employee> optionalEmployee = employeeRepo.findById(empId);
        if (optionalEmployee.isPresent()){
            return optionalEmployee.get();
        }
        else {
            return null;
        }
    }

    public Employee updateEmp(Employee employee, String empId){
        Optional<Employee> optionalEmployee = employeeRepo.findById(empId);
        if (optionalEmployee.isPresent()){
            employee.setEmpId(empId);
            return employeeRepo.save(employee);
        }
        else {
            return null;
        }
    }

    public String deleteEmp(String empId){
        Optional<Employee> optionalEmployee = employeeRepo.findById(empId);
        if (optionalEmployee.isPresent()){
            employeeRepo.deleteById(empId);
            return empId + " Deleted";
        }
        else {
            return null;
        }
    }
}
