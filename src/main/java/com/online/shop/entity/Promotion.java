package com.online.shop.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "promotions")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private BigDecimal discountAmount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date endDate;

    // Constructors, getters, setters, and other methods

    // Default constructor
    public Promotion() {
    }

    // Parameterized constructor
    public Promotion(String code, BigDecimal discountAmount, Date startDate, Date endDate) {
        this.code = code;
        this.discountAmount = discountAmount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getter and Setter methods for id, code, discountAmount, startDate, and endDate

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

