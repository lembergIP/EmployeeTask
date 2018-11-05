package ua.lviv.ukeess.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ua.lviv.ukeess.entity.Department;
import ua.lviv.ukeess.service.dto.DepartmentDto;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    DepartmentMapper instance = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDto toDto(Department department);

    List<DepartmentDto> toListDto(List<Department> departments);
}
