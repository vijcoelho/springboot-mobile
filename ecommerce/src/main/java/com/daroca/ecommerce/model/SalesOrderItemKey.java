package com.daroca.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class SalesOrderItemKey {

    @Column(name = "sales_order_id")
    private Integer salesOrderId;

    @Column(name = "product_id")
    private Integer productId;

    public SalesOrderItemKey(Integer salesOrderId, Integer productId) {
        this.salesOrderId = salesOrderId;
        this.productId = productId;
    }
}
