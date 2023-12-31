package com.uc.order.adapters.order.rest.request;

import com.uc.order.order.model.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequest {
    private String country;
    private String province;
    private String district;
    private String neighborhood;
    private String street;
    private String buildingInformation;
    private String fullAddress;

    public Address toAddress() {
        Address address= new Address();
        address.setCountry(country);
        address.setProvince(province);
        address.setDistrict(district);
        address.setNeighborhood(neighborhood);
        address.setStreet(street);
        address.setBuildingInformation(buildingInformation);
        address.setFullAddress(fullAddress);
        return address;
    }
}
