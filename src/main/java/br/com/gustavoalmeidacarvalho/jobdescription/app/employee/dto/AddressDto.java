package br.com.gustavoalmeidacarvalho.jobdescription.app.employee.dto;

import br.com.gustavoalmeidacarvalho.jobdescription.domain.user.employee.Address;
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
    private String district;
    private String zipCode;

    public static AddressDto fromEntity(Address address) {
        return new AddressDto(
                address.getStreet(),
                address.getNumber(),
                address.getComplement(),
                address.getCity(),
                address.getDistrict(),
                address.getZipCode()
        );
    }

    public Address toEntity() {
        return new Address(street, number, complement, city, district, zipCode);
    }

}
