package br.com.gustavoalmeidacarvalho.jobdescription.app.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    private String street;
    private String number;
    private String complement;
    private String city;
    private String state;
    private String zipCode;

}
