package com.daroca.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table
public class SalesOrderItem {

    @EmbeddedId
    private SalesOrderItemKey salesOrderItemId;

    @ManyToOne
    @MapsId("salesOrderId")
    @JoinColumn(name = "sales_order_id", foreignKey = @ForeignKey(name = "FK_SalesOrderItem_SalesOrder"))
    private SalesOrder salesOrder;

    @ManyToOne // cardinalidade da relação
    @MapsId("productId")
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "FK_SalesOrderItem_Product"))
    private Product product;

    @Column(nullable = false)
    private Integer quantity;
}
