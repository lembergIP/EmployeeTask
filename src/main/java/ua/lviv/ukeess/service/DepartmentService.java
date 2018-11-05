package ua.lviv.ukeess.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.ukeess.entity.Department;
import ua.lviv.ukeess.repository.DepartmentRepository;
import ua.lviv.ukeess.service.dto.DepartmentDto;
import ua.lviv.ukeess.service.mapper.DepartmentMapper;

import java.util.List;

@Service
public class DepartmentService {

    DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentDto> findAll() {
        return DepartmentMapper.instance.toListDto(departmentRepository.findAllByOrderByName());
    }
}
