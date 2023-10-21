package com.uc.order.infra.adapters.order.jpa.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;


@Embeddable
@Getter
@Setter
public class AddressEntity {
    @ColumnDefault("''")
    private String country;

    @ColumnDefault("''")
    private String province;

    @ColumnDefault("''")
    private String district;

    @ColumnDefault("''")
    private String neighborhood;

    @ColumnDefault("''")
    private String street;

    @ColumnDefault("''")
    private String buildingInformation;

    @ColumnDefault("''")
    private String fullAddress;


}
