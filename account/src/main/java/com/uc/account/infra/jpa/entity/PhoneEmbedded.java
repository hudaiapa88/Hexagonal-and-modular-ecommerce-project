package com.uc.account.infra.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;



@Embeddable
@Getter
public class PhoneEmbedded {
    @NotEmpty(message = "{constraint.register.phone.NotNull.message}")
    @Pattern(regexp = "^[0-9]*$",message = "{constraint.register.phone.Pattern.message}")
    @Size(min = 2,max = 13,message = "{constraint.register.phone.Size.message}")
    private String number;
    @Setter
    @NotEmpty(message = "{constraint.register.phone.NotNull.message}")
    @Pattern(regexp = "^[0-9]*$",message = "{constraint.register.phone.Pattern.message}")
    @Size(min = 2,max = 5)
    private String areaCode;
    @Setter
    private String countryCode;

    public void setNumber(String number){
        this.number=number.replaceAll(" ","");
    }
    @JsonIgnore
    public String getFullNumber(){

        return this.areaCode+this.number;
    }
}
