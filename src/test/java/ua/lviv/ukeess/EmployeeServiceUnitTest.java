package ua.lviv.ukeess;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import ua.lviv.ukeess.entity.Employee;
import ua.lviv.ukeess.exeptions.EmployeeNotFoundException;
import ua.lviv.ukeess.repository.EmployeeRepository;
import ua.lviv.ukeess.service.EmployeeService;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceUnitTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test(expected = EmployeeNotFoundException.class)
    public void getEmployeeDtoByIdTestNotFoundException() throws EmployeeNotFoundException {
        Mockito.when(employeeRepository.findById(1L)).thenReturn(Optional.empty() );
        employeeService.getEmployeeDtoById(1L);
    }
    @Test
    public void getEmployeeDtoByIdTest() throws EmployeeNotFoundException {
        Employee employee=new Employee();
        employee.setId(1L);
        Mockito.when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        assertThat(employeeService.getEmployeeDtoById(1L).getId()).isEqualTo(1L);
    }

}
