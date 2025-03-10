package br.com.gustavoalmeidacarvalho.jobdescription.app.report.dto;

import java.time.LocalDate;

public record ReportDto(
        Long id,
        String reportOwner,
        String department,
        String area,
        LocalDate signedAt,
        LocalDate createdAt) {
}
