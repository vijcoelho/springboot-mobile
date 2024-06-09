package com.prova.guilherme.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table
public class SalesOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salesOrderId;

    @ManyToOne
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "FK_SalesOrder_CustomerId"))
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "employee_id", foreignKey = @ForeignKey(name = "FK_SalesOrder_EmployeeId"))
    private Employee employeeId;

    @ManyToOne
    @JoinColumn(name = "shipper_id", foreignKey = @ForeignKey(name = "FK_SalesOrder_ShipperId"))
    private Shipper shipperId;

    @Column(nullable = false)
    private LocalDateTime orderDate;

    @Column(nullable = false)
    private LocalDateTime estimatedDeliveryDate;

    @Column(nullable = false)
    private Float freight;

    @Column(nullable = false)
    private Float total;

    public SalesOrder() {

    }

    public SalesOrder(Integer salesOrderId, Customer customerId, Employee employeeId, Shipper shipperId, LocalDateTime orderDate, LocalDateTime estimatedDeliveryDate, Float freight, Float total) {
        this.salesOrderId = salesOrderId;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.shipperId = shipperId;
        this.orderDate = orderDate;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.freight = freight;
        this.total = total;
    }

    public Integer getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(Integer salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Shipper getShipperId() {
        return shipperId;
    }

    public void setShipperId(Shipper shipperId) {
        this.shipperId = shipperId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(LocalDateTime estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public Float getFreight() {
        return freight;
    }

    public void setFreight(Float freight) {
        this.freight = freight;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesOrder that)) return false;
        return Objects.equals(getSalesOrderId(), that.getSalesOrderId()) && Objects.equals(getCustomerId(), that.getCustomerId()) && Objects.equals(getEmployeeId(), that.getEmployeeId()) && Objects.equals(getShipperId(), that.getShipperId()) && Objects.equals(getOrderDate(), that.getOrderDate()) && Objects.equals(getEstimatedDeliveryDate(), that.getEstimatedDeliveryDate()) && Objects.equals(getFreight(), that.getFreight()) && Objects.equals(getTotal(), that.getTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSalesOrderId(), getCustomerId(), getEmployeeId(), getShipperId(), getOrderDate(), getEstimatedDeliveryDate(), getFreight(), getTotal());
    }

    @Override
    public String toString() {
        return "SalesOrder{" +
                "salesOrderId=" + salesOrderId +
                ", customerId=" + customerId +
                ", employeeId=" + employeeId +
                ", shipperId=" + shipperId +
                ", orderDate=" + orderDate +
                ", estimatedDeliveryDate=" + estimatedDeliveryDate +
                ", freight=" + freight +
                ", total=" + total +
                '}';
    }
}
