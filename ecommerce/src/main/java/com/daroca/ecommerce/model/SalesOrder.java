package com.daroca.ecommerce.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
public class SalesOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salesOrderId;

    @Column(nullable = false)
    private LocalDateTime orderDate;

    @Column(nullable = true)
    private LocalDate estimatedDeliveryDate;

    @Column(nullable = false, length = 30)
    private String status;

    @Column(nullable = false)
    private Double total;

    public SalesOrder() {
    }

    public SalesOrder(Integer salesOrderId, LocalDateTime orderDate, LocalDate estimatedDeliveryDate, String status, Double total) {
        this.salesOrderId = salesOrderId;
        this.orderDate = orderDate;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.status = status;
        this.total = total;
    }

    public Integer getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(Integer salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(LocalDate estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
