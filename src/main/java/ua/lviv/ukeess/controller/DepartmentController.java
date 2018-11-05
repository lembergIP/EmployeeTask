package ua.lviv.ukeess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.ukeess.entity.Department;
import ua.lviv.ukeess.service.DepartmentService;
import ua.lviv.ukeess.service.dto.DepartmentDto;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/department")
    public List<DepartmentDto> getAllDepartments() {
        return departmentService.findAll();
    }
}
