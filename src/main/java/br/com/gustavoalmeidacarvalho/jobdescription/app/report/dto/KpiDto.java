package br.com.gustavoalmeidacarvalho.jobdescription.app.report.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class KpiDto {

    private String description;
    private BigDecimal value;

}
