package com.online.shop.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private BigDecimal amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date paymentDate;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    // Constructors, getters, setters, and other methods

    // Default constructor
    public Payment() {
    }

    // Parameterized constructor
    public Payment(BigDecimal amount, Date paymentDate, Order order) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.order = order;
    }

    // Getter and Setter methods for id, amount, paymentDate, and order

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
