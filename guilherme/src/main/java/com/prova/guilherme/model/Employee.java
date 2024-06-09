package com.prova.guilherme.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private LocalDate hireDate;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private Integer reportTo;

    public Employee(Integer employeeId, String name, LocalDate birthDate, LocalDate hireDate, String address, String city, String state, String postalCode, String phone, Integer reportTo) {
        this.employeeId = employeeId;
        this.name = name;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.phone = phone;
        this.reportTo = reportTo;
    }

    public Employee() {

    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getReportTo() {
        return reportTo;
    }

    public void setReportTo(Integer reportTo) {
        this.reportTo = reportTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(getEmployeeId(), employee.getEmployeeId()) && Objects.equals(getName(), employee.getName()) && Objects.equals(getBirthDate(), employee.getBirthDate()) && Objects.equals(getHireDate(), employee.getHireDate()) && Objects.equals(getAddress(), employee.getAddress()) && Objects.equals(getCity(), employee.getCity()) && Objects.equals(getState(), employee.getState()) && Objects.equals(getPostalCode(), employee.getPostalCode()) && Objects.equals(getPhone(), employee.getPhone()) && Objects.equals(getReportTo(), employee.getReportTo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getName(), getBirthDate(), getHireDate(), getAddress(), getCity(), getState(), getPostalCode(), getPhone(), getReportTo());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", hireDate=" + hireDate +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                ", reportTo=" + reportTo +
                '}';
    }
}
