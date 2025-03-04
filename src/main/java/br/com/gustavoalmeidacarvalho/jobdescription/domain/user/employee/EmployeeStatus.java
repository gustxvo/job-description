package br.com.gustavoalmeidacarvalho.jobdescription.domain.user.employee;

public enum EmployeeStatus {

    ACTIVE("Em Atividade"),
    OFF_WORK("Afastado"),
    TERMINATED("Desligado");

    private final String message;

    EmployeeStatus(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
