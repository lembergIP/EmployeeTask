package ua.lviv.ukeess.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeNotFoundExeption extends Exception {

    public EmployeeNotFoundExeption(Long employee_id) {
        super("Employee with id = " + employee_id + " is not found");
    }
}
