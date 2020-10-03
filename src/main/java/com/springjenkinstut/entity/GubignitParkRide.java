package com.springjenkinstut.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class GubignitParkRide {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;
    private int thrillFactor;
    private int vomitFactor;

    public GubignitParkRide(@NotEmpty String name, @NotEmpty String description, int thrillFactor, int vomitFactor) {
        this.name = name;
        this.description = description;
        this.thrillFactor = thrillFactor;
        this.vomitFactor = vomitFactor;
    }
}
