package com.mycompany.propertymanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String title;
    private String description;
    private String ownerName;
    private String ownerEmail;
    private Double price;
    private String address;
}
