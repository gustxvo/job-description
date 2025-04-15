package br.com.gustavoalmeidacarvalho.jobdescription.domain.department;

import java.util.List;

import br.com.gustavoalmeidacarvalho.jobdescription.app.department.dto.EmployeeOrgDto;

public class OrganizationChartService {

    public List<EmployeeOrgDto> findEmployees() {
        // Fake data to test thymeleaf recursion feature
        var marco = new EmployeeOrgDto("Marco", null);
        var carlos = new EmployeeOrgDto("Carlos", null);
        var cassio = new EmployeeOrgDto("Cássio", List.of(marco));
        var cleber = new EmployeeOrgDto("Cléber", List.of(cassio));
        var joao = new EmployeeOrgDto("João", List.of(carlos, cassio, cleber));
        var beatriz = new EmployeeOrgDto("Beatriz", List.of(joao));
        var breno = new EmployeeOrgDto("Breno", List.of(carlos, cassio, cleber, marco, joao,
                cassio, cleber, marco, joao));
        var bruno = new EmployeeOrgDto("Bruno", List.of(carlos));
        var alberto = new EmployeeOrgDto("Alberto", List.of(breno, bruno, beatriz));

        return List.of(
                alberto,
                bruno,
                breno,
                beatriz,
                carlos,
                cassio,
                cleber,
                joao,
                marco);
    }

}
