package br.com.gustavoalmeidacarvalho.jobdescription.app.department.dto;

import java.util.List;

public class EmployeeOrgDto {
    private String name;

    private List<EmployeeOrgDto> subordinates;

    public EmployeeOrgDto(String name, List<EmployeeOrgDto> subordinates) {
        this.name = name;
        this.subordinates = subordinates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeeOrgDto> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<EmployeeOrgDto> subordinates) {
        this.subordinates = subordinates;
    }
}
