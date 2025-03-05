package br.com.gustavoalmeidacarvalho.jobdescription.domain.user.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {

    @Column(name = "address_street", nullable = false, length = 50)
    private String street;

    @Column(name = "address_number", nullable = false, length = 5)
    private String number;

    @Column(name = "address_complement", nullable = false, length = 25)
    private String complement;

    @Column(name = "address_city", nullable = false, length = 50)
    private String city;

    @Column(name = "address_district", nullable = false, length = 25)
    private String district;

    @Column(name = "address_zip_code", nullable = false, length = 8)
    private String zipCode;

}
