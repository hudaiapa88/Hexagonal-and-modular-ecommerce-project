package com.uc.account.infra.adapter.account.jpa.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;


@Embeddable
@Getter
@Setter
public class AddressEmbedded {
    @ColumnDefault("''")
    private String country;

    @ColumnDefault("''")
    @NotBlank(message = "İl alanı boş olmaz.")
    private String province;

    @ColumnDefault("''")
    @NotBlank(message = "İlçe alanı boş olmaz.")
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
