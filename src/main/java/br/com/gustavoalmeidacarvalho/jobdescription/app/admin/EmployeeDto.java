package br.com.gustavoalmeidacarvalho.jobdescription.app.admin;

import java.math.BigDecimal;

public record EmployeeDto(String userId, String name, String email, String department,
                          String position, BigDecimal salary, String status) {
}
