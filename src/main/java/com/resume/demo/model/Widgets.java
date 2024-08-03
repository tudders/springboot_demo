package com.resume.demo.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

@Table(catalog = "dbo", name = "widget", uniqueConstraints = { @UniqueConstraint(columnNames = "widgetGUID") })
public class Widgets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int widgetId;

    @Column(name = "widgetGUID", insertable = false, updatable = false)
    private String widgetGUID;

    @Column(name = "orderId", nullable = false)
    private String orderId;

    @Column(name = "widgetText", columnDefinition = "TEXT")
    private String widgetText;

    @Column(name = "widgetCreatedDateTime", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date widgetCreatedDateTime = new Date();
}
