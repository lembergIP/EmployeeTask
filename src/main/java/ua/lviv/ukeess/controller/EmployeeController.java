package ua.lviv.ukeess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.ukeess.exeptions.EmployeeNotFoundException;
import ua.lviv.ukeess.service.EmployeeService;
import ua.lviv.ukeess.service.dto.EmployeeDto;
import javax.validation.Valid;



@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public Page<EmployeeDto> getAllEmployees(@RequestParam("page") int page) {
        return employeeService.findAll(page);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/employee")
    public ResponseEntity<EmployeeDto> editEmployee(@Valid @RequestBody EmployeeDto employeeDto) throws EmployeeNotFoundException {
        employeeService.updateEmployee(employeeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public EmployeeDto findEmployeeById(@PathVariable("id") Long id) throws EmployeeNotFoundException {
        return employeeService.getEmployeeDtoById(id);
    }

    @PostMapping("/employee")
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employee) {
        employeeService.createEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/employee/search")
    public Page<EmployeeDto> getEmployeesByName(@RequestParam("name") String searchName, @RequestParam("page") int page) {
        return employeeService.findEmployeesByName(searchName, page);
    }

}
