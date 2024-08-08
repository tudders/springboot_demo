package com.resume.demo.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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

@Table(catalog = "dbo", name = "widgets", uniqueConstraints = { @UniqueConstraint(columnNames = "widgetGUID") })
public class Widgets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int widgetId;

    @Column(updatable = false)
    private String widgetGuid;

    private int orderIdfk;

    private String widgetText;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date widgetCreateddatetime = new Date();

    public void Widgets(String widgetText, int orderIdfk, String widgetGuid) {
        this.widgetText = widgetText;
        this.orderIdfk = orderIdfk;
        this.widgetGuid = widgetGuid;
    }

}
