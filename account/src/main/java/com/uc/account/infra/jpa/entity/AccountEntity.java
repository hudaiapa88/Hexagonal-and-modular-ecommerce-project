package com.uc.account.infra.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
public class AccountEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "generator_sequence"
    )
    @SequenceGenerator(
            name = "generator_sequence",
            allocationSize = 1
    )
    private Long id;
    private LocalDateTime createdDateTime;

    private LocalDateTime updatedDateTime;

    @PrePersist
    protected void onCreate() {
        updatedDateTime = createdDateTime = LocalDateTime.now(ZoneOffset.UTC);
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDateTime = LocalDateTime.now(ZoneOffset.UTC);
    }

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String username;
    private String password;
    @Embedded
    private PhoneEmbedded phone;
    private String email;
    @Column(insertable=false, updatable=false)
    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum;
    private String verificationCode;
    private Boolean isActive ;
}
