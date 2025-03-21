package br.com.gustavoalmeidacarvalho.jobdescription.app.report.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class KpiDto {

    private String description;
    private BigDecimal value;

}
