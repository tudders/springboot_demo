package com.resume.demo.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.Transient;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity

@Table(catalog = "dbo", name = "orders", uniqueConstraints = { @UniqueConstraint(columnNames = "orderGUID") })
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private int orderId;

    @Column(name = "orderguid", updatable = false)
    private String orderGUID;

    @Column(name = "orderuserid", columnDefinition = "TEXT")
    private String orderUserId;

    @Column(name = "ordertext", columnDefinition = "TEXT")
    private String orderText;

    @Column(name = "createddatetime", insertable=false, updatable=false)
    @Transient
    @Temporal(TemporalType.DATE)
    private Date orderCreatedDateTime = new Date();


    public void Orders(String orderGUID, String orderText, String orderUserId) {
        this.orderUserId = orderUserId;
        this.orderText = orderText;
        this.orderGUID = orderGUID;
    }

}