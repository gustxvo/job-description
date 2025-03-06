package br.com.gustavoalmeidacarvalho.jobdescription.app.department.dto;

public record DepartmentDto(String id, String nameEn, String namePtBr, String acronym,
        PositionHolderDto positionHolder) {
}
