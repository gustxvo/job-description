package br.com.gustavoalmeidacarvalho.jobdescription.app.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.gustavoalmeidacarvalho.jobdescription.app.department.dto.DepartmentDto;
import br.com.gustavoalmeidacarvalho.jobdescription.app.department.dto.PositionHolderDto;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.department.Department;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.user.employee.Employee;

@Component
public class DepartmentMapper {

    public DepartmentDto fromEntity(Department department) {
        Employee positionHolder = department.getHolder();
        return new DepartmentDto(
                displayDepartmentId(department.getId()), department.getNameEn(), department.getNamePtBr(),
                department.getAcronym(), new PositionHolderDto(positionHolder.getUserId(), positionHolder.getName()));
    }

    public List<DepartmentDto> fromEntityList(List<Department> departments) {
        return departments.stream()
                .map(this::fromEntity)
                .toList();

    }

    private String displayDepartmentId(int departmentId) {
        return String.format("%07d", departmentId);
    }

}
