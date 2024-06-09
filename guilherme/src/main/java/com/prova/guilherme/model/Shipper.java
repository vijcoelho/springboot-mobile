package com.prova.guilherme.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class Shipper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shipperId;

    @Column(nullable = false)
    private String name;

    public Shipper() {

    }

    public Shipper(Integer shipperId, String name) {
        this.shipperId = shipperId;
        this.name = name;
    }

    public Integer getShipperId() {
        return shipperId;
    }

    public void setShipperId(Integer shipperId) {
        this.shipperId = shipperId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shipper shipper)) return false;
        return Objects.equals(getShipperId(), shipper.getShipperId()) && Objects.equals(getName(), shipper.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShipperId(), getName());
    }

    @Override
    public String toString() {
        return "Shipper{" +
                "shipperId=" + shipperId +
                ", name='" + name + '\'' +
                '}';
    }
}
