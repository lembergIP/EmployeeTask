package ua.lviv.ukeess.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.ukeess.entity.Department;
import ua.lviv.ukeess.entity.Employee;
import ua.lviv.ukeess.exeptions.EmployeeNotFoundException;
import ua.lviv.ukeess.repository.DepartmentRepository;
import ua.lviv.ukeess.repository.EmployeeRepository;
import ua.lviv.ukeess.service.dto.EmployeeDto;
import ua.lviv.ukeess.service.mapper.EmployeeMapper;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void createEmployee(EmployeeDto employeeDto) {
        Department department = departmentRepository.findFirstByName(employeeDto.getDepartmentName());
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setActive(employeeDto.getActive());
        employee.setDepartment(department);
        employeeRepository.save(employee);
    }

    @Transactional
    public void deleteEmployee(Long employee_id) {
        employeeRepository.deleteById(employee_id);
    }

    @Transactional
    public EmployeeDto getEmployeeDtoById(Long employee_id) throws EmployeeNotFoundException {
        return EmployeeMapper.instance.toDto(employeeRepository.findById(employee_id).orElseThrow(() -> new EmployeeNotFoundException(employee_id)));
    }

    @Transactional
    public Page<EmployeeDto> findAll(int page) {
        return EmployeeMapper.instance.toPageEmployeeDto(employeeRepository.findAllByOrderByName(PageRequest.of(page, 10)));
    }

    @Transactional
    public Page<EmployeeDto> findEmployeesByName(String name, int page) {
        return EmployeeMapper.instance.toPageEmployeeDto(employeeRepository.findAllByName(name, PageRequest.of(page, 10)));
    }

    @Transactional
    public void updateEmployee(EmployeeDto employeeDto) throws EmployeeNotFoundException {
        Employee employee = employeeRepository.findById(employeeDto.getId()).orElseThrow(() -> new EmployeeNotFoundException(employeeDto.getId()));
        Department department = departmentRepository.findFirstByName(employeeDto.getDepartmentName());
        employee.setName(employeeDto.getName());
        employee.setActive(employeeDto.getActive());
        employee.setDepartment(department);
        employeeRepository.save(employee);
    }

}