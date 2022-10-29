package com.uc.category.infra.jpa.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "category")
public class CategoryEntity {

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
    private String title;
}
