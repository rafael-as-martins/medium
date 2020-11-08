package com.medium.client1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="client")
public class Client {
    @Id
    @GeneratedValue
    public Integer id;

    @Column(name ="name")
    public String name;

    @Column(name ="age")
    public Integer age;

    @Column(name ="address")
    public Integer address;
}
