package com.medium.address.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="address")
public class Address {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name ="name")
    private String name;
}
