package br.com.gustavoalmeidacarvalho.jobdescription.app.mapper;

import br.com.gustavoalmeidacarvalho.jobdescription.app.employee.dto.AddressDto;
import br.com.gustavoalmeidacarvalho.jobdescription.app.employee.dto.EmployeeDto;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.user.employee.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeMapper {

    public EmployeeDto fromEntity(Employee employee) {
        return new EmployeeDto(
                employee.getUserId(), employee.getName(), employee.getPhone(), employee.getCpf(), employee.getCpf(),
                AddressDto.fromEntity(employee.getAddress()),
                employee.getPosition(), employee.getDepartment(), employee.getEmail(), employee.getPhoneExt(),
                employee.getSalary(), employee.getStatus(), employee.getAdmissionDate(), employee.getTerminationDate()
        );
    }

    public List<EmployeeDto> fromEntityList(List<Employee> employees) {
        return employees.stream()
                .map(this::fromEntity)
                .toList();
    }

    public Employee createEmployeeEntity(EmployeeDto employee) {
        return new Employee(
                null, false, true,
                employee.getName(),
                employee.getRg(),
                employee.getCpf(),
                employee.getPhone(),
                employee.getAddress().toEntity(),
                employee.getPosition(),
                employee.getDepartment(),
                employee.getEmail(),
                employee.getPhoneExt(),
                employee.getSalary(),
                employee.getStatus(),
                employee.getAdmissionDate(),
                employee.getTerminationDate()
        );
    }

    public int getUserId(String employeeId) {
        try {
            return Integer.parseInt(employeeId);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid user id: " + employeeId);
        }
    }
}
