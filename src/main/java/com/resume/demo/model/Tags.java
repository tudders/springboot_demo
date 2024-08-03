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

@Table(catalog = "dbo", name = "tags", uniqueConstraints = { @UniqueConstraint(columnNames = "tagGUID") })
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tagId")
    private int tagId;

    @Column(name = "tagGUID", insertable = false, updatable = false)
    private String tagGUID;

    @Column(name = "widgetId", nullable = false)
    private String widgetId;

    @Column(name = "tagUserId", columnDefinition = "TEXT")
    private String tagUserId;

    @Column(name = "tagText", columnDefinition = "TEXT")
    private String tagText;

    @Column(name = "tagCreatedDateTime", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date tagCreatedDateTime = new Date();
}