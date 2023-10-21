package com.uc.order.domain.order.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;


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
