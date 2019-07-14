package backend.spring.boot.springbackend.controller;

import backend.spring.boot.springbackend.model.Employee;
import backend.spring.boot.springbackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp-api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee create(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAll(){
        return employeeService.all();
    }

    @GetMapping("/employees/{empId}")
    public Employee getEmployee(@PathVariable String empId){
        return employeeService.findEmpById(empId);
    }

    @PutMapping("/employees/{empId}")
    public Employee update(@RequestBody Employee employee, @PathVariable String empId){
        return employeeService.updateEmp(employee, empId);
    }

    @DeleteMapping("/employees/{empId}")
    public String delete(@PathVariable String empId){
        return employeeService.deleteEmp(empId);
    }
}
