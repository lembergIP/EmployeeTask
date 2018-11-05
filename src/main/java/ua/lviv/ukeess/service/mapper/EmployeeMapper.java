package ua.lviv.ukeess.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import ua.lviv.ukeess.entity.Employee;
import ua.lviv.ukeess.service.dto.EmployeeDto;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper instance = Mappers.getMapper(EmployeeMapper.class);

    @Mappings({@Mapping(source = "department.name", target = "departmentName")})
    EmployeeDto toDto(Employee employee);

    @Mappings({@Mapping(source = "departmentName", target = "department.name")})
    Employee toEntity(EmployeeDto employee);

    List<EmployeeDto> listToDtoList(List<Employee> employees);

    default Page<EmployeeDto> toPageEmployeeDto(Page<Employee> page) {
        return page.map(this::toDto);
    }
}
