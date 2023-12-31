package com.uc.order.order.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String country;
    private String province;
    private String district;
    private String neighborhood;
    private String street;
    private String buildingInformation;
    private String fullAddress;


}
