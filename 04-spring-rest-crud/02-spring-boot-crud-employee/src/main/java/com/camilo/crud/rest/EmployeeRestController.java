package com.camilo.crud.rest;

import com.camilo.crud.dao.EmployeeDAO;
import com.camilo.crud.entity.Employee;
import com.camilo.crud.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private ObjectMapper objectMapper;
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        // Of course, we can handle this better!
        if (employee == null) {
            throw new RuntimeException("Employee ID not found - " + employeeId);
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee updatedEmployee) {
        return employeeService.save(updatedEmployee);
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee partialUpdateEmployee(@PathVariable int employeeId,
                                          @RequestBody Map<String, Object> patchPayload) {
        // PATCH is partial update, to update just the field(s) passed in the body
        Employee tmpEmployee = employeeService.findById(employeeId);

        if (tmpEmployee == null) {
            throw new RuntimeException("Employee ID not found - " + employeeId);
        }

        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Found ID in the request body - not allowed");
        }

        Employee patchedEmployee = apply(patchPayload, tmpEmployee);

        return employeeService.save(patchedEmployee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee tmpEmployee = employeeService.findById(employeeId);

        if (tmpEmployee == null) throw new RuntimeException("Employee is not in database ID - " + employeeId);

        employeeService.delete(employeeId);

        return "Deleted Employee ID [%d]".formatted(employeeId);
    }

    private Employee apply(Map<String, Object> patchPayload, Employee tmpEmployee) {
        // Convert data to object json nodes
        ObjectNode employeeNode = objectMapper.convertValue(tmpEmployee, ObjectNode.class);
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        // merge the patch updates into the employee node
        employeeNode.setAll(patchNode);

        return objectMapper.convertValue(employeeNode, Employee.class);
    }
}
