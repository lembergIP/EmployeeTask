package ua.lviv.ukeess.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.lviv.ukeess.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findAllByOrderByName(Pageable pageable);

    @Query("select e from Employee e where lower(e.name) like lower(concat(?1,'%')) order by e.id")
    Page<Employee> findAllByName(String name, Pageable pageable);

}
