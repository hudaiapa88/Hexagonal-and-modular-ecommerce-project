package com.uc.order.infra.adapters.order.rest.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {
    private String country;
    private String province;
    private String district;
    private String neighborhood;
    private String street;
    private String buildingInformation;
    private String fullAddress;

}
