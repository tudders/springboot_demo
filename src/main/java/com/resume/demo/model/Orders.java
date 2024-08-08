package com.resume.demo.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.Transient;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.CascadeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.resume.demo.model.Widgets;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity

@Table(catalog = "dbo", name = "orders", uniqueConstraints = { @UniqueConstraint(columnNames = "order_guid") })
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @Column(updatable = false)
    private String orderGuid;

    private String orderUserid;

    private String orderText;

    @Column(insertable = false, updatable = false)
    @Transient
    @Temporal(TemporalType.DATE)
    private Date orderCreateddatetime = new Date();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderIdfk", insertable = false, updatable = false)
    private Collection<Widgets> widgets = new ArrayList<Widgets>();

    public void Orders(String orderGuid, String orderText, String orderUserid) {
        this.orderUserid = orderUserid;
        this.orderText = orderText;
        this.orderGuid = orderGuid;
    }

}